package apresentacao;

import java.util.List;
import java.util.Scanner;

import persistencia.FuncionarioDAO;
import persistencia.LimpezaDAO;
import persistencia.SetorDAO;
import pojo.Funcionario;
import pojo.Limpeza;
import pojo.Setor;

public class MenuImpl implements Menu {
	Scanner sc = new Scanner(System.in);
	
	// INICIALIZANDO DAO's -->
	SetorDAO setorDAO = new SetorDAO();
	FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	LimpezaDAO limpezaDAO = new LimpezaDAO();
	// FIM DA INICIALIZAÇÃO -->
	
	int menu; //USADA PARA ENTRAR NAS OPCOES -->

	public MenuImpl() {
		
	}

	@Override
	public void setor() {
		System.out.println("------------\n1. Listar\n2. Inserir\n3. Editar\n4. Deletar\n------------");
		menu = sc.nextInt();
		if (menu == 1) { //LISTAR SETORES -->
			List<Setor> listaSetor = setorDAO.pesquisar(); //PERCORRE TABELA SETOR
			for (Setor setor : listaSetor) {
				System.out.println("ID: " + setor.getCodSetor() + " | Setor: " + setor.getSetor() + " | Salario: " + setor.getSalario() + "\n");
			}
		} else if (menu == 2) { //INSERIR SETOR -->
			Setor setor = new Setor();
			System.out.println("Informe um nome para o setor:"); setor.setSetor(sc.next());
			System.out.println("Informe o salário do setor:"); setor.setSalario(sc.nextDouble());
			setorDAO.salvar(setor);
			System.out.println("\n> Setor (" + setor.getSetor() + ") cadastrado com sucesso!\n");
		} else if (menu == 3) { //EDITAR SETOR
			
			List<Setor> listaSetor = setorDAO.pesquisar(); //PERCORRE TABELA SETOR
			for (Setor setor : listaSetor) {
				System.out.println("ID: " + setor.getCodSetor() + " | Setor: " + setor.getSetor() + " | Salario: " + setor.getSalario() + "\n");
			}
			
			Setor setor = new Setor();
			System.out.println("Informe o (ID) do setor que deseja editar:"); setor.setCodSetor(sc.nextLong());
			System.out.println("Informe um novo nome para o setor:"); setor.setSetor(sc.next());
			System.out.println("Informe o novo salário do setor:"); setor.setSalario(sc.nextDouble());
			setorDAO.editar(setor);
			System.out.println("\n> Setor editado com sucesso!\n");
		} else if (menu == 4) { //DELETAR SETOR
			
			List<Setor> listaSetor = setorDAO.pesquisar(); //PERCORRE TABELA SETOR
			for (Setor setor : listaSetor) {
				System.out.println("ID: " + setor.getCodSetor() + " | Setor: " + setor.getSetor() + " | Salario: " + setor.getSalario() + "\n");
			}
			
			System.out.println("Informe o (ID) do setor que deseja deletar:"); setorDAO.deletar(sc.nextLong());
			System.out.println("\n> Setor deletado com sucesso!\n");
		}
		menu = 0; // ZERA A VARIAVEL PARA O MENU RODAR NOVAMENTE -->
	}

