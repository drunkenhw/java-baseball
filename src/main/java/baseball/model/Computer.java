package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    private final List<Integer> answer;

    public Computer() {
        this.answer = generateAnswer();
    }

    public List<Integer> generateAnswer() {
        Set<Integer> uniqueAnswer = new HashSet<>();
        while (uniqueAnswer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            uniqueAnswer.add(randomNumber);
        }
        return new ArrayList<>(uniqueAnswer);
    }
}
