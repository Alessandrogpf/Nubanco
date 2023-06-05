import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Cliente {
	
    /*************
     * ATRIBUTOS *
     *************/
	
    protected String nome;
    protected String dataNascimento;
    protected String dataAtual;
    protected int idade;
    protected String numeroCelular;
    protected String endereco;
    protected String login;
    protected String senha;
    protected String email;   

    public Cliente(String nome, String dataNascimento, String numeroCelular, String endereco, String login, String senha, String email)
    {	
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.dataAtual = getDataAtual();
        this.idade = calcularIdade();
        
    	if (idade < 18) {
    		throw new RuntimeException("Você não atende aos requisitos mínimos de idade para uso dos nossos serviços.");
    	}
        
        this.numeroCelular = numeroCelular;
        this.endereco = endereco;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }
    
    /***********
     * MÉTODOS *
     ***********/
	
    // DATA DE HOJE
    private String getDataAtual() {
        Date data = Calendar.getInstance().getTime(); // Retorna o tempo/data de hoje
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy"); // Formato da data. Exemplo: 03/04/2004
        return formatoData.format(data);
    }
    
    // CALCULO DE IDADE
    private int calcularIdade() {
    	
    	/**** DATA DE NASCIMENTO ****/
        String[] dataNascimentoArray = dataNascimento.split("/");     // Separa a string no vetor através da barra '/'
        int diaNascimento = Integer.parseInt(dataNascimentoArray[0]); // DIA
        int mesNascimento = Integer.parseInt(dataNascimentoArray[1]); // MES
        int anoNascimento = Integer.parseInt(dataNascimentoArray[2]); // ANO
        /******* DATA ATUAL *******/
        String[] dataAtualArray = dataAtual.split("/"); // Mesma coisa
        int diaAtual = Integer.parseInt(dataAtualArray[0]); // DIA
        int mesAtual = Integer.parseInt(dataAtualArray[1]); // MES
        int anoAtual = Integer.parseInt(dataAtualArray[2]); // ANO

        /** CALCULA IDADE **/
        int idade = anoAtual - anoNascimento;

        if (mesAtual < mesNascimento || (mesAtual == mesNascimento && diaAtual < diaNascimento)) {
            idade--;
        }

        return idade;
    }
    
    // LOGIN CHECKER
    public boolean loginCheck(String dado, String senha) {
    	if ( (this.login == dado || this.email == dado) && this.senha == senha) {
    		// Caso o dado(string) fornecido seja o email ou login correto
    		return true;
    	} else {
    		return false;
    	}
    }
    
    /** MODIFICADORES DE DADOS **/
    // ALTERA NOME
    public void alterarNome(String novoNome, String D, String S) {
    	if (loginCheck(D, S) == true) {
    		this.nome = novoNome;
    	} else {
    		;
    	}
    }
    
    // ALTERA SENHA
    public void alterarSenha(String novaSenha, String D, String S) {
    	if (loginCheck(D, S) == true) {
    		this.senha = novaSenha;
    	} else {
    		;
    	}
    }
    
    // ALTERA LOGIN
    public void alterarLogin(String novoLogin, String D, String S) {
    	if (loginCheck(D, S) == true) {
    		this.login = novoLogin;
    	} else {
    		;
    	}
    }
    
    // ALTERA EMAIL
    public void alterarEmail(String novoEmail, String D, String S) {
    	if (loginCheck(D, S) == true) {
    		this.email = novoEmail;
    	} else {
    		;
    	}
    }
    
    /********************* 
     * SETTERS E GETTERS *
     *********************/
    
    /** GETTERS **/
    public String getNome() {
    	return nome;
    }
    
    public int getIdade() {
    	return idade;
    }
    
    public String getDataNascimento() {
    	return dataNascimento;
    }
    
    public String getCelular() {
    	return numeroCelular;
    }

	public String getEndereco() {
    	return endereco;
    }
    
    public String getLogin() {
    	return login;
    }

	public String getEmail() {
    	return email;
    }

}
