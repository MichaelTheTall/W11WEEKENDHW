import java.util.ArrayList;

public class Airport {
    private AirportCode code;
    private ArrayList<Plane> hangar;
    private ArrayList<Flight> flights;

    public Airport(AirportCode code) {
        this.code = code;
        hangar = new ArrayList<>();
        flights = new ArrayList<>();
    }


    public AirportCode getCode() {
        return code;
    }

    public ArrayList<Plane> getHangar() {
        return hangar;
    }

    public void addPlane(Plane plane) {
        hangar.add(plane);
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

    public void addFlight(Plane plane, AirportCode destination, int number) {
        Flight newflight = new Flight(plane, number, destination);
        flights.add(newflight);
        hangar.remove(plane);
    }

    public ArrayList<Flight> getFlightList() {
        return flights;
    }

    public void removeFlight(Flight flight) {
        if (flights.contains(flight)) {
            int index = flights.indexOf(flight);
            flights.remove(index);
            hangar.add(flight.getPlane());
        }
    }

    public Flight findFlight(Flight flight) {
        if (flights.contains(flight)) {
            int index = flights.indexOf(flight);
            Flight result = flights.get(index);
            return result;
        } else {
            return null;
        }
    }
}
