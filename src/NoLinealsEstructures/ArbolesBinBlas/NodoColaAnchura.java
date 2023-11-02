package NoLinealsEstructures.ArbolesBinBlas;

/*clase nodo cola para recorrer por anchura un arbol binario, este es un objeto que posee valor de tipo
* nodo binario normal (con iz y der) y como atributo un nodo del mismo tipo que seria su siguiente
* ya que esto es una cola, los nodos van unos al lado del otro*/

public class NodoColaAnchura {
    //// Nodo para TAD Cola para Recorrido en Anchura de Árbol Binario.

        //// define un atributo para apuntar recursivamente a otro nodo de la cola.
        public NodoColaAnchura siguiente;

        //// define un atributo para almacenar un valor del tipo Nodo Arbol Binario.
        public NodoBinario valor;

        public NodoColaAnchura(NodoBinario valor) {
            this.valor = valor;
            this.siguiente = null;
        }

    public static void main(String[] args) {

        NodoBinario nodo1 = new NodoBinario("10");
        NodoBinario nodo2 = new NodoBinario("20");

        NodoColaAnchura nodoCola1 = new NodoColaAnchura(nodo1);
        NodoColaAnchura nodoCola2 = new NodoColaAnchura(nodo2);

            nodoCola1.siguiente=nodoCola2;

            System.out.println(nodoCola1.valor);
            System.out.println(nodoCola1.siguiente.valor);

    }

    }