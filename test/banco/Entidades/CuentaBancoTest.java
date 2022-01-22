/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.Entidades;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabi
 */
public class CuentaBancoTest {
    
    public CuentaBancoTest() {
    }
    
        CuentaBanco cuentaBanco;

    @Test
    public void shouldInstantTheClassWhenParameteersAreOk() {
        
        Integer accountNumberExpected = 0001;
        Integer dniNumberExpected = 3555;
        Double bankBalanceExpected = 1000.0;
        String toStringExpected = "CuentaBanco{" + "numeroCuenta=" + 0001 + ", numDni=" + 3555 + ", saldoActual=" + 1000.0 + '}';
        cuentaBanco = new CuentaBanco(accountNumberExpected, dniNumberExpected, bankBalanceExpected);
        CuentaBanco cuentaBancoTest = new CuentaBanco(0001,3555,1000.0);
        
        assertEquals(cuentaBancoTest.getNumeroCuenta(),cuentaBanco.getNumeroCuenta());
        assertEquals(cuentaBancoTest.getNumDni(),cuentaBanco.getNumDni());
        assertEquals(cuentaBancoTest.getSaldoActual(),cuentaBanco.getSaldoActual(),0.0);
        assertNotNull(cuentaBanco.getNumeroCuenta());
        assertNotNull(cuentaBanco.getNumDni());
        assertNotNull(cuentaBanco.getSaldoActual());
        assertEquals(toStringExpected, cuentaBanco.toString());
    }
    
}
