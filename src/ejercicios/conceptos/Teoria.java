package ejercicios.conceptos;
//prezi https://prezi.com/view/CenXFfnCkSVaSI6lQdo3/
public class Teoria {
    public static void main(String[] args) {

        Perro perro1 = new Perro("roco",10,"pepi");

        System.out.println(perro1);
        System.out.println(perro1.getduenio());

        Gato gato1 = new Gato("gatuna",5);
        System.out.println(gato1.moverse());


    }


}


abstract class Animal{
    String nombre;
    int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public abstract String makeNoise();
    public String saludar(){
        return "hola desde clase abstracta";
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}

interface Acciones{
    String moverse();
}

class Perro extends Animal{
    private String duenio;

    public String getduenio(){
        return duenio;
    }

    public Perro(String nombre, int edad, String duenio) {
        super(nombre, edad);
        this.duenio = duenio;
    }

    @Override
    public String makeNoise() {
        return "soy un perro guau";
    }

    @Override
    public String toString() {
        return "Perro{" +
                "duenio='" + duenio + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}

class Gato extends Animal implements Acciones{

    public Gato(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public String makeNoise() {
        return "soy un gato miauu";
    }

    @Override
    public String moverse() {
        return "soy un gato me muevo saltando";
    }
}