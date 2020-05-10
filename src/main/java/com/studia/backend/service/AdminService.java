package com.studia.backend.service;

import com.studia.backend.repository.BookRepository;
import com.studia.backend.repository.EncyclopediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Service
@RequiredArgsConstructor
public class AdminService {

    private final BookRepository bookRepository;
    private final EncyclopediaRepository encyclopediaRepository;

    @Transactional
    public void deleteData() {
        bookRepository.deleteAll();
        encyclopediaRepository.deleteAll();
    }

    public void releaseBookStatistic(String startDay, String endDay) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        LocalDateTime startDate, endDate;
        try {
            startDate = convertToLocalDateTime(simpleDateFormat.parse(startDay));
            endDate = convertToLocalDateTime(simpleDateFormat.parse(endDay));
        } catch (Exception e) {
            return;
        }
        bookRepository.findAllByReleaseDateBetween(startDate,endDate);
    }

    public LocalDateTime convertToLocalDateTime(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}