/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apracticaexamen;

import java.util.Date;

/**
 *
 * @author Alfonzork
 */
public class Venta {
    
    private int numeroFactura;
    private String fecha;
    private int rut;
    private int neto;
    private int iva;
    private int total;
    private Venta ventaSgte;

    public Venta() {
    }

    public Venta(int numeroFactura, String fecha, int rut, int neto) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.rut = rut;
        this.neto = neto;
        this.iva = this.neto*19/100;
        this.total = this.neto+this.iva;
        this.ventaSgte = null;
    }
    
    public Venta AgregaVenta(Venta nueva)
    { 
        if (nueva == null) {
            nueva = this;
        }else
        {
        Venta aux = nueva;
            while (aux.ventaSgte != null) {                
                aux = aux.ventaSgte;
            }
            aux.ventaSgte=this;
        }
        return nueva;
    }
    
    public Venta EliminaVenta(int numero)
    {
        Venta vta = this;
        Venta aux = vta;
        Venta aux2 = null, aux3; 
        while (vta != null) {            
            if(vta.numeroFactura == numero)
            {  
                System.out.println("Eliminado OK...");
            }
            else
            {
            aux3 = new Venta(getNumeroFactura(), getFecha(), getRut(), getNeto());
            aux2 = aux3.AgregaVenta(aux2);
            }        
            aux = aux.ventaSgte;
        }
    return aux2;
    }
    
    public void MostrarVenta() {
        Venta v = this;
        System.out.println("*************************************************");
        System.out.println("Los Datos de la Lista Son:       ");
        System.out.println("*************************************************");
        while (v != null) {
            System.out.println("Numero Factura: " + v.getNumeroFactura());
            System.out.println("Fecha: " + v.getFecha());
            System.out.println("Rut: " + v.getRut());
            System.out.println("Neto: " + v.getNeto());
            System.out.println("Iva: " + v.getIva());
            System.out.println("Total: " + v.getTotal());
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

            v = v.ventaSgte;
        }
    }
    
    public Pila CreaPila(Venta venta)
    {
        Pila p = null, pilita;
        Venta venta2 = venta;
        while (venta2 != null) {            
            pilita = new Pila(venta2.numeroFactura);
            p = pilita.Push(p);
            
            venta2 = venta2.ventaSgte;
        }
        return p;    
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
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the rut
     */
    public int getRut() {
        return rut;
    }

    /**
     * @param rut the rut to set
     */
    public void setRut(int rut) {
        this.rut = rut;
    }

    /**
     * @return the neto
     */
    public int getNeto() {
        return neto;
    }

    /**
     * @param neto the neto to set
     */
    public void setNeto(int neto) {
        this.neto = neto;
    }

    /**
     * @return the iva
     */
    public int getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(int iva) {
        this.iva = iva;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the ventaSgte
     */
    public Venta getVentaSgte() {
        return ventaSgte;
    }

    /**
     * @param ventaSgte the ventaSgte to set
     */
    public void setVentaSgte(Venta ventaSgte) {
        this.ventaSgte = ventaSgte;
    }
    
    
            
}
