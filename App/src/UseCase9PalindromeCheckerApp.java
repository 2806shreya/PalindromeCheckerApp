import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    // Method to check palindrome
    public static boolean isPalindrome(String input) {

        // Step 1: Normalize string
        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        int start = 0;
        int end = normalized.length() - 1;

        // Step 2: Two-pointer comparison
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        boolean result = isPalindrome(input);

        if (result) {
            System.out.println("The given input is a Palindrome (Ignoring case & spaces).");
        } else {
            System.out.println("The given input is NOT a Palindrome.");
        }

        scanner.close();
    }
}