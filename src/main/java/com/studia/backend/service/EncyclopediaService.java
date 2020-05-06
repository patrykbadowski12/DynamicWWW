package com.studia.backend.service;

import com.studia.backend.entity.EncyclopediaEntity;
import com.studia.backend.repository.EncyclopediaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EncyclopediaService {
    private final EncyclopediaRepository encyclopediaRepository;

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
}

