import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    Airport airport;
    Plane plane;
    Plane findme;
    Plane test10plane;
    Person person;
    Flight flight;

    @Before
    public void before() {
        airport = new Airport(AirportCode.EDI);
        plane = new Plane(Type.B747, Airline.BA);
        person = new Person("Testman");
        flight = new Flight(plane, 888, AirportCode.HKG);
        findme = new Plane(Type.A380, Airline.EJ);
        test10plane = new Plane(Type.TEST10, Airline.RA);
    }

    @Test
    public void getAirportCode() {
        assertEquals(AirportCode.EDI, airport.getCode());
    }

    @Test
    public void checkAddPlaneEmptiesPlane() {
        plane.addPassenger(person);
        assertEquals(1, plane.boarded());
        airport.addPlane(plane);
        assertEquals(0, plane.boarded());
    }

    @Test
    public void getHangar() {
        airport.addPlane(plane);
        assertEquals(1, airport.getHangar().size());
    }

    @Test
    public void checkHangarForPlane() {
        airport.addPlane(plane);
        airport.addPlane(plane);
        airport.addPlane(findme);
        airport.addPlane(plane);
        assertEquals(4, airport.getHangar().size());
        assertEquals(findme, airport.findPlane(findme));
    }

    @Test
    public void checkHangarForInvalidPlane() {
        airport.addPlane(plane);
        airport.addPlane(plane);
        airport.addPlane(plane);
        airport.addPlane(plane);
        assertEquals(4, airport.getHangar().size());
        assertEquals(null, airport.findPlane(findme));
    }

    @Test
    public void addFlight() {
        airport.addPlane(plane);
        airport.addFlight(plane, AirportCode.BER, 123);
        assertEquals(1, airport.getFlightList().size());
        assertEquals(0, airport.getHangar().size());
    }

    @Test
    public void removeFlight() {
        airport.addPlane(plane);
        airport.addFlight(plane, AirportCode.BER, 123);
        assertEquals(1, airport.getFlightList().size());
        assertEquals(0, airport.getHangar().size());
        airport.removeFlight(airport.getFlightList().get(0));
        assertEquals(0, airport.getFlightList().size());
        assertEquals(1, airport.getHangar().size());
    }

    @Test
    public void removeFlightInvalid() {
        airport.addPlane(plane);
        airport.addFlight(plane, AirportCode.BER, 123);
        assertEquals(1, airport.getFlightList().size());
        airport.removeFlight(flight);
        assertEquals(1,airport.getFlightList().size());
    }

    @Test
    public void findFlight() {
        airport.addPlane(plane);
        airport.addFlight(plane, AirportCode.BER, 123);
        assertEquals(1, airport.getFlightList().size());
        Flight findme = airport.findFlight(airport.getFlightList().get(0));
        assertEquals(plane, findme.getPlane());
    }

    @Test
    public void findFlightInvalid() {
        airport.addPlane(plane);
        airport.addFlight(plane, AirportCode.BER, 123);
        assertEquals(1, airport.getFlightList().size());
        Flight findme = airport.findFlight(flight);
        assertEquals(null, findme);
    }

    @Test
    public void sellTicket() {
        airport.addPlane(plane);
        airport.addFlight(plane, AirportCode.BER, 123);
        Flight testflight = airport.getFlightList().get(0);
        airport.sellTicket(person, testflight);
        assertEquals(1, testflight.getPlane().boarded());
    }

    @Test
    public void checkTicketsSold() {
        airport.addPlane(plane);
        airport.addFlight(plane, AirportCode.BER, 123);
        Flight testflight = airport.getFlightList().get(0);
        airport.sellTicket(person, testflight);
        airport.sellTicket(person, testflight);
        airport.sellTicket(person, testflight);
        airport.sellTicket(person, testflight);
        airport.sellTicket(person, testflight);
        assertEquals(5, testflight.getPlane().boarded());
        assertEquals(395, testflight.getPlane().space());
    }

    public void sellTicketFullFlight() {
        airport.addPlane(test10plane);
        airport.addFlight(test10plane, AirportCode.BER, 1);
        Flight testflight = airport.getFlightList().get(0);
        airport.sellTicket(person, testflight);
        airport.sellTicket(person, testflight);
        airport.sellTicket(person, testflight);
        airport.sellTicket(person, testflight);
        airport.sellTicket(person, testflight);
        airport.sellTicket(person, testflight);
        airport.sellTicket(person, testflight);
        airport.sellTicket(person, testflight);
        airport.sellTicket(person, testflight);
        assertEquals(10, testflight.getPlane().boarded());
        airport.sellTicket(person, testflight);
        assertEquals(10, testflight.getPlane().boarded());
    }

    

}