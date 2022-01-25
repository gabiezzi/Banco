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
    public void startClass(){
        sBanco = new ServiciosBanco();
        cuentaBanco = new CuentaBanco(0001,3555,1000.0);
    }
    
    @Test
    public void shouldReturnObjectWhenParameteersAreOk(){
        //Arrange
        CuentaBanco cuentaBancoTest = new CuentaBanco(0001,3555,1000.0);
        
         //Act       
        String toStringReceived = sBanco.mostrarDatos(cuentaBanco);
        String toStringExpected = sBanco.mostrarDatos(cuentaBancoTest);
        //Assert
        
        assertEquals(toStringExpected, toStringReceived);
        assertNotNull("Account number cannot be empty!",cuentaBanco.getAccountNumber());
        assertNotNull("Dni number cannot be empty!",cuentaBanco.getNumDni());
        assertNotNull("Account balance cannot be empty!",cuentaBanco.getAvailableBalance());
        
        
        
        
    }
    
    @Test
    
    public void ShouldReturnBalanceWithDepositedMoney(){
        
       //Arrange
       Double moneyToDeposit= 1250.0;
       Double fakeMoney = -1250.0;
       Double moneyDepositedExpected = 2250.0;
       
       //Act 
       Double moneyDepositedObtained = sBanco.depositarDinero(moneyToDeposit, cuentaBanco.getAvailableBalance());
       
       //Assert
        
        assertEquals(moneyDepositedExpected,moneyDepositedObtained);
        assertNotNull("The deposited money cannot be null!", moneyDepositedObtained);
        assertTrue(sBanco.validateTransaction(moneyToDeposit));
        assertFalse(sBanco.validateTransaction(fakeMoney));
        
    }
    
    @Test
    
    public void ShouldReturnBalanceWithExtractionOfMoney(){
        
         //Arrange
       Double moneyToExtract= 250.0;
       Double fakeMoney = -250.0;
       Double moneyExtractedExpected = 750.0;
       
       //Act 
       Double moneyExtractedObtained = sBanco.retirarDinero(moneyToExtract, cuentaBanco.getAvailableBalance());
       
       //Assert
        
        assertEquals(moneyExtractedExpected,moneyExtractedObtained);
        assertNotNull("The deposited money cannot be null!", moneyExtractedObtained);
        assertTrue(sBanco.validateTransaction(moneyToExtract));
        assertFalse(sBanco.validateTransaction(fakeMoney));
        
        
    }
    
    @Test
    public void ShouldReturnBalanceWithQuickExtractionOfMoney(){
        
         //Arrange
       Double moneyQuickExtraction = 200.0;
       Double moneyQuickExtractionExceeded = 250.0;
       Double fakeMoney = -250.0;
       Double moneyExtractedExpected = 750.0;
       
       //Act 
       Double moneyExtractedObtained = sBanco.extraccionRapidaDinero(moneyQuickExtraction, cuentaBanco.getAvailableBalance());
       Double moneyExtractedError = sBanco.extraccionRapidaDinero(moneyQuickExtractionExceeded, cuentaBanco.getAvailableBalance());
       
       //Assert
        
        assertEquals(moneyExtractedExpected,moneyExtractedObtained);
        assertNotNull("The deposited money cannot be null!", moneyExtractedObtained);
        assertTrue(sBanco.validateTransaction(moneyQuickExtraction));
        assertFalse(sBanco.validateTransaction(fakeMoney));
        assertTrue(sBanco.validateQuickExtraction(moneyQuickExtraction, cuentaBanco.getAvailableBalance()));
        assertFalse(sBanco.validateQuickExtraction(moneyQuickExtractionExceeded, cuentaBanco.getAvailableBalance()));
        
        
    }
    
    @Test
    public void ShouldReturnAvailableBalanceIfBalanceIsOk(){
        
        //Arrange
        

        //Act
        
        
        //Assert
        
        
    }
    
    
    }

