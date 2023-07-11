
public class nullService implements Servico {
    private String name;
    private String description;
    private double fidelizacao;

    public nullService() {
        this.name = "nao existe";
        this.description = "não tenho descrição";
        this.fidelizacao = 0;
    }

    public String nome() {
        return name;
    }

    public String descricao() {
        return description;
    }

    public double valor() {
        return fidelizacao;
    }

    @Override
    public String toString() {
        return "Não Existe Servico [nome='" + name + '\'' +
                ", descricao='" + description + '\'' +
                ", preco=" + fidelizacao + ']';
    }
}
