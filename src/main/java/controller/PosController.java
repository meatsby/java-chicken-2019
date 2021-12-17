package controller;

import domain.MenuRepository;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class PosController {
	public void run() {
		while (true) {
			OutputView.printMainMenu();
			int mainCommend = getMainCommend();
			if (mainCommend == 1) {
				executeOrder();
			}
			if (mainCommend == 2) {
				executePayment();
			}
			if (mainCommend == 3) {
				return;
			}
		}
	}

	private void executeOrder() {
		OutputView.printTables(TableRepository.tables());
		int tableNumber = getTableNumber();
		OutputView.printMenus(MenuRepository.menus());
		int menuNumber = getMenuNumber();
		int menuQuantity = getMenuQuantity();
	}

	private void executePayment() {
		OutputView.printTables(TableRepository.tables());
		int tableNumber = getTableNumber();
		OutputView.printOrderList();
		int paymentType = getPaymentType();
		OutputView.printPayment();
	}

	private int getMainCommend() {
		int mainCommend = InputView.inputMenu();
		try {
			InputValidator.isValidMainCommend(mainCommend);
			return mainCommend;
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getMainCommend();
		}
	}

	private int getTableNumber() {
		int tableNumber = InputView.inputTableNumber();
		try {
			InputValidator.isValidTableNumber(tableNumber);
			return tableNumber;
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getTableNumber();
		}
	}

	private int getMenuNumber() {
		int menuNumber = InputView.inputMenuNumber();
		try {
			InputValidator.isValidMenuNumber(menuNumber);
			return menuNumber;
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getMenuNumber();
		}
	}

	private int getMenuQuantity() {
		int menuQuantity = InputView.inputMenuQuantity();
		try {
			InputValidator.isValidMenuQuantity(menuQuantity);
			return menuQuantity;
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getMenuQuantity();
		}
	}
	
	private int getPaymentType() {
		int paymentType = InputView.inputPayMentType();
		try {
			InputValidator.isValidPayMentType(paymentType);
			return paymentType;
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getPaymentType();
		}
	}
}
