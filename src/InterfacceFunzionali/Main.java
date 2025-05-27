package InterfacceFunzionali;

public class Main {
    public static void main(String[] args){
        //in questa istanza il metodo astratto calcola viene implementado sommando i due parametri di ingresso
       operazione sum = (a,b) -> a+b ; //espressione lambda
        System.out.println(sum);

        //in questa istanza il metodo astratto calcola viene implementado moltiplicando tra loro i due parametri di ingresso
        operazione pro = (a,b) -> a*b ;
        System.out.println(pro);
    }
}