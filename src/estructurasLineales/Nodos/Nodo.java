package estructurasLineales.Nodos;

public class Nodo {
    public String value;
    public Nodo next;

    public Nodo(String valor) {
        this.value = valor;
        this.next = null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    // toString() retorna el valor del nodo.
    @Override
    public String toString() {
        return this.value;
    }
}