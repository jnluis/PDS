public interface GestorServicos extends Iterable<String> {

	public boolean registaServico(String ref, Servico servico);
	public boolean existeServico(String ref);
	public Servico eliminaServico(String ref);
	public Servico getServico(String ref);
		
}
