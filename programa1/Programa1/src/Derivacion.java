// Se procesaran los token para ver si se pueden derviar o no
// recibe por ejemplo [not,(,true, and, false, ),] <---- Tiene que esta en una lista que contemga cada elemento;


import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.Arrays;

public class Derivacion {

    int errores = 0;

    ArrayList<String> transiciones = new ArrayList<String>(); // transisiones para imprimir al final
    ArrayList<String> transiciones_tokens = new ArrayList<String>(); // transisiones para imprimir al final

    ArrayList<String> lista_errores = new ArrayList<String>(); // lista de errores para imprimir al final



    boolean error_siguientede_and = false;

    ArrayList<String> tokens = new ArrayList<String>(); //lista que contendra los tokens
    int posicion = 0;  // contador que indicara la posicion de elemnto de la lista de tokens

    boolean usa_parentesis = false;
    int usa_parentesiss = 0;
    int cierre_parentesiss = 0;

    boolean espera; // si usa_parentesis es true se analizara que espera sea false
    // ya que si es true significara que los de apertura nunca se cerraron

    /////////////
    boolean es_and = false;
    boolean espera_and; // si usa and entonces se esperara un token despues

    boolean es_or = false;
    boolean espera_or;// si usa and entonces se esperara un token despues
    public boolean isEstadoAceptacion() {
        return estadoAceptacion;
    }

    boolean estadoAceptacion;
    public Derivacion(ArrayList tokens) {
        this.tokens = tokens;
        System.out.println("--------------------------------------------------------------------");
        System.out.println("<                          U W U                                    >");
        System.out.println("cadena a validar: "+this.tokens);
        //System.out.println(this.tokens.get(1)); //traer el primer elemento 2

        //si la cadena contiene algo procedemos a ejecutar la derivacion
        if (this.tokens != null){
            int aux = estadoS(posicion);

            // si usa parentesis = true ejecitamos su comprobacion para saber si se cerro
            if(usa_parentesis){
                // no se encontro el parentesis de cierre ")" no se encontro
                if (espera == true){
                    //System.out.println("no se encontro el cierre de parentesis");
                    lista_errores.add("no se encontro el cierre de parentesis");
                    estadoAceptacion = false;
                }
                // si se encontro el cierre de parentesis
                if (espera == false){
                    //System.out.println("se cerro el parentesis");
                    //lista_errores.add("no se encontro el cierre de parentesis");
                    estadoAceptacion = true;

                    if(es_and){
                        // no se encontro el siguiente token despues de and
                        if (espera_and == true){
                            //System.out.println("no hay ningun token valido despues");
                            lista_errores.add("no hay ningun token valido despues");
                            estadoAceptacion = false;
                            //es_and = false;
                        }
                        // si se encontro
                        if (espera_and == false){
                            //System.out.println("and esta bien");
                            estadoAceptacion = true;
                        }
                    }
                    if (es_or);
                    {
                        if (espera_or == false) {
                            //System.out.println("or esta bien");
                            estadoAceptacion = true;
                        }
                        if (espera_or == true) {
                            //System.out.println("se esperaba un token despues ");
                            lista_errores.add("se esperaba un token despues de or");
                            estadoAceptacion = false;
                        }
                    }
                    if (espera_and != false & espera_or != false ){
                        System.out.println("");
                        estadoAceptacion = false;
                    }

                }
            }






            if (espera_and != false & espera_or != false ){
                estadoAceptacion = false;
            }

            // para saber si solo se puso un pinche ")" y ya alv
            if (usa_parentesiss != cierre_parentesiss){
                //System.out.println("error en los parentesis");
                lista_errores.add("error en los parentesis");
                estadoAceptacion = false;
            }

            if (error_siguientede_and){
                //System.out.println("esa mamada que");
                lista_errores.add("se esperaba un token despues and");
                estadoAceptacion = false;
            }

            lista_errores.add("no se puede derivar");

            System.out.println("Derivacion");
            System.out.println(transiciones);
            System.out.println(transiciones_tokens);
            System.out.println("La cadena es: " + (estadoAceptacion ? "valida" : "invalida"));

            if (!estadoAceptacion){
                System.out.println(lista_errores);
            }

            //boolean es_or = false;
            //boolean espera_or; // si usa and entonces se esperara un token despues


            //System.out.println("el estado es");
            //System.out.println(estadoAceptacion);
        }
        // null --- cadena invalida o linea en blanco
        if (this.tokens == null){
            System.out.println("no hay nada que evaluar");
            estadoAceptacion = false;
        }
    }



