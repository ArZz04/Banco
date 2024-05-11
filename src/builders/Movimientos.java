package builders;

import java.util.Date;

public class Movimientos {

    private int id;
    private String tipo;
    private Date fecha;
    private double monto, saldoAnterior, saldoNuevo;

    public Movimientos(int id, String tipo, Date fecha, double monto, double saldoAnterior, double saldoNuevo){
        this.id = id;
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
        this.saldoAnterior = saldoAnterior;
        this.saldoNuevo = saldoNuevo;
    }

    // Getters
    public int getId() {
        return id;
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
    public void setId(int id) {
        this.id = id;
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
