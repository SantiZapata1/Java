package estructurasLineales;//hacer: ver si incluye un cierto valor, eliminar valor y eliminar posicion.


class Nodo {

    public String valor;
    public Nodo siguiente;

    public Nodo(String valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    // toString() retorna el valor del nodo.
    @Override
    public String toString() {
        return this.valor;
    }

}
class listaEnlazada {

    Nodo primerNodo; // Primer nodo de la lista

    // Constructor
    public listaEnlazada() {
        this.primerNodo = null; // Al principio, la lista está vacía
    }
    public listaEnlazada(String valor) {
        this.primerNodo.valor = valor; // inicializar lista con un nodo
    }

    // Método para agregar un nodo al final de la lista
    public void agregarAlFinal(String dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (primerNodo == null) {
            primerNodo = nuevoNodo; // Si la lista está vacía, el nuevo nodo es la cabeza
        } else {
            // Crear un puntero para recorrer la lista, empezando desde la cabeza
            Nodo puntero = primerNodo;

            // Mover el puntero hasta el último nodo de la lista
            while (puntero.siguiente != null) {
                puntero = puntero.siguiente;
            }

            // Enlazar el nuevo nodo al último nodo de la lista
            puntero.siguiente = nuevoNodo;
        }
    }
    // Método para imprimir todos los elementos de la lista
    public void imprimirLista() {
        Nodo puntero = primerNodo;

        while (puntero != null) {
            System.out.println(puntero.valor);
            puntero = puntero.siguiente;
        }
    }

}


public class estructurasLineales{
    public static void main(String[] args) {

        listaEnlazada lista1 = new listaEnlazada();

        lista1.agregarAlFinal("santi");
        lista1.agregarAlFinal("gonzi");

        lista1.imprimirLista();


    }
}