public class Alojamento implements Servico{

    private String name;
    private String description;
    private double price;
    private int capacity;

    public Alojamento(String name, String description, double price, int capacity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.capacity = capacity;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public double price() {
        return price;
    }

    public int getcapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Alojamento [name=" + name + ", description=" + description + ", price=" + price + ", ocupacao maxima=" + capacity + "]";
    }


    public TipoServico type() {
        return TipoServico.ALOJAMENTO;
    }
}
