package christmas.view.output;

public class EventPlanScreen {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static String EVENT_PLAN_HEADER_SCREEN = "%s에 우테코 식당에서 받을 이벤트 혜택 미리 보기!" + LINE_SEPARATOR;  // {m월 n일}
    public static String ORDERS_SCREEN = "<주문 메뉴>" + LINE_SEPARATOR
            + "%s";  // {메뉴1 n개\n메뉴2 m개\n}
    public static String TOTAL_PRICE_BEFORE_DISCOUNT_SCREEN = "<할인 전 총주문 금액>" + LINE_SEPARATOR
            + "%,d원" + LINE_SEPARATOR;   // {x원}
    public static String GIFTS_SCREEN = "<증정 메뉴>" + LINE_SEPARATOR
            + "%s";   // {없음\n} or {샴페인 1개\n}
    public static String DISCOUNT_RESULTS_SCREEN = "<혜택 내역>" + LINE_SEPARATOR
            + "%s";     // {없음\n} or {혜택1: x원\n혜택2: y원\n}
    public static String TOTAL_DISCOUNT_SCREEN = "<총혜택 금액>" + LINE_SEPARATOR
            + "%,d원" + LINE_SEPARATOR;
    public static String EXPECTED_PRICE_AFTER_DISCOUNT_SCREEN = "<할인 후 예상 결제 금액>" + LINE_SEPARATOR
            + "%,d원" + LINE_SEPARATOR;    // {x원}
    public static String EVENT_BADGE_SCREEN = "<12월 이벤트 배지>" + LINE_SEPARATOR
            + "%s" + LINE_SEPARATOR; // {없음} or {산타}
}
