package handler;
import game.GameInterface;

import java.util.ArrayList;
import java.util.List;

public class ShopHandler {
    private GameInterface game;
    private List<String> name = new ArrayList<>();
    private List<Integer> amount = new ArrayList<>();
    private List<Integer> price = new ArrayList<>();

    public ShopHandler(GameInterface game){
        this.game = game;
        initializeShop();
    }

    public String getName(int id) {
        return name.get(id);
    }

    public Integer getAmount(int id) {
        return amount.get(id);
    }

    public Integer getPrice(int id) {
        return price.get(id);
    }

    public void addItem(String character ,String name, int amount, int price){
        this.name.add( character + " " + name);
        this.amount.add(amount);
        this.price.add(price);
    }
    public int getTotalItems(){return name.size();}
    public void sell(int id){
        if(getAmount(id)>0){
            int actualAmount = amount.get(id);
            amount.set(id,actualAmount - 1);
            effect(id);
        }

    }

    private void effect(int id) {
     switch (id){
         case 1 -> game.incrementHeroHp();
         case 2 -> game.incrementBombs();
     }
    }

    public void initializeShop() {
        addItem("*","HEALTH",20, 1000);
        addItem("b","BOMBS",10, 5000);
        addItem("X","SOMETHING",10, 100000);
    }
}
