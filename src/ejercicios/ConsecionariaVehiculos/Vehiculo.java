package ejercicios.ConsecionariaVehiculos;

public abstract class Vehiculo {

    //atributos
     String marca;
     String modelo;
     Double precio;


    public String getmarca(){
        return marca;
    }
    public String getmodelo(){
        return modelo;
    }
    public Double getprecio(){
        return precio;
    }
    public void setmarca(String marca){
        this.marca=marca;
    }
    public void setmodelo(String modelo){
        this.modelo=modelo;
    }
    public void setprecio(Double precio){
        this.precio=precio;
    }


    //metodos
    public abstract void calcularImpuesto();
    public abstract String mostrarInformacion();





}
