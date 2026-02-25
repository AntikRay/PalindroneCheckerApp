import java.util.Scanner;

public class UseCase3PalindromeCheckerApp {

    public static void main(String[] args) {

        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter a string: ");
        String originalString = scanner.nextLine();

        // Variable to store reversed string
        String reversedString = "";

        // Reverse string using for loop
        for (int i = originalString.length() - 1; i >= 0; i--) {
            reversedString = reversedString + originalString.charAt(i);
        }

        // Compare original and reversed string using equals()
        if (originalString.equals(reversedString)) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        // Close scanner
        scanner.close();
    }
}
