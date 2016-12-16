/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apracticaexamen;

/**
 *
 * @author Alfonzork
 */
public class Cola {

    private int numeroFactura;
    private Cola colaSgte;

    public Cola() {
    }

    public Cola(int numeroFactura) {
        this.numeroFactura = numeroFactura;
        this.colaSgte = null;
    }

    /**
     * @return the numeroFactura
     */
    public int getNumeroFactura() {
        return numeroFactura;
    }

    /**
     * @param numeroFactura the numeroFactura to set
     */
    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    /**
     * @return the colaSgte
     */
    public Cola getColaSgte() {
        return colaSgte;
    }

    /**
     * @param colaSgte the colaSgte to set
     */
    public void setColaSgte(Cola colaSgte) {
        this.colaSgte = colaSgte;
    }

    public Cola ColocaNodo(Cola c) {
        if (c == null) {
            c = this;
        } else {
            Cola aux = c;
            while (aux.colaSgte != null) {
                aux.colaSgte = this;
            }
        }
        return c;
    }
    public void VerCola() {

        Cola cola = this;
        System.out.println("*************************************************");
        System.out.println("Los Datos de la Cola Son:       ");
        System.out.println("*************************************************");
        System.out.println("Numero Factura: " + cola.numeroFactura);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
    }

}
