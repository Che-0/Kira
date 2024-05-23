import java.util.ArrayList;
import java.util.Arrays;

//Esta clase se encarda de hacer la derivacion de la cadena dada

public class Derivacion {

    int posicion=0;  // variable para pasar caracter por caracter


    ArrayList<String> errores = new ArrayList<String>(); // Almacena las derivaciones
    ArrayList<String> pila = new ArrayList<String>(); // Almacena las derivaciones
    ArrayList<String> caracteres = new ArrayList<String>(); //almacena los caracteres dados
    String tokens ;


    public String getCorrecto() {
        return correcto;
    }

    String correcto;
    public Derivacion(String tonken) {
        this.tokens = tonken;
        System.out.println("----------TOKEN A DERIVAR----------------");
        System.out.println("->"+this.tokens);





        if (this.tokens != "Null"){
            //System.out.println();
            //System.out.println(this.tokens.length());
            //agregamos cada elemento del string dado a una lista (caracteres)
            for (int i=0 ; i < this.tokens.length() ; i++){
                char result = this.tokens.charAt(i);
                if (result != ' '){
                    caracteres.add(String.valueOf(result));  //<--- aqui los agregamos uno por uno
                }
            }


            ////////// repetidos ---- se encarga de ver si hay letras repetidas
            boolean hayRepetidos = false;

            // si hay algun caracter repetido entonces esta mal
            for (int i = 0; i < caracteres.size(); i++) {
                for (int j = i + 1; j < caracteres.size(); j++) {
                    if (caracteres.get(i).equals(caracteres.get(j))) {
                        hayRepetidos = true;
                        errores.add("caracteres repetidos");
                        break;
                    }
                }
            }
            /////// repetidos

            //si hay repetidos, pues esta mal y no hace el analisis
            if (!hayRepetidos){
                //mientras no nos pasemos de su longitud -1  --- para que no cuente el ";"
                while (this.posicion != this.caracteres.size()-1){
                    //System.out.println(pila + " <---- caracteres a derivar");
                    inicialS();
                    //System.out.println(pila + " <---- caracteres a derivar");
                }
                //System.out.println(pila);  <--------------

                // si en la pila solo quedo el ; entonces esta bien y por lo tanto su tamaño es de uno
                if (pila.size() == 1 && pila.get(0) ==";"){
                    System.out.println("Cadena valida ✓");
                    System.out.println("Elementos restantes en la pila: "+pila);
                    correcto = "cadena valida    ✓";
                }
                // si la pila tiene un tamaño superior, esta mal

                else{
                    System.out.println("Cadena invalida x");
                    System.out.println("Elementos restantes en la pila: "+pila);
                    correcto = "cadena invalida    x";
                }
            }
            else {
                correcto = "cadena invalida    x";
            }

            if (hayRepetidos){
                System.out.println("Incorrecto: "+ errores);
            }


        }

        if (this.tokens == "Null"){
            correcto = "cadena invalida    x";
        }
    }

    public void inicialS(){

        if (posicion == 0){
            this.pila.add("A");
            this.pila.add("B");
            this.pila.add(";");
            //System.out.println("desmadre");
            System.out.println(this.pila + " <--------Pila de simbolos");
            System.out.println(caracteres +" <--------Entrada");
        }

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
        System.out.println("°°°°°");
        System.out.println(this.pila + " Derivacion de A"); // <---------
        System.out.println("°°°°°");
        System.out.println(caracteres);
        System.out.println(pila);
        consume();
        sumar();
        System.out.println("posicio = "+this.posicion);
        System.out.println("°°°°°");
        //System.out.println("posicio = "+this.posicion); <-----------
//        if ( this.posicion >  caracteres.size()-1 ){
//            this.posicion +=1;
//        }
    }

    public void caminoB(){

        if (!comprobar()){
            this.pila.remove("B");
            this.pila.add("b");
            this.pila.add("d");
            this.pila.add("C");
            System.out.println(pila + " Derivacion de B");
        }

        if ("C".equals(caracteres.get(posicion))) {
            caminoC2();
        }

        if ("c".equals(caracteres.get(posicion))) {
            caminoC();
        }
        System.out.println("°°°°°");
        System.out.println(caracteres);
        System.out.println(this.pila);  //<----------
        consume();
        sumar();
        System.out.println("posicio = "+this.posicion);  //<-------------
        if ( this.posicion >  caracteres.size()-1 ){
            this.posicion +=1;
        }

//        if ("C".equals(caracteres.get(posicion)) | "c".equals(caracteres.get(posicion))) {
//            caminoC();
//        }


    }

    public void caminoC(){

        //System.out.println("chidooooooooooooo");

        this.pila.remove("C");
        this.pila.add("c");
        System.out.println("°°°°°");
        System.out.println(caracteres);
        System.out.println(pila + " Derivacion de C");

        consume();
        sumar();

        System.out.println("posicio = "+this.posicion);
//        if ( this.posicion >  caracteres.size()-1 ){
//            this.posicion +=1;
//        }
    }

    public void caminoC2(){



//        this.pila.remove("C");
//        System.out.println(pila);
        consume();
        sumar();
        System.out.println("posicio = "+this.posicion);
        System.out.println("°°°°°");

//        //System.out.println("posicio = "+this.posicion);
//        if ( this.posicion >  caracteres.size()-1 ){
//            this.posicion +=1;
//        }
    }


    // itera en la pila que almacena los elementos a derivar o consumir y los compara con el caracter que se
    // requiere analizar, si estos son iguales, el elemento se consume y se remueve de la pila
    public void consume(){

        String consumible = caracteres.get(posicion);
        System.out.println("caracter "+consumible); // <-------------

        for (String elemento : pila) {
            if (elemento.equals(consumible)){
                System.out.println("consumi "+elemento);// <-------------
                pila.remove(elemento);
                return;
            }
        }

    }

    // Comprobar es para no agregar a la pila en cada iteracion bCd y solo hacerlo la primera vez
    public boolean comprobar(){
        for (String elemento : pila) {
            if (elemento.equals("b") | elemento.equals("C") | elemento.equals("d")){
                return true;
            }
        }
        return false;
    }

    // le suma 1 a posicion para poder avanzar al siguiente caracter
    public void sumar(){
        if ( this.posicion <  caracteres.size()-1 ){
            this.posicion +=1;
            //this.bandera +=1;
        }

    }
}
