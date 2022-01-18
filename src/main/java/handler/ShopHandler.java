package handler;
import java.util.ArrayList;
import java.util.List;

public class ShopHandler {
    public ShopHandler(){
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

    private List<String> name = new ArrayList<>();
    private List<Integer> amount = new ArrayList<>();
    private List<Integer> price = new ArrayList<>();

    public void addItem(String name, int amount, int price){
        this.name.add(name);
        this.amount.add(amount);
        this.price.add(price);
    }
    public int getTotalItems(){return name.size();}
    public void sell(int id){
        amount.set(id,amount.get(1) -1);
    }

    public void initializeShop() {
        addItem("HEALTH",20, 1000);
        addItem("BOMBS",10, 5000);
        addItem("SOMETHNG",1, 100000);
    }
}
