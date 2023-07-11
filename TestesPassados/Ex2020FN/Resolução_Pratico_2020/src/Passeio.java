public class Passeio extends ServicoGeral {
    public Passeio(String name, String description, int price, int ocupacao) {
        super(TipoServico.PASSEIO, name, description, price, ocupacao);
    }

    public Passeio(String name, String description, int price) {
        this(name, description, price, 0);
    }
}
