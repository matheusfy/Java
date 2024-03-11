public class BancoTerminal{

    public static void main(String []args){
        double saldo = 15;
        double valorSolicitado = 22;

        if(saldo >= valorSolicitado)
        {
            saldo = saldo - valorSolicitado;
        }
        else
        {
            System.out.println("Saldo Insuficiente");
        }

        System.out.println("Saldo atualizado: " + saldo);

    }
}