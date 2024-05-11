package builders;

import java.util.ArrayList;
import java.util.Date;

public class CuentaNomina {

    private ArrayList<Movimientos> movimientos;
    private Date fechAlta;
    private Cliente cliente;

    public CuentaNomina(ArrayList<Movimientos> movimientos, Date fechAlta, Cliente cliente ){
        this.movimientos = movimientos;
        this.fechAlta = fechAlta;
        this.cliente = cliente;
    }

    public void depositar(double cantidad){
        return;
    }
    public void retirar(double cantidad){
        return;
    }


}
