import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {
    Person person;
    Flight flight;

    @Before
    public void before() {
        person = new Person("Testman");
        flight = new Flight(888, AirportCode.HKG);
    }

    @Test
    public void getNumber(){
        assertEquals(888, flight.getFlightnumber());
    }

    @Test
    public void getDestination(){
        assertEquals(AirportCode.HKG, flight.getDestination());
    }

    @Test
    public void addPassenger(){
        flight.addPassenger(person);
        assertEquals(1,flight.getManifest().size());
    }

    @Test
    public void removePassenger(){
        flight.addPassenger(person);
        assertEquals(1, flight.getManifest().size());
        flight.removePassenger(person);
        assertEquals(0, flight.getManifest().size());
    }


}
