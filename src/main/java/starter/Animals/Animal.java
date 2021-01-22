package starter.Animals;

import lombok.Data;

import java.util.Date;

@Data
public abstract class Animal {

    private String Name;
    private Gender Gender;
    private Reservor ReservedBy;

    public Animal(String name, Gender gender)
    {
        this.Name = name;
        this.Gender = gender;
    }

    public Animal() {
    }

    public Boolean Reserve(String reservedBy)
    {
        if (this.ReservedBy == null)
        {
            this.ReservedBy = new Reservor(reservedBy, new Date(System.currentTimeMillis()));
            return true;
        }
        return false;
    }

    public String getReserver()
    {
        String reserved = "-> not reserved";
        if (this.ReservedBy != null)
        {
            reserved = "-> reserved by " + this.ReservedBy.getName();
        }
        return this.Name + this.Gender + reserved;
    }
}
