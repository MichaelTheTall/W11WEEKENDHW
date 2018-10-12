import java.util.ArrayList;

public class Airport {
    private ArrayList<Plane> hangar;
    private AirportCode code;

    public Airport(AirportCode code) {
        this.code = code;
        hangar = new ArrayList<>();
    }


    public AirportCode getCode() {
        return code;
    }

    public ArrayList getHangar() {
        return hangar;
    }

    public void addPlane(Plane plane) {
        hangar.add(plane);
    }

    public Plane findPlane(Plane plane) {
        if (hangar.contains(plane)) {
            int index = hangar.indexOf(plane);
            Plane result = hangar.get(index);
            return result;
        } else {
            return null;
        }
    }
}
