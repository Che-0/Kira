import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello world!");
        Listatk lista = new Listatk();
        //System.out.println(lista.getListaTokens());
        ArrayList<String> x = lista.getListaTokens();

        int longitud = x.size();
        ArrayList<ArrayList<String>> pila = new ArrayList<>();

        for (int i = 0; i < longitud; i++) {
            Analisistk uwu = new Analisistk();
            uwu.Analisistk2(x.get(i)); // guardas el token de la linea en la pila
            pila.add(uwu.getPila());
        }
        //System.out.println("pila = " + pila);

        Derivacion dev = new Derivacion(pila.get(0));
        System.out.println("tons que mami");
        System.out.println(dev.isEstadoAceptacion());

        //Guarda los valores de cada cadena , si es valida o invalida
        ArrayList<Boolean> pilafinal = new ArrayList<>();

        //Derivacion dev = new Derivacion(pila.get(0));
        //System.out.println("tons que mami");
        //System.out.println(dev.isEstadoAceptacion());

        for (int i = 0; i < pila.size(); i++) {
            Derivacion itera = new Derivacion(pila.get(i));
            boolean correcto = itera.isEstadoAceptacion();
            pilafinal.add(correcto);

        }

        System.out.println("-------analisis------------");

        for (int i = 0; i < pila.size(); i++){
            String choro;
            if (pilafinal.get(i)){
                choro = "cadena valida    ✓";
            }else {
                choro="cadena invalida    x";
            }
            System.out.println(x.get(i) +" ----------> " + choro);
        }



    }
}