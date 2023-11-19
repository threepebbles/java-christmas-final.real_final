package christmas.domain;

import christmas.error.ErrorMessage;
import christmas.view.input.dto.DateInputDto;
import christmas.view.output.dto.DateDto;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Date {
    private final LocalDate localDate;

    public Date(LocalDate localDate) {
        validateYear(localDate.getYear());
        validateMonth(localDate.getMonthValue());
        this.localDate = localDate;
    }

    private void validateYear(int year) {
        final int EVENT_YEAR = 2023;
        if (year != EVENT_YEAR) {
            throw new IllegalArgumentException(ErrorMessage.getDateErrorMessage());
        }
    }

    private void validateMonth(int month) {
        final int EVENT_MONTH = 12;
        if (month != EVENT_MONTH) {
            throw new IllegalArgumentException(ErrorMessage.getDateErrorMessage());
        }
    }

    public static Date createDate(DateInputDto dateInputDTO) {
        return new Date(dateInputDTO.getLocalDate());
    }

    public DateDto toDto() {
        return new DateDto(localDate);
    }

    public boolean isBefore(LocalDate deadLine) {
        return this.localDate.isBefore(deadLine);
    }

    public boolean isEqual(LocalDate deadLine) {
        return this.localDate.isEqual(deadLine);
    }

    public boolean isWeekend() {
        return localDate.getDayOfWeek() == DayOfWeek.FRIDAY || localDate.getDayOfWeek() == DayOfWeek.SATURDAY;
    }

    public boolean isWeekDay() {
        return !isWeekend();
    }

    public int getDay() {
        return localDate.getDayOfMonth();
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
}