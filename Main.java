import java.util.Scanner;
public class Main{
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        Cliente cliente = new Cliente(null, null, null, 0, null, null, null, null, null);
        Conta conta = new Conta(0, 0, 0);
        contaCorrente contaCorrente = new contaCorrente();
        contaPoupanca contaPoupanca = new contaPoupanca();
        pessoaFisica pessoaFisica = new pessoaFisica(null, null, 0, null, null);
        pessoaJuridica pessoaJuridica = new pessoaJuridica(null, null, 0, null, null, null);
        sistema sistema = new sistema();
        Banco banco = new Banco();


    }
}
