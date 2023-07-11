public class Car extends Vehicle {
    public Car(String name, String description, int price) {
        super(name, description, price);
    }

    @Override
    public String toString() {
        return "Car\t" + name + "\t" + description + "\t" + price;
    }
}
