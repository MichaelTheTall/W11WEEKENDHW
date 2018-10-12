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
        plane.everybodyOff();
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

    public void addFlight(AirportCode destination, int number) {
        Flight newflight = new Flight(number, destination);
        flights.add(newflight);
    }

    public ArrayList<Flight> getFlightList() {
        return flights;
    }

    public void removeFlight(Flight flight) {
        if (flights.contains(flight)) {
            int index = flights.indexOf(flight);
            flights.remove(index);
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

    public void sellTicket(Person person, Flight flight) {
        flight.addPassenger(person);
    }



}
