import java.util.InputMismatchException;
import java.util.Scanner;

public class Kiosk {
    public Menu addmenulist(){
        Menu menu = new Menu();
        menu.addMenuItem(new MenuItem(1,"불고기햄버거", 6.0,"맛있는 불고기 햄버거"));
        menu.addMenuItem(new MenuItem(2,"후라이드 치킨", 7.0,"맛있는 후라이드 치킨"));
        menu.addMenuItem(new MenuItem(3,"콜라", 3.0,"마시는 콜라"));
        menu.addMenuItem(new MenuItem(3,"사이다", 3.0,"마시는 사이다"));
        menu.addMenuCategory(new Category(1,"햄버거"));
        menu.addMenuCategory(new Category(2,"치킨"));
        menu.addMenuCategory(new Category(3,"음료"));
        return menu;
    }

    public void start(Menu menu){
        firstroop :while(true) {
            menu.getTmpMenuItems().clear();
            Scanner sc = new Scanner(System.in);
            System.out.println("[MAIN MENU]");
            menu.printAllMenuCategory();
            System.out.println("0. 종료");
            System.out.println("원하는 메뉴 번호 입력 :");
            int input = 0;
            try {
                input = sc.nextInt();
                if(input == 0){
                    System.exit(0);
                }else if(input > menu.getMenuCategory().size()){
                    System.out.println("지정되어있는 숫자를 입력해주세요");
                    continue;
                }else if(menu.getMenuCategory().isEmpty()){
                    System.out.println("카테고리가 없습니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("지정되어있는 숫자를 입력해주세요");
                continue;
            }
                while(true){
                    menu.getTmpMenuItems().clear();
                    menu.printAllMenuItem(input);
                    int input2 = 0;
                    try {
                         input2 = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("지정되어있는 숫자를 입력해주세요");
                        continue;
                    }
                    if(input2 == 0){
                        continue firstroop;
                    }
                    try{
                        MenuItem m = menu.printMenuItem(input2);
                        System.out.println("선택된 음식 : "+m);
                    } catch(IndexOutOfBoundsException e){
                        System.out.println("지정되어있는 숫자를 입력해주세요");
                        continue;
                    }
                    continue firstroop;
                }
        }
    }
}
