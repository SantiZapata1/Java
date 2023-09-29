package arrayList.Basico;//package practicas.arrayList.colecciones;
import java.util.ArrayList;

public class BasicoArrayList {

    /*   metodos de array list

     * .add(elemento)         = agrega un elemento a la lista
     * .size()                = devuelve el tamaño del arreglo
     * .get(indice)           = devuelve el elemento del indice indicado
     * .set(indice, elemento) = asigna un valor al elemento
     * .remove(indice)        = elimina el elemento del indice
     * .constains(elemento)   = comprueba si un elemento existe en la lista
     * .clear()               = vacia el arrayList
     * 
     */

    public static void main(String[] args) {

        // Declaración e inicialización de un ArrayList de enteros
        ArrayList<Integer> numeros = new ArrayList<>();

        // Agregar elementos al ArrayList
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        // Mostrar el contenido del ArrayList
        System.out.println("Contenido inicial del ArrayList: " + numeros);

        // Obtener el tamaño del ArrayList
        int tamaño = numeros.size();
        System.out.println("Tamaño del ArrayList: " + tamaño);

        // Acceder a elementos por índice
        int primerNumero = numeros.get(0);
        System.out.println("Primer número: " + primerNumero);

        // Cambiar el valor de un elemento
        numeros.set(1, 25);

        // Eliminar un elemento por índice
        numeros.remove(2);

        // Verificar si un elemento existe en el ArrayList
        boolean contiene30 = numeros.contains(10);
        System.out.println("Contiene 30: " + contiene30);

        // Iterar a través del ArrayList usando un bucle for-each
        System.out.println("Elementos del ArrayList:");
        for (int numero : numeros) {
            System.out.println(numero);
        }

        // Vaciar el ArrayList
        numeros.clear();
        System.out.println("ArrayList después de vaciarlo: " + numeros);
    }
}
