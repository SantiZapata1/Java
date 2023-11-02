package NoLinealsEstructures.ArbolesBinBlas;

/*clase arbol binario con sus respectivos metodos recursivos para recorrerlo*/

public class ArbolBinario {

    private NodoBinario raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public boolean vacio() {
        return this.raiz == null;
    }

    public void construir(NodoBinario raiz) {
        this.raiz = raiz;
    }

    public void agregar(String valor) {
        this.raiz = agregarRecursivo(this.raiz, valor);
    }

    public void eliminar(String valor) {
        this.raiz = eliminarRecursivo(this.raiz, valor);
    }

    public void imprimirPreOrder() {
        preOrder(this.raiz);
    }

    public void imprimirInOrder() {
        inOrder(this.raiz);
    }

    public void imprimirPostOrder() {
        posOrder(this.raiz);
    }

    public void imprimirEnAnchura() {
        anchura(this.raiz);
    }

    //// Método interno para realizar recorrido preOrden recursivo
    private void preOrder(NodoBinario nodo) {

        if (nodo != null) {
            System.out.print(nodo.valor + " "); // Visita el nodo
            preOrder(nodo.izq);   // Recorre el subárbol izquierdo
            preOrder(nodo.der);     // Recorre el subárbol derecho
        }
    }

    //// Método interno para realizar recorrido inOrden recursivo
    private void inOrder(NodoBinario nodo) {

        if (nodo == null) return;

        if (nodo != null) {
            inOrder(nodo.izq);    // Recorre el subárbol izquierdo
            System.out.print(nodo.valor + " ");  // Visita el nodo
            inOrder(nodo.der);      // Recorre el subárbol derecho
        }
    }

    //// Método interno para realizar recorrido posOrden recuersivo
    private void posOrder(NodoBinario nodo) {

        if (nodo != null) {
            posOrder(nodo.izq);   // Recorre el subárbol izquierdo
            posOrder(nodo.der);     // Recorre el subárbol derecho
            System.out.print(nodo.valor + " ");   // Visita el nodo
        }

    }

    //// Método interno para realizar recorrido en anchura
    private void anchura(NodoBinario nodo) {

        ColaBusquedaAnchura cola = new ColaBusquedaAnchura();
        cola.encolar(nodo);

        while (!cola.vacia())
        {
            NodoBinario aux = cola.desencolar();
            System.out.print(aux.valor + " ");

            /*Enqueue left child */
            if (aux.izq != null) {
                cola.encolar(aux.izq);
            }

            /*Enqueue right child */
            if (aux.der != null) {
                cola.encolar(aux.der);
            }
        }
    }

    //// Método interno para agregar valores de forma recursiva
    private NodoBinario agregarRecursivo(NodoBinario nodo, String valor) {

        // Si el nodo es una hoja, entonces lo crear y retorna
        if (nodo == null) {
            nodo = new NodoBinario(valor);
            return nodo;
        }

        // En caso contrario, recorrer el arbol de forma recursiva
        if (valor.compareTo(nodo.valor) <= 0) {
            nodo.izq = agregarRecursivo(nodo.izq, valor);
        }
        else if (valor.compareTo(nodo.valor) > 0) {
            nodo.der = agregarRecursivo(nodo.der, valor);
        }

        // Retorna el nuevo nodo del arbol para ser unido a la raiz
        return nodo;
    }

    //// Método interno para eliminar nodos tomando los 3 casos teóricos.
    private NodoBinario eliminarRecursivo(NodoBinario nodo, String valor){
        NodoBinario aux = nodo;

        if (aux == null) {
            return aux;
        }

        if(valor.compareTo(aux.valor) < 0) {
            aux.izq = eliminarRecursivo(aux.izq, valor);
        }
        else if(valor.compareTo(aux.valor) > 0){
            aux.der = eliminarRecursivo(aux.der, valor);
        }
        else {
            if(aux.izq == null && aux.der == null){
                aux = null;
            }
            else if(aux.der == null){
                aux = aux.izq;
            }
            else if(aux.izq == null){
                aux = aux.der;
            }
            else {
                NodoBinario auxNodoHojaIzq  = encontrarNodoMasIzquierda(aux.der);
                aux.valor = auxNodoHojaIzq.valor;
                aux.der = eliminarRecursivo(aux.der, auxNodoHojaIzq.valor);
            }
        }

        return aux;
    }

    //// Método auxiliar para el proceso de eliminacion de nodos con sub-arboles a la izquierda y derecha.
    private NodoBinario encontrarNodoMasIzquierda(NodoBinario nodo) {
        NodoBinario aux = nodo;

        while(aux.izq != null){
            aux = aux.izq;
        }

        return aux;
    }

    //// Opcional, método para inserción sin usar recursividad
    private void agregarIterativo(String valor){
        NodoBinario nuevo = new NodoBinario(valor);

        if (vacio()) {
            this.raiz = nuevo;
        }
        else {
            NodoBinario auxAnterior = null;
            NodoBinario auxActual = this.raiz;

            while (auxActual != null) {

                auxAnterior = auxActual;

                if (valor.compareTo(auxActual.valor) <= 0) {
                    auxActual = auxAnterior.izq;
                }
                else if (valor.compareTo(auxActual.valor) > 0) {
                    auxActual = auxActual.der;
                }
            }

            if (valor.compareTo(auxAnterior.valor) <= 0) {
                auxAnterior.izq = nuevo;
            }

            else if (valor.compareTo(auxAnterior.valor) > 0) {
                auxAnterior.der = nuevo;
            }
        }
    }
}

























