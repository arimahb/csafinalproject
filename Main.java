import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Stadium stadium = createStadium();
        boolean running = true;

        while (running) {
            System.out.println("\nOptions:\n1. Buy a Seat\n2. View Available Seats\n3. Calculate Profits\n4. Exit");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    buySeatInStadium(stadium);
                    break;
                case 2:
                    displayAvailableSeats(stadium);
                    break;
                case 3:
                    System.out.println("Total Revenue: $" + stadium.getStadiumRevenue());
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    // 1. Create a Seat (used internally)
    public static Seat createSeat(int row, int col, double price, SeatType type) {
        return new Seat(row, col, price, type);
    }

    // 2. Create a Section
    public static Section createSection() {
        System.out.print("Enter section name: ");
        String name = scanner.nextLine();

        System.out.print("Enter number of rows: ");
        int rows = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter number of columns: ");
        int cols = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter price per seat (number only): ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter seat type (VIP, REGULAR, ECONOMY): ");
        SeatType type = SeatType.valueOf(scanner.nextLine().toUpperCase());

        return new Section(name, rows, cols, price, type);
    }

    // 3. Create a Stadium
    public static Stadium createStadium() {
        System.out.print("Enter stadium name: ");
        String name = scanner.nextLine();

        ArrayList<Section> sections = new ArrayList<>();
        boolean adding = true;

        while (adding) {
            System.out.println("Add a new section:");
            sections.add(createSection());

            System.out.print("Add another section? (yes/no): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                adding = false;
            }
        }

        return new Stadium(name, sections);
    }

    // 4. Buy a seat in a section
    public static void buySeatInStadium(Stadium stadium) {
        System.out.print("Enter section name: ");
        String sectionName = scanner.nextLine();

        Section targetSection = null;
        for (Section s : stadium.getSections()) {
            if (s.getName().equalsIgnoreCase(sectionName)) {
                targetSection = s;
                break;
            }
        }

        if (targetSection == null) {
            System.out.println("Section not found.");
            return;
        }

        System.out.print("Enter row: ");
        int row = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter column: ");
        int col = Integer.parseInt(scanner.nextLine());

        boolean success = targetSection.buySeat(row, col);
        System.out.println(success ? "Seat successfully purchased!" : "Seat unavailable or invalid.");
    }

    // 5. Display available seats in the stadium
    public static void displayAvailableSeats(Stadium stadium) {
        for (Section s : stadium.getSections()) {
            System.out.println(s.stateInfo());
            s.displaySeating();
            System.out.println();
        }
    }
}