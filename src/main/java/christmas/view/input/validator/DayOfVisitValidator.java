package christmas.view.input.validator;

import christmas.error.ErrorMessage;
import java.util.Objects;

public class DayOfVisitValidator implements InputValidator {
    private static final DayOfVisitValidator dayOfVisitValidator = new DayOfVisitValidator();

    private DayOfVisitValidator() {
    }

    public static DayOfVisitValidator getInstance() {
        return dayOfVisitValidator;
    }

    @Override
    public void validate(String target) {
        validateNull(target);
        validateBlank(target);
        validateInteger(target);
    }

    private void validateBlank(String target) {
        if (target.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.getDateErrorMessage());
        }
    }

    private void validateInteger(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.getDateErrorMessage());
        }
    }

    private void validateNull(String target) {
        if (Objects.isNull(target)) {
            throw new IllegalArgumentException(ErrorMessage.getDateErrorMessage());
        }
    }
}