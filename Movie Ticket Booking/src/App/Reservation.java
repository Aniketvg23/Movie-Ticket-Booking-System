package App;

import java.time.LocalDateTime;

public class Reservation {
    private User user;
    private Movie movie;
    private Screen screen;
    private Seat seat;
    private LocalDateTime reservationTime;

    public Reservation(User user, Movie movie, Screen screen, Seat seat, LocalDateTime reservationTime) {
        this.user = user;
        this.movie = movie;
        this.screen = screen;
        this.seat = seat;
        this.reservationTime = reservationTime;
    }

    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public Seat getSeat() {
        return seat;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }
}
