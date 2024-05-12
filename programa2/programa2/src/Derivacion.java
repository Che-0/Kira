// Se procesaran los token para ver si se pueden derviar o no
// recibe por ejemplo [not,(,true, and, false, ),] <---- Tiene que esta en una lista que contemga cada elemento;


import java.util.ArrayList;

public class Derivacion {

    ArrayList<String> tokens = new ArrayList<String>(); //lista que contendra los tokens
    int posicion = 0;  // contador que indicara la posicion de elemnto de la lista de tokens

    boolean usa_parentesis = false;
    boolean espera; // si usa_parentesis es true se analizara que espera sea false
    // ya que si es true significara que los de apertura nunca se cerraron

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
                }
            }
            //System.out.println("el estado es");
            //System.out.println(estadoAceptacion);
        }
        // null --- cadena invalida o linea en blanco
        if (this.tokens == null){
            estadoAceptacion = false;
        }
    }



    public int estadoS(int x){

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
            if (this.tokens.get(posicion).toString().equals("true") || this.tokens.get(posicion).toString().equals("false") || this.tokens.get(posicion).toString().equals("(") || this.tokens.get(posicion).toString().equals(")") || this.tokens.get(posicion).toString().equals("not")){

                return estadoT(posicion);

            }

            if (this.tokens.get(posicion).equals("or")) {
                //estadoX();
                //posicion += 1;
                //estadoX();
                return estadoE2(posicion);
            }
            return estadoS(posicion);
        }else{
            estadoAceptacion = false;
            posicion+=1;
            return estadoS(posicion);
        }
    }


    public int estadoE2(int x){
        posicion += 1;

        return estadoT(posicion);
    }

    public int estadoT(int x) {
        if (estadoX()) {
            if (this.tokens.get(posicion).equals("true") || this.tokens.get(posicion).equals("false") || this.tokens.get(posicion).equals("(") || this.tokens.get(posicion).equals(")") || this.tokens.get(posicion).equals("not")) {
                return estadoF(posicion);
                //System.out.println(posicion);
            }
            if (this.tokens.get(posicion).equals("and")) {
                //estadoX();
                //posicion += 1;
                return estadoT2(posicion);
            }
            return estadoE(posicion);

        }else {
            return estadoS(posicion);
        }
    }

    public int estadoT2(int x){
        posicion += 1;
        return estadoF(posicion);
    }


    public int estadoF(int x){
        if (estadoX())
        {


            if (this.tokens.get(posicion).equals("true") || this.tokens.get(posicion).equals("false")) {
                // //// estadoX();
                posicion += 1;

                return estadoF(posicion);
            }
            if (this.tokens.get(posicion).equals("(")) {
                //estadoX();
                usa_parentesis = true;
                posicion += 1;
                espera = true;
                return estadoF(posicion);
            }
            if (this.tokens.get(posicion).equals(")")) {
                //estadoX();
                espera = false;
                posicion += 1;

                return estadoF(posicion);
            }

            if (this.tokens.get(posicion).equals("not")) {
                //estadoX();
                return estadoF2(posicion);
            }

            return estadoT(posicion);
        }else {
            return estadoS(posicion);
        }


    }

    public int estadoF2(int x){
        posicion +=1;
        return estadoF(posicion);
    }

    public boolean estadoX(){

        if (posicion  > this.tokens.size()-1){
            estadoAceptacion = true;
            return false;
        }
        else {
            return true;
        }
    }
}
