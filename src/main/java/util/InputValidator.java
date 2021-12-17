package util;

public class InputValidator {
	private static final String PLACE_ORDER = "1";
	private static final String PAYMENT = "2";
	private static final String TERMINATION = "3";
	private static final String ERROR = "[ERROR] ";
	private static final String INVALID_INPUT = "유효한 입력이 아닙니다.";

	public static void isValidMainCommend(String mainCommend) {
		if (!(mainCommend.equals(PLACE_ORDER) || mainCommend.equals(PAYMENT) || mainCommend.equals(TERMINATION))) {
			throw new IllegalArgumentException(ERROR + INVALID_INPUT);
		}
	}
}
