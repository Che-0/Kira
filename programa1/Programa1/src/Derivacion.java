// Se procesaran los token para ver si se pueden derviar o no
// recibe por ejemplo [not,(,true, and, false, ),] <---- Tiene que esta en una lista que contemga cada elemento;


import java.util.ArrayList;
import java.util.Arrays;

public class Derivacion {

    ArrayList<String> tokens = new ArrayList<String>(); //lista que contendra los tokens
    int posicion = 0;  // contador que indicara la posicion de elemnto de la lista de tokens
    public Derivacion(ArrayList tokens) {
        this.tokens = tokens;

        System.out.println(this.tokens);   //para imprimir la lista y ver si esta bien
        System.out.println(this.tokens.get(1)); //traer el primer elemento 2

//        if (this.tokens.get(1).toString().equals("(")){
//            System.out.println(tokens.get(1));
//            System.out.println("chdio");
//        }

        estadoS(posicion);
        if (posicion > this.tokens.size()){
            System.out.println("cadena chida");
            return;
        }
        else{
            System.out.println("huevos");
        }
    }

    public int estadoS(int x){
        System.out.println("uwu");

        estadoE(posicion);
        return 0;
        //return false;
    }

    public int estadoE(int x){
        if (this.tokens.get(posicion).toString().equals("true") || this.tokens.get(posicion).toString().equals("false")|| this.tokens.get(posicion).toString().equals("(")|| this.tokens.get(posicion).toString().equals(")") || this.tokens.get(posicion).toString().equals("not")){

            return estadoT(posicion);

        }
        if(this.tokens.get(posicion).equals("or")){
            posicion+=1;
            return estadoE(posicion);
        }
        return estadoS(posicion);
    }

    public int estadoT(int x) {
        if (this.tokens.get(posicion).equals("true") || this.tokens.get(posicion).equals("false") || this.tokens.get(posicion).equals(")") || this.tokens.get(posicion).equals("not")) {
            return estadoF(posicion);
            //System.out.println(posicion);
        }
        if(this.tokens.get(posicion).equals("and")){
            posicion+=1;
            return estadoT(posicion);
        }
        return estadoE(posicion);
    }


    public int estadoF(int x){
        if (this.tokens.get(posicion).equals("true") || this.tokens.get(posicion).equals("false") || this.tokens.get(posicion).equals(")") || this.tokens.get(posicion).equals("not")) {
            posicion+=1;
            return estadoF(posicion);
        }
        if (this.tokens.get(posicion).equals("(")) {
            posicion += 1;
            return estadoE(posicion);
        }
        return estadoT(posicion);
    }
}
