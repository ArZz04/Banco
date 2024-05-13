package builders;

import java.util.Date;

public class CuentaInversion extends CuentaBancaria {

    private int plazo;
    private double interes;

    public CuentaInversion(int nCuenta, double saldo, Date fechaAlta, int plazo, double interes, Cliente cliente){
        super(nCuenta, saldo, fechaAlta, cliente);
        this.plazo = plazo;
        this.interes = interes;
    }

    public int getPlazo(){
        return this.plazo;
    }

    public void setPlazo(int plazo){
        this.plazo = plazo;
    }

    public double getInteres(){
        return this.interes;
    }

    public void setInteres(int interes){
        this.interes = interes;
    }

    public void proyectarInversion(){
        System.out.println("---------------------------------------------------------");
        System.out.println("----------------------| PROYECTAR |----------------------");
        System.out.println("Monto Invertido: " + getSaldo());
        System.out.println("A plazo de " + getPlazo() + " meses");
        System.out.println("Con un interes de " + getInteres());
        System.out.println("----------------------| $"+ (getSaldo() * getPlazo() * getInteres())/100 +" |----------------------");
    }

}
