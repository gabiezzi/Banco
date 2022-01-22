/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.Servicios;

import banco.Entidades.CuentaBanco;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Gabi
 */
public class ServiciosBancoTest {
    
    private ServiciosBanco sBanco;
    private CuentaBanco cuentaBanco;

    @Before
    public void startClas(){
        sBanco = new ServiciosBanco();
        cuentaBanco = new CuentaBanco(0001,3555,1000.0);
    }
    
    @Test
    public void shouldReturnObjectWhenParameteersAreOk(){
        
        String toStringExpected = "Numero de cuenta :  " + cuentaBanco.getNumeroCuenta()
                + "Numero de Dni :  " + cuentaBanco.getNumDni()
                + "Saldo Actual: "  + cuentaBanco.getSaldoActual();
        CuentaBanco cuentaBancoTest = new CuentaBanco();
        
    }
}
