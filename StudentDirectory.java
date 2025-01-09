import java.util.HashMap;
import java.util.Scanner;

public class StudentDirectory {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Directory");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    studentMap.put(id, name);
                    System.out.println("Student is added successfully.");
                  break;
                case 2:
                System.out.print("Enter Student ID: ");
                id = scanner.nextInt();
                if (studentMap.containsKey(id)) {
                        System.out.println("Student Name: " + studentMap.get(id));
                    } else
                    	{
                        System.out.println("Student is not found.");
                    }
                   break;
                case 3:
                    System.out.print("Enter Student ID: ");
                   id = scanner.nextInt();
                    if (studentMap.remove(id) != null) {
                        System.out.println("Student is removed successfully.");
                    } else {
                    System.out.println("Student is not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    break;
                default:
                  System.out.println("Invalid choice.");
            }
        } while (choice != 4);
 }
}
