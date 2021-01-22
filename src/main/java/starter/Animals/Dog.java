package starter.Animals;

import lombok.Data;
import starter.Interfaces.ISellable;

import java.time.LocalDateTime;

@Data
public class Dog extends Animal {

    // now
    private LocalDateTime LastWalk;
    private double price = 500;
    private int numberInShelter;

    public Dog(String name, Gender gender) {
        super(name, gender);
        LastWalk = LocalDateTime.now();
        this.price = this.calculatePrice(1);
    }

    public Dog(String name, Gender gender, int numb) {
        super(name, gender);
        LastWalk = LocalDateTime.now();
        this.price = this.calculatePrice(numb);
        this.numberInShelter = numb;
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

    public double calculatePrice(int numb){
        var x = 500;
        if(numb > 1){
            if((500 - (numb * 50)) > 50){
                x = (500 - (numb * 50));
            }
        }
        return x;
    }

    @Override
    public String toString() {
        return "Dog:{" +
                "Name=" + this.getName() +
                "Gender=" + this.getGender() +
                "Price=" + this.price +
                "LastWalk='" + LastWalk + '\'' +
                super.getReserver()+
                '}';
    }
}
