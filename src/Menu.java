import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {

    private List<Category> menuCategory;
    private List<MenuItem> menuItems;
    private List<MenuItem> cartMenuItems;
    private List<MenuItem> tmpMenuItems;

    public Menu(){
        menuCategory = new ArrayList<>();
        menuItems = new ArrayList<>();
        cartMenuItems = new ArrayList<>();
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
    // 장바구니 리스트 소분류 추가 ------------------------------------------------------------
    public  void addCartMenuItems(MenuItem MenuItems){
        cartMenuItems.add(MenuItems);
    }
    // 다른 리스트 소분류 추가 ------------------------------------------------------------
    public  void addTmpMenuItems(MenuItem MenuItems){
        tmpMenuItems.add(MenuItems);
    }

    //모든 대분류 출력 ------------------------------------------------------------
    public void printAllMenuCategory(){
        for(Category c : menuCategory){
            System.out.println(c);
        }
        if(!cartMenuItems.isEmpty()) {
            System.out.println("[ORDER MENU]");
            System.out.println(menuCategory.size() + 1 + ". Orders");
            System.out.println(menuCategory.size() + 2 + ". Cancel(장바구니 초기화)");
        }
    }
//    //선택된 대분류의 모든 소분류 출력 ------------------------------------------------------------
//    public void printAllMenuItem(int input){
//            int j = 1;
//            for(int i=0;i<menuItems.size();i++){
//                if(input == menuItems.get(i).getProductNum()){
//                    if(j==1){
//                        System.out.println("["+menuCategory.get(i).getName()+" MENU]");
//                    }
//                    System.out.println(j+". "+menuItems.get(i));
//                    addTmpMenuItems(menuItems.get(i));
//                    j++;
//                }
//            }
//        System.out.println("0. 뒤로가기");
//    }
    //선택된 대분류의 모든 소분류 출력(스트림)------------------------------------------------------------
    public void printAllMenuItemStream(int input){
        List<MenuItem> filteredItems = menuItems.stream()
                .filter(item -> item.getProductNum() == input)
                .toList();
        if(!filteredItems.isEmpty()){
            AtomicInteger j = new AtomicInteger(1);
            System.out.println("["+menuCategory.get(menuItems.indexOf(filteredItems.get(0))).getName()+" MENU]");
            filteredItems.forEach(item ->{
                System.out.println(j.getAndIncrement() +". "+item);
                addTmpMenuItems(item);
            });
        }
        System.out.println("0. 뒤로가기");
        System.out.println("원하는 메뉴 선택 : ");
    }
//    //장바구니에서 선택된 음식 제거------------------------------------------------------------
//    public void removeMenuItemCart(int input){
//        if(!cartMenuItems.isEmpty()){
//            System.out.println(cartMenuItems.get(input-1).getName()+" 메뉴를 제외했습니다");
//            cartMenuItems.remove(input-1);
//        }
//    }
    //장바구니에서 선택된 음식 제거(스트림)------------------------------------------------------------
    public void removeMenuItemCartStream(int input) {
        if (!cartMenuItems.isEmpty() && input > 0 && input <= cartMenuItems.size()) {
            String removedItemName = cartMenuItems.get(input - 1).getName();
            System.out.println(removedItemName + " 메뉴를 제외했습니다");

            cartMenuItems = cartMenuItems.stream()
                    .filter(item -> !item.equals(cartMenuItems.get(input - 1))) // 선택한 항목 제외
                    .toList(); // 새로운 리스트로 갱신
        }
    }
    //선택된 소분류 출력 ------------------------------------------------------------
    public MenuItem printMenuItem(int input){
           return tmpMenuItems.get(input-1);
    }

    // 장바구니에 담겨있는 음식들 출력
    public void printShoppingCartItems(){
        int j = 1;
        for(MenuItem i : cartMenuItems){
            System.out.println(j+++". "+i);
        }
    }
    //장바구니에 담겨있는 음식들의 값의 합 계산
    public Double shoppingCartItemsPrice(){
        double sum=0.0;
        for(MenuItem i : cartMenuItems){
            sum += i.getPrice().doubleValue();
        }
        return sum;
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
    
    public List<MenuItem> getCartMenuItems() {
        return cartMenuItems;
    }

    public void setCartMenuItems(List<MenuItem> cartMenuItems) {
        this.cartMenuItems = cartMenuItems;
    }
}
