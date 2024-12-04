package hangman;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // 게임 준비
        String answerWord = Utils.getRandomWord();
        System.out.println(answerWord);
        List<String> maskedWord = generateMaskedWord(answerWord);

        // 게임 진행
        String userGuess = Utils.getGuess();
        List<Integer> indexes = locateUserGuess(answerWord, userGuess);
    }

    static List<String> generateMaskedWord(String answerWord) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < answerWord.length(); i++) {
            list.add("_");
        }
        return list;
    }

    static List<Integer> locateUserGuess(String answerWord, String userGuess) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < answerWord.length(); i++) {
            /*
            * 예시
            * answerWord: PROGRAMMING, userGuess: R
            * [i: 0] P == R
            * [i: 1] R == R
            * [i: 2] O == R
            * */
            // if (answerWord.charAt(i) == userGuess.charAt(0)) {
            if (answerWord.substring(i, i + 1).equals(userGuess)) {
                result.add(i);
            }
        }

        return result;
    }
}
