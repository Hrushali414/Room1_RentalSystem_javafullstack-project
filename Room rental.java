import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String type;
    double rentPerDay;
    boolean isBooked;

    public Room(int roomNumber, String type, double rentPerDay) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.rentPerDay = rentPerDay;
        this.isBooked = false;
    }

    public void displayRoom() {
        System.out.println("Room No: " + roomNumber + " | Type: " + type + " | Rent: ₹" + rentPerDay + " | Booked: " + (isBooked ? "Yes" : "No"));
    }
}

class Customer {
    String name;
    String phone;
    int bookedRoom;
    int days;

    public Customer(String name, String phone, int bookedRoom, int days) {
        this.name = name;
        this.phone = phone;
        this.bookedRoom = bookedRoom;
        this.days = days;
    }

    public void displayCustomer() {
        System.out.println("Customer: " + name + " | Phone: " + phone + " | Room: " + bookedRoom + " | Days: " + days);
    }
}

public class RoomRentalSystem {
    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initializeRooms();
        int choice;
        do {
            System.out.println("\n===== ROOM RENTAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Show All Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Show All Bookings");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> showRooms();
                case 2 -> bookRoom();
                case 3 -> showBookings();
                case 4 -> checkout();
                case 5 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void initializeRooms() {
        rooms.add(new Room(101, "Single", 800));
        rooms.add(new Room(102, "Double", 1200));
        rooms.add(new Room(103, "Deluxe", 2000));
        rooms.add(new Room(104, "Suite", 3000));
    }

    static void showRooms() {
        for (Room r : rooms) r.displayRoom();
    }

    static void bookRoom() {
        showRooms();
        System.out.print("Enter room number to book: ");
        int roomNum = sc.nextInt();
        for (Room r : rooms) {
            if (r.roomNumber == roomNum) {
                if (r.isBooked) {
                    System.out.println("Room already booked!");
                    return;
                }
                sc.nextLine();
                System.out.print("Enter customer name: ");
                String name = sc.nextLine();
                System.out.print("Enter phone number: ");
                String phone = sc.nextLine();
                System.out.print("Enter number of days: ");
                int days = sc.nextInt();
                r.isBooked = true;
                customers.add(new Customer(name, phone, roomNum, days));
                double total = r.rentPerDay * days;
                System.out.println("Room booked successfully!");
                System.out.println("Total Rent: ₹" + total);
                return;
            }
        }
        System.out.println("Room not found!");
    }

    static void showBookings() {
        if (customers.isEmpty()) {
            System.out.println("No active bookings!");
            return;
        }
        for (Customer c : customers) c.displayCustomer();
    }

    static void checkout() {
        System.out.print("Enter room number for checkout: ");
        int roomNum = sc.nextInt();
        for (Room r : rooms) {
            if (r.roomNumber == roomNum && r.isBooked) {
                r.isBooked = false;
                customers.removeIf(c -> c.bookedRoom == roomNum);
                System.out.println("Checkout successful. Room is now available!");
                return;
            }
        }
        System.out.println("Room not found or not booked!");
    }
}