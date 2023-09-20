package arrayList.Veterinaria1;
import java.util.ArrayList;
import java.util.Scanner;

public class arrayObjetos2 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //objeto veterinaria
        Veterinaria veterinaria1 = new Veterinaria();

        //objetos dueño
        Duenio duenio1 = new Duenio("juan","23.543.23");
        Duenio duenio2 = new Duenio("pedro","54.234.65");
        Duenio duenio3 = new Duenio("santi","12.532.54");

        //objetos animales
        Animal animal1 = new Animal("animal1", 5, duenio1);
        Animal animal2 = new Animal("animal2", 7, duenio1);
        Animal perro1 = new Perro("perro1", 5, duenio2,"pitbull");
        Animal gato1 = new Gato("gato1", 5, duenio3,"catu");
        
        //Usamos metodos para cargar veterinaria
        veterinaria1.agregarAnimal(animal1);
        veterinaria1.agregarAnimal(animal2);
        veterinaria1.agregarAnimal(perro1);
        veterinaria1.agregarAnimal(gato1);

        veterinaria1.eliminarAnimal(0);

        veterinaria1.returnArray();

    }
    
}
//clase veterinaria
class Veterinaria{

    ArrayList<Animal> animales = new ArrayList<>();

    public Veterinaria(){
    }

    //metodos 
    public void agregarAnimal(Animal animal){
        animales.add(animal);
    }
    public void eliminarAnimal(int indice){
        animales.remove(indice);
    }
    public int cantidadAnimales(){
        return animales.size();
    }
    public void returnArray(){

         //con for-each recorremos todos los objetos del arrayList
         System.out.println("Contenido del ArrayList:");
         for (Animal animalActual : animales) {
             System.out.println("Nombre: " + animalActual.getNombre() + ", Edad: " + animalActual.getEdad()+", makeNoise: "+animalActual.makeNoise()+", duenio: "+ animalActual.getduenio());
         }

    }
    

}

class Animal{

    //atributos
    String nombre;
    int edad;
    Duenio duenio;

    //constructores
    public Animal(String nombre, int edad, Duenio duenio){
        this.nombre=nombre;
        this.edad=edad;
        this.duenio=duenio;
    }
    public Animal(){
        this.nombre="leon pred";
        this.edad=0;
    }

   //metodos set y get
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public void setEdad( int Edad){
        this.edad=Edad;
    }
    public int getEdad(){
        return edad;
    }
    public void setDuenio(Duenio Duenio){
        this.duenio=Duenio;
    }
    public String getduenio(){
        String nombre=duenio.getnombre();
        return nombre;
    }

    //metodo
    public String makeNoise(){
        return "hey";
    }

}

//clase perro que hereda de animal
class Perro extends Animal{

    String raza;

    //contructores
    public Perro(String nombre, int edad, Duenio duenio,String raza){
        super(nombre,edad,duenio);
        this.raza=raza;
    }
    public Perro(){
        this.raza="caniche pred";
    }

    //metodos set y get
    public void setRaza(String Raza){
        this.raza=Raza;
    }
    public String getRaza(){
        return raza;
    }

    @Override
    public String makeNoise(){
        return super.makeNoise()+" guau" ;
    }

} 
class Gato extends Animal{

    String raza;

    //constructores
    public Gato(String nombre, int edad, Duenio duenio,String raza){
        super(nombre,edad,duenio);
        this.raza=raza;
    }
    public Gato(){
        this.raza="cati pred";
    }

    //metodos set y get
    public void setRaza(String Raza){
        this.raza=Raza;
    }
    public String getRaza(){
        return raza;
    }

    @Override
    public String makeNoise(){
        return super.makeNoise()+" miau" ;
    }

} 

//clase duenio
class Duenio{

    String nombre;
    String dni;

    //constructores
    public Duenio(String nombre,String dni){
        this.nombre=nombre;
        this.dni=dni;
    }
    public Duenio(){
        this.nombre="juan pred";
        this.dni="45.093.232";
    }

    //metodos set y get
    public void setnombre(String nombre){
        this.nombre=nombre;
    }
    public String getnombre(){
        return nombre;
    }
    public void setDni(String dni){
        this.dni=dni;
    }
    public String getDni(){
        return dni;
    }

}