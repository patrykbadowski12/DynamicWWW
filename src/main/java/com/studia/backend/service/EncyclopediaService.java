package com.studia.backend.service;

import com.studia.backend.entity.EncyclopediaEntity;
import com.studia.backend.entity.EncyclopediaRegistrationEntity;
import com.studia.backend.repository.EncyclopediaRegistrationRepository;
import com.studia.backend.repository.EncyclopediaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EncyclopediaService {
    private final EncyclopediaRepository encyclopediaRepository;
    private final EncyclopediaRegistrationRepository registrationRepository;


    public List<EncyclopediaEntity> getAllEncyclopedies() {
        List<EncyclopediaEntity> encyclopedies = encyclopediaRepository.findAll();
        for (EncyclopediaEntity encyclopedia : encyclopedies) {
            List<EncyclopediaRegistrationEntity> registations = encyclopedia.getRegistration()
                    .stream()
                    .filter(registrationEntity -> registrationEntity.isVerification())
                    .collect(Collectors.toList());
            encyclopedia.setRegistration(registations);
        }
        return encyclopedies;
    }

    public EncyclopediaEntity getEncyclopedia(Long id){
      return encyclopediaRepository.findById(id).orElse(null);
    }

    public void saveEncyclopedia(String title) throws Exception{
        EncyclopediaEntity encyclopediaEntity = new EncyclopediaEntity(title);
        encyclopediaRepository.save(encyclopediaEntity);
    }
    public void deleteEncyclopedia(Long id) throws Exception{
     encyclopediaRepository.deleteById(id);
    }

    public void addRegistry(Long id, EncyclopediaRegistrationEntity registration) throws Exception{
        EncyclopediaEntity encyclopedia = encyclopediaRepository.findById(id).orElse(null);
        registration.setDate(new Date());
        registration.setVerification(false);
        if (encyclopedia != null) {
            registration.setEncyclopediaId(id);
            EncyclopediaRegistrationEntity encyclopediaRegistration = registrationRepository.save(registration);
            encyclopedia.getRegistration().add(encyclopediaRegistration);
            encyclopediaRepository.save(encyclopedia);
        } else {
            throw new Exception("Encyclopedia not found");
        }
    }
}

