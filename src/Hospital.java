import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.sql.*;

public class Hospital {


    //metodo para agregar paciente a la lista
    public void agregarPaciente(Paciente paciente) {

    }

    //metodo para eliminar paciente a la lista
    public void eliminarPaciente(Paciente paciente) {

    }

    //metodo para mostrar la lista de pacientes
    public void mostrarListaPacientes() {

    }

    //metodo para asignar un doctor a cada paciente
    public void asignarDoctorCabecera(Paciente paciente, Doctor doctor){

    }

    //metodo  para mostrar pacientes entre fechas
    public void mostrarPacientesEntreFechas(String fechaInicio, String fechaFin) {

    }


    //---------------- MAIN ---------------------
    public static void main(String[] args) {

        // Parámetros de conexión a la base de datos
        String url = "jdbc:mysql://localhost:33061/hospital"; // Corregido
        String usuario = "root"; // Cambia esto por tu nombre de usuario
        String contraseña = ""; // Cambia esto por tu contraseña

        Scanner scanner = new Scanner(System.in);

        try {
            // Cargar el controlador JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión exitosa");

            int cont=0;

            while(true){

                cont+=1;

                System.out.println("\n --------------- accion numero "+cont+" ---------------");

                System.out.println("1. Listar pacientes ");
                System.out.println("2. Registrar un nuevo paciente ");
                System.out.println("2. Eliminar un paciente ");
                System.out.println("3. Actualizar informacion personal de un paciente ");
                System.out.println("4. Consultar el historial medico de un paciente ");
                System.out.println("5. Nuevo historial para un paciente ");
                System.out.println("6. Guardar historial de pacientes en archivo ");
                System.out.println("7. Cargar historial de pacientes en archivo ");
                System.out.println("8. Salir ");


                System.out.print("\nIngrese su opción: ");

                int opcion = scanner.nextInt();

                switch (opcion) {

                    case 1:


                        break;
                    case 2:


                        break;
                    case 3:


                        break;
                    case 4:

                        break;
                    case 5:


                        break;
                    case 6:


                        break;
                    case 7:

                        break;
                    case 8:
                        System.out.println("programa finalizado  ");
                        // Cerrar la conexión cuando hayas terminado
                        conexion.close();
                        return;
                    default:
                        System.out.println("ingrese un caracer valido");

                }
            }



        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se pudo cargar el controlador JDBC");
            e.printStackTrace();
            e.getMessage();
            e.getCause();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos");
            e.printStackTrace();
            e.getMessage();
            e.getCause();
        }






    }
    //---------------- FIN MAIN -----------------

}

//clase abstracta persona
abstract class Persona {

    //atributos
    protected String nombre;
    protected int edad;
    protected int id;

    // Constructor y métodos necesarios
    Persona(String nombre, int edad){

        this.nombre=nombre;
        this.edad=edad;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}

//subclase paciente
class Paciente extends Persona {

    private String historialMedico;

    // Constructor y métodos necesarios
    Paciente(String nombre, int edad, String historialMedico){

        super(nombre,edad);
        this.historialMedico=historialMedico;

    }

    public String getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }
}

//subclase doctor
class Doctor extends Persona {
    private String especialidad;

    // Constructor y métodos necesarios
    public Doctor(String nombre, int edad, String especialidad) {
        super(nombre, edad);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}



