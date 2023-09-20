package modAcceso.ejercicio1;

 public class ejemplo1 {

    public static void main (String[] args){

        modificadoresEjemplo objeto1 = new modificadoresEjemplo();

        System.out.println(objeto1.varDefaul);
        System.out.println(objeto1.varPublic);
        System.out.println(objeto1.varProtected);

        //no se puede porque esta en otra clase
        //System.out.println(objeto1.varPrivate);


    }

}


