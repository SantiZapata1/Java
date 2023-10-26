package BasesDeDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class codigoBase {
    public static void main(String[] args) {
        // Parámetros de conexión a la base de datos
        String url = "jdbc:mysql://localhost:8888/Prueba"; // Corregido
        String usuario = "root"; // Cambia esto por tu nombre de usuario
        String contraseña = "santi"; // Cambia esto por tu contraseña

        try {
            // Cargar el controlador JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión exitosa");

            // Aquí puedes realizar operaciones en la base de datos

            // Cerrar la conexión cuando hayas terminado
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
}
