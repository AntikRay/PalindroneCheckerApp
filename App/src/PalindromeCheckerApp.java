import java.util.Scanner;
import java.util.Stack;

public class UseCase5PalindromeCheckerApp {

    public static void main(String[] args) {

        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Create Stack to store characters
        Stack<Character> stack = new Stack<>();

        // Push each character into stack
        for (int i = 0; i < inputString.length(); i++) {
            stack.push(inputString.charAt(i));
        }

        // Variable to store reversed string
        String reversedString = "";

        // Pop characters from stack (LIFO order)
        while (!stack.isEmpty()) {
            reversedString = reversedString + stack.pop();
        }

        // Compare original and reversed string
        if (inputString.equals(reversedString)) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        // Close scanner
        scanner.close();
    }
}
