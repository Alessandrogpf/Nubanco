public abstract class Conta {
    /* ATRIBUTOS */
    protected double saldo;
    protected double numConta;
    protected double numAgencia;
    
    
  
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
  
  
  
  // não coloquei nenhum setter porque creio que saldo, numConta e numAgencia não devem ser alterados pelo usuário
  
  }