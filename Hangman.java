import java.util.*;

public class Hangman {
    private static final String[] WORD_BANK = {"HIETT", "PLANTZ", "TREVOR", "COLEMAN"};
    private static final int MAX_GUESSES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordToGuess = selectRandomWordFromBank();
        char[] guessedLetters = new char[wordToGuess.length()];
        Arrays.fill(guessedLetters, '_');
        int incorrectGuesses = 0;

        while (incorrectGuesses < MAX_GUESSES) {
            System.out.println("Word: " + String.valueOf(guessedLetters));
            System.out.println("Guesses left: " + (MAX_GUESSES - incorrectGuesses));
            System.out.print("Guess a letter: ");
            char guess = scanner.nextLine().toUpperCase().charAt(0);

            if (wordToGuess.indexOf(guess) == -1) {
                System.out.println("Incorrect guess!");
                incorrectGuesses++;
            } else {
                System.out.println("Correct guess!");
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        guessedLetters[i] = guess;
                    }
                }
            }

            if (String.valueOf(guessedLetters).equals(wordToGuess)) {
                System.out.println("Congratulations, you guessed the word!");
                return;
            }
        }

        System.out.println("You ran out of guesses. The word was: " + wordToGuess);
    }

    private static String selectRandomWordFromBank() {
        Random random = new Random();
        return WORD_BANK[random.nextInt(WORD_BANK.length)];
    }
}
