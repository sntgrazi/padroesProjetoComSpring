public class Facade {
    
    //Criar uma interface mais simples para consumo.

    public void migrarCliente(String nome, String cep){
        String cidade = CepApi.getInstacia().recuperarCidade(cep);
        String estado = CepApi.getInstacia().recuperarEstado(cep);


        CrmService.gravarCliente(nome, cep, cidade, estado);

        
    }

}
