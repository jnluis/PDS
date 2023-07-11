package lab07.Ex03;

public class Bebida implements ProdutoInterface{
    private String nome;
    private Double peso;

    Bebida(String nome, int peso){
        this.nome = nome;
        this.peso = Double.valueOf(peso);
    }

    public void draw() {
        System.out.println("Bebida '" + this.nome + "' - Weight: " + this.peso);
    }

    public Double getPesoTotal() {
        return this.peso;
    }
}