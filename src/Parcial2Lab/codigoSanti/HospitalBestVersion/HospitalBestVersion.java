package Parcial2Lab.codigoSanti.HospitalBestVersion;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class HospitalBestVersion {
    //main del programa
    public static void main(String[] args) {

        //creamos un objeto de la clase Hospital
        Hospital hospital = new Hospital();
        Scanner scanner = new Scanner(System.in);
        int cont=0;

        while(true){

            cont+=1;

            System.out.println("\n --------------- accion numero "+cont+" ---------------");

            System.out.println("1. Mostrar lista de pacientes ");
            System.out.println("2. Mostrar doctores ");
            System.out.println("3. Agregar un nuevo paciente ");
            System.out.println("4. Agregar un nuevo doctor ");
            System.out.println("5. Eliminar un paciente ");
            System.out.println("6. Asignar doctor a un paciente ");
            System.out.println("7. Listar pacientes entre fechas ");

            System.out.println("8. Salir ");

            System.out.print("\nIngrese su opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {

                case 1://1. Mostrar lista de pacientes

                    hospital.listarPacientes();

                    break;
                case 2://2. Mostrar doctores

                    hospital.listarDoctores();

                    break;
                case 3:

                    System.out.print("ingrese NOMBRE del nuevo paciente:");
                    String nombreNuevoPaciente = scanner.next();

                    System.out.print("ingrese EDAD del nuevo paciente:");
                    int edadNuevoPaciente= scanner.nextInt();

                    System.out.print("ingrese HISTORIAL del nuevo paciente:");
                    String historialNuevoPaciente = scanner.next();

                    System.out.print("ingrese FECHA INGRESO del nuevo paciente (yyyy-mm-dd):");
                    String fechaIngreso = scanner.next();
                    LocalDate FechaIngresoNuevoPaciente = LocalDate.parse(fechaIngreso);

                    System.out.print("ingrese ID del doctor de cabecera:");
                    int idDoctorCabecera = scanner.nextInt();

                    //creamos nuevo paciente con los datos ingresados
                    Paciente pacienteNuevo = new Paciente(nombreNuevoPaciente,edadNuevoPaciente,historialNuevoPaciente,idDoctorCabecera, FechaIngresoNuevoPaciente);

                    //Usamos un metodo para agregar paciente de la clase hospital
                    hospital.agregarPaciente(pacienteNuevo);

                    break;

                case 4://4. Agregar un nuevo doctor

                    System.out.print("ingrese NOMBRE del nuevo doctor:");
                    String nombreNuevoDoctor = scanner.next();

                    System.out.print("ingrese EDAD del nuevo doctor:");
                    int edadNuevoDoctor= scanner.nextInt();

                    System.out.print("ingrese ESPECIALIDAD del nuevo doctor:");
                    String especialidadNuevoDoctor = scanner.next();

                    Doctor doctorNuevo = new Doctor(nombreNuevoDoctor,edadNuevoDoctor,especialidadNuevoDoctor);

                    hospital.agregarDoctor(doctorNuevo);


                    break;

                case 5: //5. Eliminar un paciente


                    System.out.print("ingrese NOMBRE del paciente a eliminar:");

                    String nombreEliminar = scanner.next();

                    hospital.eliminarPaciente(nombreEliminar);

                    break;
                case 6://6. Asignar doctor a un paciente

                    System.out.print("ingrese nombre del doctor a signar:");
                    String nombreDoctor = scanner.next();

                    System.out.print("ingrese nombre del paciente a signar:");
                    String nombrePaciente = scanner.next();

                    hospital.asignarDoctorCabecera(nombreDoctor, nombrePaciente);

                    break;

                case 7://7. Listar pacientes entre fechas

                    System.out.print("Ingrese una fecha de inicio(formato YYYY-MM-DD): ");
                    String fecha1 = scanner.next();

                    System.out.print("Ingrese una fecha limite (formato YYYY-MM-DD): ");
                    String fecha2 = scanner.next();

                    LocalDate fechaInicio = LocalDate.parse(fecha1);
                    LocalDate fechaFin = LocalDate.parse(fecha2);

                    hospital.listarPacientesEntreDosFechas(fechaInicio, fechaFin);
                    break;
                case 8:
                    System.out.println("programa finalizado  ");
                    return;
                default:
                    System.out.println("ingrese un caracer valido");

            }
        }

    }

}

