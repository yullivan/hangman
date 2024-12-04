package hangman;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HangmanTest {

    @Test
    void 가려진단어만들기() {
        // given
        String answerWord = "PROGRAMMING";

        // when
        List<String> maskedWord = Application.generateMaskedWord(answerWord);

        // then
        assertThat(maskedWord).isEqualTo(List.of("_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_"));
    }

    @Test
    void 알파벳위치찾기1() {
        // given
        String answerWord = "PROGRAMMING";
        String userGuess = "R";

        // when
        List<Integer> indexes = Application.locateUserGuess(answerWord, userGuess);

        // then
        assertThat(indexes).isEqualTo(List.of(1, 4));
    }
    @Test
    void 알파벳위치찾기2() {
        // given
        String answerWord = "PROGRAMMING";
        String userGuess = "X";

        // when
        List<Integer> indexes = Application.locateUserGuess(answerWord, userGuess);

        // then
        assertThat(indexes).isEqualTo(List.of());
    }

    @Test
    void 알파벳으로교체하기1() {
        // given
        String userGuess = "R";
        List<Integer> indexes = List.of(1, 4);
        List<String> maskedWord = List.of("_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_");

        // when
        List<String> newMaskedWord = Application.replaceWithAlphabet(maskedWord, indexes, userGuess);

        // then
        assertThat(newMaskedWord).isEqualTo(List.of("_", "R", "_", "_", "R", "_", "_", "_", "_", "_", "_"));

    }

    @Test
    void 알파벳으로교체하기2() {
        // given
        String userGuess = "X";
        List<Integer> indexes = List.of();
        List<String> maskedWord = List.of("_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_");

        // when
        List<String> newMaskedWord = Application.replaceWithAlphabet(maskedWord, indexes, userGuess);

        // then
        assertThat(newMaskedWord).isEqualTo(List.of("_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_"));

    }

    @Test
    void 게임오버판단1() {
        // given
        int wrongCount = 6;
        List<String> maskedWord = List.of("_", "_", "_");

        // when
        boolean result = Application.isGameOver(wrongCount, maskedWord);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 게임오버판단2() {
        // given
        int wrongCount = 5;
        List<String> maskedWord = List.of("_", "_", "_");

        // when
        boolean result = Application.isGameOver(wrongCount, maskedWord);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void 게임오버판단3() {
        // given
        int wrongCount = 5;
        List<String> maskedWord = List.of("a", "b", "c");

        // when
        boolean result = Application.isGameOver(wrongCount, maskedWord);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 틀린개수증가1() {
        // given
        int wrongCount = 1;
        List<Integer> indexes = List.of();

        // when
        int newWrongCount = Application.incrementWrongCount(indexes, wrongCount);

        // then
        assertThat(newWrongCount).isEqualTo(wrongCount + 1);
    }

    @Test
    void 틀린개수증가2() {
        // given
        int wrongCount = 1;
        List<Integer> indexes = List.of(3);

        // when
        int newWrongCount = Application.incrementWrongCount(indexes, wrongCount);

        // then
        assertThat(newWrongCount).isEqualTo(wrongCount);
    }
}
