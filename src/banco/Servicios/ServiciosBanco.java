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

        int numCuenta;
        int dni;
        double saldoActual;

        System.out.println("Ingrese el dni!");

        numCuenta = Integer.parseInt(scan.next());

        System.out.println("Ingrese numero de cuenta!");

        dni = Integer.parseInt(scan.next());

        System.out.println("Ingrese el saldo de su cuenta!");

        saldoActual = scan.nextDouble();

        return new CuentaBanco(numCuenta, dni, saldoActual);

    }

    public Double depositarDinero(Double dineroIngresado, Double saldoActual) {

        return dineroIngresado + saldoActual;

    }

    public Double retirarDinero(Double dineroARetirar, Double saldoActual) {

        return (saldoActual - dineroARetirar);

    }

    public Double extraccionRapidaDinero(Double extraccionRapida, Double saldoActual) {

        return saldoActual - extraccionRapida;

    }

    public String mostrarSaldo(Double saldoActual) {

        return "El saldo actual es de " + saldoActual;

    }

    public void mostrarDatos(CuentaBanco cuentaBanco) {

        System.out.println("Numero de cuenta :  " + cuentaBanco.getNumeroCuenta()
                + "Numero de Dni :  " + cuentaBanco.getNumDni()
                + "Saldo Actual: "  + cuentaBanco.getSaldoActual());

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
                    cuentaBanco.setSaldoActual(depositarDinero(dineroIngresado, cuentaBanco.getSaldoActual()));
                    break;
                case 2:
                    System.out.println("Digite el dinero a retirar:");
                    double dineroARetirar = scan.nextDouble();
                    if (dineroARetirar > cuentaBanco.getSaldoActual()) {
                        System.out.println("Saldo insuficiente");
                    } else {
                        cuentaBanco.setSaldoActual(retirarDinero(dineroARetirar, cuentaBanco.getSaldoActual()));
                    }

                    break;
                case 3:
                    System.out.println("Ingrese el monto de extraccion rapida:");
                    double extraccionRapida = scan.nextDouble();
                    while (extraccionRapida > 0.2 * cuentaBanco.getSaldoActual()) {
                        System.out.println("Monto no permitido para extraccion rapida! Ingrese el monto nuevamente");
                        extraccionRapida = scan.nextDouble();
                    }
                    cuentaBanco.setSaldoActual(extraccionRapidaDinero(extraccionRapida, cuentaBanco.getSaldoActual()));
                    break;
                case 4:
                    System.out.println(mostrarSaldo(cuentaBanco.getSaldoActual()));
                    break;
                case 5:
                    mostrarDatos(cuentaBanco);

                    break;
                case 6:

                    System.out.println("Ha elegido salir.");
                    System.out.println("Fin de la operación!");
                    break;

            }

        }

    }

}
