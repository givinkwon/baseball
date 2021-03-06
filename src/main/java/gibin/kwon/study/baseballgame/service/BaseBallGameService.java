package gibin.kwon.study.baseballgame.service;

import gibin.kwon.study.baseballgame.domain.Information;
import gibin.kwon.study.baseballgame.utils.RandomNumber;

import java.util.Scanner;

public class BaseBallGameService {

    final int SIZE = 3;
    final int START_NUMBER = 1;
    final int END_NUMBER = 9;
    Information information = new Information();
    int[] inputnumber = new int[3];

    public void setNumber() {
        information.setGoalNumber(RandomNumber.getRandomNumbers(SIZE, START_NUMBER, END_NUMBER));
    }

    public void playGame() {
        int strike = 0;
        while (strike != 3) {
            play();

            printResult();

            strike = information.getStrikeCount();
        }
    }

    private void printResult() {
        if(information.getStrikeCount() > 0) {
            System.out.println(information.getStrikeCount() + " 스트라이크");
        }

        if(information.getBallCount() > 0) {
            System.out.println(information.getBallCount() + " 볼");
        }

        if(information.getBallCount() == 0 && information.getStrikeCount() == 0){
            System.out.println("4볼");
        }
    }

    private void play() {
        information.init();

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
            compute(information.getGoalNumber(), inputnumber, i);
        }
    }

    private void compute(int[] GoalNumber, int[] inputNumber, int index) {
        int temp = -1;
        for (int i = 0; i < GoalNumber.length; i++) {
            if (GoalNumber[i] == inputNumber[index]) {
                temp = i;
                break;
            }
        }
        incCount(index, temp);
    }

    private void incCount(int index, int temp) {
        if (temp != index && temp != -1) {
            information.incBallCount();
        }
        if (temp == index) {
            information.incStrikeCount();
        }
    }

    public int endGame() {
        System.out.println("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner inputscanner = new Scanner(System.in);
        int input = inputscanner.nextInt();
        return input;
    }
}
