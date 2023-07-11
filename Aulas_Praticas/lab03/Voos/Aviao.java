package lab03.Voos;

import java.util.ArrayList;
import java.util.List;

public class Aviao {

    private List<Integer> E_Seats = new ArrayList<Integer>();
    private List<Integer> T_Seats = new ArrayList<Integer>();


    public Aviao(String E_Seats, String T_Seats) {
        String[] seatsE = E_Seats.split("x");

        this.E_Seats.add(Integer.parseInt(seatsE[0]));
        this.E_Seats.add(Integer.parseInt(seatsE[1]));

        seatsE = T_Seats.split("x");
        this.T_Seats.add(Integer.parseInt(seatsE[0]));
        this.T_Seats.add(Integer.parseInt(seatsE[1]));
    }

    public Aviao(String T_Seats) {
        String[] seats = T_Seats.split("x");
        this.T_Seats.add(Integer.parseInt(seats[0]));
        this.T_Seats.add(Integer.parseInt(seats[1]));

    }

    public List<Integer> getE_Seats() {
        return E_Seats;
    }

    public List<Integer> getT_Seats() {
        return T_Seats;
    }

    public int getE_Columns() {
        if (E_Seats.size() == 0) {
            return 0;
        }
        return E_Seats.get(0);
    }

    public int getT_Columns() {
        return T_Seats.get(0);
    }

    public int getE_Filas() {
        if (E_Seats.size() == 0) {
            return 0;
        }
        return E_Seats.get(1);
    }

    public int getT_Filas() {
        return T_Seats.get(1);
    }

    public int getE_TotalSeats() {
        if (E_Seats.size() == 0) {
            return 0;
        }
        return E_Seats.get(0) * E_Seats.get(1);
    }

    public int getT_TotalSeats() {
        return T_Seats.get(0) * T_Seats.get(1);
    }

    public int getNumFilas() {
        if (E_Seats.size() == 0)
            return T_Seats.get(1);
        else {
            if (T_Seats.get(1) > E_Seats.get(1)) {
                return T_Seats.get(1);
            }

            return E_Seats.get(1);
        }
    }

    public int getNumColunas() {
        if (E_Seats.size() == 0)
            return T_Seats.get(0);
        else {
            return E_Seats.get(0) + T_Seats.get(0);
        }
    }

   

    public void delReserve(int reserve_number) {
        for (int i = 0; i <= getE_TotalSeats(); i++) {
            if (E_Seats.get(i) == reserve_number) {
                E_Seats.add(i, 0);
                //System.out.println(E_Seats); //o print do flight1 dá [3, 0, 2]
            }
        }  
        // for (int i = 0; i <= getT_TotalSeats(); i++) {
        //     if (T_Seats.get(i) == reserve_number) {
        //         T_Seats.add(i, 0);
        //         System.out.println(T_Seats);
        //     }
        // }
    }

    public String toString() {
        if (E_Seats.size() == 0) {
            return "Lugares disponíveis: " + getT_TotalSeats()
                    + " lugares em classe Turística.\nClasse executiva não disponível neste voo.";
        }
        return "Lugares disponíveis: " + getE_TotalSeats() + " lugares em classe Executiva; " + getT_TotalSeats()
                + " lugares em classe Turística.";
    }

}
