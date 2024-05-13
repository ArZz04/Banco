package builders;

import java.util.ArrayList;
import java.util.Date;

public class CuentaNomina extends CuentaBancaria {

    private ArrayList<Movimientos> movimientos;

    private Cliente cliente;

    public CuentaNomina(int nCuenta, double saldo, Date fechaAlta, Cliente cliente) {
        super(nCuenta, saldo, fechaAlta, cliente);
        this.movimientos = new ArrayList<>();
        this.cliente = cliente;
    }

    public ArrayList<Movimientos> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<Movimientos> movimientos) {
        this.movimientos = movimientos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public void depositar(double cantidad){
        // Aquí implementar la lógica para depositar
    }

    public void retirar(double cantidad){
        // Aquí implementar la lógica para retirar
    }
}
