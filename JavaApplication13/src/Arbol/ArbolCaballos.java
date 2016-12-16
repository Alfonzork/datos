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
public class ArbolCaballos {
    
    NodoArbolCaballo raiz;

    public ArbolCaballos() {
        NodoArbolCaballo raiz;
        this.raiz = null;
    }
    
     public void agregarNodo(Caballo caballo) {
        NodoArbol nuevo = new NodoArbol(lista);
        if (lista.getSueldoBruto() <= 400000) {
            if (raiz == null) {
                raiz = nuevo;

            } else {
                NodoArbol auxiliar = raiz;
                NodoArbol padre;

                while (true) {
                    padre = auxiliar;
                    if (lista.getNombre().equalsIgnoreCase(auxiliar.lista.getNombre())) {
                        auxiliar = auxiliar.izquierdo;
                        if (auxiliar == null) {
                            padre.izquierdo = nuevo;
                            return;
                        }
                    } else {
                        auxiliar = auxiliar.derecho;
                        if (auxiliar == null) {
                            padre.derecho = nuevo;
                            return;
                        }
                    }
                }
            }
        }

    }

    // metodo para saber si el arbol esta vacio
    public boolean arbolNull() {
        return raiz == null;
    }

    // Metodo para recorrer en pre orden 
    public void preOrden(NodoArbol r) {
        if (r != null) {
            r.lista.MostrarLista();
            preOrden(r.izquierdo);
            preOrden(r.derecho);
        }
    }

    // Metodo para recorrer in orden 
    public void inOrden(NodoArbol r) {
        if (r != null) {
            inOrden(r.izquierdo);
            r.lista.MostrarLista();
            inOrden(r.derecho);
        }
    }

    // Metodo para recorrer en post orden 
    public void postOrden(NodoArbol r) {
        if (r != null) {
            postOrden(r.izquierdo);
            postOrden(r.derecho);
            r.lista.MostrarLista();
        }
    }

    // Metodo para buscar un nodo especifico
    public NodoArbol buscarNodo(Lista lista) {
        NodoArbol aux = raiz;

        while (aux.lista.getCodigoEmpleado() != lista.getCodigoEmpleado()) {
            if (lista.getCodigoEmpleado() < aux.lista.getCodigoEmpleado()) {
                aux = aux.izquierdo;
            } else {
                aux = aux.derecho;
            }
            if (aux == null) {
                return null;
            }
        }

        return aux;
    }

    // metodo para eliminar un nodo
    public boolean eliminarNodo(int codigo) {
        Lista lista=null;
        NodoArbol auxiliar = raiz;
        NodoArbol padre = raiz;
        boolean esHijoIzquierdo = true;

        while (auxiliar.lista.getCodigoEmpleado() != codigo) {
            padre = auxiliar;
            if (codigo < auxiliar.lista.getCodigoEmpleado()) {
                esHijoIzquierdo = true;
                auxiliar = auxiliar.izquierdo;
            } else {
                esHijoIzquierdo = false;
                auxiliar = auxiliar.derecho;
            }
            if (auxiliar == null) {
                return false;
            }
        }
        if (auxiliar.derecho == null && auxiliar.izquierdo == null) {
            if (auxiliar == raiz) {
                raiz = null;
            } else if (esHijoIzquierdo) {
                padre.izquierdo = null;
            } else {
                padre.derecho = null;
            }
        } else if (auxiliar.derecho == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.izquierdo;
            } else if (esHijoIzquierdo) {
                padre.izquierdo = auxiliar.izquierdo;
            } else {
                padre.derecho = auxiliar.izquierdo;
            }
        } else if (auxiliar.izquierdo == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.derecho;
            } else if (esHijoIzquierdo) {
                padre.izquierdo = auxiliar.derecho;
            } else {
                padre.derecho = auxiliar.izquierdo;
            }
        } else {
            NodoArbol reemplazo = obtenerNodoReemplazo(auxiliar);
            if (auxiliar == raiz) {
                raiz = reemplazo;
            } else if (esHijoIzquierdo) {
                padre.izquierdo = reemplazo;
            } else {
                padre.derecho = reemplazo;
            }
            reemplazo.izquierdo = auxiliar.izquierdo;
        }
        return true;

    }

    public NodoArbol obtenerNodoReemplazo(NodoArbol nodoReemp) {
        NodoArbol reemplazarPadre = nodoReemp;
        NodoArbol reemplazo = nodoReemp;
        NodoArbol auxiliar = nodoReemp.derecho;

        while (auxiliar != null) {
            reemplazarPadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.izquierdo;
        }
        if (reemplazo != nodoReemp.derecho) {
            reemplazarPadre.izquierdo = reemplazo.derecho;
            reemplazo.izquierdo = nodoReemp.derecho;
        }
        System.out.println("El nodo reemplazo es: " + reemplazo);
        return reemplazo;
    }

    public Cola CreaCola(NodoArbol l) {
        Cola c = null, caux;
        NodoArbol aux = l;
        while (aux != null) {
            int _sueldoLiquido = aux.lista.getSueldoBruto() - aux.lista.getAfp() - aux.lista.getSalud();
            if (_sueldoLiquido >= 200000 && _sueldoLiquido <= 300000) {
                caux = new Cola(aux.lista.getCodigoEmpleado(), aux.lista.getRut(), aux.lista.getNombre(),
                        aux.lista.getApellido(), aux.lista.getSueldoBruto());
                c = caux.colocaNodo(c);
            }
            aux = aux._sgte;
        }
        return c;
    }
}
