package com.studia.backend.service;

import com.studia.backend.entity.BookEntity;
import com.studia.backend.entity.EncyclopediaEntity;
import com.studia.backend.entity.EncyclopediaRegistrationEntity;
import com.studia.backend.repository.BookRepository;
import com.studia.backend.repository.EncyclopediaRegistrationRepository;
import com.studia.backend.repository.EncyclopediaRepository;
import com.studia.backend.util.BookConvertObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AdminService {

    private final BookRepository bookRepository;
    private final EncyclopediaRepository encyclopediaRepository;
    private final EncyclopediaRegistrationRepository encyclopediaRegistrationRepository;


    @Transactional
    public void deleteData() {
        bookRepository.deleteAll();
        encyclopediaRegistrationRepository.deleteAll();
        encyclopediaRepository.deleteAll();
    }

    public List<EncyclopediaRegistrationEntity> getRegistrationFalse() {
        return encyclopediaRegistrationRepository.findAllByVerificationFalse();
    }

    public void confirmRegistration(Long id) {
        EncyclopediaRegistrationEntity registration = encyclopediaRegistrationRepository.findById(id).orElse(null);
        if (registration != null) {
            registration.setVerification(true);
            encyclopediaRegistrationRepository.save(registration);
        }
    }

    public void deleteRegistration(Long id) {
        EncyclopediaRegistrationEntity registration = encyclopediaRegistrationRepository.findById(id).orElse(null);
        if (registration != null) {
            EncyclopediaEntity encyclopedia = encyclopediaRepository.findById(registration.getEncyclopediaId()).orElse(null);
            encyclopedia.getRegistration().remove(registration);
            encyclopediaRepository.save(encyclopedia);
            encyclopediaRegistrationRepository.deleteById(id);
        }
    }


    public Map<String, List<BookConvertObject>> releaseBookStatistic(String startDay, String endDay) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        LocalDateTime startDate, endDate;
        try {
            startDate = convertToLocalDateTime(simpleDateFormat.parse(startDay));
            endDate = convertToLocalDateTime(simpleDateFormat.parse(endDay));
        } catch (Exception e) {
            return null;
        }
        Map<String, List<BookConvertObject>> statistic = new HashMap<>();
        List<BookEntity> allBooksFromPeriod = bookRepository.findAllByReleaseDateBetween(startDate,endDate);
        List<BookConvertObject> collect = allBooksFromPeriod
                .stream()
                .map(this::mapBookEntity)
                .collect(Collectors.toList());

        for (BookConvertObject book : collect) {
            if (!statistic.containsKey(book.getKey())) {
                statistic.put(book.getKey(), new ArrayList<>());
            }
            List<BookConvertObject> bookConvertObjects = statistic.get(book.getKey());
            ArrayList<BookConvertObject> tempList = new ArrayList<>(bookConvertObjects);
            tempList.add(book);
            statistic.put(book.getKey(), tempList);
        }

        return statistic;
    }

    private LocalDateTime convertToLocalDateTime(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    BookConvertObject mapBookEntity(BookEntity bookEntity) {
        return new BookConvertObject(bookEntity);
    }
}