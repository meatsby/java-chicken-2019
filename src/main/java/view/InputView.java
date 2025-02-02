package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMenu() {
        System.out.println();
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }

    public static String inputTableNumber() {
        System.out.println();
        System.out.println("## 테이블을 선택하세요.");
        return scanner.nextLine();
    }

    public static String inputMenuNumber() {
        System.out.println();
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return scanner.nextLine();
    }

    public static String inputMenuQuantity() {
        System.out.println();
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return scanner.nextLine();
    }
}
