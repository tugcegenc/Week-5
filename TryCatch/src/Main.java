import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter index: ");

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        try {
            int number = scanner.nextInt();

            if (number < 0 || number > arr.length) {
                throw new ArrayIndexOutOfBoundsException();
            } else {
                System.out.println("Element at the specified index: " + arr[number]);
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace(System.out); // Prints the error to the console
            System.out.print("Error: Index provided is outside the bounds of the array. Array size: " + arr.length);
        } catch (Exception e) {
            e.printStackTrace(System.out); // Prints any other exceptions to the console
        }
    }
}
