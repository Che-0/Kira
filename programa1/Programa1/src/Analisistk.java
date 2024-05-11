import java.util.ArrayList;
import java.util.Arrays;

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
        //////

        this.palabra = palabra.split("");
        //System.out.println("la palabra es "+palabra);
        // Imprime el arreglo de strings
        //System.out.println(Arrays.toString(this.palabra));
        //System.out.println(this.palabra.length);
        int longitud = this.palabra.length;//

        //System.out.println(this.palabra[2]);

        while (contadorCaract < longitud){
            //analisamos los tokens hasta que lleguemos al final
            caracterr(this.palabra[contadorCaract]);
            if (!bien){
                //System.out.println("esa madre esta mal mister");
                break;
            }

        }
        //System.out.println(pila);
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
                    //System.out.println("t ta chido");
//                    if (this.palabra[contadorCaract+1].equals(" ") || this.palabra[contadorCaract].equals("(") ) {
//                        pila.add("not");
//                        contadorCaract +=1;
//                    }else{
//                        this.bien = false;
//                        pila.add("Null");
//                        return;
//                    }


                    pila.add("not");
                    contadorCaract +=1;
                }else{
                    this.bien = false;
                    return;
                }

                //////////////////////////////////////
//                if (this.palabra[contadorCaract].equals(" ") || this.palabra[contadorCaract].equals("(") ){
//                    //System.out.println("t ta chido");
//                    //pila.add("not");
//                    //contadorCaract +=1;
//                }else{
//                    this.bien = false;
//                    return;
//                }
//                if (this.palabra[contadorCaract].equals(" ")){
//                    System.out.println("not esta chdio");
//                    pila.add("not");
//                    contadorCaract +=1;
//                }else{
//                    this.bien = false;
//                    return;
//                }

                //caracterr(this.palabra[contadorCaract]);

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
                    contadorCaract +=1;
                }else{
                    this.bien = false;
                    return;
                }

                if (this.palabra[contadorCaract].equals(" ")){
                    //System.out.println("and esta chidoo");
                    pila.add("and");
                    contadorCaract +=1;
                }else{
                    this.bien = false;
                    return;
                }
                break;

            case "o":
                //System.out.println("o espero r");
                contadorCaract +=1;
                if (this.palabra[contadorCaract].equals("r")){
                    //System.out.println("r esta chido");
                    contadorCaract +=1;
                }else{
                    this.bien = false;
                    return;
                }

                if (this.palabra[contadorCaract].equals(" ")){
                    //System.out.println("or esta chido");
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

//                if (this.palabra[contadorCaract].equals(" ")){
//                    //System.out.println("true esta chido");
//                    pila.add("true");
//                    contadorCaract +=1;
//                }else{
//                    this.bien = false;
//                    return;
//                }
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

//                if (this.palabra[contadorCaract].equals(" ")){
//                    //System.out.println("false esta chido");
//                    pila.add("false");
//                    contadorCaract +=1;
//                }else{
//                    this.bien = false;
//                    return;
//                }

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
                //System.out.println("No hay nada )");
                pila.add("Null");
                this.bien = false;
                break;


            default:
                //System.out.println("ni idea we");
                //pila.add("invalido");
                this.bien=false;
                return;
            //throw new IllegalStateException("Unexpected value: " + c);
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
