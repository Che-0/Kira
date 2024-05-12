import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

// version de java 17
public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        System.out.println("Hello world!");

        Listatk lista = new Listatk();
        //System.out.println(lista.getListaTokens()); // <-- metodo para comprobar lo que se guardo
        ArrayList<String> x = lista.getListaTokens();  //crear un arraylist que contiene todas las lineas con los tokens
        //System.out.println(x.get(0));
       // System.out.println(x.remove(x.size()-1));

        int longitud = x.size();
        // pila guarda los tokens de cada linea en una lista
        ArrayList<ArrayList<String>> pila = new ArrayList<>();

        for (int i = 0; i < longitud; i++) {
            Analisistk uwu = new Analisistk();
            uwu.Analisistk2(x.get(i)); // guardas el token de la linea en la pila
            pila.add(uwu.getPila());
        }
        //System.out.println("pila = " + pila);

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