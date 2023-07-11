public class BaseCamper implements ICamper
{

    private Estado estado;
    private int lugares;
    private String descricao;

    public BaseCamper(int lugares, String descricao) {
        this.lugares = lugares;
        this.descricao = descricao;
        this.estado = Estado.Disponivel;
    }

    @Override
    public void setEstado(Estado e) {
        this.estado = e;
    }

    @Override
    public Estado getEstado() {
        return this.estado;
    }

    @Override
    public int getLugares() {
        return this.lugares;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }


    
}
