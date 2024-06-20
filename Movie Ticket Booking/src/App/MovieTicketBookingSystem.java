package App;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MovieTicketBookingSystem {
    private static List<Movie> movies = new ArrayList<>();
    private static List<Theater> theaters = new ArrayList<>();
    private static User currentUser;

    public static void main(String[] args) {
        initializeData();
        currentUser = new User("John Doe", "john.doe@example.com");
        displayMainMenu();
    }

    private static void initializeData() {
        Movie movie1 = new Movie("Movie 1", "Action", 120, Arrays.asList("10:00 AM", "1:00 PM", "4:00 PM"));
        Movie movie2 = new Movie("Movie 2", "Comedy", 90, Arrays.asList("11:00 AM", "2:00 PM", "5:00 PM"));

        movies.add(movie1);
        movies.add(movie2);

        List<Seat> seats = new ArrayList<>();
        for (char row = 'A'; row <= 'D'; row++) {
            for (int number = 1; number <= 10; number++) {
                seats.add(new Seat(number, row));
            }
        }

        Screen screen1 = new Screen(1, seats, movie1);
        Screen screen2 = new Screen(2, seats, movie2);

        Theater theater = new Theater("Theater 1", "123 Main St", Arrays.asList(screen1, screen2));

        theaters.add(theater);
    }

    private static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Movie Ticket Booking System");
            System.out.println("1. Browse Movies");
            System.out.println("2. View Reservation History");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    browseMovies();
                    break;
                case 2:
                    viewReservationHistory();
                    break;
                case 3:
                    System.out.println("Thank you for using the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void browseMovies() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Movies:");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i).getTitle());
        }
        System.out.println("Select a movie to see showtimes:");

        int movieChoice = scanner.nextInt();
        if (movieChoice < 1 || movieChoice > movies.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Movie selectedMovie = movies.get(movieChoice - 1);
        displayShowtimes(selectedMovie);
    }

    private static void displayShowtimes(Movie movie) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Showtimes for " + movie.getTitle() + ":");
        List<String> showtimes = movie.getShowtimes();
        for (int i = 0; i < showtimes.size(); i++) {
            System.out.println((i + 1) + ". " + showtimes.get(i));
        }
        System.out.println("Select a showtime:");

        int showtimeChoice = scanner.nextInt();
        if (showtimeChoice < 1 || showtimeChoice > showtimes.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        String selectedShowtime = showtimes.get(showtimeChoice - 1);
        System.out.println("Selected showtime: " + selectedShowtime);
        selectSeats(movie, selectedShowtime);
    }

    private static void selectSeats(Movie movie, String showtime) {
        Scanner scanner = new Scanner(System.in);
        Theater theater = theaters.get(0); // Assuming only one theater for simplicity
        Screen screen = theater.getScreens().stream().filter(s -> s.getMovie().equals(movie)).findFirst().orElse(null);

        if (screen == null) {
            System.out.println("No screen found for the selected movie.");
            return;
        }

        System.out.println("Available seats:");
        for (Seat seat : screen.getSeats()) {
            if (seat.isAvailable()) {
                System.out.println(seat.getRow() + "" + seat.getSeatNumber());
            }
        }
        System.out.println("Select a seat:");

        String seatChoice = scanner.next();
        char row = seatChoice.charAt(0);
        int seatNumber = Integer.parseInt(seatChoice.substring(1));

        Seat selectedSeat = screen.getSeats().stream().filter(s -> s.getRow() == row && s.getSeatNumber() == seatNumber && s.isAvailable()).findFirst().orElse(null);

        if (selectedSeat == null) {
            System.out.println("Invalid or unavailable seat choice.");
            return;
        }

        selectedSeat.setAvailable(false);
        Reservation reservation = new Reservation(currentUser, movie, screen, selectedSeat, LocalDateTime.now());
        currentUser.addReservation(reservation);

        System.out.println("Reservation successful! " + movie.getTitle() + " at " + showtime + " - Seat: " + seatChoice);
    }

    private static void viewReservationHistory() {
        List<Reservation> reservations = currentUser.getReservationHistory();
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
            return;
        }

        System.out.println("Reservation History:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation.getMovie().getTitle() + " - " + reservation.getReservationTime() + " - Seat: " + reservation.getSeat().getRow() + reservation.getSeat().getSeatNumber());
        }
    }
}

