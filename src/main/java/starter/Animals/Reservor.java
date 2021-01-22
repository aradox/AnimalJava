package starter.Animals;

import lombok.Data;

import java.util.Date;

@Data
public class Reservor {

    private String Name;
    private Date ReservedAt;

    public Reservor(String name, Date reservedAt) {
        this.Name = name;
        this.ReservedAt = reservedAt;
    }
}
