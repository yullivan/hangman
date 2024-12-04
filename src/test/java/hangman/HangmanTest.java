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
}
