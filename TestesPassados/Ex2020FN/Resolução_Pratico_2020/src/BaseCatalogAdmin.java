import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class BaseCatalogAdmin implements CatalogAdmin {
    private TreeMap<String, Servico> servicos;
    private Historico historico;

    public BaseCatalogAdmin() {
        this.servicos = new TreeMap<>();
        this.historico = Historico.getInstance();
    }

    public boolean registarServico(String codigo, Servico servico) {
        if (servicos.containsKey(codigo)) {
            System.out.println("Serviço já registado, será substituído.");
        }
        historico.add(codigo, servico);
        servicos.put(codigo, servico);
        return true;
    }

    public boolean verificarServico(String codigo) {
        return servicos.containsKey(codigo);
    }

    public Servico selecionarServico(String codigo) {
        return servicos.get(codigo);
    }

    public Servico removerServico(String codigo) {
        if (!servicos.containsKey(codigo)) {
            return new NullService();
        }
        historico.remove(codigo, servicos.get(codigo));
        return servicos.remove(codigo);
    }

    public Map<String, Servico> getServicos() {
        return servicos;
    }

    public Iterator<String> iterator() {
        return new CatalogIterator(this);
    }
}
