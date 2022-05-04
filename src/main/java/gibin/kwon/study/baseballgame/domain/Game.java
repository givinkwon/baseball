package gibin.kwon.study.baseballgame.domain;

public class Game {
    int[] goalNumber;
    int[] inputNumber;
    int strikeCount;
    int ballCount;

    public void init() {
        strikeCount = 0;
        ballCount = 0;
    }

    public void setGoalNumber(int[] goalNumber) {
        this.goalNumber = goalNumber;
    }

    public int[] getGoalNumber() {
        return goalNumber;
    }

    public void setInputNumber(int[] inputNumber) {
        this.inputNumber = inputNumber;
    }

    public int[] getInputNumber() {
        return inputNumber;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void incStrikeCount() {
        strikeCount += 1;
    }

    public void incBallCount() {
        ballCount += 1;
    }

}
