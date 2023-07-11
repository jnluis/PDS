public class Motorcycle extends Vehicle {
    public Motorcycle(String name, String description, int price) {
        super(name, description, price);
    }

    @Override
    public String toString() {
        return "Motorcycle\t" + name + "\t" + description + "\t" + price;
    }
}
