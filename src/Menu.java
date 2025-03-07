import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<MenuItem> menuItems;
    public Menu(){
        menuItems = new ArrayList<>();
    }
    public void addmenu(MenuItem menuItem){
        menuItems.add(menuItem);
    }
    public void printmenu(){
        for(MenuItem m : menuItems){
            System.out.println(m);
        }
    }
}
