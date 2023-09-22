package Serializable.variosObjetos;


        import java.io.*;
        import java.util.ArrayList;
        import java.util.List;

public class Lectura {
    public static void main(String[] args) {

        List<Persona> personas = new ArrayList<>();

        try (ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream("miObjetoSerializado.txt"))) {
            while (true) {
                Persona personaEntrada = (Persona) flujoEntrada.readObject();
                personas.add(personaEntrada);
            }
        } catch (EOFException e) {
            // Fin del archivo, no se lanzará excepción
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Persona persona : personas) {
            System.out.println(persona.toString());
        }
    }
}

class Escritura {

    public static void main(String[] args) {
        Persona personita = new Persona("Juan", 123);
        Persona personita2 = new Persona("Santi", 321);

        try (ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream("miObjetoSerializado.txt"))) {
            flujoSalida.writeObject(personita);
            flujoSalida.writeObject(personita2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Persona implements Serializable {
    private String nombre;
    private int dni;

    public Persona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String toString() {
        return this.nombre + " (" + this.dni + ")";
    }
}
