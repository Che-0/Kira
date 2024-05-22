// Se procesaran los token para ver si se pueden derviar o no
// recibe por ejemplo [not,(,true, and, false, ),] <---- Tiene que esta en una lista que contemga cada elemento;


import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.Arrays;

public class Derivacion {

    int errores = 0;

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

        //System.out.println(this.tokens);
        //System.out.println(this.tokens.get(1)); //traer el primer elemento 2


        if (this.tokens != null){
            int aux = estadoS(posicion);

            if(usa_parentesis){
                // no se encontro el parentesis de cierre ")" no se encontro
                if (espera == true){
                    estadoAceptacion = false;
                }
                // si se encontro
                if (espera == false){
                    estadoAceptacion = true;

                    if(es_and){
                        // no se encontro el siguiente token despues de and
                        if (espera_and == true){
                            estadoAceptacion = false;
                            //es_and = false;
                        }
                        // si se encontro
                        if (espera_and == false){
                            estadoAceptacion = true;
                        }
                    }
                    if (es_or);
                    {
                        if (espera_or == false) {
                            estadoAceptacion = true;
                        }
                        if (espera_or == true) {
                            estadoAceptacion = false;
                        }
                    }
                    if (espera_and != false & espera_or != false ){
                        estadoAceptacion = false;
                    }

                }
            }






            if (espera_and != false & espera_or != false ){
                estadoAceptacion = false;
            }

            // para saber si solo se puso un pinche ")" y ya alv
            if (usa_parentesiss != cierre_parentesiss){
                estadoAceptacion = false;
            }

            if (error_siguientede_and){
                estadoAceptacion = false;
            }

            //boolean es_or = false;
            //boolean espera_or; // si usa and entonces se esperara un token despues


            //System.out.println("el estado es");
            //System.out.println(estadoAceptacion);
        }
        // null --- cadena invalida o linea en blanco
        if (this.tokens == null){
            estadoAceptacion = false;
        }
    }



    public int estadoS(int x){
        errores +=1;
        if (errores>10){
            estadoAceptacion = false;
            return 0;
        }
        //en caso de que solo sea un elemento true false ...
        if (this.tokens.size()==1){
            //if (posicion <  this.tokens.size()){
            //System.out.println("nomas es uno");
            if (this.tokens.get(posicion).toString().equals("true") || this.tokens.get(posicion).toString().equals("false")){
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
            //espera_and = false;
            if (this.tokens.get(posicion).toString().equals("true") || this.tokens.get(posicion).toString().equals("false") || this.tokens.get(posicion).toString().equals("(") || this.tokens.get(posicion).toString().equals(")") || this.tokens.get(posicion).toString().equals("not")){

                return estadoT(posicion);

            }

            if (this.tokens.get(posicion).equals("or")) {
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
            //espera_and = false;
            if (this.tokens.get(posicion).equals("true") || this.tokens.get(posicion).equals("false") || this.tokens.get(posicion).equals("(") || this.tokens.get(posicion).equals(")") || this.tokens.get(posicion).equals("not")) {
                return estadoF(posicion);
                //System.out.println(posicion);
            }
            if (this.tokens.get(posicion).equals("and")) {
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
            //espera_and = false;

            if (this.tokens.get(posicion).equals("true") || this.tokens.get(posicion).equals("false") || this.tokens.get(posicion).equals("not")) {
                // //// estadoX();
                error_siguientede_and = false;
                espera_or = false;
                espera_and = false;
                posicion += 1;

                return estadoF(posicion);
            }
            if (this.tokens.get(posicion).equals("(")) {
                //estadoX();
                usa_parentesiss +=1 ; //para llevar la cuenta de esas madres
                usa_parentesis = true;
                posicion += 1;
                espera = true;
                return estadoF(posicion);
            }
            if (this.tokens.get(posicion).equals(")")) {
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
