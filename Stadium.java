import java.util.ArrayList;

public class Stadium {
    private ArrayList<Section> sections; private String name;

    public Stadium(String nameVal, ArrayList<Section> sectionVal) {
        this.name = nameVal;
        this.sections = sectionVal;
    }

    public ArrayList<Section> getSections() {
        return this.sections;
    }

    public void addSection(Section section) {
        sections.add(section);
    }

    public double getStadiumRevenue() { // If the entire stadium is sold out, how much money from seats come from revenue?
        double price = 0.0;
        for (Section s : this.sections) {
            price += s.getTotalPrice();
        }
        return price;
    }

    public int getSeatCount() {
        int seatCount = 0;
        for (Section s : this.sections) {
            seatCount += (s.getTotalSeatCount());
        }
        return seatCount;
    }

    public int getNumberOfType(String type) { // precondition: the strings inputted are one of three seat types shown in SeatType.java
        int count = 0;
        SeatType desiredType = SeatType.valueOf(type.toUpperCase());
        for (Section s : this.sections) {
            if (s.getType() == desiredType) {
                count++;
            }
        }
        return count;
    }

    public int getSectionCount() {
        return this.sections.size();
    }

    public double getMeanTypePrice(String type) { // precondition: the strings inputted are one of three seat types shown in SeatType.java
        SeatType desiredType = SeatType.valueOf(type.toUpperCase());
        int count = 0;
        double numerator = 0.0;
        for (Section s : this.sections) {
            if (s.getType() == desiredType) {
                count++;
                numerator += s.getPrice();
            }
        }
        return (numerator / count);
    }

    public String stadiumInfo() {
        String part1 = this.name + " is a stadium with a capacity of ";
        int capacity = this.getSeatCount();
        String part2 = capacity + ". It has ";
        int sections = this.getSectionCount();
        String part3 = sections + " sections, of which ";
        int vipCount = this.getNumberOfType("vip");
        int normalCount = this.getNumberOfType("regular");
        int econCount = this.getNumberOfType("economy");
        String part4 = vipCount + "are VIP sections, ";
        String part5 = normalCount + "are standard sections, ";
        String part6 = "and " + econCount + " are economy sections.";
        String part7 = "The mean price for each section is: ";
        double vipPrice = this.getMeanTypePrice("vip");
        double normalPrice = this.getMeanTypePrice("standard");
        double economyPrice = this.getMeanTypePrice("economy");
        String part8 = vipPrice + " for the VIP sections, ";
        String part9 = normalPrice + " for the standard sections, and ";
        String part10 = economyPrice + " for the economy sections.";
        String end = part1 + part2 + part3 + part4 + part5 + part6 + part7 + part8 + part9 + part10;
        return end;
    }

    
}
