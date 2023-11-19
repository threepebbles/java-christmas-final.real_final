package christmas.error;

public class ErrorMessage {
    public static final String ERROR_HEADER = "[ERROR]";
    public static final String WHITE_SPACE = " ";
    public static final String RETRY = "다시 입력해 주세요.";
    public static final String NOT_PROPER_DAY = "유효하지 않은 날짜입니다.";
    public static final String NOT_PROPER_ORDERS = "유효하지 않은 주문입니다.";

    private static String getMessage(String message) {
        return ERROR_HEADER + WHITE_SPACE
                + message + WHITE_SPACE
                + RETRY;
    }

    public static String getDateErrorMessage() {
        return getMessage(NOT_PROPER_DAY);
    }

    public static String getOrdersErrorMessage() {
        return getMessage(NOT_PROPER_ORDERS);
    }
}