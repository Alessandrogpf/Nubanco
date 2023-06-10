import java.util.*;

public class Banco{
  /*************
  * ATRIBUTOS *
  *************/
	private String nome;
	private List<clienteJuridico> ListJ;
	private List<clienteFisico> ListF;

	
	/*CONSTRUTOR*/
	public Banco (String nome){
		this.nome = nome;
		this.ListJ = new ArrayList<>();
		this.ListF = new ArrayList<>();
	}
	
  /***********
  * MÉTODOS *
  ***********/
	public void addClienteFisico(clienteFisico clienteFisico) {
		if (ListF.contains(clienteFisico)) {
            System.out.println("Erro: O cliente já existe em nosso sistema");
		}else {
            ListF.add(clienteFisico);
            System.out.println("Cliente foi adicionado com sucesso.");
        }
    }

	public void addClienteJuridico(clienteJuridico clienteJuridico) {
        if (ListJ.contains(clienteJuridico)) {
            System.out.println("Erro: O cliente já existe em nosso sistema.");
        } else {
            ListJ.add(clienteJuridico);
            System.out.println("Cliente foi adicionado com sucesso.");
        }
    }
  
    /********************* 
     * SETTERS E GETTERS *
    *********************/
	public String getNome() {
		return nome;
	}
  
}