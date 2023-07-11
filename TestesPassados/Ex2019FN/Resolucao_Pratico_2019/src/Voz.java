public class Voz implements Servico {
    private String name;
    private String description;
    private double value;

    public Voz(String name, String description, double value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public String nome() {
        return name;
    }

    public String descricao() {
        return description;
    }

    public double valor() {
        return value;
    }

    @Override
    public String toString() {
        return "Voz [" +
                "nome='" + name + '\'' +
                ", descricao='" + description + '\'' +
                ", preco=" + value +
                ']';
    }
}
