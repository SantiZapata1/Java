package Herencia.plantas;

//Esta clase horatiza extiende de la superclase planta
public class Hortaliza extends Planta{

    public String tipo;

    //constructores
    public Hortaliza(String nombre, int edad , String tipo){
        super(nombre, edad);// con super() usamos los constructores que tenemos en nuestra superclase
        this.tipo=tipo;
    }
    public Hortaliza(String nombre, int edad){
        super(nombre, edad);
    }
    public Hortaliza(String nombre, String tipo){
        super(nombre);
        this.tipo=tipo;
    }
    public Hortaliza(int edad , String tipo){
        super(edad);
        this.tipo=tipo;
    }

    //metodos set y get
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public String getTipo(){
        return tipo;
    }

    
    // Sobrescribir el método toString() para presentarse
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad +", tipo: "+tipo;
    }

    
}
