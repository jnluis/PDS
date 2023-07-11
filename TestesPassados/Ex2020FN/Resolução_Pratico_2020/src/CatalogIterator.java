import java.util.Iterator;

public class CatalogIterator implements Iterator<String> {
    private CatalogAdmin catalog;
    private Iterator<String> keys;

    public CatalogIterator(CatalogAdmin catalog) {
        this.catalog = catalog;
        this.keys = catalog.getServicos().keySet().iterator();
    }

    public boolean hasNext() {
        return keys.hasNext();
    }

    public String next() {
        if (!hasNext()) {
            return null;
        }
        String code = keys.next();
        return String.format(
                "Código %s : %s",
                code,
                catalog.getServicos().get(code).toString());
    }
}
