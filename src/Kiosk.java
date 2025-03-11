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
            int input2 = 0;
            try {
                input = sc.nextInt();
                if(input == 0){
                    System.exit(0);
                }else if(input > menu.getMenuCategory().size() && menu.getCartMenuItems().isEmpty()){
                    System.out.println("지정되어있는 숫자를 입력해주세요");
                    continue;
                }else if(input > menu.getMenuCategory().size()+2 && !menu.getCartMenuItems().isEmpty()){
                    System.out.println("지정되어있는 숫자를 입력해주세요");
                    continue;
                }else if(menu.getMenuCategory().isEmpty()){
                    System.out.println("카테고리가 없습니다.");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("지정되어있는 숫자를 입력해주세요");
                continue;
            }
            if(input == menu.getMenuCategory().size()+1){
                while(true){
                    System.out.println("아래와 같이 주문하시겠습니까?");
                    System.out.println("[Orders]");
                    menu.printShoppingCartItems();
                    System.out.println("[Total]");
                    System.out.println(menu.shoppingCartItemsPrice()+"$");
                    System.out.println("1. 주문       2. 취소(처음화면으로)");
                    try {
                        input2 = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("지정되어있는 숫자를 입력해주세요");
                        continue;
                    }
                    if(input2 == 1){
                        System.out.println("주문이 완료되었습니다 금액은 "+menu.shoppingCartItemsPrice()+"$ 입니다.");
                        menu.getCartMenuItems().clear();
                        break firstroop;
                    }else if(input2 == 2){
                        continue firstroop;
                    }else{
                        System.out.println("지정되어있는 숫자를 입력해주세요");
                    }

                }
            } else if (input == menu.getMenuCategory().size()+2) {
                menu.getCartMenuItems().clear();
                continue;
            }
            while(true){
                    menu.getTmpMenuItems().clear();
                    menu.printAllMenuItem(input);
                    MenuItem m = null;
                    input2 = 0;
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
                        m = menu.printMenuItem(input2);
                        System.out.println("선택된 음식 : "+m);
                    } catch(IndexOutOfBoundsException e){
                        System.out.println("지정되어있는 숫자를 입력해주세요");
                        continue;
                    }
                   while(true){
                       System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                       System.out.println("1. 추가       2. 취소");
                       input2 = 0;
                       try {
                           input2 = sc.nextInt();
                       } catch (InputMismatchException e) {
                           System.out.println("지정되어있는 숫자를 입력해주세요");
                           continue;
                       }
                       if(input2 == 1){
                           menu.addCartMenuItems(m);
                           System.out.println(m.getName()+"가(이) 장바구니에 추가되었습니다.");
                           continue firstroop;
                       }else if(input2 == 2){
                           continue firstroop;
                       }else{
                           System.out.println("지정되어있는 숫자를 입력해주세요");
                       }
                   }
                }
        }
    }
}
