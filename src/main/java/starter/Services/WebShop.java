package starter.Services;

import lombok.Data;
import starter.Animals.Animal;
import starter.Interfaces.ISellable;
import starter.Interfaces.IWebShop;

import java.util.ArrayList;
import java.util.List;

@Data
public class WebShop implements IWebShop {

    private final List<ISellable> shopCart;
    private double amountInCart = 0;

    public WebShop() {
        this.shopCart = new ArrayList<>();
    }

    public void UpdateAmountInCard(){
        for (ISellable iSellable : shopCart) {
            this.amountInCart += iSellable.getPrice();
        }
    }

    public void AddToCart(ISellable product){
        if(product instanceof Animal){
            if(this.shopCart.contains(product)){
                return;
            }
        }

        this.shopCart.add(product);
        this.UpdateAmountInCard();
    }

    public void RemoveFromCart(ISellable product){
        this.shopCart.remove(product);
        this.UpdateAmountInCard();
    }

    @Override
    public List<ISellable> getItemsInCart() {
        return this.shopCart;
    }
}
