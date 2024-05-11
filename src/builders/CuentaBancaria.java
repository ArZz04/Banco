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

    public CuentaBancaria(long nCuenta, String nombre, Date fechAlta){
        this.nCuenta = nCuenta;
        this.cliente = new Cliente(nombre);;
        this.fechAlta = fechAlta;
    }

    public long getNCuenta() {
        return nCuenta;
    }

    public void setNCuenta(long nCuenta) {
        this.nCuenta = nCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getFechAlta() {
        return fechAlta;
    }

    public void setFechAlta(Date fechAlta) {
        this.fechAlta = fechAlta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
