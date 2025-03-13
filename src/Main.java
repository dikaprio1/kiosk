public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        Menu menu = kiosk.addMenuList();
        kiosk.start(menu);
    }
}
