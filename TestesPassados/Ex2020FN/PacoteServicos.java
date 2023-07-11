public class PacoteServicos implements Servico{
    private String name;
    private String description;
    private int TaxaDesconto;
    private double price;
    private BaseCatalogAdmin catalogo;

    public PacoteServicos(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public void add(Servico ServicoSelecionado){
        catalogo = new BaseCatalogAdmin();
    }


    @Override
    public double price() {
        double total = 0;
        for (Servico servico : catalogo.getServicos().values()) {
            total += servico.price();
        }
        return total;
    }

    public TipoServico type() {
        return null;
    }
}