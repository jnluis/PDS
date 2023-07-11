package lab11.Ex3;

public class Emprestado implements State{

    @Override
    public void regista(Livro livro) {
        System.out.println("Operação não disponível");
    }

    @Override
    public void requesita(Livro livro) {
        System.out.println("Operação não disponível");
    }

    @Override
    public void devolve(Livro livro) {
        livro.setEstado(new Disponivel());
    }

    @Override
    public void cancelaReserva(Livro livro) {
        System.out.println("Operação não disponível");
    }

    @Override
    public void reserva(Livro livro) {
        System.out.println("Operação não disponível");
    }

    @Override
    public String toString() {
        return "[Emprestado]";
    }
    
}
