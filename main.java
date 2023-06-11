import java.util.Scanner;

// clienteFisico(nome, data, cel, endereco, login, senha, email, cpf, rg, renda)
// clienteJuridico(nome, data, cel, endereco, login, senha, email, cnpj, fatura, razao)
// Conta(saldo, numConta, numAgencia, titular)

public class Main {
	public static void main(String[] args) {
		
		/******** 
		 * MAIN *
		 ********/
		Banco B = new Banco("Nubank2");
		
		Scanner sc = new Scanner(System.in);
		
		// Clientes pré-definidos
		clienteFisico cfexemplo = new clienteFisico("Bob Ferreira da Cruz", "23/05/2001", "992354356", "Centro", "Bob Ferreira", "senha123321", "BobFC@gmail.com", "123.667.901-45", "RG!", 300.0);
		clienteJuridico cjexemplo = new clienteJuridico("Rodrigo Nogueira Almeida", "29/07/1991", "991930338", "Rua Quinze", "Rodrigo Almeida", "rodrigãoXtreme", "RodrigoAlmeidaTrabalho@gmail.com", "43. 555. 101/0001-99", 700.0, "MEI");

		B.addClienteFisico(cfexemplo);
		B.addClienteJuridico(cjexemplo);
		
	
		int opcao = -1;
		
		while(opcao != 0) {
			exibirMenu();
			opcao = sc.nextInt();
            sc.nextLine();
			
            switch (opcao) {
            
            case 1:
            	perguntasCadastro(B, sc);
            	break;
            case 2:
                realizarDeposito(B, sc);
                break;
            case 3:
                realizarTransferencia(B, sc);
                break;
            case 4:
                realizarPix(B, sc);
                break;
            case 5:
                consultarSaldo(B, sc);
                break;
            case 6:
                alterarDadosCliente(B, sc);
                break;
            case 0:
                System.out.println("Encerrando...");
                break;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
                break;
        }
        System.out.println();
    }		
}
		
		/******** 
		 * MENU *
		********/
		public static void exibirMenu() {
	        System.out.println("----- MENU -----");
	        System.out.println("1. Abrir uma Conta");
	        System.out.println("2. Realizar Depósito");
	        System.out.println("3. Realizar Transferência");
	        System.out.println("4. Realizar PIX");
	        System.out.println("5. Consultar Saldo");
	        System.out.println("6. Alterar Dados do Cliente");
	        System.out.println("0. Sair");
	        System.out.print("Escolha uma opção: ");
		}
		
		public static void perguntasCadastro(Banco banco, Scanner scanner) {
			System.out.println("--- Cadastrando Conta ---");
			
			System.out.println("Selecione o tipo de cliente que você é: ");
			System.out.println("1. Físico");
			System.out.println("2. Jurídico");
			int x = scanner.nextInt();
			
			System.out.println("Selecione o tipo de serviço que deseja possuir: ");
			System.out.println("1. Poupança");
			System.out.println("2. Corrente");
			int y = scanner.nextInt();
			
			switch (x) {
			case 1:
				cadastrarClienteFisico(banco, scanner, y);
				break;
			case 2:
				cadastrarClienteJuridico(banco, scanner, y);
				break;
			default:
				System.out.println("Desculpe, selecione uma opção válida.");
				break;
			}
		}
		
