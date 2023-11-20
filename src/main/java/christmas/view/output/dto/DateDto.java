package christmas.view.output.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateDto {
    private final LocalDate localDate;

    public DateDto(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M월 d일");
        return localDate.format(dateTimeFormatter);
    }
}