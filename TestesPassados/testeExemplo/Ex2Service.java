public interface Ex2Service {

    public void registaUtilizador(Utilizador u); 
    public ICamper registaCamper(Proprietario p, int lugares, String descrição); 
    public String registaPedido(Cliente u, ICamper c); 
    public String cancelaPedido(Cliente u, ICamper c); 
    public String aceitaPedido(Cliente u, ICamper c); 
    public String rejeitaPedido(Cliente u, ICamper c); 
    public String registaDevolucao(Cliente u, ICamper c);
    
}
