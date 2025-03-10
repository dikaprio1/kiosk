import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<Category> menuCategory;
    private List<MenuItem> menuItems;
    private List<MenuItem> tmpMenuItems;

    public Menu(){
        menuCategory = new ArrayList<>();
        menuItems = new ArrayList<>();
        tmpMenuItems = new ArrayList<>();
    }

    // 대분류 추가(추후 관리자에서 사용예정) ------------------------------------------------------------
    public  void addMenuCategory(Category category){
        menuCategory.add(category);
    }

    // 소분류 추가(추후 관리자에서 사용예정) ------------------------------------------------------------
    public  void addMenuItem(MenuItem menuItem){
        menuItems.add(menuItem);
    }
    // 다른 리스트 소분류 추가 ------------------------------------------------------------
    public  void addTmpMenuItems(MenuItem tmpmenuItems){
        tmpMenuItems.add(tmpmenuItems);
    }

    //모든 대분류 출력 ------------------------------------------------------------
    public void printAllMenuCategory(){
        for(Category c : menuCategory){
            System.out.println(c);
        }
    }
    //선택된 대분류의 모든 소분류 출력 ------------------------------------------------------------
    public void printAllMenuItem(int input){
        int j = 1;
        for(int i=0;i<menuItems.size();i++){
            if(input == menuItems.get(i).getProductNum()){
                if(j==1){
                    System.out.println("["+menuCategory.get(i).getName()+" MENU]");
                }
                System.out.println(j+". "+menuItems.get(i));
                addTmpMenuItems(menuItems.get(i));
                j++;
            }
        }
        System.out.println("0. 뒤로가기");
    }
    //선택된 소분류 출력 ------------------------------------------------------------
    public void printMenuItem(int input){
            System.out.println(tmpMenuItems.get(input-1));
    }

    //게터 세터 ------------------------------------------------------------

    public List<Category> getMenuCategory() {
        return menuCategory;
    }

    public void setMenuCategory(List<Category> menuCategory) {
        this.menuCategory = menuCategory;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public List<MenuItem> getTmpMenuItems() {
        return tmpMenuItems;
    }

    public void setTmpMenuItems(List<MenuItem> tmpMenuItems) {
        this.tmpMenuItems = tmpMenuItems;
    }
}
