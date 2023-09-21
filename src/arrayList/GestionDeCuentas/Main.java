package arrayList.GestionDeCuentas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GestorCuentas gestorCuentas1 = new GestorCuentas();

        System.out.println("\nBienvenido al 'Gestor de cuentas', que accion desea hacer? ");

        while(true){

            System.out.println("\n 1- agregar cuenta persona \n 2- agregar cuenta sociedad \n\n 3- eliminar cuenta persona \n 4- eliminar cuenta sociedad \n\n 5- editar cuenta persona \n 6- editar cuenta sociedad \n\n 7- MOSTRAR TODAS LAS CUENTAS \n 8- salir");

            System.out.print("eleccion:");
            int eleccion = scanner.nextInt();
            scanner.nextLine();

            switch (eleccion) {
                case 1:
                    System.out.print("Ingrese numero de cuenta (persona): ");
                    int numCuentaPersona = scanner.nextInt();
                    System.out.print("Ingrese saldo: ");
                    double saldoPersona = scanner.nextDouble();
                    System.out.print("Ingrese nombre: ");
                    String nombrePersona = scanner.next();
                    System.out.print("Ingrese apellido: ");
                    String apellidoPersona = scanner.next();

                    CuentaPersona cuenta1 = new CuentaPersona(numCuentaPersona,saldoPersona,nombrePersona,apellidoPersona);
                    gestorCuentas1.agregarCuentaPersona(cuenta1);

                    gestorCuentas1.mostrarTodasLasCuentas();

                    break;
                case 2:
                    System.out.print("Ingrese numero de cuenta (sociedad): ");
                    int numCuentaSociedad = scanner.nextInt();
                    System.out.print("Ingrese saldo: ");
                    double saldoSociedad = scanner.nextDouble();
                    System.out.print("Ingrese nombre de la empresa: ");
                    String nombreEmpresa = scanner.next();
                    System.out.print("Ingrese tipo de empresa: ");
                    String tipoEmpresa = scanner.next();

                    CuentaSociedad cuenta2 = new CuentaSociedad(numCuentaSociedad,saldoSociedad,nombreEmpresa,tipoEmpresa);
                    gestorCuentas1.agregarCuentaSociedad(cuenta2);

                    gestorCuentas1.mostrarTodasLasCuentas();

                    break;
                case 3:
                    System.out.print("Ingrese num de la cuenta a eliminar (persona): ");
                    int numCuentaEliminarPersona = scanner.nextInt();
                    gestorCuentas1.eliminarCuentaPersona(numCuentaEliminarPersona);

                    gestorCuentas1.mostrarTodasLasCuentas();

                    break;
                case 4:
                    System.out.print("Ingrese num de la cuenta a eliminar (sociedad): ");
                    int numCuentaEliminarSociedad = scanner.nextInt();
                    gestorCuentas1.eliminarCuentaSociedad(numCuentaEliminarSociedad);

                    gestorCuentas1.mostrarTodasLasCuentas();

                    break;
                case 5:
                    gestorCuentas1.mostrarTodasLasCuentas();

                    System.out.print("Ingrese numero de cuenta a editar (persona): ");
                    int numCuentaBuscar = scanner.nextInt();
                    System.out.print("Ingrese saldo: ");
                    double nuevoSaldo = scanner.nextDouble();
                    System.out.print("Ingrese nombre: ");
                    String nuevoNombre = scanner.next();
                    System.out.print("Ingrese apellido: ");
                    String nuevoApellido = scanner.next();

                    gestorCuentas1.editarCuentaPersona(numCuentaBuscar,nuevoSaldo,nuevoNombre,nuevoApellido);
                    gestorCuentas1.mostrarTodasLasCuentas();

                    break;
                case 6:
                    System.out.print("Ingrese numero de cuenta a editar (sociendad): ");
                    int numCuentaBuscar2 = scanner.nextInt();
                    System.out.print("Ingrese nuevo saldo: ");
                    double nuevoSaldo2 = scanner.nextDouble();
                    System.out.print("Ingrese nuevo nombre de la empresa: ");
                    String nuevoNombreEmpresa = scanner.next();
                    System.out.print("Ingrese nuevo tipo de empresa: ");
                    String nuevoTipoEmpresa = scanner.next();

                    gestorCuentas1.editarCuentaSociedad(numCuentaBuscar2,nuevoSaldo2,nuevoNombreEmpresa,nuevoTipoEmpresa);
                    gestorCuentas1.mostrarTodasLasCuentas();

                    break;
                case 7:
                    gestorCuentas1.mostrarTodasLasCuentas();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }


        }






    }
}
