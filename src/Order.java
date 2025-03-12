public class Order<T extends Number>{

    public Number calDiscount(int input, T price){
        double result;
        result = price.doubleValue() - (Discount.selectOneDiscounts(input).doubleValue() * price.doubleValue());
        if(result % 1 == 0){
            return (int) result;
        } else {
            return result;
        }
    }
}
