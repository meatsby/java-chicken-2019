package util;

import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;

public class InputValidator {
	private static final String PLACE_ORDER = "1";
	private static final String PAYMENT = "2";
	private static final String TERMINATION = "3";
	private static final String ERROR = "[ERROR] ";
	private static final String INVALID_INPUT = "유효한 입력이 아닙니다.";
	private static final String INVALID_TABLE_NUMBER = "해당 테이블이 존재하지 않습니다.";
	private static final String INVALID_MENU_NUMBER = "해당 메뉴가 존재하지 않습니다.";
	private static final String INVALID_MENU_QUANTITY = "최대 99개까지 주문 가능합니다.";

	public static void isValidMainCommend(String mainCommend) {
		if (!(mainCommend.equals(PLACE_ORDER) || mainCommend.equals(PAYMENT) || mainCommend.equals(TERMINATION))) {
			throw new IllegalArgumentException(ERROR + INVALID_INPUT);
		}
	}

	public static void isValidTableNumber(String tableNumber) {
		if (!TableRepository.tableNumbers().contains(tableNumber)) {
			throw new IllegalArgumentException(ERROR + INVALID_TABLE_NUMBER);
		}
	}

	public static void isValidMenuNumber(String menuNumber) {
		if (!MenuRepository.menuNumbers().contains(menuNumber)) {
			throw new IllegalArgumentException(ERROR + INVALID_MENU_NUMBER);
		}
	}

	public static int isValidMenuQuantity(String menuNumber, String menuQuantity, Table table) {
		try {
			Integer.parseInt(menuQuantity);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR + "숫자여야합니다.");
		}
		if (!table.canOrder(menuNumber, Integer.parseInt(menuQuantity))) {
			throw new IllegalArgumentException(ERROR + INVALID_MENU_QUANTITY);
		}
		if (Integer.parseInt(menuQuantity) < 0) {
			throw new IllegalArgumentException(ERROR + "양수여야합니다.");
		}
		return Integer.parseInt(menuQuantity);
	}
}
