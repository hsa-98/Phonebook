package Model;

import java.net.PortUnreachableException;

public class Inventory {
    private String name;
    private double price;
    private double weight   ;

    public Inventory(){

    }

    public Inventory(String name, double price, double height) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
