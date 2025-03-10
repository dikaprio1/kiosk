public class MenuItem {
    private final int productNum;
    private String name;
    private Double price;
    private String menu;

    public MenuItem(int productNum,String name,Double price,String menu){
        this.productNum = productNum;
        this.name = name;
        this.price = price;
        this.menu = menu;
    }

    public int getProductNum() {
        return productNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "이름: " + name + ", 가격: " + price+ ", 메뉴설명: " + menu;
    }

}
