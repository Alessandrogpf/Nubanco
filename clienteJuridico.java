public class pessoaJuridica extends {
    /* ATRIBUTOS */
    private String CNPJ;
    private String comprovanteFaturamento;
    private String contratoSocial;
  
    //construtor
    public pessoaJuridica(String nome, String dataNascimento, int idade, String CNPJ, String comprovanteFaturamento, String contratoSocial){
      super(nome, dataNascimento, idade);
      this.CNPJ = CNPJ;
      this.comprovanteFaturamento = comprovanteFaturamento;
      this.contratoSocial = contratoSocial;
      
    }
    
    
  
  
  
  
    
  }
