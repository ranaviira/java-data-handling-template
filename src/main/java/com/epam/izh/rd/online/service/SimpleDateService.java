package com.epam.izh.rd.online.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class SimpleDateService implements DateService {

    @Override
    public String parseDate(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    @Override
    public LocalDateTime parseString(String string) {
        return LocalDateTime.parse(string, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    @Override
    public String convertToCustomFormat(LocalDate localDate, DateTimeFormatter formatter) {
        return localDate.format(formatter);
    }

    @Override
    public long getNextLeapYear() {
        long leapYear = LocalDate.now().getYear();
        while (!Year.isLeap(leapYear)) {
            leapYear++;
        }
        return leapYear;
    }

    @Override
    public long getSecondsInYear(int year) {
        return (long) LocalDate.of(year, 1, 1).lengthOfYear() * 24 * 60 * 60;
    }

}
