import java.util.Scanner;

public class UseCase8PalindromeCheckerApp {

    // Node class for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to check if linked list is palindrome
    public static boolean isPalindrome(Node head) {

        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find middle using fast and slow pointer
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node secondHalf = reverse(slow);
        Node copySecondHalf = secondHalf;

        // Step 3: Compare first half and reversed second half
        Node firstHalf = head;
        boolean isPalindrome = true;

        while (copySecondHalf != null) {
            if (firstHalf.data != copySecondHalf.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            copySecondHalf = copySecondHalf.next;
        }

        return isPalindrome;
    }

    // Function to reverse linked list
    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node nextNode = null;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    // Convert string to linked list
    public static Node createLinkedList(String input) {
        Node head = null;
        Node tail = null;

        for (char ch : input.toCharArray()) {
            Node newNode = new Node(ch);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Convert string to linked list
        Node head = createLinkedList(input);

        // Check palindrome
        if (isPalindrome(head)) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
