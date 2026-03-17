import java.util.Stack;

class UseCase10PalindromeCheckerApp {

    // Method to check palindrome
    public boolean checkPalindrome(String input) {
        // Remove spaces and convert to lowercase
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (int i = 0; i < cleaned.length(); i++) {
            stack.push(cleaned.charAt(i));
        }

        // Compare with original string
        for (int i = 0; i < cleaned.length(); i++) {
            if (cleaned.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Main class to test
public class Main {
    public static void main(String[] args) {
        UseCase10PalindromeCheckerApp checker = new UseCase10PalindromeCheckerApp();

        String test = "Madam";

        if (checker.checkPalindrome(test)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }
}