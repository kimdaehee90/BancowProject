package com.bancow.process.util;

import com.bancow.process.constant.DateType;
import com.bancow.process.dto.response.RequestDateResponseDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.DayOfWeek.*;

public class CalendarCalculator {

    public static List<RequestDateResponseDto> getWeekendList() {

        List WeekendList = new ArrayList();

        LocalDate now = LocalDate.now();
        LocalDate ReservationDate = getDayAtEndOfMonthAfterAddNumToMonth(now, 3);

        while (!now.isEqual(ReservationDate)) {
            now = now.plusDays(1);
            if (now.getDayOfWeek() == SATURDAY) {
                WeekendList.add(new RequestDateResponseDto("토요일", now, DateType.SATURDAY));
            }
            if (now.getDayOfWeek() == SUNDAY) {
                WeekendList.add(new RequestDateResponseDto("일요일", now, DateType.SUNDAY));
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
