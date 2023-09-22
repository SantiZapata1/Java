package Buffer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EjemploBufferedReader {
    public static void main(String[] args) throws IOException {
        // Abrir un archivo para lectura
        BufferedReader br = new BufferedReader(new FileReader("Buffer/archivo.txt"));

        String linea;
        // Leer líneas completas del archivo
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }

        // Cerrar el BufferedReader
        br.close();
    }
}
