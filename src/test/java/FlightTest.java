import org.junit.Before;

public class FlightTest {

    Plane plane;
    Person person;
    Flight flight;

    @Before
    public void before() {
        plane = new Plane(Type.B747, Airline.BA);
        person = new Person("Testman");
        flight = new Flight(plane, 888, AirportCode.HKG);
    }

    


}
