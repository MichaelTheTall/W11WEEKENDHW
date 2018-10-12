import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Airport {
    private AirportCode code;
    private ArrayList<Plane> hangar;
    private ArrayList<Flight> bookings;
    private HashMap<Plane, Flight> flights;

    public Airport(AirportCode code) {
        this.code = code;
        hangar = new ArrayList<>();
        bookings = new ArrayList<>();
        flights = new HashMap<>();
    }


    public AirportCode getCode() {
        return code;
    }

    public ArrayList<Plane> getHangar() {
        return hangar;
    }

    public void sortHangar() {
        Collections.sort(hangar, new Comparator<Plane>() {
            @Override
            public int compare(Plane p1, Plane p2) {
                if (p1.maxCapacity() > p2.maxCapacity())
                    return 1;
                if (p1.maxCapacity() < p2.maxCapacity())
                    return -1;
                return 0;
            }
        });
    }

    public void addPlane(Plane plane) {
        plane.everybodyOff();
        hangar.add(plane);
        sortHangar();
    }

    public Plane findPlane(Plane plane) {
        if (hangar.contains(plane)) {
            int index = hangar.indexOf(plane);
            Plane result = hangar.get(index);
            return result;
        } else {
            return null;
        }
    }

    public void addFlight(AirportCode destination, int number) {
        Flight newflight = new Flight(number, destination);
        bookings.add(newflight);
    }

    public ArrayList<Flight> getFlightList() {
        return bookings;
    }

    public void removeFlight(Flight flight) {
        if (bookings.contains(flight)) {
            int index = bookings.indexOf(flight);
            bookings.remove(index);
        }
    }

    public Flight findFlight(Flight flight) {
        if (bookings.contains(flight)) {
            int index = bookings.indexOf(flight);
            Flight result = bookings.get(index);
            return result;
        } else {
            return null;
        }
    }

    public void sellTicket(Person person, Flight flight) {
        flight.addPassenger(person);
    }

    public void assignPlane(Flight flight) {
        int tickets = flight.getManifest().size();
        for (Plane plane : hangar) {
            if (tickets < plane.maxCapacity()) {
                flights.put(plane, flight);
                break;
            }
        }
    }

    public HashMap outbound() {
        return flights;
    }
}
