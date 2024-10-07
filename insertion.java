import java.util.Scanner;
public class InsertionSort {
  // Function for performing insertion sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int a = 1; a < n; a++) {
            int key = arr[a];
            int b = a - 1;

 // E move ang elements of arr[0..a-1], that are greater than key,
 // to one position ahead of their current position
            while (b>= 0 && arr[b] > key) {
                arr[b + 1] = arr[b];
                b = b - 1;
            }
            arr[b + 1] = key;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new        Scanner(System.in);

 // Mag ask kung pila ka numbers 
        System.out.print("Enter the number of integers: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

// Ibutang ang imong numbers 
        System.out.println("Enter the integers: ");
        for (int a = 0; a < n; a++) {
            numbers[a] = scanner.nextInt();
        }
 // Sort the numbers using insertion sort
        insertionSort(numbers);
 // Output the sorted numbers
        System.out.println("Sorted numbers in ascending order:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        scanner.close();
    }
}