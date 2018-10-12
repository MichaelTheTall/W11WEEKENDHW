import org.junit.Before;

public class AirportTest {

    Airport airport;
    Plane plane;
    Person person;
    Flight flight;

    @Before
    public void before(){
        airport = new Airport(AirportCode.EDI);
        plane = new Plane(Type.B747, Airline.BA);
        person = new Person("Testman");
        flight = new Flight(plane, 888, AirportCode.HKG);
    }
}
