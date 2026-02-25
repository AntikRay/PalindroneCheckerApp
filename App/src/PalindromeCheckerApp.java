import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class UseCase6PalindromeCheckerApp {

    public static void main(String[] args) {

        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Create Stack and Queue
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Add characters to both Stack and Queue
        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            stack.push(ch);     // LIFO
            queue.add(ch);      // FIFO (Enqueue)
        }

        boolean isPalindrome = true;

        // Compare pop (Stack) and dequeue (Queue)
        while (!stack.isEmpty()) {
            char fromStack = stack.pop();      // LIFO
            char fromQueue = queue.remove();   // FIFO (Dequeue)

            if (fromStack != fromQueue) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        if (isPalindrome) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
