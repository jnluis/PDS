public class TV implements Servico {
    private String name;
    private String description;
    private double value;
    private int channels;

    public TV(String name, String description, double value, int channels) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.channels = channels;
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

    public int getChannels() {
        return channels;
    }

    @Override
    public String toString() {
        return "TV [" +
                "nome='" + name + '\'' +
                ", descricao='" + description + '\'' +
                ", preco=" + value +
                ", canais=" + channels + ']';
    }
}
