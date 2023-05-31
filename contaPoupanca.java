public class contaPoupanca extends Conta {
    /* Atributos */
  private double taxaRendimento; // Rendimento da poupança do mês

  public contaPoupanca(double saldo, double numConta, double numAgencia, String nomeTitular, double taxaRendimento){
    super(saldo, numConta, numAgencia, nomeTitular);
    this.taxaRendimento = taxaRendimento;
  }

  public double getTaxaRendimento(){
    return taxaRendimento;
  }
}
