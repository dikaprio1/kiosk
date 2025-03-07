public class Kiosk {
    public void start(){
        Menu menu = new Menu();
        menu.addmenu(new MenuItem(1,"햄버거", 6.0,"맛있는 햄버거"));
        menu.addmenu(new MenuItem(1,"치킨", 7.0,"맛있는 치킨"));
        menu.addmenu(new MenuItem(2,"콜라", 3.0,"마시는 콜라"));
        menu.addmenu(new MenuItem(2,"사이다", 3.0,"마시는 사이다"));
        menu.printmenu();
    }
}
