//mga class ni diri boss
import java.util.Arrays;
import java.util.Scanner;

public class SortingArray {
	public static void main(String [] args){

		//mao ni katong scanner maong maka type
		Scanner sc = new Scanner(System.in);

		//Mangayo og pila kabuok ibutang ni bossing
		System.out.print("Enter size of the number: ");
		int number = sc.nextInt();

		// diri kay murag mangayog sa gi specified nga gi butang ni bossing
		int[] array = new int[number];

				//Mangayo og unsay ipa sort ni bossing
		        System.out.println("Numbers to be be sorted: ");

		       //loop ni bossing
		       for (int i = 0; i < number; i++) {
		            array[i] = sc.nextInt();
        }

//mo call sa bubblesort kay naas void
bubbleSort(array);


		//diri dapita kay mao naning sorted nga array, nag looping rapud
        System.out.print("Sorted arrays in Ascending Order: ");
        for (int i = 0; i < array.length; i++) {
		            System.out.print(array[i] + " ");
        }

}

//Method sa bubbleSort53
public static void bubbleSort(int[] array) {
        int n = array.length;

        //diri kay murag outer loop mani diri
        for (int i = 0; i < n - 1; i++) {
			//diri kay inner loop siguro mao ning mo compare and swap adjacent elements
            for (int j = 0; j < n - i - 1; j++) {

				//diri kay mag swap swap na,
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

}
