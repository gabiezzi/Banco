/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.Servicios;

import banco.Entidades.CuentaBanco;
import java.util.Scanner;

/**
 *
 * @author Gabi
 */
public class ServiciosBanco {

    public Scanner scan = new Scanner(System.in);

    public CuentaBanco crearCuenta() {

        int accountNumber;
        int dni;
        double availableBalance;

        System.out.println("Ingrese numero de cuenta!");

        accountNumber = Integer.parseInt(scan.next());

        System.out.println("Ingrese numero de dni!");

        dni = Integer.parseInt(scan.next());

        System.out.println("Ingrese el saldo de su cuenta!");

        availableBalance = scan.nextDouble();
        
        return new CuentaBanco(accountNumber, dni, availableBalance);

    }

    public boolean validateAccountNumber(int accountNumber) {

        if (accountNumber > 0 || accountNumber < 5000) {

            return true;

        }

        return false;
    }

    public boolean validateDniNumber(int numDni) {

        if (numDni > 0) {

            return true;

        }

        return false;
    }

    public boolean validateAvailableBalance(int availableBalance) {

        if (availableBalance >= 0) {

            return true;

        }

        return false;
    }

    public boolean validateTransaction(Double money) {

        if (money > 0) {
            return true;
        }

        return false;
    }
    
    public boolean validateQuickExtraction(Double moneyQuickExtraction, Double availableBalance){
        
        if(moneyQuickExtraction <=(0.2* availableBalance)){
        
        return true;
    }
        
        return false;
    }

    public Double depositarDinero(Double depositedMoney, Double availableBalance) {

        return depositedMoney + availableBalance;

    }

    public Double retirarDinero(Double dineroARetirar, Double availableBalance) {

        return (availableBalance - dineroARetirar);

    }

    public Double extraccionRapidaDinero(Double extraccionRapida, Double availableBalance) {

        return availableBalance - extraccionRapida;

    }

    public String mostrarSaldo(Double availableBalance) {

        return "El saldo actual es de " + availableBalance;

    }

    public String mostrarDatos(CuentaBanco cuentaBanco) {

        return "Numero de cuenta :  " + cuentaBanco.getAccountNumber()
                + "Numero de Dni :  " + cuentaBanco.getNumDni()
                + "Saldo Actual: " + cuentaBanco.getAvailableBalance();

    }

    public void menuCuenta(CuentaBanco cuentaBanco) {

        int opc = 0;

        System.out.println("Buenos dias!");

        while (opc != 6) {

            System.out.println("Ingrese la opcion que desea realizar:\n"
                    + "\n"
                    + "1. Deposito.\n"
                    + "2. Extracción.\n"
                    + "3. Extracción rápida.\n"
                    + "4. Mostrar Saldo Actual.\n"
                    + "5. Mostrar Datos de Cuenta.\n"
                    + "6. Salir.");

            System.out.println("");
            opc = scan.nextInt();
            System.out.println("");

            switch (opc) {

                case 1:
                    System.out.println("Digite el dinero a depositar:");
                    double dineroIngresado = scan.nextDouble();

                    if (validateTransaction(dineroIngresado)) {

                        cuentaBanco.setAvailableBalance(depositarDinero(dineroIngresado, cuentaBanco.getAvailableBalance()));

                    } else {

                        System.out.println("ERROR, Transaction Failed! ");

                    }

                    break;
                case 2:
                    System.out.println("Digite el dinero a retirar:");
                    double dineroARetirar = scan.nextDouble();
                    if (validateTransaction(dineroARetirar)) {

                        if (dineroARetirar > cuentaBanco.getAvailableBalance()) {
                            System.out.println("Saldo insuficiente");
                        } else {
                            cuentaBanco.setAvailableBalance(retirarDinero(dineroARetirar, cuentaBanco.getAvailableBalance()));
                        }

                    } else {

                        System.out.println("ERROR, Transaction Failed! ");

                    }

                    break;
                case 3:
                    System.out.println("Ingrese el monto de extraccion rapida:");
                    double extraccionRapida = scan.nextDouble();

                    if (validateTransaction(extraccionRapida)) {

                        while (!(validateQuickExtraction(extraccionRapida, cuentaBanco.getAvailableBalance()))) {
                            System.out.println("Monto no permitido para extraccion rapida! Ingrese el monto nuevamente");
                            extraccionRapida = scan.nextDouble();
                        }
                        cuentaBanco.setAvailableBalance(extraccionRapidaDinero(extraccionRapida, cuentaBanco.getAvailableBalance()));

                    } else {

                        System.out.println("ERROR, Transaction Failed! ");

                    }

                    break;
                case 4:
                    System.out.println(mostrarSaldo(cuentaBanco.getAvailableBalance()));
                    break;
                case 5:
                    System.out.println(mostrarDatos(cuentaBanco));

                    break;
                case 6:

                    System.out.println("Ha elegido salir.");
                    System.out.println("Fin de la operación!");
                    break;

            }

        }

    }

}
