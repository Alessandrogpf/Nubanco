public class pessoaFisica extends Cliente{
    /* ATRIBUTOS */
    private String RG;
    private String comprovanteRenda;
  
    
  public pessoaFisica(String nome, String dataNascimento, int idade, String RG, String comprovanteRenda){
    super(nome, dataNascimento, idade);
    this.RG = RG;
    this.comprovanteRenda = comprovanteRenda;
    
  }
  
  
  
  
    
  }