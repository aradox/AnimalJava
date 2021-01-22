package starter.Products;

import lombok.Data;

@Data
public class Pen extends Product{
    private String name;
    private double price;

    public Pen(String name, double price) {
        super(name, price);
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

}