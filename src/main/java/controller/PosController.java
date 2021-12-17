package controller;

import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import util.InputValidator;
import view.InputView;
import view.OutputView;

public class PosController {
	public void run() {
		while (true) {
			OutputView.printMainMenu();
			String mainCommend = getMainCommend();
			if (mainCommend.equals("1")) {
				executeOrder();
			}
			if (mainCommend.equals("2")) {
				executePayment();
			}
			if (mainCommend.equals("3")) {
				return;
			}
		}
	}

	private void executeOrder() {
		OutputView.printTables(TableRepository.tables());
		String tableNumber = getTableNumber();
		OutputView.printMenus(MenuRepository.menus());
		String menuNumber = getMenuNumber();
		String menuQuantity = getMenuQuantity();
		for (Table table : TableRepository.tables()) {
			if (tableNumber.equals(table.toString())) {
				table.addOrder(menuNumber, menuQuantity);
			}
		}
	}

	private void executePayment() {
		// OutputView.printTables(TableRepository.tables());
		// String tableNumber = getTableNumber();
		// OutputView.printOrderList();
		// String paymentType = getPaymentType();
		// OutputView.printPayment();
	}

	private String getMainCommend() {
		String mainCommend = InputView.inputMenu();
		try {
			InputValidator.isValidMainCommend(mainCommend);
			return mainCommend;
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getMainCommend();
		}
	}

	private String getTableNumber() {
		String tableNumber = InputView.inputTableNumber();
		try {
			InputValidator.isValidTableNumber(tableNumber);
			return tableNumber;
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getTableNumber();
		}
	}

	private String getMenuNumber() {
		String menuNumber = InputView.inputMenuNumber();
		try {
			InputValidator.isValidMenuNumber(menuNumber);
			return menuNumber;
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getMenuNumber();
		}
	}

	private String getMenuQuantity() {
		String menuQuantity = InputView.inputMenuQuantity();
		try {
			InputValidator.isValidMenuQuantity(menuQuantity);
			return menuQuantity;
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getMenuQuantity();
		}
	}

	// private String getPaymentType() {
	// 	String paymentType = InputView.inputPayMentType();
	// 	try {
	// 		InputValidator.isValidPayMentType(paymentType);
	// 		return paymentType;
	// 	} catch (IllegalArgumentException e) {
	// 		OutputView.printError(e.getMessage());
	// 		return getPaymentType();
	// 	}
	// }
}
