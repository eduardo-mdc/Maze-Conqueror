package handler;

import game.GameInterface;

import java.util.ArrayList;
import java.util.List;

public class ShopHandler {

    /**
     * Class used to handle the shop's behaviour in the game.
     * This class makes the shop menu responsive since every time an item is added correctly
     * to this class it will change the Shop Menu to accommodate it the right way
     * 
     *  @author Eduardo Correia
     *  @author Alberto Serra
     *  @author José Carvalho
     */
    private final GameInterface game;
    private final List<String> name;
    private final List<Integer> amount;
    private final List<Integer> price;
    private final List<Integer> maxAmount;

    private int hp;
    private int points;
    private int bombs;
    /**
     * Constructor for the shop handler class
     * @param game game class to interact with
     */
    public ShopHandler(GameInterface game) {
        this.game = game;
        name = new ArrayList<>();
        amount = new ArrayList<>();
        price = new ArrayList<>();
        maxAmount = new ArrayList<>();
        initializeShop();
        value();

    }
    /**
     * Gets the name of an item
     * @param id id of the item
     * @return name of item
     */
    public String getName(int id) {
        return name.get(id);
    }
    /**
     * Gets the amount of an item
     * @param id id of the item
     * @return amount of item
     */
    public Integer getAmount(int id) {
        return amount.get(id);
    }
    /**
     * Gets the price of an item
     * @param id id of the item
     * @return price of item
     */
    public Integer getPrice(int id) {
        return price.get(id);
    }
    /**
     * And a new item to the stop with fixed max amount
     * @param character icon for the item
     * @param name name of the item
     * @param amount amount of the item
     * @param price price of the item
     * @param max max price of the item
     */
    public void addItem(String character, String name, int amount, int price, int max) {
        this.name.add(character + " " + name);
        this.amount.add(amount);
        this.price.add(price);
        this.maxAmount.add(max);
    }
    /**
     * And a new item to the stop without fixed max amount
     * @param character icon for the item
     * @param name name of the item
     * @param amount amount of the item
     * @param price price of the item
     */
    public void addItem(String character, String name, int amount, int price) {
        this.name.add(character + " " + name);
        this.amount.add(amount);
        this.price.add(price);
        this.maxAmount.add(-1);
    }
    /**
     * Gets the hp
     * @return hp
     */
    public int getHp() {
        return hp;
    }
    /**
     * Gets the points
     * @return points
     */
    public int getPoints() {
        return points;
    }
    /**
     * Gets the bombs
     * @return bombs
     */
    public int getBombs() {
        return bombs;
    }
    /**
     * Gets the amount of health, bombs and budget of the player
     * @return points
     */
    public void value() {
        hp = game.getMaze().getActualHeroHp();
        points = game.getPointsHandler().getPoints();
        bombs = game.getCurrentBombs();
    }
    /**
     * Gets amount if items available in the stop
     * @return amount of items
     */
    public int getTotalItems() {
        return name.size();
    }
    /**
     * Sells an item to the player
     * @param id of the item to buy
     */
    public void sell(int id) {
        if (getAmount(id) > 0 && game.getPointsHandler().getPoints() >= price.get(id) && canSell(id)) {
            int actualAmount = amount.get(id);
            amount.set(id, actualAmount - 1);
            game.getPointsHandler().incrementPoints(-price.get(id));
            effect(id);
        }
        value();
    }
    /**
     * Checks if the action is possible
     * @param id of the item to buy
     * @return true/false
     */
    private boolean canSell(int id) {
        switch (id) {
            case 0: {
                return hp < maxAmount.get(id);
            }
            case 1: {
                return bombs < maxAmount.get(id);
            }
            case 2:
            case 3: {
                return true;
            }
        }
        return false;
    }
    /**
     * Gives the player the benefit of the purchase
     * @param id of the item to buy
     */
    private void effect(int id) {
        switch (id) {
            case 0 -> game.incrementHeroHp(1);
            case 1 -> game.incrementBombs();
            case 2 -> game.turnInvincible();
            case 3 -> game.increaseRadius();
        }
    }
    /**
     * Increments the amount of an item in stock
     * @param id of the item to increment
     * @param increment amount to increment
     */
    public void increaseStock(int id, int increment) {
        amount.set(id, amount.get(id) + increment);
    }
    /**
     * Increments the amount all items in the shop except for one
     * @param newAmount amount to increment
     * @param exception if needed one item can be deselected to increment
     */
    public void generalReStock(int newAmount, int exception) {
        for (int i = 0; i < this.amount.size(); i++)
            if (i != exception) increaseStock(i, newAmount);
    }
    /**
     * Base items available in the shop for this game
     */
    public void initializeShop() {
        addItem("*", "HEALTH", 20, 1000, game.getMaxHP());
        addItem("b", "BOMBS", 10, 1500, game.getBombsHandler().getMaxbomb());
    }
}
