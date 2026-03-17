import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack Strategy
class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : cleaned.toCharArray()) {
            stack.push(c);
        }

        for (char c : cleaned.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque Strategy
class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : cleaned.toCharArray()) {
            deque.add(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// Context Class
class PalindromeChecker {
    private PalindromeStrategy strategy;

    // Inject strategy at runtime
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set!");
        }
        return strategy.isPalindrome(input);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        // Choose strategy dynamically
        System.out.println("Choose Strategy: 1. Stack  2. Deque");
        int choice = sc.nextInt();

        if (choice == 1) {
            checker.setStrategy(new StackStrategy());
        } else {
            checker.setStrategy(new DequeStrategy());
        }

        boolean result = checker.check(input);

        if (result) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }

        sc.close();
    }
}