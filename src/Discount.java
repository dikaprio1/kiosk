public enum Discount {
    NATIONAL(0.1), SOLDIER(0.05), STUDENT(0.03), NORMAL(0.0);

    private Number symbol = 0.0;

    Discount(double symbol) {
        this.symbol = symbol;
    }

    public Number getSymbol() {
        return symbol;
    }

    public static void printDiscountList() {
        Discount[] discounts = values();
        for (int i = 0; i < discounts.length; i++) {
            System.out.println(i + 1 + ". " + discounts[i] + "  할인율 : "+(int)(discounts[i].symbol.doubleValue()*100)+"%");
        }
    }

    public static int discountsLength() {
        Discount[] discounts = values();
        return discounts.length;
    }
    public static Number selectOneDiscounts(int input) {
        Discount[] discounts = values();
        return discounts[input-1].symbol;
    }
}

