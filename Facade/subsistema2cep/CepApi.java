public class CepApi {
    
    private static CepApi instacia = new CepApi();;

    private CepApi(){
        super();
    }

    public static CepApi getInstacia(){
        return instacia;
    } 
    
    public String recuperarCidade(String cep){
        return "Feira de Santana";
    }

    public String recuperarEstado(String cep){
        return "BA";
    }


}
