package ArchivosDirectorios;
import java.io.File;
public class BasicoArchivos {


    public static void main(String[] args) {

        // Crear una instancia de File para un archivo
        File archivo = new File("miArchivo.txt");

        // Crear una instancia de File para un directorio
        File directorio = new File("miDirectorio");

        // Verificar si un archivo o directorio existe
        boolean existe = archivo.exists();

        // Obtener el nombre del archivo o directorio
        String nombre = archivo.getName();

        // Obtener la ruta absoluta del archivo o directorio
        String rutaAbsoluta = archivo.getAbsolutePath();

        // Verificar si es un directorio
        boolean esDirectorio = directorio.isDirectory();

        // Crear un directorio
        boolean directorioCreado = directorio.mkdir();

        // Eliminar un archivo o directorio
        boolean eliminado = archivo.delete();

        // Listar archivos y directorios en un directorio
        File[] archivosEnDirectorio = directorio.listFiles();

        // Iterar a través de los archivos y directorios en un directorio
        for (File archivoODirectorio : archivosEnDirectorio) {
            // Realizar operaciones con cada archivo o directorio
        }

        // Renombrar un archivo o directorio
        File nuevoNombre = new File("nuevoNombre.txt");
        boolean renombrado = archivo.renameTo(nuevoNombre);

        // Mover un archivo o directorio a otro lugar
        File nuevoDirectorio = new File("nuevoDirectorio");
        boolean movido = archivo.renameTo(new File(nuevoDirectorio, archivo.getName()));

        // Obtener el tamaño del archivo en bytes
        long tamaño = archivo.length();

        // Obtener la última fecha de modificación del archivo o directorio
        long ultimaModificacion = archivo.lastModified();



    }







}
