package ejercicios.ConsecionariaVehiculos;

public class Moto extends Vehiculo{


    Moto(String marca, String modelo, Double precio){
        this.marca=marca;
        this.modelo=modelo;
        this.precio=precio;
    }


    //metodos
    @Override
    public void calcularImpuesto(){



    }

    @Override
    public String mostrarInformacion(){
        return "marca: "+this.marca+ "modelo: "+ this.modelo + "precio: $"+this.precio;

    }

}
