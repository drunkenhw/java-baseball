package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    private InputStream generateInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private void generatePlayerInput(String input) {
        System.setIn(generateInputStream(input));
    }

    @DisplayName("입력 받은 값을 숫자를 자릿수 별로 나눈다.")
    @ParameterizedTest
    @ValueSource(strings = "123")
    void inputNumberToDigitsTest(String input) {
        generatePlayerInput(input);

        List<Integer> uniqueDigits = InputView.getUniqueDigits(3);

        assertThat(uniqueDigits).containsExactly(1, 2, 3);
    }

    @DisplayName("입력 받은 값이 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = "일이삼")
    void inputNumberTest(String input) {
        generatePlayerInput(input);

        assertThatThrownBy(() -> InputView.getUniqueDigits(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 값이 서로 다른 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = "112")
    void inputNumberUniqueTest(String input) {
        generatePlayerInput(input);

        assertThatThrownBy(() -> InputView.getUniqueDigits(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 값이 3자리 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = "1234")
    void inputNumberSizeTest(String input) {
        generatePlayerInput(input);

        assertThatThrownBy(() -> InputView.getUniqueDigits(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 값을 숫자가 서로 다르면서 1~9 까지의 숫자가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = "023")
    void inputNumberRangeTest(String input) {
        generatePlayerInput(input);

        assertThatThrownBy(() -> InputView.getUniqueDigitsInRange(1, 9, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

}