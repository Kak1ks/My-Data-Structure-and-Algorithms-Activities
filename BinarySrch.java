import java.util.Scanner;
import java.util.Arrays;

public class BinarySrch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);								 //Object, instance of a class

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] array = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }


         Arrays.sort(array);
	        System.out.println("Sorted array for binary search: " + Arrays.toString(array));
	        System.out.print("Enter the value to search using Binary Search: ");
	      int  target = sc.nextInt();

	        int binaryResult = binarySearch(array, target, 0, array.length - 1);
        System.out.println("Binary Search result: " + (binaryResult != -1 ? "Found at index " + binaryResult : "Not found"));
}

		public static int binarySearch(int[] array, int target, int low, int high) {		// Nag create og function nga binarySearch
	        if (low <= high) {
	            int mid = low + (high - low) / 2;

	            if (array[mid] == target) {
	                return mid;
	            }

	            if (array[mid] > target) {
	                return binarySearch(array, target, low, mid - 1);
	            }

	            return binarySearch(array, target, mid + 1, high);
	        }
	        return -1;																	// return -1 kay empty man
    }
}