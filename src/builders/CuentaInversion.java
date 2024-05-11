package builders;

import java.util.Date;

public class CuentaInversion extends CuentaBancaria {

    private int plazo;
    private int interes;

    public CuentaInversion(int nCuenta, double saldo, Date fechaAlta, Cliente cliente){
        super(nCuenta, 0, fechaAlta, cliente);
        this.plazo = plazo;
        this.interes = interes;
    }

    public int getPlazo(){
        return this.plazo;
    }

    public void setPlazo(int plazo){
        this.plazo = plazo;
    }

    public int getInteres(){
        return this.interes;
    }

    public void setInteres(int interes){
        this.interes = interes;
    }

    public void proyectarInversion(){
        return;
    }

}
