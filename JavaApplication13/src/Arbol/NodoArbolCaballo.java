/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

/**
 *
 * @author Alfonzork
 */
public class NodoArbolCaballo {
    
    private int numeroCaballo;
    private NodoArbolCaballo derecho;
    private NodoArbolCaballo izquierdo;

    public NodoArbolCaballo(int numeroCaballo) {
        this.numeroCaballo = numeroCaballo;
        this.derecho = null;
        this.izquierdo = null;
    }

    @Override
    public String toString() {
        return "numero " + numeroCaballo + "Izquierdo "+ izquierdo + "Derecho "+ derecho;
    } 
    
    /**
     * @return the numeroCaballo
     */
    public int getNumeroCaballo() {
        return numeroCaballo;
    }

    /**
     * @param numeroCaballo the numeroCaballo to set
     */
    public void setNumeroCaballo(int numeroCaballo) {
        this.numeroCaballo = numeroCaballo;
    }

    /**
     * @return the derecho
     */
    public NodoArbolCaballo getDerecho() {
        return derecho;
    }

    /**
     * @param derecho the derecho to set
     */
    public void setDerecho(NodoArbolCaballo derecho) {
        this.derecho = derecho;
    }

    /**
     * @return the izquierdo
     */
    public NodoArbolCaballo getIzquierdo() {
        return izquierdo;
    }

    /**
     * @param izquierdo the izquierdo to set
     */
    public void setIzquierdo(NodoArbolCaballo izquierdo) {
        this.izquierdo = izquierdo;
    }
    
    
}
