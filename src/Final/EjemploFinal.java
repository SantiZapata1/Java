package Final;
public class EjemploFinal {

    // Variable final (constante)
    final int CONSTANTE = 42;

    // Método final
    public final void metodoFinal() {
        System.out.println("Este es un método final.");
    }

    // Clase final
    public static final class MiClaseFinal {
        // Contenido de la clase final
    }

    public static void main(String[] args) {
        EjemploFinal ejemplo = new EjemploFinal();
        System.out.println("Valor de la constante: " + ejemplo.CONSTANTE);
        ejemplo.metodoFinal();

        // Intentar crear una subclase de MiClaseFinal generaría un error,
        // ya que MiClaseFinal es una clase final y no puede ser extendida.
    }
}
