package gibin.kwon.study.baseballgame.controller;

import gibin.kwon.study.baseballgame.service.BaseBallGameService;

public class Controller {

    BaseBallGameService baseballgameService = new BaseBallGameService();

    public void run() throws IllegalArgumentException {
        setNumber();
        startGame();
        endGame();
    }

    private void setNumber() {
        baseballgameService.setGoalNumber();
    }

    private void startGame() throws IllegalArgumentException {
        System.out.print("숫자를 입력해 주세요 : ");
        baseballgameService.playGame();
    }

    private void endGame() throws IllegalArgumentException {
        if (baseballgameService.endGame() == 1) {
            run();
        }
    }

}
