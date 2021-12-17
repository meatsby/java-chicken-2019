package view;

import domain.Menu;
import domain.Table;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String ORDER_LINE = "└ W ┘";

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public static void printTables(final List<Table> tables) {
        System.out.println();
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(size);
        List<Integer> hasOrders = printTableNumbers(tables);
        printOrderLine(size, hasOrders);
    }

    private static void printLine(final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(TOP_LINE);
        }
        System.out.println();
    }

    private static void printOrderLine(final int count, List<Integer> hasOrders) {
        for (int index = 0; index < count; index++) {
            if (hasOrders.contains(index)) {
                System.out.print(ORDER_LINE);
                continue;
            }
            System.out.print(BOTTOM_LINE);
        }
        System.out.println();
    }

    private static List<Integer> printTableNumbers(final List<Table> tables) {
        List<Integer> hasOrders = new ArrayList<>();
        for (int i = 0; i < tables.size(); i++) {
            System.out.printf(TABLE_FORMAT, tables.get(i));
            if (tables.get(i).hasOrder()) {
                hasOrders.add(i);
            }
        }
        System.out.println();
        return hasOrders;
    }

    public static void printMainMenu() {
        System.out.println();
        System.out.println("## 메인화면");
        System.out.println("1. 주문등록");
        System.out.println("2. 결제하기");
        System.out.println("3. 프로그램 종료");
    }

    public static void printError(String message) {
        System.out.println(message);
    }
}
