public class Passeio implements Servico{
    private String name;
    private String description;
    private double price;

    public Passeio(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
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
    
    @Override
    public String toString() {
        return "Passeio [name=" + name + ", description=" + description + ", price=" + price + "]";
    }

    public TipoServico type() {
        return TipoServico.PASSEIO;
    }
}
