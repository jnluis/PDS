import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class GestorServicosMinimo implements GestorServicos {
    private GestorServicos GestorServicosStandard;
    private Historico historico;

    public GestorServicosMinimo(GestorServicos GestorServicosStandard) {
        this.GestorServicosStandard = GestorServicosStandard;
        historico = Historico.getHistorico();
    }

    @Override
    public Iterator<String> iterator() {
        return GestorServicosStandard.iterator();
    }

    @Override
    public boolean registaServico(String ref, Servico servico) {
        if (existeServico(ref)) {
            return false;
        }
        historico.add(ref, servico);
        return GestorServicosStandard.registaServico(ref, servico);
    }

    @Override
    public boolean existeServico(String ref) {
        return GestorServicosStandard.existeServico(ref);
    }

    @Override
    public Servico eliminaServico(String ref) {
        if (existeServico(ref)) {
            return GestorServicosStandard.eliminaServico(ref);
        } else {
            return new nullService();
        }
    }

    @Override
    public Servico getServico(String ref) {
        return GestorServicosStandard.getServico(ref);
    }

    @Override
    public String toString() {
        return GestorServicosStandard.toString();
    }
}
