public enum Discount {
    NATIONAL(0.1), SOLDIER(0.05), STUDENT(0.03), NORMAL(0.0);

    private Number symbol = 0.0;

    Discount(double symbol) {
        this.symbol = symbol;
    }

    public Number getSymbol() {
        return symbol;
    }
    //할인율 출력
    public static void printDiscountList() {
        Discount[] discounts = values();
        for (int i = 0; i < discounts.length; i++) {
            System.out.println(i + 1 + ". " + discounts[i] + "  할인율 : "+(int)(discounts[i].symbol.doubleValue()*100)+"%");
        }
    }
    // enum으로 정의되어있는 상수들의 길이(갯수) 반환
    public static int discountsLength() {
        Discount[] discounts = values();
        return discounts.length;
    }
    // 입력받은 값으로 맞는 순번에있는 상수 반환
    public static Number selectOneDiscounts(int input) {
        Discount[] discounts = values();
        return discounts[input-1].symbol;
    }
}

