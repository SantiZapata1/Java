package BasesDeDatos;

import java.sql.*;
import java.util.Scanner;

public class pruebaBaseDeDatos2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Parámetros de conexión a la base de datos
        String url = "jdbc:mysql://localhost:8889/estudiantes"; // Corregido
        String usuario = "test"; // Cambia esto por tu nombre de usuario
        String contraseña = "test"; // Cambia esto por tu contraseña

        try {
            // Cargar el controlador JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("\nConexión exitosa\n");

            // Crear una declaración SQL
            Statement statement = conexion.createStatement();

            //consulta
            String consulta = "SELECT * FROM estudiantes";

            //almacenamos el resultado de la consulta que hagamos
            ResultSet resultado = statement.executeQuery(consulta);

//            System.out.print("ingrese ID a buscar: ");
//            int idBuscado=scanner.nextInt();

//            buscarEstudianteID(idBuscado,resultado);

            agregarEstudiante(conexion,scanner);



            //se cierran los recursos
            statement.close();
            conexion.close();

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

    public static void buscarEstudianteID(int IdBuscado, ResultSet resultado){


        try {
            //recorremos cada fila y obtenemos el dato de cada campo
            while (resultado.next()) {

                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String legajo = resultado.getString("legajo");
                String dni = resultado.getString("dni");

                if(id==IdBuscado){
                    System.out.println("ID: " + id);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Apellido: " + apellido);
                    System.out.println("Legajo: " + legajo);
                    System.out.println("DNI: " + dni);
                    System.out.println("-----------------------");
                }

            }

        }catch (SQLException e) {
                System.out.println("Error: No se pudo conectar a la base de datos");
                e.printStackTrace();
                e.getMessage();
                e.getCause();
        }

    }
    private static void agregarEstudiante(Connection conexion, Scanner scanner) throws SQLException {


        try {

            // Solicita al usuario que ingrese los detalles del estudiante
            System.out.print("Nombre: ");
            String nombre = scanner.next();
            System.out.print("Apellido: ");
            String apellido = scanner.next();
            System.out.print("Legajo: ");
            String legajo = scanner.next();
            System.out.print("DNI: ");
            String dni = scanner.next();

            // Consulta SQL para insertar un nuevo estudiante en la base de datos.
            // Utiliza signos de interrogaci�n como marcadores de posici�n para los valores.
            String consulta = "INSERT INTO estudiantes (nombre, apellido, legajo, dni) VALUES (?, ?, ?, ?)";

            // Crea un PreparedStatement para ejecutar la consulta SQL con valores reales.
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, nombre); // Asigna el valor de nombre al primer marcador de posici�n
            preparedStatement.setString(2, apellido); // Asigna el valor de apellido al segundo marcador de posici�n
            preparedStatement.setString(3, legajo); // Asigna el valor de legajo al tercer marcador de posici�n
            preparedStatement.setString(4, dni); // Asigna el valor de dni al cuarto marcador de posici�n

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

}
