public class MundoRural extends ServicoGeral {
    public MundoRural(String name, String description, int price, int ocupacao) {
        super(TipoServico.MUNDORURAL, name, description, price, ocupacao);
    }

    public MundoRural(String name, String description, int price) {
        this(name, description, price, 0);
    }
}
