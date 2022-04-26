package gibin.kwon.study.baseballgame;

import gibin.kwon.study.baseballgame.controller.Controller;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();
    }
}
