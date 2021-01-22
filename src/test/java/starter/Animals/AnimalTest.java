package starter.Animals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    private Animal animal;

    @BeforeEach
    void setUp() {
        //cant directly make new animal because animal is abstract.
        this.animal = new Dog("Ugly Duckling", Gender.Male);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void TestConstructor()
    {
        assertEquals("Ugly Duckling", this.animal.getName());
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
}