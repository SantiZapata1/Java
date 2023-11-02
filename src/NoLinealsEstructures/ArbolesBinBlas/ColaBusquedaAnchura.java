package NoLinealsEstructures.ArbolesBinBlas;

public class ColaBusquedaAnchura {
    //// TAD Cola para Recorrido en Anchura para Árbol Binario
        private NodoColaAnchura primero;
        private NodoColaAnchura ultimo;
        private int tamaño;

        public ColaBusquedaAnchura() {
            this.primero = null;
            this.ultimo = null;
            this.tamaño = 0;
        }

        public boolean vacia() {
            return this.primero == null;
        }

        //// enqueue
        public void encolar(NodoBinario valor) {

            NodoColaAnchura nuevo = new NodoColaAnchura(valor);

            if (vacia()) {
                this.primero = nuevo;
                this.ultimo = nuevo;
            }
            else {
                this.ultimo.siguiente = nuevo;
                this.ultimo = nuevo;
            }

            this.tamaño++;
        }

        //// dequeue
        public NodoBinario desencolar() {

            if (vacia()) {
                return null;
            }
            else {
                //NodoCola aux = new NodoCola(this.primero.valor);

                NodoBinario aux = this.primero.valor;

                this.primero = this.primero.siguiente;
                this.tamaño--;

                return aux;
            }
        }
    }