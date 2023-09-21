public class Teste {
    public static void main(String[] args) {

        // Strategy

        Comportamento normal = new ComportamentoNormal();
        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento agressivo = new ComportamentoAgressivo();

        Robo robo = new Robo();
        robo.setComportamento(agressivo);
        robo.mover();
        robo.setComportamento(defensivo);
        robo.mover();
    }
}
