package Herencia.plantas;

public class Main {

    public static void main(String[] args){

        //creamos objetos
        Planta planta1 = new Planta("suculenta",2);
        Planta planta2 = new Planta("cactus",3);
        Planta planta3 = new Planta();
        Hortaliza hortaliza1 = new Hortaliza("tomate", 5, "tierra");

        //pruebas de get y set
        /* 
        String nombre = hortaliza1.getTipo();
        System.out.println(nombre);
        hortaliza1.setTipo("sandia");
        nombre = hortaliza1.getTipo();
        System.out.println(nombre);
        */

        // Llamada implícita a toString()
        
        System.out.println(planta1);
        System.out.println(planta2);
        System.out.println(planta3);
        System.out.println(hortaliza1);//subclase hortaliza
        
        
    }
    
}
