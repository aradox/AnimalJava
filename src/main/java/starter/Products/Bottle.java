package starter.Products;

import lombok.Data;

@Data
public class Bottle extends Product{
    private String name;
    private double price;

    public Bottle(String name, double price) {
        super(name, price);
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

}
