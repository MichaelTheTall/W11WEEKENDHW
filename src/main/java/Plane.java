import java.util.ArrayList;

public class Plane {
    private Type type;
    private Airline airline;
    private ArrayList<Person> passengers;

    public Plane(Type type, Airline airline){
        this.type = type;
        this.airline = airline;
        passengers = new ArrayList<>();
    }

    public Type getType() {
        return type;
    }

    public Airline getAirline() {
        return airline;
    }

    public int maxCapacity() {
        return type.getCapacity();
    }

    public int boarded() {
        return passengers.size();
    }

    public void addPassenger(Person person) {
        passengers.add(person);
    }

    public int space() {
        int result = maxCapacity() - boarded();
        return result;
    }

    public void everybodyOff() {
        passengers.clear();
    }

}
