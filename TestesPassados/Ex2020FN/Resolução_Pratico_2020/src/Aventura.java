public class Aventura extends ServicoGeral {
    public Aventura(String name, String description, int price, int ocupacao) {
        super(TipoServico.AVENTURA, name, description, price, ocupacao);
    }

    public Aventura(String name, String description, int price) {
        this(name, description, price, 0);
    }
}
