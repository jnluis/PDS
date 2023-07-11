public class Vehicle implements Product, Comparable<Product> {
    String name;
    String description;
    int price;

    public Vehicle(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String code() {
        return name;
    }

    public String description() {
        return description;
    }

    public double points() {
        return price * 0.1;
    }

    @Override
    public int compareTo(Product other) {
        return this.code().compareTo(other.code());
    }
}
