package builders;

import data.movementManager;
import data.nominas.NomController;

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


    public void retirar( double cantidad){
        if (cantidad > 0 && cantidad <= getSaldo()) {

            double saldoAnterior = getSaldo();

            setSaldo(saldoAnterior - cantidad);

            Movimientos movimiento = new Movimientos(getNCuenta(), "RETIRO", new Date(), cantidad, saldoAnterior, getSaldo());
            movimientos.add(movimiento);
            movementManager.addMovement(movimiento);
            NomController.refreshSaldo(getNCuenta(), getSaldo());

            System.out.println("Retiro de " + cantidad + " realizado con éxito.");
        } else {
            System.out.println("-------------------------------------------------------------");
            System.out.println("--| Fondos insuficientes o cantidad inválida para retirar. |-");
        }
    }


    public void depositar(double cantidad){
        if (cantidad > 0) {
            double saldoAnterior = getSaldo();

            setSaldo(saldoAnterior + cantidad);

            Movimientos movimiento = new Movimientos(getNCuenta(), "DEPÓSITO", new Date(), cantidad, saldoAnterior, getSaldo());
            movimientos.add(movimiento);
            movementManager.addMovement(movimiento);
            NomController.refreshSaldo(getNCuenta(), getSaldo());

            System.out.println("Depósito de " + cantidad + " realizado con éxito.");
        } else {
            System.out.println("Error: La cantidad a depositar debe ser mayor que cero.");
        }
    }
}
