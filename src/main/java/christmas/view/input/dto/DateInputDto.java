package christmas.view.input.dto;

import java.time.LocalDate;

public class DateInputDto {
    private final LocalDate localDate;

    public DateInputDto(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
}