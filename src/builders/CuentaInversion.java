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

        double montoInvertido = getSaldo();
        int plazo = getPlazo();
        double interes = getInteres();

        double rendimiento = (montoInvertido * plazo * interes) / 100;
        double total = montoInvertido + rendimiento;

        System.out.println("---------------------------------------------------------");
        System.out.println("---------------------| PROYECCION |----------------------");
        System.out.println("Monto Invertido: $" + montoInvertido);
        System.out.println("A plazo de " + plazo + " meses");
        System.out.println("Con un interés de " + interes + "%");
        System.out.println("-----------------| Rendimiento: $" + rendimiento + " |-----------------");
        System.out.println("--------------------| Total: $" + total + " |-------------------");
    }

}
