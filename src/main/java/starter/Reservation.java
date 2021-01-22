package starter;

import lombok.Data;
import starter.Animals.Animal;
import starter.Animals.Cat;
import starter.Animals.Dog;
import starter.Animals.Gender;

import java.util.ArrayList;
import java.util.List;

@Data
public class Reservation {

    private List<Animal> Animals;
    private int amountOfDogs = 0;

    public Reservation() {
        Animals = new ArrayList<>();
    }

    public void NewCat(String name, Gender gender, String badHabits){
        this.Animals.add(new Cat(name, gender, badHabits));
    }

    public void NewDog(String name, Gender gender)
    {
        this.amountOfDogs = this.amountOfDogs + 1;
        this.Animals.add(new Dog(name, gender, this.amountOfDogs));

    }

}
