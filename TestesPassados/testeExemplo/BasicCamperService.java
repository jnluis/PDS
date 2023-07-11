
import java.util.ArrayList;
public class BasicCamperService implements ICamperService {

    ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();
    ArrayList<BaseCamper> campers = new ArrayList<BaseCamper>();
    ArrayList<ICamper> available_campers = new ArrayList<ICamper>();

    public BasicCamperService() {
        this.utilizadores = new ArrayList<Utilizador>();
        this.campers = new ArrayList<BaseCamper>();
        this.available_campers = new ArrayList<ICamper>();
    }

    @Override
    public void registaUtilizador(Utilizador u) {
        this.utilizadores.add(u);
    }

    @Override
    public ICamper registaCamper(int lugares, String descricao) {
        BaseCamper camper = new BaseCamper(lugares, descricao);
        this.campers.add(camper);
        this.available_campers.add(camper);
        return camper;
    }

    @Override
    public String registaAluguer(Cliente u, ICamper c) {
        c.setEstado(Estado.Reservado);
        this.available_campers.remove(c);
        return "Utilzador "+ u + " alugou o camper " + c + " com sucesso";
    }
    

    @Override
    public String terminaAluguer(Cliente u, ICamper c) {
        c.setEstado(Estado.Disponivel);
        this.available_campers.add(c);
        return "Utilzador "+ u + " terminou o aluguer do camper " + c + " com sucesso";
    }

    public ArrayList<ICamper> getCampersDisponiveis() {

        return this.available_campers;
        
    }
    
}
