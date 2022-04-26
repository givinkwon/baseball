package gibin.kwon.study.baseballgame.utils;


public class RandomNumber {

    public static int[] getRandomNumbers(int size, int start, int end) {
        int[] numbers = new int[3];

        for (int i = 0; i < size; i++) {
            numbers[i] = getUniqueRandomNumber(numbers, start, end, i);
        }
        return numbers;
    }

    private static int getUniqueRandomNumber(int[] numbers, int start, int end, int i) {
        int randomNumber = (int)(Math.random() * 10);
        while (!isUnique(numbers, i, randomNumber)) {
            randomNumber = (int)(Math.random() * 10);
        }
        return randomNumber;
    }

    private static Boolean isUnique(int[] numbers, int i, int randomNumber) {
        for (int j = 0; j < i; j++) {
            if (numbers[j] == randomNumber) {
                return false;
            }
        }
        return true;
    }
}