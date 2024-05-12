import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.NoSuchElementException;


/// Esta pendejada lee el archivo de conf.txt
// guarda los caracteres y elimina el ";"

public class Listatk {

    //direccion del archivo
    String documento = System.getProperty("user.dir") + "\\src\\conf.txt";

    //lista que guardara el token final
    ArrayList<String> listaTokens = new ArrayList<String>();
    public Listatk() throws FileNotFoundException {
        File doc = new File(documento);
        Scanner obj = new Scanner(doc);
        try {
            while (obj.hasNextLine()){
                String linea = obj.nextLine();
                if (!linea.isEmpty()) {

                    if (linea.substring(linea.length() - 1).equals(";")){
                        listaTokens.add(linea.replace(";",""));
                    }else {
                        listaTokens.add("Null");
                    }
                }
                else{
                    listaTokens.add("Null");
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("No se encontraron más líneas para leer.");
        }
    }

    public ArrayList<String> getListaTokens() {
        return listaTokens;
    }
}

