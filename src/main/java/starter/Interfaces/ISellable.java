package starter.Interfaces;

import lombok.Data;

public interface ISellable {
    String name = null;
    Double price = null;

    public double getPrice();
}
