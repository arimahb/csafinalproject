public class Seat {
    private double price; private int row; private int col; private boolean isTaken; private SeatType type;

    public Seat(int rowVal, int colVal, double priceVal, SeatType typeVal) {
        this.row = rowVal;
        this.col = colVal;
        this.price = priceVal;
        this.type = typeVal;
        this.isTaken = false;
    }

    public boolean isAvailable() {
        return !isTaken;
    }
    
    public void reserve() {
        isTaken = true;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getLocation() {
        return "(" + row + "," + col + ")";
    }
    
    public SeatType getType() {
        return type;
    }

    

}
