package NoLinealsEstructures.ArbolesBinBlas;

/*clase nodo binario que lo que hace es crear un nodo que tiene un valor y una referencia a sus nodos izq y derecho*/

public class NodoBinario {

        public String valor;

        public NodoBinario izq;
        public NodoBinario der;

        public NodoBinario(String valor) {
            this.valor = valor;
            this.izq = null;
            this.der = null;
        }
        public NodoBinario(String valor, NodoBinario nodoIzq, NodoBinario nodoDer) {
            this.valor = valor;
            this.izq = nodoIzq;
            this.der = nodoDer;
        }

        @Override
        public String toString() {
            return "valor: "+this.valor;
        }

    public static void main(String[] args) {

        NodoBinario nodo1= new NodoBinario("5");
        NodoBinario nodo2= new NodoBinario("6");
        NodoBinario nodo3= new NodoBinario("7");

        nodo1.der=nodo2;
        nodo1.izq=nodo3;

        System.out.println(nodo1.valor);
        System.out.println(nodo1.izq);
        System.out.println(nodo1.der);

        NodoBinario nodo4 = new NodoBinario("10",nodo1, nodo2);

        System.out.println(nodo4.valor);
        System.out.println(nodo4.izq);
        System.out.println(nodo4.der);

    }
}
