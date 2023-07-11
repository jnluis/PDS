import java.util.ArrayList;

public class Historico {
    private static Historico historico1 = new Historico("Historico1");
    private String name;
    private ArrayList<String> historico;

    public Historico(String name) {
        super();
        this.name = name;
        this.historico = new ArrayList<>();
    }

    public static Historico getInstance() {
        return historico1;
    }

    public void add(String string, Servico s) {
        this.historico.add(String.format("Registo: Ref %s - %s", string, s.toString()));
    }

    public void remove(String string, Servico s) {
        this.historico.add(String.format("Eliminado: Ref %s - %s", string, s.toString()));
    }

    public String getHistoricoString() {
        String historico = "Historico:\n";
        for (String string : this.historico) {
            historico += "\t" + string + "\n";
        }
        return historico;
    }
}
