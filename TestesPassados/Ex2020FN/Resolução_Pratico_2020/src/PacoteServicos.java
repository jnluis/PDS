import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PacoteServicos implements Servico {
    ArrayList<Servico> servicos;
    private String nome;
    private String descricao;

    public PacoteServicos(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.servicos = new ArrayList<>();
    }

    public void add(Servico servico) {
        servicos.add(servico);
    }

    public void remove(Servico servico) {
        servicos.remove(servico);
    }

    public String name() {
        return nome;
    }

    public String description() {
        return descricao;
    }

    public double price() {
        int discount = getDesconto();
        double price = 0;
        for (Servico s : servicos) {
            price += s.price() * ((double) (100 - discount) / 100);
        }
        return price;
    }

    public TipoServico type() {
        return TipoServico.PACOTE;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(
                String.format(
                        "Pacote com %d AbstractServicos de %d tipos. Preço (desconto = %d%%): %.1f\n",
                        servicos.size(),
                        getNumeroTipos(),
                        getDesconto(),
                        price()));
        for (Servico s : servicos) {
            sb.append(
                    String.format(
                            "\t%s\n",
                            s.toString()));
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }

    private int getDesconto() {
        return servicos.size() * 3 < 10 ? servicos.size() * 3 : 10;
    }

    private int getNumeroTipos() {
        Set<String> tipos = new HashSet<>();
        for (Servico s : servicos) {
            tipos.add(s.getClass().getName());
        }
        return tipos.size();
    }
}
