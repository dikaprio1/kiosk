import java.util.InputMismatchException;
import java.util.Scanner;

public class Kiosk {

    // 기본적인 메뉴들 추가
    public Menu addMenuList(){
        Menu menu02 = new Menu();
        menu02.addMenuItem(new MenuItem(1,"불고기햄버12339거", 6,"맛있는 불고기 햄버거"));
        menu02.addMenuItem(new MenuItem(2," 치킨", 7.2,"맛있는 후라이드 치킨"));
        menu02.addMenuItem(new MenuItem(3,"콜라", 3,"마시는 콜라"));
        menu02.addMenuItem(new MenuItem(3,"사이다", 3.1,"마시는 사이다"));
        menu02.addMenuCategory(new Category(1,"햄버거"));
        menu02.addMenuCategory(new Category(2,"치킨"));
        menu02.addMenuCategory(new Category(3,"음료"));
        return menu02;
    }
    public Menu addMenuList2(){
        Menu menu03 = new Menu();
        menu03.addMenuItem(new MenuItem(1,"불불불", 6,"맛있는 불고기 햄버거"));
        menu03.addMenuItem(new MenuItem(2," 치킨", 7.2,"맛있는 후라이드 치킨"));
        menu03.addMenuItem(new MenuItem(3,"콜라", 3,"마시는 콜라"));
        menu03.addMenuItem(new MenuItem(3,"사이다", 3.1,"마시는 사이다"));
        menu03.addMenuCategory(new Category(1,"햄버거"));
        menu03.addMenuCategory(new Category(2,"치킨"));
        menu03.addMenuCategory(new Category(3,"음료"));
        return menu03;
    }
    // 키오스크 시작
    public void start(Menu menu){
        firstRoop:while(true) {
            menu.getTmpMenuItems().clear();
            Scanner sc = new Scanner(System.in);
            System.out.println("[MAIN MENU]");
            menu.printAllMenuCategory();
            System.out.println("0. 종료");
            System.out.println("원하는 메뉴 번호 입력 :");
            int input;
            int input2;
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
                }else if(input < 0){
                    System.out.println("지정되어있는 숫자를 입력해주세요");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("지정되어있는 숫자를 입력해주세요");
                continue;
            }
            if(input == menu.getMenuCategory().size()+1){
               order: while(true){
                    System.out.println("아래와 같이 주문하시겠습니까?");
                    System.out.println("[Orders]");
                    menu.printShoppingCartItems();
                    System.out.println("[Total]");
                    System.out.println(menu.shoppingCartItemsPrice()+"$");
                    System.out.println("1. 주문    2.  메뉴부분취소    3. 메뉴추가   4. 모든주문취소(처음화면으로)");
                    try {
                        input2 = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("지정되어있는 숫자를 입력해주세요");
                        continue;
                    }
                    if(input2 == 1){
                        while(true){
                            System.out.println("할인 정보를 입력해주세요");
                            System.out.println("할인 정보를 입력해주세요");
                            Discount.printDiscountList();
                            try {
                                input2 = sc.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("지정되어있는 숫자를 입력해주세요");
                                continue;
                            }
                            if(input2 > Discount.discountsLength() || input2 < 0){
                                System.out.println("지정되어있는 숫자를 입력해주세요");
                                continue;
                            }
                            Order<Double> order = new Order<>();
                            System.out.println("주문이 완료되었습니다 금액은 "+
                                    order.calDiscount(input2,menu.shoppingCartItemsPrice())+"$ 입니다.");
                            menu.getCartMenuItems().clear();
                            break firstRoop;
                        }
                    }else if(input2 == 2){
                        while(true) {
                            System.out.println("[Orders]");
                            menu.printShoppingCartItems();
                            System.out.println("취소할 메뉴를 선택해주세요.");
                            try {
                                input2 = sc.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("지정되어있는 숫자를 입력해주세요");
                                continue;
                            }
                            if(input2 > menu.getCartMenuItems().size() || input2 < 0){
                                System.out.println("지정되어있는 숫자를 입력해주세요");
                                continue;
                            }
                            menu.removeMenuItemCartStream(input2);
                            continue order;
                        }

                    }else if(input2 == 3){
                        continue firstRoop;
                    }
                    else if(input2 == 4) {
                        menu.getCartMenuItems().clear();
                        continue firstRoop;
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
                    menu.printAllMenuItemStream(input);
                    MenuItem m;
                    try {
                         input2 = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("지정되어있는 숫자를 입력해주세요");
                        continue;
                    }
                    if(input2 == 0){
                        continue firstRoop;
                    }else if(input2 < 0){
                        System.out.println("지정되어있는 숫자를 입력해주세요");
                        continue;
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
                       try {
                           input2 = sc.nextInt();
                       } catch (InputMismatchException e) {
                           System.out.println("지정되어있는 숫자를 입력해주세요");
                           continue;
                       }
                       if(input2 == 1){
                           menu.addCartMenuItems(m);
                           System.out.println(m.getName()+"가(이) 장바구니에 추가되었습니다.");
                           continue firstRoop;
                       }else if(input2 == 2){
                           continue firstRoop;
                       }else{
                           System.out.println("지정되어있는 숫자를 입력해주세요");
                       }
                   }
                }
        }
    }
}
