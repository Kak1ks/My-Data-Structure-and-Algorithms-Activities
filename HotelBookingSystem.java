import java.util.Scanner;

class Room {
    int roomNumber;
    boolean isAvailable;

	 // Constructor to initialize a room with a given room number
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isAvailable = true;  // All rooms are available initially
    }

	// Method to book the room if it's available
    public void bookRoom() {
        if (isAvailable) {
            isAvailable = false;	// Mark the room as booked
            System.out.println("Room " + roomNumber + " has been booked.");
        } else {
            System.out.println("Room " + roomNumber + " is already booked.");
        }
    }

	// Method to release the room if it's booked
    public void releaseRoom() {
        if (!isAvailable) {
            isAvailable = true;	 // Mark the room as available
            System.out.println("Room " + roomNumber + " has been released.");
        } else {
            System.out.println("Room " + roomNumber + " is already available.");
        }
    }

	// Method to print details of the room
    public void printRoomDetails() {
        System.out.println("Room Number: " + roomNumber + " - " + (isAvailable ? "Available" : "Booked"));
    }
}

	class TreeNode {
		Room room;
		TreeNode left, right;

		public TreeNode(int roomNumber) {
			room = new Room(roomNumber);
			left = right = null;
		}
	}

	class Hotel {
		TreeNode root;

		public Hotel() {
			root = null;
		}

    // Insert a room into the tree
    public void insertRoom(int roomNumber) {
        root = insertRoomRec(root, roomNumber);
    }

    private TreeNode insertRoomRec(TreeNode root, int roomNumber) {
        if (root == null) {
            root = new TreeNode(roomNumber);
            return root;
        }

        if (roomNumber < root.room.roomNumber) {
            root.left = insertRoomRec(root.left, roomNumber);
        } else if (roomNumber > root.room.roomNumber) {
            root.right = insertRoomRec(root.right, roomNumber);
        }

        return root;
    }

    // Book a room
    public void bookRoom(int roomNumber) {
        TreeNode node = search(root, roomNumber);
        if (node != null) {
            node.room.bookRoom();
        } else {
            System.out.println("Room " + roomNumber + " not found.");
        }
    	}

    // Release a room
    public void releaseRoom(int roomNumber) {
        TreeNode node = search(root, roomNumber);
        if (node != null) {
            node.room.releaseRoom();
        } else {
            System.out.println("Room " + roomNumber + " not found.");
        }
    	}

    // Search for a room by room number
    private TreeNode search(TreeNode root, int roomNumber) {
        if (root == null || root.room.roomNumber == roomNumber) {
            return root;
        }

        if (roomNumber < root.room.roomNumber) {
            return search(root.left, roomNumber);
        }

        return search(root.right, roomNumber);
    }

    // Print available rooms
    public void printAvailableRooms() {
        printAvailableRoomsRec(root);
    }

    private void printAvailableRoomsRec(TreeNode root) {
        if (root != null) {
            printAvailableRoomsRec(root.left);
            root.room.printRoomDetails();
            printAvailableRoomsRec(root.right);
}
}
}

// Main class for the hotel booking system
public class HotelBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        // Sample rooms: Adding rooms to the hotel
        hotel.insertRoom(101);
        hotel.insertRoom(102);
        hotel.insertRoom(103);
        hotel.insertRoom(104);
        hotel.insertRoom(105);
        hotel.insertRoom(106);


		// The Menu
        while (true) {
            System.out.println("\n--- Hotel Booking System ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Release a Room");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hotel.printAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter room number to book: ");
                    int bookRoomNumber = scanner.nextInt();
                    hotel.bookRoom(bookRoomNumber);
                    break;
                case 3:
                    System.out.print("Enter room number to release: ");
                    int releaseRoomNumber = scanner.nextInt();
                    hotel.releaseRoom(releaseRoomNumber);
                    break;
                case 4:
                    System.out.println("Exiting the system. Thank you for using the hotel booking system!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
