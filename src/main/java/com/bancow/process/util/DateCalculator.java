package com.bancow.process.util;

import com.bancow.process.constant.DateType;
import com.bancow.process.dto.response.RequestDateResponseDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.DayOfWeek.*;

public class DateCalculator {

    public static List<RequestDateResponseDto> getWeekendList(LocalDate startDate, LocalDate endDate) {

        List WeekendList = new ArrayList();

        while (!startDate.isEqual(endDate)) {
            startDate = startDate.plusDays(1);
            if (startDate.getDayOfWeek() == SATURDAY) {
                WeekendList.add(new RequestDateResponseDto("토요일", startDate, DateType.SATURDAY));
            }
            if (startDate.getDayOfWeek() == SUNDAY) {
                WeekendList.add(new RequestDateResponseDto("일요일", startDate, DateType.SUNDAY));
            }
        }

        return WeekendList;
    }

    public static LocalDate getDayAtEndOfMonthAfterAddNumToMonth(LocalDate date, int num) {
        return date
                .plusMonths(num)
                .plusDays(date.plusMonths(num).lengthOfMonth() - date.getDayOfMonth());
    }

}
