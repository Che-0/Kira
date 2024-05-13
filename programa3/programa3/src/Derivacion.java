import java.util.ArrayList;
import java.util.Arrays;

public class Derivacion {

    int posicion=0;
    int bandera =0;
    ArrayList<String> pila = new ArrayList<String>();
    ArrayList<String> caracteres = new ArrayList<String>();
    String tokens ;

    public String getCorrecto() {
        return correcto;
    }

    String correcto;
    public Derivacion(String tonken) {
        this.tokens = tonken;
        System.out.println(this.tokens);
        if (this.tokens != "Null"){
            System.out.println(this.tokens.length());
            for (int i=0 ; i < this.tokens.length() ; i++){
                char result = this.tokens.charAt(i);
                if (result != ' '){
                    caracteres.add(String.valueOf(result));
                }

            }
            System.out.println(caracteres);
            //caracteres.remove(";");
            System.out.println(caracteres);

            //while (this.posicion < this.tokens.length()-1){
            while (bandera != this.caracteres.size()-1){
                inicialS();
                System.out.println(bandera);
                System.out.println(this.caracteres.size()-1);
            }
            System.out.println(pila);

            //if (pila.get(0) == ";"){
            if (pila.size() == 1){
                correcto = "cadena valida    ✓";
            }else{
                correcto = "cadena invalida    x";
            }

        }
        if (this.tokens == "Null"){
            correcto = "cadena invalida    x";
        }

//        System.out.println(this.tokens.length());
//        for (int i=0 ; i < this.tokens.length() ; i++){
//            char result = this.tokens.charAt(i);
//            if (result != ' '){
//                caracteres.add(String.valueOf(result));
//            }
//
//        }
//        System.out.println(caracteres);
//        //caracteres.remove(";");
//        System.out.println(caracteres);
//
//        //while (this.posicion < this.tokens.length()-1){
//        while (bandera != this.caracteres.size()-1){
//            inicialS();
//            System.out.println(bandera);
//            System.out.println(this.caracteres.size()-1);
//        }
//        System.out.println(pila);
//
//        if (pila.get(0) == ";"){
//            correcto = "cadena valida    ✓";
//        }else{
//            correcto = "cadena invalida    x";
//        }

    }

    public void inicialS(){
//        if (";".equals(caracteres.get(posicion))) {
//            System.out.println("simn");
//            return;
//        }

        if (posicion == 0){
            this.pila.add("A");
            this.pila.add("B");
            this.pila.add(";");
            System.out.println(this.pila);
        }


//        if ("a" == caracteres.get(0)){
//            caminoA();
//        } else if (("b" | "C" | "d" | "c") == caracteres.get(0)) {
//            System.out.println("si");
//        }
        if ("a".equals(caracteres.get(posicion))) {
            caminoA();
        } else if ("b".equals(caracteres.get(posicion)) || "C".equals(caracteres.get(posicion)) || "d".equals(caracteres.get(posicion)) || "c".equals(caracteres.get(posicion))) {
            caminoB();
        }else {
            pila.add("mal");
            posicion+=1;
        }



    }

    public void caminoA(){
        this.pila.remove("A");
        this.pila.add("a");
        System.out.println(this.pila);
        consume();
        sumar();
        //this.posicion+=1;
        System.out.println("posicio = "+this.posicion);
        if ( this.posicion >  caracteres.size()-1 ){
            this.posicion +=1;
        }
    }

    public void caminoB(){

        if (!comprobar()){
            this.pila.remove("B");
            this.pila.add("b");
            this.pila.add("d");
            this.pila.add("C");
        }

        System.out.println(this.pila);
        consume();
        sumar();
        //this.posicion+=1;
        System.out.println("posicio = "+this.posicion);
        if ( this.posicion >  caracteres.size()-1 ){
            this.posicion +=1;
        }

        if ("C".equals(caracteres.get(posicion)) | "c".equals(caracteres.get(posicion))) {
            caminoC();
        }

        //this.pila.add("b,C,d");

    }

    public void caminoC(){
        this.pila.remove("C");
        this.pila.add("c");
        consume();
        sumar();
        //this.posicion+=1;
        System.out.println("posicio = "+this.posicion);
        if ( this.posicion >  caracteres.size()-1 ){
            this.posicion +=1;
        }
    }

    public void consume(){



        String consumible = caracteres.get(posicion);
        System.out.println("caracter "+consumible);

        for (String elemento : pila) {
            //System.out.println(elemento);
            if (elemento.equals(consumible)){
                System.out.println("consumi "+elemento);
                pila.remove(elemento);
                return;
            }
        }

    }

    public boolean comprobar(){
        for (String elemento : pila) {
            if (elemento.equals("b") | elemento.equals("C") | elemento.equals("d")){
                return true;
            }

        }
        return false;
    }

    public void sumar(){
        if ( this.posicion <  caracteres.size()-1 ){
            this.posicion +=1;
            this.bandera +=1;
        }
        if ( this.posicion >  caracteres.size()-1 ){
            this.bandera +=1;
        }
    }


}
