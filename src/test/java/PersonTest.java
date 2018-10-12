import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    Person person;

    @Before
    public void before(){
        person = new Person("Bob");
    }

    @Test
    public void getName() {
        assertEquals("Bob", person.getName());
    }

}
