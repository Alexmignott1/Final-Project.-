import java.util.*;

public class Hangman {
    private static final String[] WORD_BANK = {"HIETT", "PLANTZ", "TREVER", "COLMAN"};
    private static final int MAX_GUESSES = 6;
    private static final int CORRECT_GUESS_POINTS = 10;
    private static final int INCORRECT_GUESS_POINTS = -5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordToGuess = selectRandomWordFromBank();
        char[] guessedLetters = new char[wordToGuess.length()];
        Arrays.fill(guessedLetters, '_');
        int incorrectGuesses = 0;
        int score = 0;

        while (incorrectGuesses < MAX_GUESSES) {
            System.out.println("Word: " + String.valueOf(guessedLetters));
            System.out.println("Guesses left: " + (MAX_GUESSES - incorrectGuesses));
            System.out.println("Score: " + score);
            System.out.print("Guess a letter: ");
            char guess = scanner.nextLine().toUpperCase().charAt(0);

            if (wordToGuess.indexOf(guess) == -1) {
                System.out.println("Incorrect guess!");
                incorrectGuesses++;
                score += INCORRECT_GUESS_POINTS;
            } else {
                System.out.println("Correct guess!");
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        guessedLetters[i] = guess;
                    }
                }
                score += CORRECT_GUESS_POINTS;
            }

            if (String.valueOf(guessedLetters).equals(wordToGuess)) {
                System.out.println("Congratulations, you guessed the word!");
                System.out.println("Final score: " + score);
                return;
            }
        }

        System.out.println("You ran out of guesses. The word was: " + wordToGuess);
        System.out.println("Final score: " + score);
    }

    private static String selectRandomWordFromBank() {
        Random random = new Random();
        return WORD_BANK[random.nextInt(WORD_BANK.length)];
    }
}
