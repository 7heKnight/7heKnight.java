package j1.s.p0081;

/**
 *
 * @author ASUS
 */
public class data {
    private String name;
    private int health;
    private String status;

    public data(String name, int health, String status) {
        this.name = name;
        this.health = health;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return name + " | " + health + " | " + status;
    }
    
}
