package Ex2;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class CamperService implements CampService{

    private ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();
    private HashMap<Proprietario,String> camper_map = new HashMap<Proprietario,String>();
    private ArrayList<ICamper> campers = new ArrayList<ICamper>();
    private HashMap<ICamper,ArrayList<Cliente>> requests = new HashMap<ICamper,ArrayList<Cliente>>();



    public CamperService() {

        this.utilizadores = new ArrayList<Utilizador>();
        this.camper_map = new HashMap<Proprietario,String>();
        this.campers = new ArrayList<ICamper>();
        this.requests = new HashMap<ICamper,ArrayList<Cliente>>();

    }



    @Override
    public void registaUtilizador(Utilizador u) {
        this.utilizadores.add(u);
    }

    @Override
    public ICamper registaCamper(Proprietario p, int lugares, String descricao) {
        ICamper camper = new BaseCamper(lugares, descricao);
        camper.setEstado(Estado.Disponivel);
        campers.add(camper);
        camper_map.put(p,camper.getDescricao());
        return camper;
            
    }


    @Override
    public String registaPedido(Cliente u, ICamper c) {

        if (this.requests.get(c)== null ){
            ArrayList<Cliente> clientes = new ArrayList<Cliente>();
            this.requests.put(c,clientes);
        }
        else {
        this.requests.get(c).add(u);
    }
        c.setEstado(Estado.Reservado);
        u.receiveMsg("Pedido para o camper " + c + " registado com sucesso");
        for ( Proprietario p : camper_map.keySet()){
            if (camper_map.get(p) == c.getDescricao()){
                p.receiveMsg( u.toString() + " registou um pedido em " + c.toString());
            }
        }
        return u.toString() + " pedido em " + c.toString() + " Estado: Pendente";
    }

    @Override
    public String cancelaPedido(Cliente u, ICamper c) {
        // get the proprietario of camper c from requests hashmap

        for ( Proprietario p : camper_map.keySet()){
            if (camper_map.get(p) == c.getDescricao()){
                p.receiveMsg( u.toString() + " cancelou o pedido em " + c.toString());
            }
        }
        this.requests.remove(c,u);
        c.setEstado(Estado.Disponivel);
        return u.toString() + " pedido em " + c.toString() + " Estado: Cancelado";
    }

    @Override
    public String aceitaPedido(Cliente u, ICamper c) {
        if (c.getEstado() == Estado.Reservado){
            this.requests.remove(c,u);
            c.setEstado(Estado.Indisponivel);
            u.receiveMsg("Pedido para o camper " + c + " foi aceite");
            return u.toString() + " pedido em " + c.toString() + " Estado: Aceite";
        }
        else {
            return "O camper " + c + " tem de ser reservado antes que possa ser aceite um pedido";
        }
    }

    @Override
    public String rejeitaPedido(Cliente u, ICamper c) {
        if (c.getEstado() == Estado.Reservado){
            this.requests.remove(c,u);
            if (this.requests.get(c).size() == 0){ // set state to disponivel if there are no requests 
                c.setEstado(Estado.Disponivel);
            }
            u.receiveMsg("Pedido para o camper " + c + " foi rejeitado");
            return u.toString() + " pedido em " + c.toString() + " Estado: Rejeitado";
        }
        else {
            return "O camper " + c + " tem de ser reservado antes que possa ser aceite um pedido";
        }
    }

    @Override
    public String registaDevolucao(Cliente u, ICamper c) {
       c.setEstado(Estado.Disponivel);
       for ( Proprietario p : camper_map.keySet()){
        if (camper_map.get(p) == c.getDescricao()){
            p.receiveMsg( u.toString() + " devolveu o pedido em " + c.toString());
        }
    }
       return u.toString() + " devolveu " + c.toString() + " Estado: Disponivel";

    }

    public ArrayList<ICamper> getCampersDisponiveis(){
        // return a arraylist with all the campers that have estado disponivel
        ArrayList<ICamper> disponiveis = new ArrayList<ICamper>();
        for (ICamper camper : this.campers){
            if (camper.getEstado() == Estado.Disponivel){
                disponiveis.add(camper);
            }
        }
        return disponiveis;
    }
    
}
