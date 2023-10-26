package estructurasLineales.Listas;

import estructurasLineales.Nodos.Nodo;

/**
 * Clase Lista simplemente enlazada.
 */

public class ListaSimple {

    //stributos
    private Nodo firstNode;
    public int size;

    //constructor para una lista simple
    public ListaSimple() {
        this.firstNode = null;
        this.size = 0;
    }

    //metodo para poner a null el primer nodo
    public boolean isEmpty() {
        return this.firstNode == null;
    }

    //metodo para add nodo a la lista
    public void add(String valor) {

        Nodo newNode = new Nodo(valor);

        if (isEmpty()) {
            // agregamos el primer nodo
            this.firstNode = newNode;
        } else {
            // se tiene que recorrer la lista hasta llegar al ultimo nodo
            Nodo nodoAux = this.firstNode;

            while (nodoAux.next != null) {
                nodoAux = nodoAux.next;
            }
            nodoAux.next = newNode;
        }
        this.size++;
    }

    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("List empty");
        } else {

            // se tiene que recorrer la lista hasta llegar al ultimo nodo
            Nodo nodoAux = firstNode;
            Nodo nodoPrevious = nodoAux;

            while (nodoAux.next != null) {
                nodoPrevious = nodoAux;
                nodoAux = nodoAux.next;
            }

            // Verifico si realmente avanzó en la lista hasta llegar al
            // último nodo que sea distinto del firstNode.
            // Si estoy en el firstNode, entonces lo hago null para indicar que la lista esta vacia.
            if (nodoAux == this.firstNode) {
                this.firstNode = null;
            } else {
                // Le indico al nodo Previous que no apunte más al nodo a eliminar "nodoAux".
                nodoPrevious.next = null;
            }

            // Decremento el size
            this.size--;
            System.out.println("last node deleted");
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("List empty");
        } else {
            System.out.println("nodes of list:");
            Nodo nodoAux = this.firstNode;
            for(int i = 0; i<this.size; i++) {
                System.out.println((i+1)+"- "+nodoAux.value);
                nodoAux = nodoAux.next;
            }
        }
    }

    public static void main(String[] args) {

        ListaSimple list = new ListaSimple();

        System.out.println("first node: "+list.firstNode);
        list.add("10");
        System.out.println("first node: "+list.firstNode);

        list.add("20");
        list.add("30");
        list.add("40");

        list.print();
        list.deleteLast();
        list.print();


        }


}
