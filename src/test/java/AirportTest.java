import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    Airport airport;
    Plane plane;
    Plane findme;
    Person person;
    Flight flight;

    @Before
    public void before(){
        airport = new Airport(AirportCode.EDI);
        plane = new Plane(Type.B747, Airline.BA);
        person = new Person("Testman");
        flight = new Flight(plane, 888, AirportCode.HKG);
        findme = new Plane(Type.A380,Airline.EJ);
    }

    @Test
    public void getAirportCode(){
        assertEquals(AirportCode.EDI, airport.getCode());
    }

    @Test
    public void getHangar(){
        airport.addPlane(plane);
        assertEquals(1, airport.getHangar().size());
    }

    @Test
    public void checkHangarForPlane(){
        airport.addPlane(plane);
        airport.addPlane(plane);
        airport.addPlane(findme);
        airport.addPlane(plane);
        assertEquals(4, airport.getHangar().size());
        assertEquals(findme, airport.findPlane(findme));
    }

    @Test
    public void checkHangarForInvalidPlane(){
    airport.addPlane(plane);
    airport.addPlane(plane);
    airport.addPlane(plane);
    airport.addPlane(plane);
    assertEquals(4, airport.getHangar().size());
    assertEquals(null, airport.findPlane(findme));
    }

    @Test
    public void bookFlight(){
        
    }
}
