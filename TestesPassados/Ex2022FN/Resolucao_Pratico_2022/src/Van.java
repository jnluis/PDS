public class Van extends Vehicle {
    public Van(String name, String description, int price) {
        super(name, description, price);
    }

    @Override
    public String toString() {
        return "Van\t" + name + "\t" + description + "\t" + price;
    }
}