    public int estadoS(int x){
        transiciones.add("S-->");
        errores +=4;
        if (errores>10){
            estadoAceptacion = false;
            lista_errores.add("error, imposible de derivar");
            return 0;
        }
        //en caso de que solo sea un elemento true false ...
        if (this.tokens.size()==1){
            //if (posicion <  this.tokens.size()){
            //System.out.println("nomas es uno");
            if (this.tokens.get(posicion).toString().equals("true") || this.tokens.get(posicion).toString().equals("false")){
                transiciones.add("F-->");

                if (this.tokens.get(posicion).equals("true")){
                    transiciones_tokens.add("true");
                }
                if (this.tokens.get(posicion).equals("false")){
                    transiciones_tokens.add("false");
                }
                posicion+=1;
                estadoX();
            }
        }

        if (posicion <  this.tokens.size()-1){
        //if (posicion <  this.tokens.size()){
            //System.out.println("uwu");

            estadoE(posicion);
        }
        return 0;
    }

    public int estadoE(int x){
        if (estadoX()) {
            transiciones.add("E-->");
            //espera_and = false;
            if (this.tokens.get(posicion).toString().equals("true") || this.tokens.get(posicion).toString().equals("false") || this.tokens.get(posicion).toString().equals("(") || this.tokens.get(posicion).toString().equals(")") || this.tokens.get(posicion).toString().equals("not")){

                return estadoT(posicion);

            }

            if (this.tokens.get(posicion).equals("or")) {
                transiciones_tokens.add("or-->");
                //estadoX();
                es_or = true;
                espera_or = true;
                posicion += 1;
                return estadoE(posicion);
            }
            if (this.tokens.get(posicion).equals("and")) {

                //estadoX();

                return estadoS(posicion);
            }

            return estadoS(posicion);
        }else{
            estadoAceptacion = false;
            posicion+=1;
            return estadoS(posicion);
        }
    }

    public int estadoT(int x) {
        if (estadoX()) {
            transiciones.add("T-->");
            //espera_and = false;
            if (this.tokens.get(posicion).equals("true") || this.tokens.get(posicion).equals("false") || this.tokens.get(posicion).equals("(") || this.tokens.get(posicion).equals(")") || this.tokens.get(posicion).equals("not")) {
                return estadoF(posicion);
                //System.out.println(posicion);
            }
            if (this.tokens.get(posicion).equals("and")) {
                transiciones_tokens.add("and-->");
                //estadoX();
                error_siguientede_and = true;
                es_and = true; ////////////
                espera_and = true;
                posicion += 1;

                return estadoT(posicion);
            }
            return estadoE(posicion);

        }else {
            return estadoS(posicion);
        }
    }


    public int estadoF(int x){
        if (estadoX())
        {
            transiciones.add("F-->");
            //espera_and = false;

            if (this.tokens.get(posicion).equals("true") || this.tokens.get(posicion).equals("false") || this.tokens.get(posicion).equals("not")) {
                // //// estadoX();
                if (this.tokens.get(posicion).equals("true")){
                    transiciones_tokens.add("true-->");
                }
                if (this.tokens.get(posicion).equals("false")){
                    transiciones_tokens.add("false-->");
                }

                if (this.tokens.get(posicion).equals("not")){
                    transiciones_tokens.add("not-->");
                }

                error_siguientede_and = false;
                espera_or = false;
                espera_and = false;
                posicion += 1;


                //transiciones_tokens.add("or-->");


                return estadoF(posicion);
            }
            if (this.tokens.get(posicion).equals("(")) {
                transiciones_tokens.add("(-->");
                //estadoX();
                usa_parentesiss +=1 ; //para llevar la cuenta de esas madres
                usa_parentesis = true;
                posicion += 1;
                espera = true;
                return estadoF(posicion);
            }
            if (this.tokens.get(posicion).equals(")")) {
                transiciones_tokens.add(")-->");
                //estadoX();
                cierre_parentesiss +=1;
                espera = false;
                posicion += 1;

                return estadoF(posicion);
            }

            return estadoT(posicion);
        }else {
            return estadoS(posicion);
        }


    }

    public boolean estadoX(){

        if (posicion  > this.tokens.size()-1){
            if (this.tokens.get(posicion-1) == "and"){
                //System.out.println(this.tokens.get(posicion-1)+ "a huevo");
                estadoAceptacion = false;
                error_siguientede_and = true;
            }
            if (this.tokens.get(posicion-1) != "and" ){
                estadoAceptacion = true;
            }
            //estadoAceptacion = true;
            return false;
        }
        else {
            return true;
        }
    }
}
