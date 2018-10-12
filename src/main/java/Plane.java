import java.util.ArrayList;

public class Plane {
    private Type type;
    private Airline airline;
    private ArrayList<Person> passengers;

    public Plane(Type type, Airline airline){
        this.type = type;
        this. airline = airline;
        passengers = new ArrayList<>();
    }

}
