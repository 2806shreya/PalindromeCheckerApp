import java.util.Scanner;

public class UseCase9PalindromeCheckerApp {

    // Recursive function to check palindrome
    public static boolean isPalindrome(String word, int start, int end) {

        // Base condition
        if (start >= end) {
            return true;
        }

        // If characters do not match
        if (word.charAt(start) != word.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindrome(word, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = scanner.nextLine().toLowerCase();

        boolean result = isPalindrome(word, 0, word.length() - 1);

        if (result) {
            System.out.println("The word \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + word + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}