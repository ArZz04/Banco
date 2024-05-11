package builders;

import java.util.Date;
public class CuentaBancaria {

    // NUMERO DE CUENTA, SALDO, FECHALTA, CLIENTE
    private long nCuenta;
    private double saldo;
    private Date fechAlta;
    private Cliente cliente;

    public CuentaBancaria(long nCuenta, double saldo, Date fechAlta, Cliente cliente){
        this.nCuenta = nCuenta;
        this.saldo = saldo;
        this.fechAlta = fechAlta;
        this.cliente = cliente;
    }

}
