package App;
import java.util.List;

public class Movie {
    private String title;
    private String genre;
    private int duration; // in minutes
    private List<String> showtimes; // list of showtime strings

    public Movie(String title, String genre, int duration, List<String> showtimes) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.showtimes = showtimes;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public List<String> getShowtimes() {
        return showtimes;
    }
}

