import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

// Stack-based palindrome strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String text) {
        String normalized = text.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        // Push all chars onto stack
        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        // Compare while popping
        for (char ch : normalized.toCharArray()) {
            if (stack.pop() != ch) {
                return false;
            }
        }

        return true;
    }
}

// Deque-based palindrome strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String text) {
        String normalized = text.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        // Add all chars to deque
        for (char ch : normalized.toCharArray()) {
            deque.addLast(ch);
        }

        // Compare front and back
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}

// Context class to inject strategy
class PalindromeCheckerContext {
    private PalindromeStrategy strategy;

    public PalindromeCheckerContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String text) {
        return strategy.isPalindrome(text);
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }
}

// Main application
public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Choose palindrome algorithm:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();

        PalindromeCheckerContext checker = null;

        switch (choice) {
            case 1:
                checker = new PalindromeCheckerContext(new StackStrategy());
                break;
            case 2:
                checker = new PalindromeCheckerContext(new DequeStrategy());
                break;
            default:
                System.out.println("Invalid choice. Using Stack Strategy by default.");
                checker = new PalindromeCheckerContext(new StackStrategy());
        }

        if (checker.check(input)) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
