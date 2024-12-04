package hangman;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static final String MASK = "_";
    static final int MAX_WRONG_COUNT = 6;

    public static void main(String[] args) {
        // 게임 준비
        String answerWord = Utils.getRandomWord();
        System.out.println(answerWord);
        List<String> maskedWord = generateMaskedWord(answerWord);

        int wrongCount = 0;
        // 게임 진행
        while (!isGameOver(wrongCount, maskedWord)) {
            showWord(maskedWord);
            System.out.println("틀린 횟수: " + wrongCount);
            String userGuess = Utils.getGuess();
            List<Integer> indexes = locateUserGuess(answerWord, userGuess);
            wrongCount = incrementWrongCount(indexes, wrongCount);
            maskedWord = replaceWithAlphabet(maskedWord, indexes, userGuess);
        }
    }

    static int incrementWrongCount(List<Integer> indexes, int wrongCount) {
        if (indexes.isEmpty()) {
            return wrongCount + 1;
        }
        return wrongCount;
    }

    static boolean isGameOver(int wrongCount, List<String> maskedWord) {
        if (wrongCount == MAX_WRONG_COUNT) {
            return true;
        }
        if (!maskedWord.contains(MASK)) {
            return true;
        }
        return false;
    }

    static List<String> generateMaskedWord(String answerWord) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < answerWord.length(); i++) {
            list.add(MASK);
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

    static List<String> replaceWithAlphabet(List<String> maskedWord, List<Integer> indexes, String userGuess) {
        ArrayList<String> result = new ArrayList<>();
        for (String alphabet : maskedWord) {
            result.add(alphabet);
        }

        for (Integer index : indexes) {
//            maskedWord.set(index, userGuess);
            result.set(index, userGuess);
        }

        return result;
    }

    static void showWord(List<String> maskedWord) {
        String joinedWord = String.join("", maskedWord);
        System.out.println(joinedWord);
    }
}
