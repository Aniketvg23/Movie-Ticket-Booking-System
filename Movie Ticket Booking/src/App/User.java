package App;

import java.util.List;
import java.util.ArrayList;

public class User {
    private String name;
    private String contactInformation;
    private List<Reservation> reservationHistory;

    public User(String name, String contactInformation) {
        this.name = name;
        this.contactInformation = contactInformation;
        this.reservationHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public List<Reservation> getReservationHistory() {
        return reservationHistory;
    }

    public void addReservation(Reservation reservation) {
        reservationHistory.add(reservation);
    }
}

