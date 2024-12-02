package hangman;

import java.util.Scanner;

public class Utils {

    static Scanner scanner = new Scanner(System.in);
    static String[] WORDS = {"JAVA", "PROGRAMMING", "COMPUTER", "ALGORITHM"};
    // 행맨 그림 표시용
    static final String[] HANGMAN_PICS = {
            """
            +---+
            |   |
                |
                |
                |
                |
            ==========""",
            """
            +---+
            |   |
            O   |
                |
                |
                |
            ==========""",
            """
            +---+
            |   |
            O   |
            |   |
                |
                |
            ==========""",
            """
            +---+
            |   |
            O   |
           /|   |
                |
                |
            ==========""",
            """
            +---+
            |   |
            O   |
           /|\\  |
                |
                |
            ==========""",
            """
            +---+
            |   |
            O   |
           /|\\  |
           /    |
                |
            ==========""",
            """
            +---+
            |   |
            O   |
           /|\\  |
           / \\  |
                |
            ==========""",
    };

    // 랜덤 단어 선택 메소드
    static String getRandomWord() {
        return WORDS[(int) (Math.random() * WORDS.length)];
    }

    // 사용자 입력을 받는 메소드
    static private String getInput() {
        System.out.print("글자를 추측하세요: ");
        String input = scanner.nextLine();
        if (input.length() != 1) {
            throw new IllegalArgumentException("[ERROR] 알파벳 한 자만 입력해야 합니다.");
        }

        char letter = input.charAt(0);
        if (!Character.isAlphabetic(letter)) {
            throw new IllegalArgumentException("[ERROR] 알파벳이 아닙니다. 알파벳을 입력해 주세요.");
        }
        return String.valueOf(Character.toUpperCase(letter));
    }

    static String getGuess() {
        String guess = "";
        while (guess.isEmpty()) {
            try {
                guess = getInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return guess;
    }

    static String getHangmanPic(int wrongGuesses) {
        return HANGMAN_PICS[Math.min(wrongGuesses, 6)];
    }

}
