import java.util.Scanner;

// PalindromeChecker class encapsulates palindrome logic
class PalindromeChecker {

    private String text;

    // Constructor to initialize text
    public PalindromeChecker(String text) {
        this.text = text;
    }

    // Method to normalize string (optional: ignore spaces & case)
    private String normalize(String str) {
        return str.replaceAll("\\s+", "").toLowerCase();
    }

    // Public method to check if string is palindrome
    public boolean checkPalindrome() {
        String normalized = normalize(this.text);
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

// Main Application
public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Create PalindromeChecker object
        PalindromeChecker checker = new PalindromeChecker(input);

        // Check palindrome using object method
        if (checker.checkPalindrome()) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
