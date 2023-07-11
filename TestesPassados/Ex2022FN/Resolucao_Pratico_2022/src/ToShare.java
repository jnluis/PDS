import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class ToShare implements Empresa, Iterable<Product> {
    TreeMap<String, Product> products;
    TreeMap<Client, ArrayList<Product>> sharedProductsList;
    private TreeMap<Product, ArrayList<Client>> interestedClients;
    private Historico historico;

    public ToShare() {
        this.products = new TreeMap<String, Product>();
        this.sharedProductsList = new TreeMap<Client, ArrayList<Product>>();
        this.interestedClients = new TreeMap<Product, ArrayList<Client>>();
        this.historico = Historico.getInstance();
    }

    public boolean add(Product product) {
        if (products.containsKey(product.code())) {
            return false;
        }
        products.put(product.code(), product);
        return true;
    }

    public Product remove(String code) {
        return products.remove(code);
    }

    public Product remove(Product product) {
        return products.remove(product.code());
    }

    public boolean share(String code, Client client) {
        Product product = this.products.get(code);
        if (product == null) {
            for (ArrayList<Product> products : sharedProductsList.values()) {
                for (Product sharedProduct : products) {
                    if (sharedProduct.code().equals(code)) {
                        product = sharedProduct;
                        break;
                    }
                }
            }
            if (product != null) {
                ArrayList<Client> clients = this.interestedClients.getOrDefault(product, new ArrayList<>());
                if (!clients.contains(client)) {
                    clients.add(client);
                }
                this.interestedClients.put(product, clients);
                return false;
            } else {
                return false;
            }
        }
        if (sharedProductsList.containsKey(client)) {
            sharedProductsList.get(client).add(product);
        } else {
            ArrayList<Product> list = new ArrayList<Product>();
            list.add(product);
            sharedProductsList.put(client, list);
        }
        historico.add(product);
        products.remove(code);
        return true;
    }

    public boolean share(Product product, Client client) {
        return share(product.code(), client);
    }

    public boolean giveBack(String code) {
        for (Client client : sharedProductsList.keySet()) {
            for (Product product : sharedProductsList.get(client)) {
                if (product.code().equals(code)) {
                    sharedProductsList.get(client).remove(product);
                    ArrayList<Client> clients = this.interestedClients.get(product);
                    if (clients != null) {
                        for (Client interestedClient : clients) {
                            interestedClient.onProductReturned(product);
                        }
                    }
                    products.put(product.code(), product);
                    historico.remove(product);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean giveBack(Product product) {
        return giveBack(product.code());
    }

    public int totalProducts() {
        return products.size();
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> list = new ArrayList<Product>();
        for (Product product : products.values()) {
            list.add(product);
        }
        return list;
    }

    public String sharedProducts() {
        String result = "";
        for (Client client : sharedProductsList.keySet()) {
            result += client + "\n";
            for (Product product : sharedProductsList.get(client)) {
                result += "\t" + product + "\n";
            }
        }
        return result;
    }

    public void loadProducts(ProductDataSource dataSource) {
        for (Product product : dataSource.getProducts()) {
            this.add(product);
        }
    }

    public String getHistorico() {
        return historico.toString();
    }

    @Override
    public Iterator<Product> iterator() {
        return new ToShareIterator(this);
    }
}
