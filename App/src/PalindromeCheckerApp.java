import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    // Function to check palindrome
    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Step 1: Normalize string
        // Remove spaces and convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Step 2: Check palindrome
        if (isPalindrome(normalized)) {
            System.out.println("The given string is a Palindrome (case & space ignored).");
        } else {
            System.out.println("The given string is NOT a Palindrome (case & space ignored).");
        }

        scanner.close();
    }
}
