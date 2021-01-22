package starter.Animals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    private Dog animal;

    @BeforeEach
    void setUp() {
        //cant directly make new animal because animal is abstract.
        this.animal = new Dog("Ugly Dog", Gender.Male);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void TestConstructor()
    {
        assertEquals("Ugly Dog", this.animal.getName());
        assertEquals(Gender.Male, this.animal.getGender());
        assertNull(this.animal.getReservedBy());
    }

    @Test
    public void TestReservation()
    {
        assertNull(this.animal.getReservedBy());
        assertTrue(this.animal.Reserve("John Doe"));
        assertNotNull(this.animal.getReservedBy());
        assertEquals("John Doe", this.animal.getReservedBy().getName());
        assertFalse(this.animal.Reserve("Jane Doe"));
    }

    @Test
    void needsWalk() {
        assertFalse(this.animal.NeedsWalk());
        this.animal.addDay();
        assertTrue(this.animal.NeedsWalk());
    }
}