	@Override
	public void funcionario() {
		System.out.println("------------\n1. Listar\n2. Inserir\n3. Editar\n4. Deletar\n------------");
		menu = sc.nextInt();
		if (menu == 1) { //LISTAR FUNCIONARIOS -->
			List<Funcionario> listaFuncionario = funcionarioDAO.pesquisar(); //PERCORRE TABELA FUNCIONARIO
			for (Funcionario funcionario : listaFuncionario) {
				System.out.println("ID: " + funcionario.getIdFuncionario() + " | Setor: " + funcionario.getCodSetor() + " | Nome: " + funcionario.getNome() + " " + funcionario.getSobrenome() +  " | Login: " + funcionario.getLogin() +  " | Senha: " + funcionario.getSenha() +  " | CPF: " + funcionario.getCpf() +  " | Telefone: " + funcionario.getTelefone() + "\n");
			}
		} else if (menu == 2) { //INSERIR FUNCIONARIO -->
			Funcionario funcionario = new Funcionario();
			System.out.println("Informe o primeiro nome do funcionario:"); funcionario.setNome(sc.next());
			System.out.println("Informe o sobrenome do funcionario:"); funcionario.setSobrenome(sc.next());
			System.out.println("Informe um nome de usuario para o funcionario:"); funcionario.setLogin(sc.next());
			System.out.println("Informe uma senha para o funcionario:"); funcionario.setSenha(sc.next());
			System.out.println("Informe o CPF do funcionario:"); funcionario.setCpf(sc.next());
			System.out.println("Informe o telefone do funcionario:"); funcionario.setTelefone(sc.next());
			System.out.println("Escolha um setor para o funcionario:\n");
			
			List<Setor> listaSetor = setorDAO.pesquisar(); //PERCORRE TABELA SETOR
			for (Setor setor : listaSetor) {
				System.out.println("ID: " + setor.getCodSetor() + " | Setor: " + setor.getSetor() + " | Salario: " + setor.getSalario() + "\n");
			}
			
			System.out.println("Informe o (ID) do setor escolhido:"); funcionario.setCodSetor(sc.nextLong());
			
			funcionarioDAO.salvar(funcionario);
			System.out.println("\n> Funcionario (" + funcionario.getNome() + " " + funcionario.getSobrenome() + ") cadastrado com sucesso!\n");
		} else if (menu == 3) { //EDITAR FUNCIONARIO
			
			List<Funcionario> listaFuncionario = funcionarioDAO.pesquisar(); //PERCORRE TABELA FUNCIONARIO
			for (Funcionario funcionario : listaFuncionario) {
				System.out.println("ID: " + funcionario.getIdFuncionario() + " | Setor: " + funcionario.getCodSetor() + " | Nome: " + funcionario.getNome() + " " + funcionario.getSobrenome() +  " | Login: " + funcionario.getLogin() +  " | Senha: " + funcionario.getSenha() +  " | CPF: " + funcionario.getCpf() +  " | Telefone: " + funcionario.getTelefone() + "\n");
			}
			
			Funcionario funcionario = new Funcionario();
			System.out.println("Informe o (ID) do funcionario que deseja editar:"); funcionario.setIdFuncionario(sc.nextLong());
			System.out.println("-- Insira os novos dados --");
			System.out.println("Informe o primeiro nome do funcionario:"); funcionario.setNome(sc.next());
			System.out.println("Informe o sobrenome do funcionario:"); funcionario.setSobrenome(sc.next());
			System.out.println("Informe um nome de usuario para o funcionario:"); funcionario.setLogin(sc.next());
			System.out.println("Informe uma senha para o funcionario:"); funcionario.setSenha(sc.next());
			System.out.println("Informe o CPF do funcionario:"); funcionario.setCpf(sc.next());
			System.out.println("Informe o telefone do funcionario:"); funcionario.setTelefone(sc.next());
			System.out.println("Escolha um setor para o funcionario:\n");
			
			List<Setor> listaSetor = setorDAO.pesquisar(); //PERCORRE TABELA SETOR
			for (Setor setor : listaSetor) {
				System.out.println("ID: " + setor.getCodSetor() + " | Setor: " + setor.getSetor() + " | Salario: " + setor.getSalario() + "\n");
			}
			
			System.out.println("Informe o (ID) do setor escolhido:"); funcionario.setCodSetor(sc.nextLong());
			funcionarioDAO.editar(funcionario);
			System.out.println("\n> Funcionario editado com sucesso!\n");
		} else if (menu == 4) { //DELETAR FUNCIONARIO
			
			List<Funcionario> listaFuncionario = funcionarioDAO.pesquisar(); //PERCORRE TABELA FUNCIONARIO
			for (Funcionario funcionario : listaFuncionario) {
				System.out.println("ID: " + funcionario.getIdFuncionario() + " | Setor: " + funcionario.getCodSetor() + " | Nome: " + funcionario.getNome() + " " + funcionario.getSobrenome() +  " | Login: " + funcionario.getLogin() +  " | Senha: " + funcionario.getSenha() +  " | CPF: " + funcionario.getCpf() +  " | Telefone: " + funcionario.getTelefone() + "\n");
			}
			
			System.out.println("Informe o (ID) do funcionario que deseja deletar:"); funcionarioDAO.deletar(sc.nextLong());
			System.out.println("\n> Funcionario deletado com sucesso!\n");
		}
		menu = 0; // ZERA A VARIAVEL PARA O MENU RODAR NOVAMENTE -->
	}

