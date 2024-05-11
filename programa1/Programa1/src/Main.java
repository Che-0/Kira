import java.io.FileNotFoundException;
import java.util.ArrayList;

// version de java 17
public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        System.out.println("Hello world!");

        Listatk lista = new Listatk();
        System.out.println(lista.getListaTokens()); // <-- metodo para comprobar lo que se guardo


        ArrayList<String> x = lista.getListaTokens();  //crear un arraylist que contiene todas las lineas con los tokens

        System.out.println(x.get(0));
       // System.out.println(x.remove(x.size()-1));

        int longitud = x.size();
        ArrayList<ArrayList<String>> pila = new ArrayList<>();

        for (int i = 0; i < longitud; i++) {
            Analisistk uwu = new Analisistk();
            uwu.Analisistk2(x.get(i));
            pila.add(uwu.getPila());
        }
        System.out.println("pila = " + pila);


        ArrayList<Boolean> pilafinal = new ArrayList<>();

        Derivacion dev = new Derivacion(pila.get(0));
        //dev.isEstadoAceptacion();
        System.out.println(dev.isEstadoAceptacion());
        //for (int i = 0; i < pila.size(); i++) {
          //  Derivacion dev = new Derivacion(pila.get(i));
            //boolean correcto = dev.Derivacion2(pila.get(i));

            //pilafinal.add(correcto);
            // token = String.valueOf(pila.get(i));
        //}

    }
}