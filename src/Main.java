public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        Menu menu = kiosk.addmenulist();
        kiosk.start(menu);
    }
}