	@Override
	public void limpeza() {
		System.out.println("------------\n1. Listar\n2. Inserir\n3. Editar\n4. Deletar\n------------");
		menu = sc.nextInt();
		if (menu == 1) { //LISTAR LIMPEZA -->
			List<Limpeza> listaLimpeza = limpezaDAO.pesquisar(); //PERCORRE TABELA LIMPEZA
			for (Limpeza limpeza : listaLimpeza) {
				System.out.println("COD: " + limpeza.getCodLimpeza() + " | Data/Hora: " + limpeza.getDataHora() + " | Desc.: " + limpeza.getDescricao() + " | ID Funcionario: " + limpeza.getIdFuncionario() + " | Quarto: " + limpeza.getIdQuarto() + "\n");
			}
		} else if (menu == 2) { //INSERIR LIMPEZA -->
			Limpeza limpeza = new Limpeza();
			System.out.println("Informe a data que a limpeza foi efetuada (dd/mm/aaaa):"); limpeza.setDataHora(sc.next()); //arrumar nextline
			System.out.println("Informe uma descricao se necessario: (ex: itens quebrados)"); limpeza.setDescricao(sc.next()); //arrumar nextline
			System.out.println("Informe o funcionario que efetuou a limpeza:");
			
			List<Funcionario> listaFuncionario = funcionarioDAO.pesquisar(); //PERCORRE TABELA FUNCIONARIO
			for (Funcionario funcionario : listaFuncionario) {
				System.out.println("ID: " + funcionario.getIdFuncionario() + " | Setor: " + funcionario.getCodSetor() + " | Nome: " + funcionario.getNome() + " " + funcionario.getSobrenome() +  " | Login: " + funcionario.getLogin() +  " | Senha: " + funcionario.getSenha() +  " | CPF: " + funcionario.getCpf() +  " | Telefone: " + funcionario.getTelefone() + "\n");
			}
			
			System.out.println("Digite o (ID) referente:"); limpeza.setIdFuncionario(sc.nextLong());
			System.out.println("Informe o numero do quarto que foi limpo:"); limpeza.setIdQuarto(sc.nextLong());
			
			limpezaDAO.salvar(limpeza);
			System.out.println("\n> Limpeza no quarto (" + limpeza.getIdQuarto() + ") cadastrada com sucesso!\n");
		} else if (menu == 3) { //EDITAR LIMPEZA
			
			List<Limpeza> listaLimpeza = limpezaDAO.pesquisar(); //PERCORRE TABELA LIMPEZA
			for (Limpeza limpeza : listaLimpeza) {
				System.out.println("COD: " + limpeza.getCodLimpeza() + " | Data/Hora: " + limpeza.getDataHora() + " | Desc.: " + limpeza.getDescricao() + " | ID Funcionario: " + limpeza.getIdFuncionario() + " | Quarto: " + limpeza.getIdQuarto() + "\n");
			}
			
			Limpeza limpeza = new Limpeza();
			System.out.println("Informe o (COD) da limpeza que deseja editar:"); limpeza.setCodLimpeza(sc.nextLong());
			System.out.println("-- Insira os novos dados --");
			System.out.println("Informe a data/hora que a limpeza foi efetuada (dd/mm/aaaa hh:mm):"); limpeza.setDataHora(sc.next());
			System.out.println("Informe uma descricao se necessario: (ex: itens quebrados)"); limpeza.setDescricao(sc.next());
			System.out.println("Informe o funcionario que efetuou a limpeza:");
			
			List<Funcionario> listaFuncionario = funcionarioDAO.pesquisar(); //PERCORRE TABELA FUNCIONARIO
			for (Funcionario funcionario : listaFuncionario) {
				System.out.println("ID: " + funcionario.getIdFuncionario() + " | Setor: " + funcionario.getCodSetor() + " | Nome: " + funcionario.getNome() + " " + funcionario.getSobrenome() +  " | Login: " + funcionario.getLogin() +  " | Senha: " + funcionario.getSenha() +  " | CPF: " + funcionario.getCpf() +  " | Telefone: " + funcionario.getTelefone() + "\n");
			}
			
			System.out.println("Digite o (ID) referente:"); limpeza.setIdFuncionario(sc.nextLong());
			System.out.println("Informe o numero do quarto que foi limpo:"); limpeza.setIdQuarto(sc.nextLong());
			limpezaDAO.editar(limpeza);
			System.out.println("\n> Limpeza editada com sucesso!\n");
		} else if (menu == 4) { //DELETAR LIMPEZA
			
			List<Limpeza> listaLimpeza = limpezaDAO.pesquisar(); //PERCORRE TABELA LIMPEZA
			for (Limpeza limpeza : listaLimpeza) {
				System.out.println("COD: " + limpeza.getCodLimpeza() + " | Data/Hora: " + limpeza.getDataHora() + " | Desc.: " + limpeza.getDescricao() + " | ID Funcionario: " + limpeza.getIdFuncionario() + " | Quarto: " + limpeza.getIdQuarto() + "\n");
			}
			
			System.out.println("Informe o (COD) da limpeza que deseja deletar:"); limpezaDAO.deletar(sc.nextLong());
			System.out.println("\n> Limpeza deletada com sucesso!\n");
		}
		menu = 0; // ZERA A VARIAVEL PARA O MENU RODAR NOVAMENTE -->
	}

	@Override
	public void quarto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void categoria() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reserva() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cliente() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pagamento() {
		// TODO Auto-generated method stub
		
	}

}
