package hangman;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // 게임 준비
        String answerWord = Utils.getRandomWord();
        System.out.println(answerWord);
        List<String> maskedWord = generateMaskedWord(answerWord);
    }

    static List<String> generateMaskedWord(String answerWord) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < answerWord.length(); i++) {
            list.add("_");
        }
        return list;
    }
}
