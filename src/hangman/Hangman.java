package hangman;

/**
 *
 * @author Treus
 */
import java.util.Scanner;

public class Hangman {

    private static String[] games = {"mobile legends", "wild rift", "League of legends", "genshin Impact", "mario", "call of duty"};
    private static String[] foods = {"pizza", "burger", "spaghetti", "carbonara", "ice cream", "chocolate"};
    private static String[] movies = {"frozen", "spiderman", "superman", "batman"};
    private static String[] work = {"doctor", "engineer", "programmer", "nurse", "teacher", "janitor"};
    private static String[] currentCategory;
    private static String word;
    private static String asterisk;
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a category:");
        System.out.println("1. Games");
        System.out.println("2. Foods");
        System.out.println("3. movies");
        System.out.println("4. work");
        System.out.print("Your choice of category: ");

        int categoryChoice = sc.nextInt();

        if (categoryChoice == 1) {
            currentCategory = games;
        } else if (categoryChoice == 2) {
            currentCategory = foods;
        } else if (categoryChoice == 3) {
            currentCategory = movies;
        } else if (categoryChoice == 4) {
            currentCategory = work;
        } else {
            System.out.println("Invalid choice. Exiting the game.");
            return;
        }

        word = currentCategory[(int) (Math.random() * currentCategory.length)];
        asterisk = new String(new char[word.length()]).replace("\0", "*");

        while (count < 7 && asterisk.contains("*")) {
            System.out.println("Guess any letter from the category.");
            System.out.println(asterisk);
            String guess = sc.next().toLowerCase(); // Convert the guess to lowercase for case-insensitive comparison
            hang(guess);
        }

        sc.close();
    }

    private static void hang(String guess) {
        String newAsterisk = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess.charAt(0)) {
                newAsterisk += guess.charAt(0);
            } else if (asterisk.charAt(i) != '*') {
                newAsterisk += word.charAt(i);
            } else {
                newAsterisk += "*";
            }
        }

        if (asterisk.equals(newAsterisk)) {
            count++;
            hangmanImage();
        } else {
            asterisk = newAsterisk;
        }
        if (asterisk.equals(word)) {
            System.out.println("");
            System.out.println("Correct! You win! The word was " + word);
        }
    }

	public static void hangmanImage() {
		if (count == 1) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (count == 2) {
			System.out.println("Wrong guess, try again");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 3) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (count == 4) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 5) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 6) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		if (count == 7) {
			System.out.println("GAME OVER!");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			System.out.println("GAME OVER! The word was " + word);
		}
	}
}
