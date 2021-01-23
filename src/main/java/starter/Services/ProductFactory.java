package starter.Services;

import starter.Interfaces.IProductFactory;
import starter.Products.Bottle;
import starter.Products.Pen;
import starter.Products.Product;

public class ProductFactory implements IProductFactory {

    public Product getProduct(String name){
        switch(name){
            case "Bottle":
                return new Bottle("Bottle", 50);
            case "Pen":
                return new Pen("Pen", 10);
            default:
                return null;
        }
    }
}
