/**
 * Singleton Apressado
 */

public class padraoSingletonA {
    
    private static padraoSingletonA instacia = new padraoSingletonA();;

    private padraoSingletonA(){
        super();
    }

    public static padraoSingletonA getInstacia(){
        return instacia;
    }  

}
