public class NullService implements Servico {
    private String name;
    private String description;
    private double price;
    private TipoServico type;

    public NullService() {
        this.name = "nao existe";
        this.description = "nao ha";
        this.price = 0.0;
        this.type = TipoServico.NULL;
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

    public TipoServico type() {
        return type;
    }

    @Override
    public String toString() {
        return "Não Existe Servico [nome='" + name + '\'' +
                ", descricao='" + description + '\'' +
                ", preco=" + price + ']';
    }
}
