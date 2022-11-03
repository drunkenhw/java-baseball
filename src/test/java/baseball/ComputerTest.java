package baseball;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ComputerTest {

    @Test
    void 컴퓨터가_각각_다른_숫자를_생성한다() {
        Computer computer = new Computer();
        List<Integer> answer = computer.generateAnswer();

        long count = answer.stream()
                .distinct()
                .count();

        assertThat(count).isEqualTo(3);
    }

}