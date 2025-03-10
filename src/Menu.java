import java.util.ArrayList;
import java.util.List;

public class Menu {

    List<Category> menucategory;
    List<MenuItem> menuItems;

    public Menu(){
        menucategory = new ArrayList<>();
        menuItems = new ArrayList<>();
    }

    // 대분류 추가(추후 관리자에서 사용예정) ------------------------------------------------------------
    public void addMenuCategory(Category category){
        menucategory.add(category);
    }

    // 소분류 추가(추후 관리자에서 사용예정) ------------------------------------------------------------
    public void addMenuItem(MenuItem menuItem){
        menuItems.add(menuItem);
    }

    //모든 대분류 출력 ------------------------------------------------------------
    public void printAllMenuCategory(){
        for(Category c : menucategory){
            System.out.println(c);
        }
    }
    //선택된 대분류의 모든 소분류 출력 ------------------------------------------------------------
    public void printAllMenuItem(int input){
        int j = 1;
        for(int i=0;i<menuItems.size();i++){
            if(input == menuItems.get(i).getProductNum()){
                if(j==1){
                    System.out.println("["+menuItems.get(i).getName()+" MENU]");
                }
                System.out.println(j+". "+menuItems.get(i));
                j++;
            }
        }
        System.out.println("0. 뒤로가기");
    }
    //선택된 소분류 출력 ------------------------------------------------------------
    public void printMenuItem(){
        for(MenuItem m : menuItems){
            System.out.println(m);
        }
    }

    //게터 세터 ------------------------------------------------------------
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
    public List<Category> getMenucategory() {
        return menucategory;
    }
    public void setMenucategory(List<Category> menucategory) {
        this.menucategory = menucategory;
    }
}
