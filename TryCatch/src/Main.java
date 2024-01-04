import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.print("Enter index: ");
        int number = scanner.nextInt();

        try {
            // Printing the element at the specified index by calling the method
            printElementAtIndex(arr, number);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace(System.out);
            System.out.print("Error: Index provided is outside the bounds of the array. Array size: " + arr.length);
        }
    }

    // Method to print the element at a specified index
    public static void printElementAtIndex(int[] arr, int index) {
        try {
            // Index validation and printing the element
            if (index < 0 || index >= arr.length) {
                throw new ArrayIndexOutOfBoundsException();
            } else {
                System.out.println("Element at the specified index: " + arr[index]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e; // Re-throwing the exception
        }
    }
}
