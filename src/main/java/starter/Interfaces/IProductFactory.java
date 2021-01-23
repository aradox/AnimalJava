package starter.Interfaces;

import starter.Products.Product;

public interface IProductFactory {

    Product getProduct(String name);
}
