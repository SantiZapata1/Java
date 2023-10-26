package estructurasLineales.Listas;

import estructurasLineales.Nodos.NodoDoble;

/**
 * Lista doblemente enlazada
 */
public class listaDoble {

    private NodoDoble firstNode;
    private NodoDoble lastNode;
    private int tamaño;

    public listaDoble() {
        this.firstNode = null;
        this.lastNode = null;
        this.tamaño = 0;
    }

    public boolean vacia() {
        return this.firstNode == null;
    }

    public void agregar(String valor) {

        NodoDoble nuevo = new NodoDoble(valor);

        if (vacia()) {
            this.firstNode = nuevo;
            this.lastNode = nuevo;
        } else {

            // se tiene que recorrer la lista hasta llegar al ultimo nodo
            NodoDoble aux = firstNode;

            while (aux.next != null) {
                aux = aux.next;
            }

            // asigna primero y ultimo
            aux.next = nuevo;
            nuevo.previous = aux;
            this.lastNode = nuevo;
        }

        this.tamaño++;
    }

    public void agregarInicio(String valor){
        NodoDoble nuevo = new NodoDoble(valor);

        if(vacia()){
            this.firstNode=nuevo;
        } else {
            nuevo.next = this.firstNode;
            this.firstNode.previous = nuevo;
            this.firstNode = nuevo;
        }
    }

    public void eliminarUltimo() {
        if (vacia()) {
            System.out.println("Lista vacia");
        } else {
            // se tiene que recorrer la lista hasta llegar al ultimo nodo
            NodoDoble aux = firstNode;
            NodoDoble nodoprevious = aux;

            while (aux.next != null) {
                nodoprevious = aux;
                aux = aux.next;
            }

            // Verifico si realmente avanzó en la lista hasta llegar al
            // último nodo que sea distinto del primero.
            // Si estoy en el primero, entonces hago primero y ultimo null para indicar que la lista esta vacia.
            if (aux == this.firstNode) {
                this.firstNode = null;
                this.lastNode = null;
            } else {
                this.lastNode = nodoprevious;
                nodoprevious.next = null;
                aux.previous = null;
            }

            this.tamaño--;
        }
    }

    public void imprimir() {
        if (vacia()) {
            System.out.println("Lista vacia");
        } else {

            NodoDoble aux = firstNode;

            for(int i=0;i<this.tamaño;i++){
                System.out.println(aux.value);
                aux = aux.next;
            }
        }
    }

    public void imprimirInverso() {
        if (vacia()) {
            System.out.println("Lista vacia");
        } else {

            NodoDoble aux = lastNode;

            for(int i=0;i<this.tamaño;i++){
                System.out.println(aux.value);
                aux = aux.previous;
            }
        }
    }
}