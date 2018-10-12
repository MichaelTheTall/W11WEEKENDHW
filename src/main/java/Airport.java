import java.util.ArrayList;

public class Airport {
    private ArrayList<Plane> hangar;
    private AirportCode code;

    public Airport(AirportCode code) {
        this.code = code;
        hangar = new ArrayList<>();
    }


}
