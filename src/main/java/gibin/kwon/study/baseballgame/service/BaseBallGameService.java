package gibin.kwon.study.baseballgame.service;

import gibin.kwon.study.baseballgame.domain.Game;
import gibin.kwon.study.baseballgame.utils.RandomNumber;

import java.util.Scanner;

public class BaseBallGameService {

    private final static int SIZE = 3;
    private final static int START_NUMBER = 1;
    private final static int END_NUMBER = 9;
    private final static int CHECK_RESULT = 0;
    Game game = new Game();
    int[] inputnumber = new int[3];

    public void setGoalNumber() {
        game.setGoalNumber(RandomNumber.getRandomNumbers(SIZE, START_NUMBER, END_NUMBER));
    }

    public void playGame() {
        int strike = 0;
        while (strike != 3) {
            play();

            printResult();

            strike = game.getStrikeCount();
        }
    }

    private void printResult() {
        if(game.getStrikeCount() > CHECK_RESULT) {
            System.out.println(game.getStrikeCount() + " 스트라이크");
        }

        if(game.getBallCount() > CHECK_RESULT) {
            System.out.println(game.getBallCount() + " 볼");
        }

        if(game.getBallCount() == CHECK_RESULT && game.getStrikeCount() == CHECK_RESULT){
            System.out.println("4볼");
        }
    }

    private void play() {
        game.init();

        inputnumber = setInputNumber();

        computeScore(inputnumber);
    }

    private int[] setInputNumber() {
        Scanner inputscanner = new Scanner(System.in);
        String input = inputscanner.next();

        for (int i = 0; i < input.length(); i++){
            inputnumber[i] = Integer.parseInt(input.split("")[i]);
        }
        return inputnumber;
    }

    private void computeScore(int[] inputnumber) {
        for (int i = 0; i < 3; i++) {
            compute(game.getGoalNumber(), inputnumber, i);
        }
    }

    private void compute(int[] GoalNumber, int[] inputNumber, int index) {
        int temp = -1;
        for (int i = 0; i < GoalNumber.length; i++) {
            temp = computeMatchCount(GoalNumber, inputNumber, index, i, temp);
        }
        incCount(index, temp);
    }

    private int computeMatchCount(int[] GoalNumber, int[] inputNumber, int index, int i, int temp) {
        if (GoalNumber[i] == inputNumber[index]) {
            return i;
        }
        return temp;
    }

    private void incCount(int index, int temp) {
        if (temp != index && temp != -1) {
            game.incBallCount();
        }
        if (temp == index) {
            game.incStrikeCount();
        }
    }

    public int endGame() {
        System.out.println("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner inputscanner = new Scanner(System.in);
        int input = inputscanner.nextInt();
        return input;
    }
}
