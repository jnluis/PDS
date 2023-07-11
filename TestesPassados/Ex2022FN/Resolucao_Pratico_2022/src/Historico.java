import java.util.ArrayList;

public class Historico {
    private static Historico historico1 = new Historico("Historico1");
    private ArrayList<String> historico;

    public Historico(String name) {
        super();
        this.historico = new ArrayList<>();
    }

    public static Historico getInstance() {
        return historico1;
    }

    public void add(Product product) {
        this.historico.add(String.format("Registo: Vehicle %s lended", product.code()));
    }

    public void remove(Product product) {
        this.historico.add(String.format("Devolucao: Vehicle %s was returned", product.code()));
    }

    public String toString() {
        String historico = "Historico:\n";
        for (String string : this.historico) {
            historico += "\t" + string + "\n";
        }
        return historico;
    }
}
