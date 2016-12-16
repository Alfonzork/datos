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
public class Pila {

    private int numeroFactura;
    private Pila pilaSgte;

    public Pila() {
    }

    public Pila(int numeroFactura) {
        this.numeroFactura = numeroFactura;
        this.pilaSgte = null;
    }

    public Pila Push(Pila p) {
        if (p == null) {
            p = this;
        } else {
            this.setPilaSgte(p);
            p = this;
        }
        return p;
    }

    public Pila Pop() {
        Pila p, q;
        q = this;
        p = q.getPilaSgte();
        q.setPilaSgte(null);

        return p;
    }

    public Pila InviertePila() {
        Pila pila = this;
        Pila aux = null;
        Pila q = null;

        while (pila != null) {
            q = pila;
            pila = pila.Pop();
            aux = q.Push(aux);
        }
        return aux;
    }

    public void MuestraPila() {
        Pila p = this;
        Pila auxPila = null;
        Pila auxP2 = null;
        while (p != null) {
            auxP2 = p;
            p = p.Pop();
            System.out.println("Numero Factura: " + auxP2.getNumeroFactura());
            auxPila = auxP2.Push(auxPila);
        }
        p = auxPila.InviertePila();

    }

    public Cola CrearCola(Pila p) {
        Pila p2 = p;
        Cola c2 = null, c3;
        Pila auxPila = null, q;

        while (p != null) {
            q = p;
            p = p.Pop();
            c3 = new Cola(q.numeroFactura);
            c2 = c3.ColocaNodo(c2);
            auxPila = q.Push(auxPila);
        }
        p = auxPila.InviertePila();

        return c2;
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
     * @return the pilaSgte
     */
    public Pila getPilaSgte() {
        return pilaSgte;
    }

    /**
     * @param pilaSgte the pilaSgte to set
     */
    public void setPilaSgte(Pila pilaSgte) {
        this.pilaSgte = pilaSgte;
    }

}
