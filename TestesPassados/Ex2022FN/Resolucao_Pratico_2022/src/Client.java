import java.io.PrintStream;

public class Client implements Comparable<Client>, ProductObserver {
    String code;
    String name;
    private PrintStream out;

    public Client(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String code() {
        return code;
    }

    public String name() {
        return name;
    }

    public void setPrintStream(PrintStream out) {
        this.out = out;
    }

    @Override
    public void onProductReturned(Product product) {
        if (out != null) {
            this.out.println(this.code() + " foi notificado que o produto " + product.code() + " foi devolvido.");
        }
    }

    @Override
    public String toString() {
        return "Client \t" + this.code + "\t" + this.name;
    }

    @Override
    public int compareTo(Client other) {
        return this.name.compareTo(other.name());
    }
}
