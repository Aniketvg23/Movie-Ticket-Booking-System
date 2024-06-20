package App;

public class Seat {
    private int seatNumber;
    private char row;
    private boolean isAvailable;

    public Seat(int seatNumber, char row) {
        this.seatNumber = seatNumber;
        this.row = row;
        this.isAvailable = true;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public char getRow() {
        return row;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
