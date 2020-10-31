package data;

/**
 *
 * @author ASUS
 */
public class Order {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private double amout;

    public Order(String id, String name, double price, int quantity, double amout) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.amout = amout;
    }

    public double getAmout() {
        return amout;
    }

    public void setAmout(double amout) {
        this.amout = amout;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name+"  "+ quantity+"  $"+price+"  $"+amout+"\n";
    }
    
}
