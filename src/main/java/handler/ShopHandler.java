package handler;

import game.GameInterface;

import java.util.ArrayList;
import java.util.List;

public class ShopHandler {

    private final GameInterface game;
    private final List<String> name;
    private final List<Integer> amount;
    private final List<Integer> price;
    private final List<Integer> maxAmount;

    private int hp;
    private int points;
    private int bombs;

    public ShopHandler(GameInterface game) {
        this.game = game;
        name = new ArrayList<>();
        amount = new ArrayList<>();
        price = new ArrayList<>();
        maxAmount = new ArrayList<>();
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

    public void addItem(String character, String name, int amount, int price, int max) {
        this.name.add(character + " " + name);
        this.amount.add(amount);
        this.price.add(price);
        this.maxAmount.add(max);
    }

    public void addItem(String character, String name, int amount, int price) {
        this.name.add(character + " " + name);
        this.amount.add(amount);
        this.price.add(price);
        this.maxAmount.add(-1);
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
        hp = game.getMaze().getActualHeroHp();
        points = game.getPointsHandler().getPoints();
        bombs = game.getCurrentBombs();
    }

    public int getTotalItems() {
        return name.size();
    }

    public void sell(int id) {
        if (getAmount(id) > 0 && game.getPointsHandler().getPoints() >= price.get(id) && canSell(id)) {
            int actualAmount = amount.get(id);
            amount.set(id, actualAmount - 1);
            game.getPointsHandler().incrementPoints(-price.get(id));
            effect(id);
        }
        value();
    }

    private boolean canSell(int id) {
        switch (id) {
            case 0: {
                return hp < maxAmount.get(id);
            }
            case 1: {
                return bombs < maxAmount.get(id);
            }
            case 2: {
                return true;
            }
        }
        return false;
    }

    private void effect(int id) {
        switch (id) {
            case 0 -> game.incrementHeroHp(1);
            case 1 -> game.incrementBombs();
            case 2 -> game.turnInvincible();
        }
    }

    public void increaseStock(int id, int increment) {
        amount.set(id, amount.get(id)+ increment);
    }

    public void generalReStock(int newAmount, int exception) {
        for (int i = 0; i < this.amount.size(); i++)
            if (i != exception) increaseStock(i, newAmount);
    }

    public void initializeShop() {
        addItem("*", "HEALTH", 20, 1000, game.getMaxHP());
        addItem("b", "BOMBS", 10, 1500, game.getBombsHandler().getMaxbomb());
    }
}