		public static void cadastrarClienteFisico(Banco banco, Scanner scanner, int key) {
	        System.out.println("--- Cadastro de Cliente Físico ---");
	        
	        // Solicitar os dados do cliente físico
	        System.out.print("Nome: ");
	        String nome = scanner.nextLine();
	        // Consumir a quebra de linha pendente
	        scanner.nextLine();
	        
	        System.out.print("Data de Nascimento: ");
	        String data = scanner.nextLine();
	        
	        System.out.print("Número de celular: ");
	        String cel = scanner.nextLine();
	        
	        System.out.print("Endereço: ");
	        String endereco = scanner.nextLine();
	        
	        System.out.print("Crie um Login: ");
	        String login = scanner.nextLine();
	        
	        System.out.print("Crie uma senha: ");
	        String senha = scanner.nextLine();
	        
	        System.out.print("Digite seu email: ");
	        String email = scanner.nextLine();

	        System.out.print("CPF: ");
	        String cpf = scanner.nextLine();
	        
	        System.out.print("RG: ");
	        String rg = scanner.nextLine();
	        
	        System.out.print("Insira sua renda: ");
	        double renda = scanner.nextDouble();

	        // Criar um novo objeto
	        clienteFisico cf = new clienteFisico(nome, data, cel, endereco, login, senha, email, cpf, rg, renda);

	        // Adicionar o cliente ao banco   
	        try {
		        banco.addClienteFisico(cf);
		        
		        if(key == 1) {
		        	abrirContaPoupanca(banco, scanner, cf);
		        } else {
		        	abrirContaCorrente(banco, scanner, cf);
		        }
		        
	        	System.out.println("Cliente físico cadastrado com sucesso!");
	        } catch (RuntimeException e) {
	        	System.out.println(e.getMessage());
	        }
	    }

	    public static void cadastrarClienteJuridico(Banco banco, Scanner scanner, int key) {
	        System.out.println("--- Cadastro de Cliente Jurídico ---");
	        
	        // Solicitar os dados do cliente juridico
	        System.out.print("Nome: ");
	        String nome = scanner.nextLine();
	        // Consumir a quebra de linha pendente
	        scanner.nextLine();
	        
	        System.out.print("Data de Nascimento: ");
	        String data = scanner.nextLine();
	        
	        System.out.print("Número de celular: ");
	        String cel = scanner.nextLine();
	        
	        System.out.print("Endereço: ");
	        String endereco = scanner.nextLine();
	        
	        System.out.print("Crie um Login: ");
	        String login = scanner.nextLine();
	        
	        System.out.print("Crie uma senha: ");
	        String senha = scanner.nextLine();
	        
	        System.out.print("Digite seu email: ");
	        String email = scanner.nextLine();
	        
	        System.out.print("Insira seu CNPJ: ");
	        String cnpj = scanner.nextLine();
	        
	        System.out.print("Digite sua fatura: ");
	        double fatura = scanner.nextDouble();
	        // Consumir a quebra de linha pendente
	        scanner.nextLine();
	        
	        System.out.print("Razão Social: ");
	        String razao = scanner.nextLine();
	        
	        clienteJuridico cj = new clienteJuridico(nome, data, cel, endereco, login, senha, email, cnpj, fatura, razao);
	        
	        // Adicionar o cliente ao banco   
	        try {
		        banco.addClienteJuridico(cj);
		        
		        if(key == 1) {
		        	abrirContaPoupanca(banco, scanner, cj);
		        } else {
		        	abrirContaCorrente(banco, scanner, cj);
		        }
		        
	        	System.out.println("Cliente jurídico cadastrado com sucesso!");
	        } catch (RuntimeException e) {
	        	System.out.println(e.getMessage());
	        }
	        
	    }

	    public static void abrirContaPoupanca(Banco banco, Scanner scanner, Cliente c) {
	        System.out.println("--- Abertura de Conta Poupanca ---");
	        
        	// Conta(saldo, numConta, numAgencia, titular)
        	System.out.print("Seu saldo inicial: ");
        	double saldo = scanner.nextDouble();
            // Consumir a quebra de linha pendente
            scanner.nextLine();
        	
        	System.out.print("Seu número de conta: ");
        	String num = scanner.nextLine();
        	
        	System.out.print("O número da sua agência: ");
        	String ag = scanner.nextLine();
      	        
        	Cliente titular = c;
        	
        	System.out.print("Sua taxa de rendimento: ");
        	double taxaRendimento = scanner.nextDouble();
        	
        	contaPoupanca P = new contaPoupanca(saldo, num, ag, titular, taxaRendimento);
        	banco.addContaPoupanca(P);
	    }
	    
