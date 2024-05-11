package builders;

import java.util.Date;

public class CuentaInversion extends CuentaBancaria {

    private int plazo;
    private int interes;

    public CuentaInversion(int plazo, int interes, Date fechAlta, Cliente cliente){
        super(0, 0, fechAlta, cliente);
        this.plazo = plazo;
        this.interes = interes;
    }

    public void proyectarInversion(){
        return;
    }

}
