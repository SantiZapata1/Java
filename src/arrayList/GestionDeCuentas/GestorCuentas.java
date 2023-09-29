package arrayList.GestionDeCuentas;

import java.util.ArrayList;

public class GestorCuentas {

    ArrayList<CuentaPersona> cuentaPersonaArrayList = new ArrayList<>();
    ArrayList<CuentaSociedad> cuentaSociedadArrayList = new ArrayList<>();



    //metodos
    public void agregarCuentaPersona(CuentaPersona cuenta){
        cuentaPersonaArrayList.add(cuenta);
        System.out.println("cuenta agregada");
    }
    public void agregarCuentaSociedad(CuentaSociedad cuenta){
        cuentaSociedadArrayList.add(cuenta);
        System.out.println("cuenta agregada");

    }

    public void eliminarCuentaPersona(int numCuenta){
        for (int i = 0; i < cuentaPersonaArrayList.size(); i++) {
            if (cuentaPersonaArrayList.get(i).getNumCuenta()==numCuenta) {
                cuentaPersonaArrayList.remove(i);
                System.out.println("cuenta eliminada");

                break;
            }
        }
    }

    public void eliminarCuentaSociedad(int numCuenta){
        for (int i = 0; i < cuentaSociedadArrayList.size(); i++) {
            if (cuentaSociedadArrayList.get(i).getNumCuenta()==numCuenta) {
                cuentaSociedadArrayList.remove(i);
                System.out.println("cuenta eliminada");

                break;
            }
        }
    }

    public void editarCuentaPersona(int numCuenta, double nuevoSaldo, String nuevoNombre, String nuevoApellido){
        for (CuentaPersona cuenta: cuentaPersonaArrayList) {
            if (cuenta.numeroCuenta==numCuenta){

                cuenta.setSaldo(nuevoSaldo);
                cuenta.setApellido(nuevoApellido);
                cuenta.setNombre(nuevoNombre);
            }

        }

    }
    public void editarCuentaSociedad(int numCuenta, double nuevoSaldo, String nuevoNombreEmpresa, String nuevoTipoEmpresa){
        for (CuentaSociedad cuenta: cuentaSociedadArrayList) {
            if (cuenta.numeroCuenta==numCuenta){

                cuenta.setSaldo(nuevoSaldo);
                cuenta.setNombreEmpresa(nuevoNombreEmpresa);
                cuenta.setTipoEmpresa(nuevoTipoEmpresa);
            }

        }

    }

    public void mostrarTodasLasCuentas(){

        for (CuentaSociedad cuenta: cuentaSociedadArrayList) {
            cuenta.mostrarInformacion();
        }
        for (CuentaPersona cuenta: cuentaPersonaArrayList) {
            cuenta.mostrarInformacion();
        }

    }





}
