package estructurasLineales.Nodos;

public class NodoDoble {

    public String value;
    public NodoDoble next;
    public NodoDoble previous;

    public NodoDoble(String valor) {
        this.value = valor;
        this.next = null;
        this.previous = null;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public NodoDoble getNext() {
        return this.next;
    }
    public void setNext(NodoDoble next) {
        this.next = next;
    }
    public NodoDoble getPrevious() {
        return this.previous;
    }
    public void setPrevious( NodoDoble previous) {
        this.previous = previous;
    }

    // toString() retorna el valor del nodo.
    @Override
    public String toString() {
        return this.value;
    }
}
