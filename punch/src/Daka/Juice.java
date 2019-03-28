package Daka;

public class Juice implements Comparable<Juice> {
    public String name;
    public int price;

    public Juice(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Juice juice) {
        return this.getPrice() - juice.getPrice();
    }
}
