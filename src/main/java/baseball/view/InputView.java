package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String NUMBER_PATTERN = "^[0-9]*$";

    private static String inputNumber() {
        String number = Console.readLine();
        validateNumber(number);
        return number;
    }

    public static List<Integer> getUniqueDigits(int count) {
        String input = inputNumber();
        List<Integer> digits = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        validateUniqueNumber(digits);
        validateCount(digits, count);

        return digits;
    }

    private static void validateNumber(String input) {
        if (!input.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private static void validateUniqueNumber(List<Integer> numbers) {
        int uniqueNumberSize = (int) numbers.stream()
                .distinct()
                .count();

        if (numbers.size() != uniqueNumberSize) {
            throw new IllegalArgumentException("서로 다른 숫자가 아닙니다");
        }
    }

    private static void validateCount(List<Integer> numbers, int count) {
        if (numbers.size() != count) {
            throw new IllegalArgumentException("입력하신 숫자는 " + numbers.size() + "개 입니다. " + count + "개를 입력해주세요");
        }
    }
}
