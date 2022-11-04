package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String NUMBER_PATTERN = "^[0-9]*$";

    private static String inputNumber() {
        String number = Console.readLine();
        validateNumber(number);
        return number;
    }

    private static void validateNumber(String input) {
        if (!input.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

}
