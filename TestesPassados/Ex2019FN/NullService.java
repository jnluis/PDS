//Null Object

class NullService implements Servico{
    private String nome = "nao existe";
    private String descricao = "nao existe";
    private double price = 0.0;
    private GestorServicos gestorServicos;

	public String descricao(){
        return this.descricao;
    };
	public double price(){
        return this.price;
    };

    @Override
    public String toString(){
        return "Servico vazio [nome=" + this.nome + ", descricao=" + this.descricao + ", preco=" + this.price + "]";
    }
    @Override
    public void setGestorServicos(GestorServicos gestorServicos) {
        this.gestorServicos = gestorServicos;        
    }

    public GestorServicos getGestorServicos() {
        return gestorServicos;
    }

    @Override
    public String getName() {
        return this.nome;
    }
}