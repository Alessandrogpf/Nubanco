public class contaCorrente extends Conta {
    protected double limCredito;

    //construtor
    public contaCorrente(double saldo, double numConta, double numAgencia, String nomeTitular, double limCredito){
        super(saldo, numConta, numAgencia, nomeTitular);
        this.limCredito = limCredito;
    }

    public double getLimcredito(){
        return limCredito;
      }
    public double setLimcredito(double limCredito){
        this.limCredito = limCredito;
      }
}
