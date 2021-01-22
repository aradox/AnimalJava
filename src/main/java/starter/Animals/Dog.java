package starter.Animals;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Dog extends Animal {

    // now
    private LocalDateTime LastWalk;

    public Dog(String name, Gender gender) {
        super(name, gender);
        LastWalk = LocalDateTime.now();
    }

    //Methode to test NeedsWalk
    public void addDay(){
        this.LastWalk = this.LastWalk.plusDays(1);
    }

    public Boolean NeedsWalk() {
        var dayNow = LocalDateTime.now().getDayOfYear();
        var dayLast = LastWalk.getDayOfYear();
        return (dayLast - dayNow) > 0;
    }

    @Override
    public String toString() {
        return "Dog:{" +
                "Name=" + this.getName() +
                "Gender=" + this.getGender() +
                "LastWalk='" + LastWalk + '\'' +
                super.getReserver()+
                '}';
    }
}
