package Parcial2Lab;

import java.sql.*;
import java.util.Scanner;

public class Hospital {
    


    //metodo para agregar paciente a la lista
    public static void agregarPaciente(Paciente paciente, Connection conexion) {


        try{
            // Consulta SQL para insertar un nuevo estudiante en la base de datos.
            // Utiliza signos de interrogaci�n como marcadores de posici�n para los valores.
            String consulta = "INSERT INTO pacientes (nombre, edad, historial_medico, fecha_ingreso, doctor) VALUES (?, ?, ?, ?, ?)";

            // Crea un PreparedStatement para ejecutar la consulta SQL con valores reales.
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, paciente.getNombre()); // Asigna el valor de apellido al segundo marcador de posici�n
            preparedStatement.setString(2, paciente.getEdad()); // Asigna el valor de legajo al tercer marcador de posici�n
            preparedStatement.setString(3, paciente.getHistorialMedico()); // Asigna el valor de dni al cuarto marcador de posici�n
            preparedStatement.setString(4, "2000-10-10"); // Asigna el valor de dni al cuarto marcador de posici�n
            preparedStatement.setString(5, "0"); // Asigna el valor de dni al cuarto marcador de posici�n

            // Ejecuta la consulta y obtiene el n�mero de filas afectadas.
            int filasAfectadas = preparedStatement.executeUpdate();

            // Verifica si la inserci�n fue exitosa y muestra un mensaje apropiado.
            if (filasAfectadas > 0) {
                System.out.println("Estudiante agregado exitosamente.");
            } else {
                System.out.println("No se pudo agregar el estudiante.");
            }

            // Cierra el PreparedStatement para liberar recursos.
            preparedStatement.close();

        }catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos");
            e.printStackTrace();
            e.getMessage();
            e.getCause();
        }




    }

    //metodo para eliminar paciente a la lista
    public static void eliminarPaciente(Paciente paciente) {

        System.out.println("eliminar paciente");
    }

    //metodo para mostrar la lista de pacientes
    public static void mostrarListaPacientes(Connection conexion) {

        /*En este metodo pasamos como parametro nuestra conexion a la BD para poder acceder a ella
        * y ejecutamos la consulta que selecciona toda la tabla que le pedimos
        *
        * Luego a traves del while recorremos fila por fila cada campo de la tabla, capturando y mostrando
        * en cada ciclo los datos de los campos de la misma, hasta el final de la tabla*/


        System.out.println("\n-----lista de pacientes----- ");

        try {
            Statement statement = conexion.createStatement();

            // Define la consulta SQL para obtener todos los estudiantes.
            String consulta = "SELECT * FROM pacientes";

            // Ejecuta la consulta SQL y almacena los resultados en un ResultSet.
            ResultSet resultado = statement.executeQuery(consulta);

            // Imprime una cabecera de columnas para los datos de los estudiantes.
            System.out.printf("%-4s%-20s%-6s%-20s%-20s%-10s\n", "ID", "Nombre", "Edad", "Historial Médico", "Fecha de ingreso", "Doctor");

            // Itera a trav�s de los resultados y muestra los datos de cada estudiante en forma de tabla.
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                int edad = resultado.getInt("edad");
                String historialMedico = resultado.getString("historial_medico");
                String fechaIngreso = resultado.getString("fecha_ingreso");
                String doctor = resultado.getString("doctor");

                // Imprime los datos del estudiante con tabulaciones para formatear como una tabla.
                System.out.printf("%-4d%-20s%-6d%-20s%-20s%-10s\n", id, nombre, edad, historialMedico, fechaIngreso, doctor);

            }

            // Cierra el ResultSet y la declaraci�n para liberar recursos.
            resultado.close();
            statement.close();

        }catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la BD en metodo mostrar Pacientes");
            e.printStackTrace();
            e.getMessage();
            e.getCause();
        }



    }

    //metodo para asignar un doctor a cada paciente
    public static void asignarDoctorCabecera(Paciente paciente, Doctor doctor){

        System.out.println("asigar doctor a paciente");
    }

    //metodo  para mostrar pacientes entre fechas
    public static void mostrarPacientesEntreFechas(String fechaInicio, String fechaFin) {
        System.out.println("lista de pacientes entre fechas:");
    }


    //---------------- MAIN ---------------------
    public static void main(String[] args) {

        // Parámetros de conexión a la base de datos
        String url = "jdbc:mysql://localhost:8889/Hospital"; // Corregido
        String usuario = "test"; // Cambia esto por tu nombre de usuario
        String contraseña = "test"; // Cambia esto por tu contraseña

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

                System.out.println("1. Mostrar lista de pacientes ");
                System.out.println("2. Agregar un nuevo paciente ");
                System.out.println("3. Eliminar un paciente ");
                System.out.println("4. Asignar doctor a un paciente ");
                System.out.println("5. Listar pacientes entre fechas ");

                System.out.println("6. Salir ");


                System.out.print("\nIngrese su opción: ");

                int opcion = scanner.nextInt();

                switch (opcion) {

                    case 1:

                        mostrarListaPacientes(conexion);

                        break;
                    case 2:

                        System.out.print("ingrese EDAD del nuevo paciente:");
                        String edadNuevo= scanner.next();

                        System.out.print("ingrese NOMBRE del nuevo paciente:");
                        String nombreNuevo = scanner.next();

                        System.out.print("ingrese HISTORIAL del nuevo paciente:");
                        String historialNuevo = scanner.next();

                        Paciente pacienteNuevo = new Paciente(nombreNuevo,edadNuevo,historialNuevo);

                        agregarPaciente(pacienteNuevo,conexion);

                        break;
                    case 3:

//                        eliminarPaciente();

                        break;
                    case 4:

//                        asignarDoctorCabecera();

                        break;
                    case 5:

//                        mostrarPacientesEntreFechas();

                        break;

                    case 6:
                        System.out.println("programa finalizado  ");
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
    protected String edad;
    protected String id;

    // Constructor y métodos necesarios
    Persona( String nombre, String edad){

        this.nombre=nombre;
        this.edad=edad;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getId() {
        return id;
    }


}

//subclase paciente
class Paciente extends Persona {

    private String historialMedico;

    // Constructor y métodos necesarios
    Paciente( String nombre, String edad,  String historialMedico){

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
    public Doctor( String nombre, String edad, String especialidad) {
        super( nombre, edad);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}


