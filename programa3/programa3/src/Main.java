import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello world!");
        Listatk lista = new Listatk();
        System.out.println("---------Cadenas a procesar---------");
        System.out.println(lista.getListaTokens());


        ArrayList<String> x = lista.getListaTokens();
        ArrayList<String>  pilafinal = new ArrayList<String>();

        for (int i=0 ; i< x.size() ; i++){
            Derivacion dev = new Derivacion(x.get(i));
            pilafinal.add(dev.getCorrecto());
        }

        System.out.println("--------- Analisis -----------");
        for(int i=0 ; i< x.size() ; i++){
            System.out.println(x.get(i) + " --------> " + pilafinal.get(i) );
        }
        }
}