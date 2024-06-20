package App;

import java.util.List;

public class Screen {
    private int screenNumber;
    private List<Seat> seats;
    private Movie movie;

    public Screen(int screenNumber, List<Seat> seats, Movie movie) {
        this.screenNumber = screenNumber;
        this.seats = seats;
        this.movie = movie;
    }

    public int getScreenNumber() {
        return screenNumber;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Movie getMovie() {
        return movie;
    }
}
