import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.NoSuchElementException;


/// Esta pendejada lee el archivo de conf.txt
// va linea por linea y agrupa los and, not, or ... para que no seab caracateres "a" , "n" ...
// las lineas vacias las retorna como Null y las que no terminen con ;

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
                        //String aux = tokens.remove(tokens.size()-1);
//                        ArrayList<String> aux = new ArrayList<String>();
//                        aux.add(linea);
//                        System.out.println(aux);
//                        aux.remove(aux.size()-1);
                        //linea.replace(";"," ");
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

