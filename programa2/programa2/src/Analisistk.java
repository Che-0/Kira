import java.util.ArrayList;
import java.util.Arrays;


// va linea por linea y agrupa los and, not, or ... para que no seab caracateres "a" , "n" ...
// las lineas vacias las retorna como Null y las que no terminen con ;

public class Analisistk {

    String[] palabra;
    boolean bien = true;
    public Analisistk() {

    }
    ArrayList<String>  pila = new ArrayList<String>();
    int contadorCaract = 0;
    public void Analisistk2(String palabra) {
        // para saber si la linea tiene algo
        if(palabra.trim().isEmpty()){
            pila.add("Null");
            return;}

        this.palabra = palabra.split("");
        int longitud = this.palabra.length;//

        //System.out.println(this.palabra[2]);

        while (contadorCaract < longitud){
            //analisamos los tokens hasta que lleguemos al final
            caracterr(this.palabra[contadorCaract]);
            if (!bien){
                //esa madre esta mal
                break;
            }

        }
        return ;
    }


    public void caracterr(String c ){

        switch (c){
            case " ":
                //System.out.println("nada +1");
                contadorCaract +=1;
                break;
            case "n":
                //System.out.println("n espero o");
                contadorCaract +=1;
                if (this.palabra[contadorCaract].equals("o")){
                    //System.out.println("o espero t");
                    contadorCaract +=1;
                }else{
                    this.bien = false;
                    return;
                }
                if (this.palabra[contadorCaract].equals("t")){
                    pila.add("not");
                    contadorCaract +=1;
                }else{
                    this.bien = false;
                    return;
                }
                break;

            case "a":
                //System.out.println("a espero n");
                contadorCaract +=1;
                if (this.palabra[contadorCaract].equals("n")){
                    //System.out.println("n espero d");
                    contadorCaract +=1;
                }else{
                    this.bien = false;
                    return;
                }
                if (this.palabra[contadorCaract].equals("d")){
                    //System.out.println("d esta chido");
                    pila.add("and");
                    contadorCaract +=1;
                }else{
                    this.bien = false;
                    return;
                }

//                if (this.palabra[contadorCaract].equals(" ")){
//                    //System.out.println("and esta chidoo");
//                    pila.add("and");
//                    contadorCaract +=1;
//                }else{
//                    this.bien = false;
//                    return;
//                }
                break;

            case "o":
                //System.out.println("o espero r");
                contadorCaract +=1;
                if (this.palabra[contadorCaract].equals("r")){
                    //System.out.println("r esta chido");
                    pila.add("or");
                    contadorCaract +=1;
                }else{
                    this.bien = false;
                    return;
                }
                break;

            case "t":
                //System.out.println("t espero r");
                contadorCaract +=1;
                if (this.palabra[contadorCaract].equals("r")){
                    //System.out.println("r espero u");
                    contadorCaract +=1;
                }else{
                    this.bien = false;
                    return;
                }

                if (this.palabra[contadorCaract].equals("u")){
                    //System.out.println("u espero e");
                    contadorCaract +=1;
                }else{
                    this.bien = false;
                    return;
                }

                if (this.palabra[contadorCaract].equals("e")){
                    //System.out.println("e esta chido");
                    pila.add("true");
                    contadorCaract +=1;
                }else{
                    this.bien = false;
                    return;
                }
                break;

            case "f":
                //System.out.println("f espero a");
                contadorCaract +=1;
                if (this.palabra[contadorCaract].equals("a")){
                    //System.out.println("a espero l");
                    contadorCaract +=1;
                }else{
                    this.bien = false;
                    return;
                }
                if (this.palabra[contadorCaract].equals("l")){
                    //System.out.println("l espero s");
                    contadorCaract +=1;
                }else{
                    this.bien = false;
                    return;
                }

                if (this.palabra[contadorCaract].equals("s")){
                    //System.out.println("s espero e");
                    contadorCaract +=1;
                }else{
                    this.bien = false;
                    return;
                }

                if (this.palabra[contadorCaract].equals("e")){
                    //System.out.println("e esta chido");
                    pila.add("false");
                    contadorCaract +=1;
                }else{
                    this.bien = false;
                    return;
                }

                break;

            case "(":
                //System.out.println("es un (");
                pila.add("(");
                contadorCaract +=1;
                break;

            case ")":
                //System.out.println("es un )");
                pila.add(")");
                contadorCaract +=1;
                break;

            case "N":
                //No hay nada
                pila.add("Null");
                this.bien = false;
                break;


            default:
                this.bien=false;
                return;

        }
    }





    // siitodo esta bien , se retornara pila que est un arraylist con los tokens
    // de no ser asi, retornara un null que significa que esta mal ese pedo
    public ArrayList<String> getPila() {
        if (!bien){
            return null;
        }
        return pila;

    }
}

