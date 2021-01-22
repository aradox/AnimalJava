package starter.Animals;

import lombok.Data;

@Data
public class Cat extends Animal {

    private String BadHabits;

    public Cat(String name, Gender gender, String badHabits) {
        super(name, gender);
        this.BadHabits = badHabits;

    }

    public Cat() {
    }

    @Override
    public String toString() {
        return "Cat:{" +
                "Name=" + this.getName() +
                "Gender=" + this.getGender() +
                "BadHabits='" + BadHabits.toLowerCase() + '\'' +
                super.getReserver()+
                '}';
    }
}
