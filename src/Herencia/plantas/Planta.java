package Herencia.plantas;

//clase Herencia.plantas
public class Planta {

    //atributos
    String nombre;
    int edad;

    //constructores (4)
    public Planta(String nombre, int edad){
        this.nombre=nombre;
        this.edad=edad;
    }
    public Planta(String nombre){
        this.nombre=nombre;
        this.edad=0;
    }
    public Planta(int edad){
        this.nombre="sin especificar";
        this.edad=edad;
    }
    public Planta(){
        this.nombre="sin especificar";
        this.edad=0;
    }



    //metodos set y get
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public void setEdad(int edad){
        this.edad=edad;
    }
    public int getEdad(){
        return edad;
    }

    // Sobrescribir el método toString() para dar datos del objeto
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad;
    }
    
    
}

