public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();        // 키오스크 생성
        Menu menu = kiosk.addMenuList();  // 키오스크에 기본 메뉴 생성
        kiosk.start(menu);                // 키오스크 시작
    }
}
