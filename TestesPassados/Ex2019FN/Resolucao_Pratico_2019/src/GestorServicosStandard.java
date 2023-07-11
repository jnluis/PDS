import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class GestorServicosStandard implements GestorServicos {

	private Map<String, Servico> servicos;
	private Historico historico;

	public GestorServicosStandard() {
		this.servicos = new TreeMap<>();
		historico = Historico.getHistorico();
	}

	@Override
	public Iterator<String> iterator() {
		Set<String> serv = new TreeSet<String>();
		for (String ref : this.servicos.keySet())
			serv.add(String.format("Ref: %s - %s", ref, this.servicos.get(ref)));
		return serv.iterator();
	}

	@Override
	public boolean registaServico(String ref, Servico servico) {
		if (servicos.containsKey(ref)) {
			return false;
		}
		historico.add(ref, servico);
		this.servicos.put(ref, servico);
		return true;
	}

	@Override
	public boolean existeServico(String ref) {
		return servicos.containsKey(ref);
	}

	@Override
	public Servico eliminaServico(String ref) {
		if (!servicos.containsKey(ref)) {
			return new nullService();
		}
		historico.remove(ref, servicos.get(ref));
		return servicos.remove(ref);
	}

	@Override
	public Servico getServico(String ref) {
		return servicos.get(ref);
	}

}
