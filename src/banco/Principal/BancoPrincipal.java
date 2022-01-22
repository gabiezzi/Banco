/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.Principal;

import banco.Entidades.CuentaBanco;
import banco.Servicios.ServiciosBanco;

/**
 *
 * @author Gabi
 */
public class BancoPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ServiciosBanco nuevoServicio = new ServiciosBanco();
        
        CuentaBanco cuenta1 = nuevoServicio.crearCuenta();
        
        nuevoServicio.menuCuenta(cuenta1);

        System.out.println(cuenta1.toString());
    }
    
}
