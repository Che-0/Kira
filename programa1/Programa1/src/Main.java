import java.io.FileNotFoundException;
import java.util.ArrayList;

// version de java 17
public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        System.out.println("Hello world!");

        Listatk lista = new Listatk();
        System.out.println(lista.getListaTokens()); // <-- metodo para comprobar lo que se guardo


        ArrayList<String> x = lista.getListaTokens();  //crear un arraylist que contiene todas las lineas con los tokens



    }
}