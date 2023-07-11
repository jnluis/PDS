import java.util.ArrayList;
public class Proprietario extends Utilizador {

    ArrayList<ICamper> campers = new ArrayList<ICamper>();

    public Proprietario(String nome, String localidade, int idade) {
        super(nome, localidade, idade);
    }

    public void acceptRequest(Cliente c, ICamper camper){

        if (camper.getEstado() ==  Estado.Disponivel){

            camper.setEstado(Estado.Indisponivel);
            System.out.println("O cliente " + c.toString() + " aceitou o pedido de aluguer do camper " + camper.getDescricao());

        } else {

            System.out.println("O proprietário " + this.toString() + " não pode aceitar o pedido de aluguer do camper " + camper.getDescricao());

        }

    }

    public String toString(){
        return "Proprietario " + super.toString();
    }
    
}
