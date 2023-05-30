public abstract class Conta {
    /* ATRIBUTOS */
    protected double saldo;
    protected double numConta;
    protected double numAgencia;
    protected double limCredito;
    
  
    //construtor
    public Conta(double saldo, double numConta, double numAgencia, double limCredito){
      this.saldo = saldo;
      this.numConta = numConta;
      this.numAgencia = numAgencia;
      this.limCredito = limCredito;
    }
  
    // ideia de método: transferencia
  // abstract transferencia
  // abstract deposito
  // empréstimo
  // limite do cartão de crédito
  
  
  public double getSaldo(){
    return saldo;
  }
  
  public double getNumconta(){
    return numConta;
  }

  public double getNumagencia(){
    return numAgencia;
  }
  public double getLimcredito(){
    return limCredito;
  }
  public double setLimcredito(double limCredito){
    this.limCredito = limCredito;
  }
  
  
  // não coloquei nenhum setter porque creio que saldo, numConta e numAgencia não devem ser alterados pelo usuário
  
  }