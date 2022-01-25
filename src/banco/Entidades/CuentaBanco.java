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

    private Integer accountNumber;
    private Integer numDni;
    private double  availableBalance;

    public CuentaBanco(Integer numeroCuenta, Integer numDni, double saldoActual) {
        this.accountNumber = numeroCuenta;
        this.numDni = numDni;
        this.availableBalance = saldoActual;
    }

    public CuentaBanco() {
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setNumeroCuenta(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getNumDni() {
        return numDni;
    }

    public void setNumDni(Integer numDni) {
        this.numDni = numDni;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    @Override
    public String toString() {
        return "CuentaBanco{" + "numeroCuenta=" + accountNumber + ", numDni=" + numDni + ", saldoActual=" + availableBalance + '}';
    }


    
}


