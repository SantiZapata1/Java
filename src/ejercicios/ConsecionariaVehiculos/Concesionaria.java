package ejercicios.ConsecionariaVehiculos;

import java.util.ArrayList;

public class Concesionaria implements Serializable{

    ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }
    public void eliminarVehiuculo(String marca, String modelo){

        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getmarca()==marca && vehiculos.get(i).getmodelo()==modelo) {
                vehiculos.remove(i);
                System.out.println("vehiculo eliminado");
                break;
            }
        }

    }
    public void editarPrecio(String marca, String modelo, Double nuevoPrecio){

        for (Vehiculo vehiculo: vehiculos) {
            if (vehiculo.getmarca()==marca && vehiculo.getmodelo()==modelo){

                vehiculo.setprecio(nuevoPrecio);

            }

        }


    }
    public void mostrarInventario(){
        for (Vehiculo vehiculo: vehiculos) {
            vehiculo.mostrarInformacion();
        }

    }



}
