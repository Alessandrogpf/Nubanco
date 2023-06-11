import java.util.*;

public class Banco{
  /*************
  * ATRIBUTOS *
  *************/
	private String nome;
	private List<clienteJuridico> ListJ; // Juridico
	private List<clienteFisico> ListF;   // Fisico
	private List<contaCorrente> contaC;  // Corrente
	private List<contaPoupanca> contaP;  // Poupanca
	
	/*CONSTRUTOR*/
	public Banco(String nome){
		this.nome = nome;
		this.ListJ = new ArrayList<>();
		this.ListF = new ArrayList<>();
    this.contaC = new ArrayList<>();
    this.contaP = new ArrayList<>();
	}
	
  /***********
  * MÉTODOS *
  ***********/
	public void addClienteFisico(clienteFisico c) {
		for (clienteFisico l: ListF) {
			if(c.email.equals(l.email) && c.senha.equals(l.senha)) {
				throw new RuntimeException("Os dados fornecidos já estão cadastrados!");
			} 
		}
		
		if(c.idade < 18) {
			throw new IdadeMinimaException("Você não possui a idade mínima para usar nossos serviços");
		}
		
		ListF.add(c);
	}
	
	public void addClienteJuridico(clienteJuridico c) {
		for (clienteJuridico l: ListJ) {
			if(c.email.equals(l.email) && c.senha.equals(l.senha)) {
				throw new RuntimeException("Os dados fornecidos já estão cadastrados!");
			} 
		}
		
		if(c.idade < 18) {
			throw new IdadeMinimaException("Você não possui a idade mínima para usar nossos serviços");
		}
		
		ListJ.add(c);
	}

	// CONSULTA DE SALDO
	public double saldoConsulta(String data, String senha) {
		for (contaPoupanca p: contaP) {
			if(checkPermission(data, senha) == true) {
				return p.saldo;
			}
		}
		for (contaCorrente c: contaC) {
			if(checkPermission(data,senha) == true) {
				return c.saldo;
			}
		}
		return -1;
	}

  // ADICIONAR CONTAS
  public void addContaPoupanca(contaPoupanca c) {
		  contaP.add(c);
  }
	public void addContaCorrente(contaCorrente c) {
		  contaC.add(c);
	}

	// BUSCA CONTAS
	public Conta buscarConta(String num) {
		// POUPANÇA
		for(Conta c: contaP) {
			if(c.getNumconta().equals(num)) {
				return c;
			}
		}
		// CORRENTE
		for(Conta c2: contaC) {
			if(c2.getNumconta().equals(num)) {
				return c2;
			}
		}
		// Nada
		return null;
	}

  // REMOVE CONTAS
	public void removerConta(String num) {

	    // POUPANÇA
	    Iterator<contaPoupanca> iteratorP = contaP.iterator();
	    while (iteratorP.hasNext()) {
	        Conta conta = iteratorP.next();
	        if (conta.getNumconta().equals(num)) {
	            iteratorP.remove();
	        }
	    }

	    // CORRENTE
	    Iterator<contaCorrente> iteratorC = contaC.iterator();
	    while (iteratorC.hasNext()) {
	        Conta conta = iteratorC.next();
	        if (conta.getNumconta().equals(num)) {
	            iteratorC.remove();
	        }
	    }
	}
  
  /********************* 
  * SETTERS E GETTERS *
  *********************/
	public String getNome() {
		return nome;
	}
  
}