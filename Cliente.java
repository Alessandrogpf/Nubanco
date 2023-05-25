public class Cliente extends Pessoa {
	/* ATRIBUTOS */
	private String numeroCelular;
	private String endereco;
	private String login;
	private String senha;
	private String email;  

	/* CONSTRUTOR */
	public Cliente(String nome, String CPF, String dataNascimento, int idade, String numeroCelular, String endereco, String login, String senha, String email){
		super(nome, CPF, dataNascimento, idade);
	    this.numeroCelular = numeroCelular;
	    this.endereco = endereco;
	    this.login = login;
	    this.senha = senha;
	    this.email = email;
	}
	
	/* MÉTODOS */

	String idadeMinima(int idade){
		if(idade < 18){
			return "Você não atende aos requisitos mínimos de idade para uso dos nossos serviços.";
		} else {
			return "Tudo certo!";
		}
	}
	

}