	    public static void abrirContaCorrente(Banco banco, Scanner scanner, Cliente c) {
	        System.out.println("--- Abertura de Conta ---");
	        
        	// Conta(saldo, numConta, numAgencia, titular)
        	System.out.print("Seu saldo inicial: ");
        	double saldo = scanner.nextDouble();
            // Consumir a quebra de linha pendente
            scanner.nextLine();
        	
        	System.out.print("Seu número de conta: ");
        	String num = scanner.nextLine();
        	
        	System.out.print("O número da sua agência: ");
        	String ag = scanner.nextLine();
        	
        	Cliente titular = c;
        	
        	System.out.print("Limite de crédito: ");
        	double lim = scanner.nextDouble();
        	
        	contaCorrente C = new contaCorrente(saldo, num, ag, titular, lim);
        	banco.addContaCorrente(C);
        	
	    }

	    public static void realizarDeposito(Banco banco, Scanner scanner) {
	        System.out.println("--- Realizar Depósito ---");
	        
	        System.out.print("Digite o número da conta: ");
	        String numeroConta = scanner.nextLine();
	        scanner.nextLine();
	        
	        Conta conta = banco.buscarConta(numeroConta);
	        
	        if (conta == null) {
	            System.out.println("Conta não encontrada. Verifique o número da conta e tente novamente.");
	            return;
	        }
	        
	        System.out.print("Informe o valor do depósito: ");
	        double valorDeposito = scanner.nextDouble();
	        scanner.nextLine();
	        
	        conta.depositar(valorDeposito);
	        
	    }

	    public static void realizarTransferencia(Banco banco, Scanner scanner) {
	        System.out.println("--- Realizar Transferência ---");
	        
	        System.out.print("Digite o número da conta de origem: ");
	        String numeroContaOrigem = scanner.nextLine();
	        
	        System.out.print("Digite o número da conta de destino: ");
	        String numeroContaDestino = scanner.nextLine();
	        
	        System.out.print("Digite o valor da transferência: ");
	        double valorTransferencia = scanner.nextDouble();

	        Conta contaOrigem = banco.buscarConta(numeroContaOrigem);
	        Conta contaDestino = banco.buscarConta(numeroContaDestino);

	        if (contaOrigem == null || contaDestino == null) {
	            System.out.println("Conta de origem ou conta de destino não encontrada.");
	            return;
	        }

	        contaOrigem.transferir(contaDestino, valorTransferencia);
	        
	    }
	    
	    public static void realizarPix(Banco banco, Scanner scanner) {
	        System.out.println("--- Realizar PIX ---");

	        System.out.print("Informe o número da conta de origem: ");
	        String numeroContaOrigem = scanner.nextLine();
	        scanner.nextLine();
	        
	        System.out.print("Informe a chave PIX de destino: ");
	        String chavePixDestino = scanner.nextLine();

	        System.out.print("Informe o valor a ser enviado: ");
	        double valor = scanner.nextDouble();
	        scanner.nextLine();
	        
	        Conta contaOrigem = banco.buscarContaCorrente(numeroContaOrigem);
	        
	        contaOrigem.fazerPix(chavePixDestino, valor);
	        
	        
	    }
	    
	    public static void consultarSaldo(Banco banco, Scanner scanner) {
	        System.out.println("--- Realizar Consulta ---");
	        
	        System.out.print("Insira seu email ou login: ");
	        String data = scanner.nextLine();
	        System.out.print("Insira sua senha: ");
	        String senha = scanner.nextLine();
	        
	        double s = banco.saldoConsulta(data, senha);
	        
	        if(s != -1) {
	        	System.out.println("Saldo atual: R$" + s);
	        } else {
	        	System.out.println("Nenhuma conta encontrada com essas credenciais");
	        }
	    }
	    
	    public static void alterarDadosCliente(Banco banco, Scanner scanner) {
	        System.out.println("--- Realizar Alteração ---");
	        
	    }	

}