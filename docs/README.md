

##  기능 구현 목록

- [x] 게임 시작 문구를 출력한다 **(OutputView)**
- [x] 컴퓨터가 임의의 서로 다른 3개의 숫자를 생성한다. **(Computer)**
- [ ] 플레이어에게 숫자를 입력 받는다.  **(Player)**
- [ ] 플레이어에게 받은 숫자와 컴퓨터의 숫자를 비교한다.**(BaseballGame)**
- [ ] 비교한 결과값을 출력한다. **(OutputView)**
    - [ ] 각 자릿수에 맞는 숫자를 입력 받으면 `${갯수} 스트라이크`를 반환한다. **(OutputView)**
    - [ ] 각 자릿수에 맞지 않지만 숫자만 같은 수를 입력 받으면 `${갯수} 볼`을 반환한다. **(OutputView)**
    - [ ] 숫자가 아무것도 같지 않다면`낫싱`을 반환한다.**(OutputView)**
    - [ ] 정답을 맞추면 `3개의 숫자를 모두 맞히셨습니다! 게임종료`를 반환한다.**(OutputView)**
- [ ] 정답을 맞추면 게임 재시작 유무를 입력받는다. **(Player)**
- [ ] 재시작을 원하면 처음부터 다시 시작한다. **(BaseballGame)**
- 예외 처리 `(예외는 IllegalArgumentException을 발생시킨다)`
    - [ ] 플레이어가 3자리 수를 입력하지 않으면 예외를 발생시킨다 **(Validator)**
    - [ ] 플레이어가 입력한 수가 서로 다르지 않으면 예외를 발생시킨다.**(Validator)**
    - [ ] 플레이어가 입력한 수가 `1~9`가 아니면 예외를 발생시킨다.**(Validator)**
    - [ ] 재시작 유무를 입력받을 때 `1, 2`가 아닌 수를 입력하면 예외를 발생시킨다.**(Validator)**

## 클래스 목록

- Computer
    - 랜덤한 3자리 숫자를 생성한다.
- Player
    - Input으로 3자리 숫자를 받는다.
- BaseballGame
    - 게임 결과를 계산한다.
    - 시작, 종료 유무를 판단한다.
- OutputView
    - Console에 메세지를 출력한다.
- Validator
    - 입력받은 값을 검증한다.
- Application
    - 게임을 실행한다.