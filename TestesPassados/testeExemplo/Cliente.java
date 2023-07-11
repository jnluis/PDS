public class Cliente extends Utilizador {
    public Cliente(String nome, String localidade, int idade) {
        super(nome, localidade, idade);
    }

    public String toString() {
        return "Cliente " + super.toString();
    }
    
    
}
