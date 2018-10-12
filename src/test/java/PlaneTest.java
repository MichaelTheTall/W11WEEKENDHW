import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane;
    Person person;

    @Before
    public void before(){
        plane = new Plane(Type.B747, Airline.BA);
        person = new Person("Testman");
    }

    @Test
    public void getType(){
        assertEquals(Type.B747, plane.getType());
    }

    @Test
    public void getAirline(){
        assertEquals(Airline.BA, plane.getAirline());
    }

    @Test
    public void getAirlineName(){
        assertEquals("British Airways", plane.getAirline().getName());
    }

    @Test
    public void getCapacity(){
        assertEquals(400, plane.maxCapacity());
    }

    @Test
    public void getBoardedEmpty(){
        assertEquals(0, plane.boarded());
    }

    @Test
    public void addPassenger(){
        plane.addPassenger(person);
        assertEquals(1, plane.boarded());
    }

    @Test
    public void getSpaceLeft(){
        plane.addPassenger(person);
        plane.addPassenger(person);
        plane.addPassenger(person);
        plane.addPassenger(person);
        plane.addPassenger(person);
        assertEquals(5, plane.boarded());
        assertEquals(395, plane.space());
    }

    @Test
    public void everybodyOff(){
        plane.addPassenger(person);
        plane.addPassenger(person);
        plane.addPassenger(person);
        plane.addPassenger(person);
        plane.addPassenger(person);
        assertEquals(5, plane.boarded());
        plane.everybodyOff();
        assertEquals(0, plane.boarded());
    }
}
