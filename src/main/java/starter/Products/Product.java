package starter.Products;

import lombok.Data;
import starter.Interfaces.ISellable;

@Data
public abstract class Product implements ISellable {
    private String name;
    private double price;

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return this.name + this.price;
    }
}
