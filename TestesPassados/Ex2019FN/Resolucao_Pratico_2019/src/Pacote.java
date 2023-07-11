import java.util.ArrayList;

public class Pacote implements Servico {
    private ArrayList<Servico> servicos;
    private String name;
    private String description;
    private int fidelizacao;

    public Pacote(String name, String description, int fidelizacao) {
        this.name = name;
        this.description = description;
        this.fidelizacao = fidelizacao;
        this.servicos = new ArrayList<>();
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

    public void add(Servico servico) {
        servicos.add(servico);
    }

    public double getPreco() {
        double preco = 0;
        for (Servico servico : servicos) {
            preco += servico.valor();
        }
        return preco;
    }

    public String getServicesString() {
        String services = "";
        for (Servico servico : servicos) {
            services += servico.toString() + "\n\t\t";
        }
        return services;
    }

    @Override
    public String toString() {
        return "Pacote [" +
                "nome='" + name + '\'' +
                ", descricao='" + description + '\'' +
                ", preco=" + this.getPreco() + "], com fidelizacao de " + fidelizacao + " meses"
                + "\n\t\t"
                + this.getServicesString();
    }
}
