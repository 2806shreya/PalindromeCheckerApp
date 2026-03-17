import java.util.*;

// Stack Approach
class StackPalindrome {
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

// Deque Approach
class DequePalindrome {
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

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = sc.nextLine();

        StackPalindrome sp = new StackPalindrome();
        DequePalindrome dp = new DequePalindrome();

        // Stack timing
        long start1 = System.nanoTime();
        boolean res1 = sp.isPalindrome(input);
        long end1 = System.nanoTime();

        // Deque timing
        long start2 = System.nanoTime();
        boolean res2 = dp.isPalindrome(input);
        long end2 = System.nanoTime();

        System.out.println("\nStack Result: " + res1);
        System.out.println("Stack Time: " + (end1 - start1) + " ns");

        System.out.println("\nDeque Result: " + res2);
        System.out.println("Deque Time: " + (end2 - start2) + " ns");

        sc.close();
    }
}