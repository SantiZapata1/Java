package estructurasLineales.Colas.ejerciciosColas;
import estructurasLineales.Colas.Cola;

public class cajeroAutomatico {

    public static void main(String[] args) {

        Cola cola1 = new Cola();

        int tiempoSimulacion = 600;

        int personasAtendidas = 0;

        for(int i=0;i<tiempoSimulacion;i++){

            String num = Integer.toString(i);

            if (i%2==0){
                cola1.encolar(num);
                System.out.println("encolado usuario: "+cola1.tamaño);
            }
            if(i%4==0){
                cola1.desencolar();
                personasAtendidas++;
                System.out.println("cant usuarios atendidos: "+personasAtendidas);

            }

        }

        System.out.println("Personas restantes en 10hs: "+ cola1.tamaño);
        System.out.println("Personas atendidas en 10hs: "+ personasAtendidas);

    }

}
