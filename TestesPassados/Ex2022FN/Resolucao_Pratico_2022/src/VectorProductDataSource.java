import java.util.Arrays;
import java.util.List;

public class VectorProductDataSource implements ProductDataSource {
    private Product[] products;

    public VectorProductDataSource(Product[] products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return Arrays.asList(products);
    }
}
