package starter.Animals;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import starter.Reservation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservationTest {

    private Reservation reservation;
    private String reserverName = "bob";
    @BeforeEach
    void setUp() {
        reservation = new Reservation();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void init(){
        reservation = new Reservation();
    }

    @Test
    public void TestCat(){
        assertEquals(0, reservation.getAnimals().size());
        this.reservation.NewCat("Cat1", Gender.Female,"Makes sound");
        assertEquals(1, reservation.getAnimals().size());
    }

    @Test
    public void TestDog(){
        assertEquals(0, reservation.getAnimals().size());
        this.reservation.NewDog("Dog1", Gender.Male);
        assertEquals(1, reservation.getAnimals().size());
    }
}
