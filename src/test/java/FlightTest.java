import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void getPlane() {
        assertEquals(Type.B747, flight.getPlane().getType());
    }

    @Test
    public void getMaxCapacity() {
        assertEquals(400, flight.getPlane().maxCapacity());
    }

    @Test
    public void getBoardedAndSpaceLeft() {
        flight.getPlane().addPassenger(person);
        flight.getPlane().addPassenger(person);
        flight.getPlane().addPassenger(person);
        flight.getPlane().addPassenger(person);
        flight.getPlane().addPassenger(person);
        assertEquals(5, flight.getPlane().boarded());
        assertEquals(395, flight.getPlane().space());
    }



}
