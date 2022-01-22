/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.Entidades;

/**
 *
 * @author Gabi
 */
public class CuentaBanco {

    private Integer numeroCuenta;
    private Integer numDni;
    private double saldoActual;

    public CuentaBanco(Integer numeroCuenta, Integer numDni, double saldoActual) {
        this.numeroCuenta = numeroCuenta;
        this.numDni = numDni;
        this.saldoActual = saldoActual;
    }

    public CuentaBanco() {
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Integer getNumDni() {
        return numDni;
    }

    public void setNumDni(Integer numDni) {
        this.numDni = numDni;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    @Override
    public String toString() {
        return "CuentaBanco{" + "numeroCuenta=" + numeroCuenta + ", numDni=" + numDni + ", saldoActual=" + saldoActual + '}';
    }


    
}


