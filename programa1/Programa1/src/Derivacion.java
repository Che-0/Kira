// Se procesaran los token para ver si se pueden derviar o no
// recibe por ejemplo [not,(,true, and, false, ),] <---- Tiene que esta en una lista que contemga cada elemento;


import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.Arrays;

public class Derivacion {

    ArrayList<String> tokens = new ArrayList<String>(); //lista que contendra los tokens
    int posicion = 0;  // contador que indicara la posicion de elemnto de la lista de tokens

    boolean usa_parentesis = false;
    boolean espera;

    public boolean isEstadoAceptacion() {
        return estadoAceptacion;
    }

    boolean estadoAceptacion;
    public Derivacion(ArrayList tokens) {
        //tokens.remove(tokens.size()-1);
        this.tokens = tokens;

        System.out.println(this.tokens);   //para imprimir la lista y ver si esta bien
        //System.out.println(this.tokens.get(1)); //traer el primer elemento 2

        //inicial();
        int aux = estadoS(posicion);
//        if (espera){
//            estadoAceptacion = false;
//        }else{
//            estadoAceptacion = true;
//        }

        if(usa_parentesis){
            if (espera == true){
                estadoAceptacion = false;
        }
            if (espera == false){
                estadoAceptacion = true;
            }
        }
        System.out.println("el estado es");
        System.out.println(estadoAceptacion);

//        if (posicion > this.tokens.size()){
//            System.out.println("cadena chida");
//            return;
//        }
//        else{
//            System.out.println("huevos");
//        }
    }

    public void inicial(){
        int ll = estadoS(posicion);
        System.out.println("fin");
        return;
    }

    public int estadoS(int x){
        if (posicion <  this.tokens.size()-1){
            System.out.println("uwu");

            estadoE(posicion);
        }

        return 0;



        //return false;
    }

    public int estadoE(int x){
        if (estadoX()) {
            if (this.tokens.get(posicion).toString().equals("true") || this.tokens.get(posicion).toString().equals("false") || this.tokens.get(posicion).toString().equals("(") || this.tokens.get(posicion).toString().equals(")") || this.tokens.get(posicion).toString().equals("not")) {

                return estadoT(posicion);

            }
            if (this.tokens.get(posicion).equals("or")) {
                estadoX();
                posicion += 1;
                return estadoE(posicion);
            }
            return estadoS(posicion);
        }else{
            return estadoS(posicion);
        }
    }

    public int estadoT(int x) {
        if (estadoX()) {
            if (this.tokens.get(posicion).equals("true") || this.tokens.get(posicion).equals("false") || this.tokens.get(posicion).equals("(") || this.tokens.get(posicion).equals(")") || this.tokens.get(posicion).equals("not")) {
                return estadoF(posicion);
                //System.out.println(posicion);
            }
            if (this.tokens.get(posicion).equals("and")) {
                //estadoX();
                posicion += 1;
                return estadoT(posicion);
            }

//            if (this.tokens.get(posicion).equals("(")) {
//                //estadoX();
//                posicion += 1;
//                //espera que dira si se cerro el parentesis
//
//                return estadoT(posicion);
//            }



            return estadoE(posicion);

        }else {
            return estadoS(posicion);
        }
    }


    public int estadoF(int x){
        if (estadoX())
        {


            if (this.tokens.get(posicion).equals("true") || this.tokens.get(posicion).equals("false") || this.tokens.get(posicion).equals("not")) {
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

            return estadoT(posicion);
        }else {
            return estadoS(posicion);
        }


    }

    public boolean estadoX(){
        System.out.println(posicion);
        //System.out.println(this.tokens.size()-1);
        if (posicion  > this.tokens.size()-1){
            estadoAceptacion = true;
            //estadoS(posicion);
            return false;
        }
        else {
            return true;
        }
    }
}
