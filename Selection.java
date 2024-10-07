import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
	public static void main(String [] args){

//mau ni ang scanner maung maka type²
		Scanner sc = new Scanner(System.in);
//mangayo mo og pila inyo e butang
		System.out.print("Enter size of the number: ");
		int number = sc.nextInt();
// Mangayo rag ge specific nge e butang
		int[] array = new int[number];
//ngayo mo unsay e sort ari
		        System.out.println("Numbers to be be sorted: ");

//looping ni deri
		       for (int a = 0; a < number; a++) {
		            array[a] = sc.nextInt();
        }

//mag call tag  insertSort kay naa sa void
selectionSort(array);
//mag looping rata deri dapita
        System.out.print("Sorted arrays in Ascending Order: ");
        for (int a = 0; a < array.length; a++) {
		            System.out.print(array[a] + " ");
        }

}

//Method sa selectionSort
public static void selectionSort(int[] array) {
        for (int a = 0; a < array.length - 1; a++) {
            int minIndex = a;
            for (int b = a + 1; b < array.length; b++) {
                if (array[a] < array[minIndex]) {
                    minIndex = b;
                }
            }
//E  swap nimo ang found minimum element sa unang felement
            int temp = array[minIndex];
           	 	array[minIndex] = array[a];
           	 	array[a] = temp;
        }

    }

}
