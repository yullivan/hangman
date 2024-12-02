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
    static char getGuess() {
        System.out.print("글자를 추측하세요: ");
        return scanner.nextLine().toUpperCase().charAt(0);
    }

    static String getHangmanPic(int wrongGuesses) {
        return HANGMAN_PICS[Math.min(wrongGuesses, 6)];
    }

}
