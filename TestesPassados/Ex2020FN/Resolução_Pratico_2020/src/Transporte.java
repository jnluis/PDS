public class Transporte extends ServicoGeral {
    public Transporte(String name, String description, int price, int ocupacao) {
        super(TipoServico.TRANSPORTE, name, description, price, ocupacao);
    }

    public Transporte(String name, String description, int price) {
        this(name, description, price, 0);
    }
}
