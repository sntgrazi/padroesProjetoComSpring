/**
 * Singleton "Preguicoso"
 */

public class padraoSingletonP {
    
    private static padraoSingletonP instacia;

    private padraoSingletonP(){
        super();
    }

    public static padraoSingletonP getInstacia(){
        if(instacia == null) {
            instacia = new padraoSingletonP();
        }

        return instacia;
    }

}
