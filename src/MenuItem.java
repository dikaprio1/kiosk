public class MenuItem {

    //소분류 음식 정의

    private final int productNum;
    private String name;
    private Number price;
    private String menu;

    public MenuItem(int productNum,String name,Number price,String menu){
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

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
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
