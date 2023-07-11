public class Alojamento extends ServicoGeral {
    public Alojamento(String name, String description, int price, int ocupacao) {
        super(TipoServico.ALOJAMENTO, name, description, price, ocupacao);
    }

    public Alojamento(String name, String description, int price) {
        this(name, description, price, 0);
    }
}
