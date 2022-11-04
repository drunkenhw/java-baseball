package baseball;

import baseball.view.InputView;
import java.util.List;

public class Player {

    private final List<Integer> expectNumber;

    public Player() {
        this.expectNumber = inputNumber();
    }

    private List<Integer> inputNumber() {
        return InputView.getUniqueDigitsInRange(1,9,3);
    }
}
