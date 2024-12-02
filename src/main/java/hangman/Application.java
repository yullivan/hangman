package hangman;

public class Application {

    public static void main(String[] args) {
        System.out.println("랜덤 단어1: " + Utils.getRandomWord());
        System.out.println("랜덤 단어2: " + Utils.getRandomWord());
        System.out.println("랜덤 단어3: " + Utils.getRandomWord());
        System.out.println("랜덤 단어4: " + Utils.getRandomWord());

        System.out.println(Utils.getHangmanPic(0));
        System.out.println(Utils.getHangmanPic(1));
        System.out.println(Utils.getHangmanPic(2));
        System.out.println(Utils.getHangmanPic(3));
        System.out.println(Utils.getHangmanPic(4));
        System.out.println(Utils.getHangmanPic(5));
        System.out.println(Utils.getHangmanPic(6));

        System.out.println(Utils.getGuess());
    }

}
