public class Flight {
    private Plane plane;
    private int flightnumber;
    private AirportCode destination;

    public Flight(Plane plane, int flightnumber, AirportCode destination) {
        this.plane = plane;
        this.flightnumber = flightnumber;
        this.destination = destination;
    }

}
