import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Cliente {
    /* ATRIBUTOS */
    private String nome;
    private String CPF;
    private String dataNascimento;
    private String dataAtual;
    private int idade;
    private String numeroCelular;
    private String endereco;
    private String login;
    private String senha;
    private String email;   

    public Cliente(String nome, String CPF, String dataNascimento, String numeroCelular, String endereco, String login, String senha, String email)
    {	
        this.nome = nome;
        this.CPF = CPF;
        
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
	
    private String getDataAtual() {
        Date data = Calendar.getInstance().getTime(); // Retorna o tempo/data de hoje
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy"); // Formato da data; exemplo: 03/04/2004
        return formatoData.format(data);
    }
    
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
    
    /********************* 
     * SETTERS E GETTERS *
     *********************/
    
    /** SETTERS **/
    public void setNome(String novoNome) {
    	this.nome = novoNome;
    }
    
    
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

}
