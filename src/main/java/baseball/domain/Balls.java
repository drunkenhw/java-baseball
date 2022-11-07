package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Balls {
    private List<Ball> balls;

    private Balls(List<Ball> balls) {
        this.balls = balls;
    }

    //TODO 더 좋은 네이밍 생각해보기
    public static Balls generateUniqueBalls() {
        List<Ball> uniqueBalls = new ArrayList<>();
        while (uniqueBalls.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            Ball randomBall = new Ball(randomNumber);

            if (!uniqueBalls.contains(randomBall)) {
                uniqueBalls.add(randomBall);
            }
        }
        return new Balls(uniqueBalls);
    }

    public static Balls convertNumberToBalls(List<Integer> inputNumber) {
        List<Ball> balls = inputNumber.stream()
                .map(Ball::new)
                .collect(Collectors.toList());
        return new Balls(balls);
    }

    public int equalsExactly(Balls player) {
        int count = 0;
        for (int position = 0; position < balls.size(); position++) {
            if (isBallEqual(player, position)) {
                count++;
            }
        }
        return count;
    }

    private boolean isBallEqual(Balls player, int index) {
        return getBall(index).equals(player.getBall(index));
    }

    private Ball getBall(int index) {
        return balls.get(index);
    }

    public int containsCountWithoutEqual(Balls player) {
        int count = 0;
        for (int position = 0; position < balls.size(); position++) {
            if (balls.contains(player.getBall(position)) && !isBallEqual(player, position)) {
                count++;
            }
        }
        return count;
    }
}
