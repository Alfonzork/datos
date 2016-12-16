/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apracticaexamen;

import java.util.Scanner;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 *
 * @author Alfonzork
 */
public class APracticaExamen {

    private static void Menu() {
        System.out.println("*********************************************");
        System.out.println("1.- Crear Lista: ");
        System.out.println("2.- Crear Pila desde Lista: ");
        System.out.println("3.- Crear Cola desde Pila");
        System.out.println("4.- Mostrar Lista: ");
        System.out.println("5.- Mostrar Pila: ");
        System.out.println("6.- Salir");
        System.out.println("*********************************************");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opc;
        Scanner scan = new Scanner(System.in);
        Venta venta = null, auxVta;
        Pila pila = null;
        Cola cola = null;

        do {
            Menu();
            System.out.println("Ingrese Opcion: ");
            opc = scan.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Ingrese Numero Factura: ");
                    int numero = scan.nextInt();
                    System.out.println("Ingrese Fecha: ");
                    String fecha = scan.next();
                    System.out.println("Ingrese Rut: ");
                    int rut = scan.nextInt();
                    System.out.println("Ingrese Neto: ");
                    int neto = scan.nextInt();

                    auxVta = new Venta(numero, fecha, rut, neto);
                    venta = auxVta.AgregaVenta(venta);
                    System.out.println("Guardado con Exito...");
                    break;

                case 2:
                    if (venta == null) {
                        System.out.println("No hay datos");
                    } else {
                        pila = venta.CreaPila(venta);

                        System.out.println("Se ha agregado datos en la Pila, Los datos son: ");
                        pila.MuestraPila();
                    }
                    break;

                case 3:
                    if (pila == null) {
                        System.out.println("No hay datos");
                    } else {
                        cola = pila.CrearCola(pila);
                        System.out.println("Se ha agregado datos en la Cola, Los datos son: ");
                        cola.VerCola();
                    }
                    break;

                case 4:
                    if (venta == null) {
                        System.out.println("No Existe Lista a Mostrar...");
                    } else {
                        venta.MostrarVenta();
                    }
                    break;

                case 5:
                    if (pila == null) {
                        System.out.println("No Existen Datos...");
                    } else {
                        pila.MuestraPila();
                    }
                    break;
            }
        } while (opc != 6);
    }
}
