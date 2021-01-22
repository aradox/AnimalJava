package starter.Interfaces;

import java.util.List;

public interface IWebShop {

    void UpdateAmountInCard();
    void AddToCart(ISellable product);
    void RemoveFromCart(ISellable product);
    List<ISellable> getItemsInCart();
}
