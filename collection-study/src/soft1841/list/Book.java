package soft1841.list;

/**
 *
 */
public class Book {
    public Integer ID;
    public String name;
    public double price;

    public Book(Integer ID, String name, double price) {
        this.ID = ID;
        this.name = name;
        this.price = price;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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
}
