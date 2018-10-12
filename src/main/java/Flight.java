import java.util.ArrayList;
import java.util.BitSet;

public class Flight {
    private int flightnumber;

    private AirportCode destination;

    private ArrayList<Person> manifest;
    public Flight(int flightnumber, AirportCode destination) {
        this.flightnumber = flightnumber;
        this.destination = destination;
        manifest = new ArrayList<>();
    }
    public int getFlightnumber() {
        return flightnumber;
    }

    public AirportCode getDestination() {
        return destination;
    }

    public ArrayList getManifest() {
        return manifest;
    }

    public void addPassenger(Person person) {
        manifest.add(person);
    }

    public void removePassenger(Person person) {
        if (manifest.contains(person)) {
            int index = manifest.indexOf(person);
            manifest.remove(index);
        }
    }
}
