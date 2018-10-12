import org.junit.Before;

public class PlaneTest {

    Plane plane;

    @Before
    public void before(){
        plane = new Plane(Type.B747, Airline.BA);
    }

}
