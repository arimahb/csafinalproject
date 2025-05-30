public class Section {
    private int rows; private int cols; private String name; private double price; private SeatType type; 
    private Seat[][] seats;

    public Section(String name, int rows, int cols, double price, SeatType type) {
        this.name = name;
        this.rows = rows;
        this.cols = cols;
        this.price = price;
        this.type = type;
        this.seats = new Seat[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seats[i][j] = new Seat(i, j, price, type);  // Example price
            }
        }
    }

    public String stateInfo() {
        String sType = this.seats[0][0].getType().toString();
        String part1 = "Section " + this.name + " is a " + sType + " section with ";
        int totalSeats = this.rows * this.cols;
        String part2 = totalSeats + " seats.";
        int totalAvail = this.getAvailableSeatCount();
        String part3 = totalAvail + " seats are currently available.";
        return (part1 + part2 + part3);
    }

    public boolean buySeat(int row, int col) {
        if (isValidSeat(row, col) && seats[row][col].isAvailable()) {
            seats[row][col].reserve();
            return true;
        }
        return false;
    }

    public SeatType getType() {
        return this.type;
    }

    public double getPrice() {
        return this.price;
    }
    
    public int getAvailableSeatCount() {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (seats[i][j].isAvailable()) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getTotalSeatCount() {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                    count++;
            }
        }
        return count;
    }
    


    public void displaySeating() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(seats[i][j].isAvailable() ? "O " : "X ");
            }
            System.out.println();
        }
    }

    public double getTotalPrice() {
        return (this.rows * this.cols * this.price);
    }
    
    private boolean isValidSeat(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public String getName() {
        return this.name;
    }

    
}
