package NoLinealsEstructures.Grafos.GrafoBlas;

public class Grafo {

    //matriz cuadrada de, tamano de la cantidad de vertices
    int[][] matrizPesos;

    //Lista de vertices
    String[] vertices;

    public Grafo(String[] vertices) {
        this.vertices = vertices;
        matrizPesos = new int[vertices.length][vertices.length];
    }

    //si existe la posicion que se desea conectar, se asigna el peso a esa posicion en la matriz de adyacencia
    public void conectar(String v1, String v2, int peso) {

        int index1 = busquedaIndex(v1);
        int index2 = busquedaIndex(v2);

        if (index1 != -1 && index2 != -1) {
            matrizPesos[index1][index2] = peso;
            matrizPesos[index2][index1] = peso;
            System.out.println("\ngrafos conectados exitosamente!");
        }else {
            System.out.println("\nno existe esa ubicacion");
        }
    }

    //metodo para determinar si existe la ubicacion de los indices a conectar
    private int busquedaIndex(String v) {
        int resultado = -1;

        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(v)) {
                resultado = i;
                break;
            }
        }

        return resultado;
    }

    //metodo para imprimir matriz de adyacencia
    public void imprimirMatriz() {
        System.out.print("\n   ");

        //marco de vertices superior
        for (int j = 0; j < vertices.length; j++) {
            System.out.print(vertices[j] + " ");
        }
        System.out.println();

        //matriz
        for (int i = 0; i < matrizPesos.length; i++) {
            System.out.print(vertices[i]+"  ");//marco de vertices lateral
            for (int j = 0; j < matrizPesos.length; j++) {
                System.out.print(matrizPesos[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void imprimirVertices(){
        System.out.print("\nvertices:");

        for (int i = 0; i < vertices.length; i++) {
            System.out.print(" "+vertices[i]);
        }
    }

    public static void main(String[] args) {

        String[] vertices = {"A","B","C","D","E"};

        Grafo grafo1 = new Grafo(vertices);

        grafo1.imprimirVertices();

        grafo1.imprimirMatriz();

        grafo1.conectar("A","B",5);
        grafo1.conectar("B","D",3);
        grafo1.conectar("C","E",2);
        grafo1.conectar("A","D",7);

        grafo1.imprimirMatriz();

    }

}

