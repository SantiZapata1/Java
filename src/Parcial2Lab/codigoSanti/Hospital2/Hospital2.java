package Parcial2Lab.codigoSanti.Hospital2;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Hospital2 {

    //metodo para agregar paciente
    public static void agregarPaciente(Paciente2 paciente, Connection conexion) {

        try{
            // Consulta SQL para insertar un nuevo estudiante en la base de datos.
            // Utiliza signos de interrogacion como marcadores de posicion para los valores.

            String consulta = "INSERT INTO pacientes (nombre, edad, historial_medico, fecha_ingreso, doctor) VALUES (?, ?, ?, ?, ?)";

            // Crea un PreparedStatement para ejecutar la consulta SQL con valores reales.
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, paciente.getNombre()); // Asigna el valor de apellido al segundo marcador de posici�n
            preparedStatement.setString(2, paciente.getEdad()); // Asigna el valor de legajo al tercer marcador de posici�n
            preparedStatement.setString(3, paciente.getHistorialMedico()); // Asigna el valor de dni al cuarto marcador de posici�n
            preparedStatement.setString(4, paciente.getFechaIngreso()); // Asigna el valor de dni al cuarto marcador de posici�n
            preparedStatement.setString(5, "0"); // Asigna el valor de dni al cuarto marcador de posicion


            // Ejecuta la consulta y obtiene el n�mero de filas afectadas.
            int filasAfectadas = preparedStatement.executeUpdate();

            // Verifica si la inserci�n fue exitosa y muestra un mensaje apropiado.
            if (filasAfectadas > 0) {
                System.out.println("Paciente agregado exitosamente.");
                mostrarListaPacientes(conexion);

            } else {
                System.out.println("No se pudo agregar el paciente.");
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

    //metodo para agregar doctor
    public static void agregarDoctor(Doctor2 doctor, Connection conexion) {


        try{
            // Consulta SQL para insertar un nuevo estudiante en la base de datos.
            // Utiliza signos de interrogacion como marcadores de posicion para los valores.

            String consulta = "INSERT INTO doctores (nombre, edad, especialidad) VALUES (?, ?, ?)";

            // Crea un PreparedStatement para ejecutar la consulta SQL con valores reales.
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, doctor.getNombre()); // Asigna el valor de apellido al segundo marcador de posici�n
            preparedStatement.setString(2, doctor.getEdad()); // Asigna el valor de legajo al tercer marcador de posici�n
            preparedStatement.setString(3, doctor.getEspecialidad()); // Asigna el valor de dni al cuarto marcador de posici�n

            // Ejecuta la consulta y obtiene el n�mero de filas afectadas.
            int filasAfectadas = preparedStatement.executeUpdate();

            // Verifica si la inserci�n fue exitosa y muestra un mensaje apropiado.
            if (filasAfectadas > 0) {
                System.out.println("Doctor agregado exitosamente.");
                mostrarDoctores(conexion);

            } else {
                System.out.println("No se pudo agregar el doctor.");
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

    //metodo para eliminar paciente
    public static void eliminarPaciente(int IdEliminar, Connection conexion) {

        try{

            // Verificar si el estudiante con el ID especificado existe en la base de datos.
            String consultaExistencia = "SELECT * FROM pacientes WHERE id = ?";

            PreparedStatement preparedStatementExistencia = conexion.prepareStatement(consultaExistencia);

            preparedStatementExistencia.setInt(1, IdEliminar); // Establece el valor del marcador de posici�n.

            ResultSet resultadoExistencia = preparedStatementExistencia.executeQuery();

            // Si no se encuentra ning�n estudiante con el ID proporcionado, muestra un mensaje y sale de la funci�n.
            if (!resultadoExistencia.next()) {
                System.out.println("El paciente no existe.");
                preparedStatementExistencia.close();
                return;
            }else {
                // Consulta SQL para eliminar el estudiante de la base de datos.
                String consulta = "DELETE FROM pacientes WHERE id = ?";

                PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

                preparedStatement.setInt(1, IdEliminar); // Establece el valor del marcador de posici�n.

                // Ejecuta la consulta SQL y obtiene el n�mero de filas afectadas.
                int filasAfectadas = preparedStatement.executeUpdate();

                // Verifica si la eliminaci�n fue exitosa y muestra un mensaje apropiado.
                if (filasAfectadas > 0) {
                    System.out.println("paciente eliminado exitosamente.");
                    mostrarListaPacientes(conexion);

                } else {
                    System.out.println("No se pudo eliminar el paciente.");
                }

                // Cierra el PreparedStatement para liberar recursos.
                preparedStatement.close();
            }



        }catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos");
            e.printStackTrace();
            e.getMessage();
            e.getCause();
        }


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

                if (doctor.equals("0")){
                    doctor="sin doctor";
                }

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
    public static void mostrarPacientes(Connection conexion) {


            System.out.println("\n-----lista de pacientes----- ");

            try {
                Statement statement = conexion.createStatement();

                // Define la consulta SQL para obtener todos los estudiantes.
                String consulta = "SELECT * FROM pacientes";

                // Ejecuta la consulta SQL y almacena los resultados en un ResultSet.
                ResultSet resultado = statement.executeQuery(consulta);

                // Imprime una cabecera de columnas para los datos de los estudiantes.
                System.out.printf("%-4s%-20s\n", "ID", "Nombre");

                // Itera a trav�s de los resultados y muestra los datos de cada estudiante en forma de tabla.
                while (resultado.next()) {

                    int id = resultado.getInt("id");
                    String nombre = resultado.getString("nombre");

                    // Imprime los datos del estudiante con tabulaciones para formatear como una tabla.
                    System.out.printf("%-4d%-20s\n", id, nombre);

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

    //metodo para mostrar doctores
    public static void mostrarDoctores(Connection conexion){
        System.out.println("\n-----lista de doctores----- ");

        try {
            Statement statement = conexion.createStatement();

            // Define la consulta SQL para obtener todos los estudiantes.
            String consulta = "SELECT * FROM doctores";

            // Ejecuta la consulta SQL y almacena los resultados en un ResultSet.
            ResultSet resultado = statement.executeQuery(consulta);

            // Imprime una cabecera de columnas para los datos de los estudiantes.
            System.out.printf("%-4s%-20s\n", "ID", "Nombre");

            // Itera a trav�s de los resultados y muestra los datos de cada estudiante en forma de tabla.
            while (resultado.next()) {

                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");

                // Imprime los datos del estudiante con tabulaciones para formatear como una tabla.
                System.out.printf("%-4d%-20s\n", id, nombre);

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
    public static void asignarDoctorCabecera(int idDoctor, int idPaciente, Connection conexion){

        try{
            // Verificar si el estudiante con el ID especificado existe en la base de datos.
            String consultaExistencia = "SELECT * FROM pacientes WHERE id = ?";
            PreparedStatement preparedStatementExistencia = conexion.prepareStatement(consultaExistencia);
            preparedStatementExistencia.setInt(1, idPaciente); // Establece el valor del marcador de posici�n.
            ResultSet resultadoExistencia = preparedStatementExistencia.executeQuery();

            // Si no se encuentra ning�n estudiante con el ID proporcionado, muestra un mensaje y sale de la funci�n.
            if (!resultadoExistencia.next()) {
                System.out.println("El paciente no existe.");
                preparedStatementExistencia.close();
            }
            else{

                // Consulta SQL para actualizar los datos del estudiante en la base de datos.
                String consulta = "UPDATE pacientes SET doctor = ? WHERE id = ?";

                // Crea un PreparedStatement para ejecutar la consulta SQL con valores reales.
                PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
                preparedStatement.setInt(1, idDoctor);
                preparedStatement.setInt(2, idPaciente);

                // Ejecuta la consulta SQL y obtiene el n�mero de filas afectadas.
                int filasAfectadas = preparedStatement.executeUpdate();

                // Verifica si la edici�n fue exitosa y muestra un mensaje apropiado.
                if (filasAfectadas > 0) {
                    System.out.println("Estudiante editado exitosamente.");
                    mostrarListaPacientes(conexion);

                } else {
                    System.out.println("No se pudo editar el estudiante.");
                }

                // Cierra el PreparedStatement para liberar recursos.
                preparedStatement.close();

            }


        }catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos");
            e.printStackTrace();
            e.getMessage();
            e.getCause();
        }

    }

    //metodo  para mostrar pacientes entre fechas
    public static void mostrarPacientesEntreFechas(Connection conexion, LocalDate fechaInicio, LocalDate fechaFin) {


        try{

            Statement statement = conexion.createStatement();

            // Define la consulta SQL para obtener todos los estudiantes.
            String consulta = "SELECT * FROM pacientes ";

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

                LocalDate FechaIngreso = LocalDate.parse(fechaIngreso);


                if (FechaIngreso.isAfter(fechaInicio) && FechaIngreso.isBefore(fechaFin)){
                    // Imprime los datos del estudiante con tabulaciones para formatear como una tabla.
                    System.out.printf("%-4d%-20s%-6d%-20s%-20s%-10s\n", id, nombre, edad, historialMedico, fechaIngreso, doctor);
                }

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
                System.out.println("6. agregar un nuevo doctor ");
                System.out.println("7. mostrar doctores ");

                System.out.println("8. Salir ");


                System.out.print("\nIngrese su opción: ");

                int opcion = scanner.nextInt();

                switch (opcion) {

                    case 1:

                        mostrarListaPacientes(conexion);

                        break;
                    case 2:

                        System.out.print("ingrese NOMBRE del nuevo paciente:");
                        String nombreNuevo = scanner.next();

                        System.out.print("ingrese EDAD del nuevo paciente:");
                        String edadNuevo= scanner.next();

                        System.out.print("ingrese HISTORIAL del nuevo paciente:");
                        String historialNuevo = scanner.next();

                        System.out.print("ingrese FECHA INGRESO del nuevo paciente (yyyy-mm-dd):");
                        String fechaIngreso = scanner.next();

                        Paciente2 pacienteNuevo = new Paciente2(nombreNuevo,edadNuevo,historialNuevo, fechaIngreso);

                        agregarPaciente(pacienteNuevo,conexion);

                        break;
                    case 3:

                        System.out.print("ingrese ID del paciente a eliminar:");
                        int IdEliminar = scanner.nextInt();

                        eliminarPaciente(IdEliminar, conexion);

                        break;
                    case 4:

                        mostrarDoctores(conexion);
                        System.out.print("ingrese ID del doctor a signar:");
                        int idDoctor = scanner.nextInt();

                        mostrarPacientes(conexion);
                        System.out.print("ingrese ID del paciente a signar:");
                        int IdPaciente = scanner.nextInt();

                        asignarDoctorCabecera(idDoctor, IdPaciente, conexion);

                        break;
                    case 5:

                        System.out.print("Ingrese una fecha de inicio(formato YYYY-MM-DD): ");
                        String fecha1 = scanner.next();

                        System.out.print("Ingrese una fecha limite (formato YYYY-MM-DD): ");
                        String fecha2 = scanner.next();

                        LocalDate fechaInicio = LocalDate.parse(fecha1);
                        LocalDate fechaFin = LocalDate.parse(fecha2);

                        mostrarPacientesEntreFechas(conexion, fechaInicio, fechaFin);

                        break;
                    case 6:

                        System.out.print("ingrese NOMBRE del nuevo doctor:");
                        String nombreNuevo2 = scanner.next();

                        System.out.print("ingrese EDAD del nuevo doctor:");
                        String edadNuevo2= scanner.next();

                        System.out.print("ingrese ESPECIALIDAD del nuevo doctor:");
                        String especialidadNuevo = scanner.next();

                        Doctor2 doctorNuevo = new Doctor2(nombreNuevo2,edadNuevo2,especialidadNuevo);

                        agregarDoctor(doctorNuevo,conexion);

                        break;
                    case 7:

                        mostrarDoctores(conexion);

                        break;
                    case 8:
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
abstract class Persona2 {

    //atributos
    protected String nombre;
    protected String edad;
    protected int id;


    // Constructor y métodos necesarios
    Persona2( String nombre, String edad){

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

    public int getId() {
        return id;
    }


}

//subclase paciente
class Paciente2 extends Persona2 {

    private String historialMedico;
    protected String fechaIngreso;

    // Constructor y métodos necesarios
    Paciente2(String nombre, String edad,  String historialMedico, String fechaIngreso){

        super(nombre,edad);
        this.historialMedico=historialMedico;
        this.fechaIngreso=fechaIngreso;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public String getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }
}

//subclase doctor
class Doctor2 extends Persona2 {
    private String especialidad;

    // Constructor y métodos necesarios
    public Doctor2( String nombre, String edad, String especialidad) {
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


