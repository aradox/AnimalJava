package starter.Animals;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Cat extends Animal {

    private List<String> BadHabits;
    private String badHabitsString;
    private double price = 0;

    public Cat(String name, Gender gender, String badHabits) {
        super(name, gender);
        this.BadHabits = splitHabits(badHabits);
        this.badHabitsString = badHabits;
        this.price = calculatePrice();
    }

    public Cat() {
    }

    public List<String> splitHabits(String habits){
        if(!habits.equals("")){
            var habitsList = habits.split(";");
            return Arrays.asList(habitsList.clone());
        }
        return null;
    }

    public double calculatePrice(){
        var x = 350;
        if(BadHabits != null){
            if((350 - (BadHabits.size() * 25)) > 35){
                x = 350 - (BadHabits.size() * 25);
            }
        }
        return x;
    }

    @Override
    public String toString() {
        return "Cat:{" +
                "Name=" + this.getName() +
                "Gender=" + this.getGender() +
                "Price=" + this.price +
                "BadHabits='" + badHabitsString.toLowerCase() + '\'' +
                super.getReserver()+
                '}';
    }
}
