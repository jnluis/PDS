public class Net implements Servico {
    private String name;
    private String description;
    private double value;
    private String speed;

    public Net(String name, String description, double value, String speed) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.speed = speed;
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

    public String getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Net [" +
                "nome='" + name + '\'' +
                ", descricao='" + description + '\'' +
                ", preco=" + value +
                ", velocidade=" + speed + ']';
    }
}
