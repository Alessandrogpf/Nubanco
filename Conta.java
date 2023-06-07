abstract class Conta {
	/*************
	  * ATRIBUTOS *
	  *************/
	  protected double saldo;
	  private double numConta;
	  private double numAgencia;
	  private Cliente titular;
	  
	  /*CONSTRUTOR */
	  public Conta(double saldo, double numConta, double numAgencia, Cliente titular){
	    this.saldo = saldo;
	    this.numConta = numConta;
	    this.numAgencia = numAgencia;
	    this.titular = titular;
	    
	  }

	 /***********
	  * MÉTODOS *
	  ***********/

	  //DEPOSITAR
	  public void depositar(double valor){
	    if (valor > 0) {
	      saldo += valor;
	      System.out.println("Depósito realizado");
	    } else {
	      System.out.println("Valor inválido para depósito.");
	    }
	  }

	  //TRANSFERENCIA
	  public void transferir(Conta destino, double valor) {
	    if (valor > 0 && valor <= saldo) {
	        this.saldo -= valor;
	        destino.depositar(valor);
	        System.out.println("Transferência realizada");
	    } else {
	        System.out.println("Transferência inválida. Saldo insuficiente ou valor inválido.");
	    }

	  }
	  
	  /** MODIFICADORES DE DADOS **/
	  
	    // LOGIN CHECKER
	    public boolean loginCheck(String dado, String senha) {
	    	if ( (this.titular.login == dado || this.titular.email == dado) && this.titular.senha == senha) {
	    		// Caso o dado(string) fornecido seja o email ou login correto
	    		return true;
	    	} else {
	    		return false;
	    	}
	    }
	    
	    
	    // ALTERA NOME
	    public void alterarNome(String novoNome, String D, String S) {
	    	if (loginCheck(D, S) == true) {
	    		this.titular.nome = novoNome;
	    	} else {
	    		System.out.println("Informações incorretas");
	    	}
	    }
	    
	    // ALTERA SENHA
	    public void alterarSenha(String novaSenha, String D, String S) {
	    	if (loginCheck(D, S) == true) {
	    		this.titular.senha = novaSenha;
	    	} else {
	    		System.out.println("Informações incorretas");
	    	}
	    }
	    
	    // ALTERA LOGIN
	    public void alterarLogin(String novoLogin, String D, String S) {
	    	if (loginCheck(D, S) == true) {
	    		this.titular.login = novoLogin;
	    	} else {
	    		System.out.println("Informações incorretas");
	    	}
	    }
	    
	    // ALTERA EMAIL
	    public void alterarEmail(String novoEmail, String D, String S) {
	    	if (loginCheck(D, S) == true) {
	    		this.titular.email = novoEmail;
	    	} else {
	    		System.out.println("Informações incorretas");
	    	}
	    }
	  
	  /********************* 
	  * SETTERS E GETTERS *
	  *********************/
	  
	  public void getInfo() {
		  titular.getInfo();
		  System.out.println("Saldo: " + getSaldo());
		  System.out.println("Numero da Conta: " + getNumconta());
		  System.out.println("Numero da Agencia: " + getNumagencia());
	  }
	  
	  //CONSULTAR SALDO
	  public String getSaldo() {
	    return "R$" + saldo;
	  }

	  public double getNumconta(){
	    return numConta;
	  }

	  public double getNumagencia(){
	    return numAgencia;
	  }

	  public Cliente getTitular(){
	    return titular;
	  }
}

