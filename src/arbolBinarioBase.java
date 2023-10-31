/*Estos métodos son formas comunes de explorar y visitar los nodos de un árbol binario,
y cada uno tiene aplicaciones específicas en algoritmos y procesamiento de datos.
Dependiendo del problema que estés resolviendo,
puedes elegir el método de recorrido que mejor se adapte a tus necesidades.*/


public class arbolBinarioBase {

    public static void main(String[] args) {

        //creamos los nodos
        Nodo raiz = new Nodo(1);
        raiz.izquierdo = new Nodo(2);
        raiz.derecho = new Nodo(3);

        raiz.recorridoPostorden(raiz);
    }
}

class Nodo {

    int valor;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(int valor) {
        this.valor = valor;
        izquierdo = null;
        derecho = null;
    }

    //Recorrido en Preorden

    //El recorrido en preorden se implementa visitando el nodo raíz, luego llamando
    // al método en el subárbol izquierdo y, finalmente, llamando al método en el subárbol derecho.

    public void recorridoPreorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " "); // Visita el nodo
            recorridoPreorden(nodo.izquierdo);   // Recorre el subárbol izquierdo
            recorridoPreorden(nodo.derecho);     // Recorre el subárbol derecho
        }
    }

    //Recorrido en Inorden

    //El recorrido en inorden se implementa llamando al método en el subárbol izquierdo,
    // luego visitando el nodo raíz y, finalmente, llamando al método en el subárbol derecho.

    public void recorridoInorden(Nodo nodo) {
        if (nodo != null) {
            recorridoInorden(nodo.izquierdo);    // Recorre el subárbol izquierdo
            System.out.print(nodo.valor + " ");  // Visita el nodo
            recorridoInorden(nodo.derecho);      // Recorre el subárbol derecho
        }
    }

    //Recorrido en Postorden

    //El recorrido en postorden se implementa llamando al método en el subárbol izquierdo,
    //luego llamando al método en el subárbol derecho y, finalmente, visitando el nodo raíz.

    public void recorridoPostorden(Nodo nodo) {
        if (nodo != null) {
            recorridoPostorden(nodo.izquierdo);   // Recorre el subárbol izquierdo
            recorridoPostorden(nodo.derecho);     // Recorre el subárbol derecho
            System.out.print(nodo.valor + " ");   // Visita el nodo
        }
    }






}
