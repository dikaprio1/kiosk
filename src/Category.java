public class Category {

    //대분류 음식 정의

    private String name;
    private final int category;

    public Category(int Category,String name){
        this.category = Category;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }
    @Override
    public String toString() {
        return category+". " + name;
    }
}
