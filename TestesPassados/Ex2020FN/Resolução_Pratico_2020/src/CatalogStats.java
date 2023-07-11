public class CatalogStats {
    private CatalogAdmin catalog;

    public CatalogStats(CatalogAdmin catalog) {
        this.catalog = catalog;
    }

    public String getAveragePriveActivities() {
        double sum = 0;
        int count = 0;
        for (String code : catalog.getServicos().keySet()) {
            Servico servico = catalog.getServicos().get(code);
            if (servico.type() != TipoServico.ALOJAMENTO && servico.type() != TipoServico.PACOTE) {
                sum += servico.price();
                count++;
            }
        }
        return String.format("%.3f", sum / count);
    }

    public String getMinimumPrice(TipoServico type) {
        double min = Double.MAX_VALUE;
        for (String code : catalog.getServicos().keySet()) {
            Servico servico = catalog.getServicos().get(code);
            if (servico.type() == type && servico.price() < min) {
                min = servico.price();
            }
        }
        return String.format("%.3f", min);
    }
}
