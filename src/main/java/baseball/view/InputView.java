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

    public static List<Integer> getUniqueDigits(int size) {
        String input = inputNumber();
        List<Integer> digits = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        validateUniqueNumber(digits);
        validateCount(digits, size);

        return digits;
    }

    public static List<Integer> getUniqueDigitsInRange(int start, int end, int size) {
        List<Integer> uniqueDigits = getUniqueDigits(size);

        validateRange(uniqueDigits, start, end);

        return uniqueDigits;
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

    private static void validateRange(List<Integer> numbers, int start, int end) {
        boolean isOutOfRange = numbers.stream()
                .anyMatch(n -> n < start || n > end);

        if (isOutOfRange) {
            throw new IllegalArgumentException("숫자는 " + start + " ~ " + end + " 사이만 가능합니다");
        }
    }
}
