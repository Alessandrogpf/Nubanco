abstract class Conta {
    /* ATRIBUTOS */
    protected double saldo;
    protected double numConta;
    protected double numAgencia;
    protected String nomeTitular;
    protected double limCredito;
  
    //construtor
    public Conta(double saldo, double numConta, double numAgencia, String nomeTitular, double limCredito){
      this.saldo = saldo;
      this.numConta = numConta;
      this.numAgencia = numAgencia;
      this.nomeTitular = nomeTitular;
      this.limCredito = limCredito;
    }
  
    // abstract deposito
    public void depositar(double valor) {
        saldo += valor;
    }
    
    //transferencia
    public boolean transferir(Conta destinatario, double valor){
        if(valor <= saldo){
            saldo -= valor;
            destinatario.depositar(valor);
            return true;

        }else{
            return false;
        }
    }
    
    // consultar saldo
    public String getInfo() {
        return "Seu saldo é de R$" +saldo;
    }

    public double getNumconta(){
        return numConta;
    }

    public double getNumagencia(){
        return numAgencia;
    }

    public String getNomeTitular(){
        return nomeTitular;
    }

    public double getLimcredito(){
        return limCredito;
    }
  
  
  // não coloquei nenhum setter porque creio que saldo, numConta e numAgencia não devem ser alterados pelo usuário
  
  }
