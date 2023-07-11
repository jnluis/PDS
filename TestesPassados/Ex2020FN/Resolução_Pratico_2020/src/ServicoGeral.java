public class ServicoGeral implements Servico {
    private String name;
    private String description;
    private int price;
    private TipoServico type;
    private int ocupacao;

    public ServicoGeral(TipoServico type, String name, String description, int price, int ocupacao) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.price = price;
        this.ocupacao = ocupacao;
    }

    public ServicoGeral(TipoServico type, String name, String description, int price) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.price = price;
        this.ocupacao = 0;
    }

    public String name() {
        return this.name;
    }

    public String description() {
        return this.description;
    }

    public double price() {
        return this.price;
    }

    public TipoServico type() {
        return this.type;
    }

    public int ocupacao() {
        return this.ocupacao;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s [name = %s, description = %s, price = %d]", type, name, description, price));
        if (ocupacao != 0) {
            sb.append(String.format("[ ocupação máxima : %d ]", ocupacao));
        }
        return sb.toString();
    }
}
