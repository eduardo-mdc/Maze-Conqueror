package handler;
import game.GameInterface;

import java.util.ArrayList;
import java.util.List;

public class ShopHandler {

    private final GameInterface game;
    private final List<String> name = new ArrayList<>();
    private final List<Integer> amount = new ArrayList<>();
    private final List<Integer> price = new ArrayList<>();

    private int hp;
    private int points;
    private int bombs;

    public ShopHandler(GameInterface game){
        this.game = game;
        initializeShop();
        value();
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

    public int getHp() {
        return hp;
    }

    public int getPoints() {
        return points;
    }

    public int getBombs() {
        return bombs;
    }

    public void value() {
        hp = game.getHeroHp();
        points = game.getPointsHandler().getPoints();
        bombs = game.getBombsHandler().getBombs();
    }

    public int getTotalItems(){return name.size();}

    public void sell(int id){
        if(getAmount(id)>0 && game.getPointsHandler().getPoints() >= price.get(id)){
            int actualAmount = amount.get(id);
            amount.set(id,actualAmount - 1);
            game.getPointsHandler().incrementPoints(-price.get(id));
            effect(id);
        }
        value();
    }

    private void effect(int id) {
        switch (id){
         case 0 -> game.incrementHeroHp();
         case 1 -> game.incrementBombs();
         case 2 -> game.turnInvincible();
        }
    }

    public void initializeShop() {
        addItem("*","HEALTH",20, 1000);
        addItem("b","BOMBS",10, 5000);
    }
}
