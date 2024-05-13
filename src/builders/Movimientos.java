package builders;

import java.util.Date;

public class Movimientos {

    private long nCuenta;
    private String tipo;
    private Date fecha;
    private double monto, saldoAnterior, saldoNuevo;

    public Movimientos(long nCuenta, String tipo, Date fecha, double monto, double saldoAnterior, double saldoNuevo){
        this.nCuenta = nCuenta;
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
        this.saldoAnterior = saldoAnterior;
        this.saldoNuevo = saldoNuevo;
    }

    // Getters
    public long getnCuenta() {
        return nCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public double getSaldoAnterior() {
        return saldoAnterior;
    }

    public double getSaldoNuevo() {
        return saldoNuevo;
    }

    // Setters
    public void setnCuenta(int nCuenta) {
        this.nCuenta = nCuenta;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setSaldoAnterior(double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public void setSaldoNuevo(double saldoNuevo) {
        this.saldoNuevo = saldoNuevo;
    }
}
