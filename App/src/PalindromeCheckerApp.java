import java.util.*;
import java.util.concurrent.TimeUnit;

public class UseCase13PalindromeCheckerApp {

    // 1. Iterative (simple) palindrome check
    public static boolean iterativePalindrome(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        int start = 0, end = normalized.length() - 1;
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    // 2. Recursive palindrome check
    public static boolean recursivePalindrome(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return recursivePalindrome(str, start + 1, end - 1);
    }

    // 3. Stack-based palindrome check
    public static boolean stackPalindrome(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) stack.push(ch);
        for (char ch : normalized.toCharArray()) {
            if (stack.pop() != ch) return false;
        }
        return true;
    }

    // 4. Deque-based palindrome check
    public static boolean dequePalindrome(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : normalized.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }

    // Measure execution time helper
    public static long measureTime(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string for performance test: ");
        String input = scanner.nextLine();

        // Iterative
        long timeIterative = measureTime(() -> iterativePalindrome(input));

        // Recursive
        long timeRecursive = measureTime(() -> recursivePalindrome(
                input.replaceAll("\\s+", "").toLowerCase(), 0,
                input.replaceAll("\\s+", "").length() - 1));

        // Stack
        long timeStack = measureTime(() -> stackPalindrome(input));

        // Deque
        long timeDeque = measureTime(() -> dequePalindrome(input));

        System.out.println("\nPalindrome Performance Comparison (nanoseconds):");
        System.out.println("1. Iterative check: " + timeIterative);
        System.out.println("2. Recursive check: " + timeRecursive);
        System.out.println("3. Stack-based check: " + timeStack);
        System.out.println("4. Deque-based check: " + timeDeque);

        scanner.close();
    }
}