class Hospital {
    public void agregarPaciente(Paciente paciente) {
        // Agregar el paciente a la base de datos
        String consulta = "INSERT INTO pacientes (nombre, edad, historial_medico, doctor, fecha_ingreso) VALUES ('" + paciente.getNombre() + "', " + paciente.getEdad() + ", '" + paciente.getHistorialMedico() + "', " + paciente.getDoctorCabecera() + ", '" + paciente.getFechaIngreso() + "')";
        DBHelper.ejecutarConsulta(consulta);

    }public void agregarDoctor(Doctor doctor) {
        // Agregar el paciente a la base de datos
        String consulta = "INSERT INTO doctores (nombre, edad, especialidad) VALUES ('" + doctor.getNombre() + "', " + doctor.getEdad() + ", '" + doctor.getEspecialidad() +"')";
        DBHelper.ejecutarConsulta(consulta);
    }
    // elimine un paciente indicando su nombre
    public void eliminarPaciente(String nombre) {
        // Eliminar el paciente de la base de datos
        String consulta = "DELETE FROM pacientes WHERE nombre = '" + nombre + "'";
        DBHelper.ejecutarConsulta(consulta);

    }

    //método para asignar un doctor de cabecera a un paciente indicando el nombre del doctor y el nombre del paciente
    public void asignarDoctorCabecera(String nombreDoctor, String nombrePaciente) {
        String consulta = "UPDATE pacientes SET doctor = (SELECT id FROM doctores WHERE nombre = '"+nombreDoctor+"') WHERE nombre = '"+nombrePaciente+"'";
        DBHelper.ejecutarConsulta(consulta);
    }

    public void listarPacientes() {
        String consulta = "SELECT * FROM pacientes";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
        listarPacientes(resultado);
    }

    public void listarPacientesEntreDosFechas(LocalDate fechaDesde, LocalDate fechaHasta) {
        String consulta = "SELECT * FROM pacientes WHERE fecha_ingreso BETWEEN '"+fechaDesde+"' AND '"+fechaHasta+"';";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
        listarPacientes(resultado);
    }
    //mostrar listado de pacientes
    public void listarPacientes(ResultSet resultado){
        if (resultado != null) {
            try {
                System.out.println("Lista de Pacientes:");
                System.out.printf("%-10s %-15s %-5s %-20s %-12s %-10s\n", "ID", "Nombre", "Edad", "Historial Médico", "Fecha Ingreso", "Doctor");

                while (resultado.next()) {
                    int id = resultado.getInt("id");
                    String nombre = resultado.getString("nombre");
                    int edad = resultado.getInt("edad");
                    String historialMedico = resultado.getString("historial_medico");
                    Date fechaIngreso = resultado.getDate("fecha_ingreso");
                    int idDoctor = resultado.getInt("doctor");

                    System.out.printf("%-10d %-15s %-5d %-20s %-12s %-10d\n", id, nombre, edad, historialMedico, fechaIngreso, idDoctor);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void listarDoctores() {
        String consulta = "SELECT * FROM doctores";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
        listarDoctores(resultado);
    }
    public void listarDoctores(ResultSet resultado){
        if (resultado != null) {
            try {
                System.out.println("Lista de Doctores:");
                System.out.printf("%-10s %-15s %-5s %-20s\n", "ID", "Nombre", "Edad", "Especialidad");

                while (resultado.next()) {
                    int id = resultado.getInt("id");
                    String nombre = resultado.getString("nombre");
                    int edad = resultado.getInt("edad");
                    String especialidad = resultado.getString("especialidad");

                    System.out.printf("%-10d %-15s %-5d %-20s\n", id, nombre, edad, especialidad);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


//clase con los metodos para ejecutar las consultas con o sin resultados a la BD
class DBHelper {

    //datos de la BD
    private static final String URL = "jdbc:mysql://localhost:8889/Hospital";
    private static final String USER = "test";
    private static final String PASSWORD = "test";

    // Método para ejecutar una consulta sin devolver resultados
    public static void ejecutarConsulta(String consulta) {
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Crear la declaración
            try (PreparedStatement statement = connection.prepareStatement(consulta)) {
                // Ejecutar la consulta
                statement.executeUpdate();
            }

            // Cerrar la conexión
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para ejecutar una consulta y devolver un conjunto de resultados
    public static ResultSet ejecutarConsultaConResultado(String consulta) {
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Crear la declaración
            PreparedStatement statement = connection.prepareStatement(consulta);

            // Ejecutar la consulta y devolver el conjunto de resultados
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}

// 1. Define la clase abstracta Persona con atributos comunes para pacientes y doctores.
abstract class Persona {
    protected String nombre;
    protected int edad;

    // Constructor y métodos necesarios

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}

// 2. Implementa la clase Paciente que hereda de Persona con atributos adicionales como historial médico.
class Paciente extends Persona {
    private String historialMedico;
    private int doctorCabecera;
    private LocalDate fechaIngreso;

    public Paciente(String nombre, int edad, String historialMedico, int doctorCabecera, LocalDate fechaIngreso) {
        super( nombre, edad);
        this.historialMedico = historialMedico;
        this.doctorCabecera = doctorCabecera;
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public String getHistorialMedico() {
        return historialMedico;
    }

    public int getDoctorCabecera() {
        return doctorCabecera;
    }
}


class Doctor extends Persona {
    private String especialidad;

    // Constructor y métodos necesarios
    public Doctor( String nombre, int edad, String especialidad) {
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
