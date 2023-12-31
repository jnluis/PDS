class TV implements Servico{
    private String nome;
    private String descricao;
    private double price;
    private int canais; //# Channels
    private GestorServicos gestorServicos;

    TV(String nome, String descricao, double price, int channels){
        this.nome = nome;
        this.descricao = descricao;
        this.price = price;
        this.canais = channels;
    }

    public String nome(){
        return this.nome;
    };
	public String descricao(){
        return this.descricao;
    };
	public double price(){
        return this.price;
    };
    public int canais(){
        return this.canais;
    };

    @Override
    public String toString(){
        return "TV [nome=" + this.nome + ", descricao=" + this.descricao + ", preco=" + this.price + "], canais=" + this.canais;
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