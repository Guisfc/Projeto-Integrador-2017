package apresentacao;

import java.util.List;
import java.util.Scanner;
import persistencia.CategoriaDAO;

import persistencia.ClienteDAO;
import persistencia.FuncionarioDAO;
import persistencia.LimpezaDAO;
import persistencia.QuartoDAO;
import persistencia.ReservaDAO;
import persistencia.SetorDAO;
import pojo.Categoria;
import pojo.Cliente;
import pojo.Funcionario;
import pojo.Limpeza;
import pojo.Quarto;
import pojo.Reserva;
import pojo.Setor;

public class MenuAdministrador implements Menu {
	
	Scanner sc = new Scanner(System.in);
	
	// INICIALIZANDO DAO's -->
	SetorDAO setorDAO = new SetorDAO();
	FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	LimpezaDAO limpezaDAO = new LimpezaDAO();
	ClienteDAO clienteDAO = new ClienteDAO();
        QuartoDAO quartoDAO = new QuartoDAO();
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        ReservaDAO reservaDAO = new ReservaDAO();
	// FIM DA INICIALIZACAO -->
	
	int menu; //USADA PARA ENTRAR NAS OPCOES -->

	public MenuAdministrador() {
		
	}
	
        @Override
	public void setor() {
		System.out.println("------------\n1. Listar\n2. Inserir\n3. Editar\n4. Deletar\n------------");
		menu = sc.nextInt();
		if (menu == 1) { //LISTAR SETORES -->
			List<Setor> listaSetor = setorDAO.pesquisar(); //PERCORRE TABELA SETOR
			for (Setor setor : listaSetor) {
				System.out.println("ID: " + setor.getCodSetor() + " | Setor: " + setor.getNomeSetor() + " | Salario: " + setor.getSalario() + "\n");
			}
		} else if (menu == 2) { //INSERIR SETOR -->
			Setor setor = new Setor();
			System.out.println("Informe um nome para o setor:"); setor.setNomeSetor(sc.next());
			System.out.println("Informe o sal�rio do setor:"); setor.setSalario(sc.nextDouble());
			setorDAO.salvar(setor);
			System.out.println("\n> Setor (" + setor.getNomeSetor() + ") cadastrado com sucesso!\n");
		} else if (menu == 3) { //EDITAR SETOR
			
			List<Setor> listaSetor = setorDAO.pesquisar(); //PERCORRE TABELA SETOR
			for (Setor setor : listaSetor) {
				System.out.println("ID: " + setor.getCodSetor() + " | Setor: " + setor.getNomeSetor() + " | Salario: " + setor.getSalario() + "\n");
			}
			
			Setor setor = new Setor();
			System.out.println("Informe o (ID) do setor que deseja editar:"); setor.setCodSetor(sc.nextLong());
			System.out.println("Informe um novo nome para o setor:"); setor.setNomeSetor(sc.next());
			System.out.println("Informe o novo sal�rio do setor:"); setor.setSalario(sc.nextDouble());
			setorDAO.editar(setor);
			System.out.println("\n> Setor editado com sucesso!\n");
		} else if (menu == 4) { //DELETAR SETOR
			
			List<Setor> listaSetor = setorDAO.pesquisar(); //PERCORRE TABELA SETOR
			for (Setor setor : listaSetor) {
				System.out.println("ID: " + setor.getCodSetor() + " | Setor: " + setor.getNomeSetor() + " | Salario: " + setor.getSalario() + "\n");
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
				System.out.println("ID: " + funcionario.getIdFuncionario() + " | Setor: " + funcionario.getSetor().getNomeSetor() + " | Nome: " + funcionario.getNome() + " " + funcionario.getSobrenome() +  " | Login: " + funcionario.getLogin() +  " | Senha: " + funcionario.getSenha() +  " | CPF: " + funcionario.getCpf() +  " | Telefone: " + funcionario.getTelefone() + "\n");
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
				System.out.println("ID: " + setor.getCodSetor() + " | Setor: " + setor.getNomeSetor() + " | Salario: " + setor.getSalario() + "\n");
			}
                        
			Setor setor = new Setor();
			System.out.println("Informe o (ID) do setor escolhido:"); setor.setCodSetor(sc.nextLong()); funcionario.setSetor(setor);
			funcionarioDAO.salvar(funcionario);
			System.out.println("\n> Funcionario (" + funcionario.getNome() + " " + funcionario.getSobrenome() + ") cadastrado com sucesso!\n");
		} else if (menu == 3) { //EDITAR FUNCIONARIO
			
			List<Funcionario> listaFuncionario = funcionarioDAO.pesquisar(); //PERCORRE TABELA FUNCIONARIO
			for (Funcionario funcionario : listaFuncionario) {
				System.out.println("ID: " + funcionario.getIdFuncionario() + " | Setor: " + funcionario.getSetor().getNomeSetor() + " | Nome: " + funcionario.getNome() + " " + funcionario.getSobrenome() +  " | Login: " + funcionario.getLogin() +  " | Senha: " + funcionario.getSenha() +  " | CPF: " + funcionario.getCpf() +  " | Telefone: " + funcionario.getTelefone() + "\n");
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
				System.out.println("ID: " + setor.getCodSetor() + " | Setor: " + setor.getNomeSetor() + " | Salario: " + setor.getSalario() + "\n");
			}
			
			Setor setor = new Setor();
			System.out.println("Informe o (ID) do setor escolhido:"); setor.setCodSetor(sc.nextLong()); funcionario.setSetor(setor);
			funcionarioDAO.editar(funcionario);
			System.out.println("\n> Funcionario editado com sucesso!\n");
		} else if (menu == 4) { //DELETAR FUNCIONARIO
			
			List<Funcionario> listaFuncionario = funcionarioDAO.pesquisar(); //PERCORRE TABELA FUNCIONARIO
			for (Funcionario funcionario : listaFuncionario) {
				System.out.println("ID: " + funcionario.getIdFuncionario() + " | Setor: " + funcionario.getSetor().getCodSetor() + " | Nome: " + funcionario.getNome() + " " + funcionario.getSobrenome() +  " | Login: " + funcionario.getLogin() +  " | Senha: " + funcionario.getSenha() +  " | CPF: " + funcionario.getCpf() +  " | Telefone: " + funcionario.getTelefone() + "\n");
			}
			
			System.out.println("Informe o (ID) do funcionario que deseja deletar:"); funcionarioDAO.deletar(sc.nextLong());
			System.out.println("\n> Funcionario deletado com sucesso!\n");
		}
		menu = 0; // ZERA A VARIAVEL PARA O MENU RODAR NOVAMENTE -->
	}

	@SuppressWarnings("resource")
        @Override
	public void limpeza() {
		System.out.println("------------\n1. Listar\n2. Inserir\n3. Editar\n4. Deletar\n------------");
		menu = sc.nextInt();
		if (menu == 1) { //LISTAR LIMPEZA -->
			List<Limpeza> listaLimpeza = limpezaDAO.pesquisar(); //PERCORRE TABELA LIMPEZA
			for (Limpeza limpeza : listaLimpeza) {
				System.out.println("COD: " + limpeza.getCodLimpeza() + " | Data/Hora: " + limpeza.getDataSql() + " | Desc.: " + limpeza.getDescricao() + " | Funcionario: " + limpeza.getFuncionario().getNome() + " " + limpeza.getFuncionario().getSobrenome() + " | Quarto: " + limpeza.getQuarto().getIdQuarto() + "\n");
			}
		} else if (menu == 2) { //INSERIR LIMPEZA -->
			Limpeza limpeza = new Limpeza();
			Scanner sc = new Scanner(System.in); //GAMBIARRA PRA O NEXTLINE NAO PULAR ETAPAS
			System.out.println("Informe a data e hora que a limpeza foi efetuada (dd/mm/aaaa HH:mm):"); limpeza.setData(sc.nextLine());
			System.out.println("Informe uma descricao se necessario: (ex: itens quebrados)"); limpeza.setDescricao(sc.nextLine());
			System.out.println("Informe o funcionario que efetuou a limpeza:");
			
			List<Funcionario> listaFuncionario = funcionarioDAO.pesquisar(); //PERCORRE TABELA FUNCIONARIO
			for (Funcionario funcionario : listaFuncionario) {
				System.out.println("ID: " + funcionario.getIdFuncionario() + " | Setor: " + funcionario.getSetor().getNomeSetor() + " | Nome: " + funcionario.getNome() + " " + funcionario.getSobrenome() +  " | Login: " + funcionario.getLogin() +  " | Senha: " + funcionario.getSenha() +  " | CPF: " + funcionario.getCpf() +  " | Telefone: " + funcionario.getTelefone() + "\n");
			}
			
                        Funcionario funcionario = new Funcionario();
			System.out.println("Digite o (ID) referente:"); funcionario.setIdFuncionario(sc.nextLong());
                        limpeza.setFuncionario(funcionario);
                        
                        Quarto quarto = new Quarto();
			System.out.println("Informe o numero do quarto que foi limpo:"); quarto.setIdQuarto(sc.nextLong());
                        limpeza.setQuarto(quarto);
			
                        quarto.setStatusLimpeza(1); 
                        quartoDAO.editarLimpeza(quarto);//MUDA O STATUS DO QUARTO PARA LIMPO
                        
			limpezaDAO.salvar(limpeza);
			System.out.println("\n> Limpeza no quarto (" + limpeza.getQuarto().getIdQuarto() + ") cadastrada com sucesso!\n");
		} else if (menu == 3) { //EDITAR LIMPEZA
			
			List<Limpeza> listaLimpeza = limpezaDAO.pesquisar(); //PERCORRE TABELA LIMPEZA
			for (Limpeza limpeza : listaLimpeza) {
				System.out.println("COD: " + limpeza.getCodLimpeza() + " | Data/Hora: " + limpeza.getDataSql() + " | Desc.: " + limpeza.getDescricao() + " | Funcionario: " + limpeza.getFuncionario().getNome() + " " + limpeza.getFuncionario().getSobrenome() + " | Quarto: " + limpeza.getQuarto().getIdQuarto() + "\n");
			}
			
			Limpeza limpeza = new Limpeza();
			System.out.println("Informe o (COD) da limpeza que deseja editar:"); limpeza.setCodLimpeza(sc.nextLong());
			Scanner sc = new Scanner(System.in); //GAMBIARRA PRA O NEXTLINE NAO PULAR ETAPAS
			System.out.println("Informe a data e hora que a limpeza foi efetuada (dd/mm/aaaa HH:mm):"); limpeza.setData(sc.nextLine());
			System.out.println("Informe uma descricao se necessario: (ex: itens quebrados)"); limpeza.setDescricao(sc.nextLine());
			System.out.println("Informe o funcionario que efetuou a limpeza:");
			
			List<Funcionario> listaFuncionario = funcionarioDAO.pesquisar(); //PERCORRE TABELA FUNCIONARIO
			for (Funcionario funcionario : listaFuncionario) {
				System.out.println("ID: " + funcionario.getIdFuncionario() + " | Setor: " + funcionario.getSetor().getNomeSetor() + " | Nome: " + funcionario.getNome() + " " + funcionario.getSobrenome() +  " | Login: " + funcionario.getLogin() +  " | Senha: " + funcionario.getSenha() +  " | CPF: " + funcionario.getCpf() +  " | Telefone: " + funcionario.getTelefone() + "\n");
			}
			
			System.out.println("Digite o (ID) referente:"); limpeza.getFuncionario().setIdFuncionario(sc.nextLong()); //ver se funciona
			System.out.println("Informe o numero do quarto que foi limpo:"); limpeza.getQuarto().setIdQuarto(sc.nextLong());
			limpezaDAO.editar(limpeza);
			System.out.println("\n> Limpeza editada com sucesso!\n");
		} else if (menu == 4) { //DELETAR LIMPEZA
			
			List<Limpeza> listaLimpeza = limpezaDAO.pesquisar(); //PERCORRE TABELA LIMPEZA
			for (Limpeza limpeza : listaLimpeza) {
				System.out.println("COD: " + limpeza.getCodLimpeza() + " | Data/Hora: " + limpeza.getDataSql() + " | Desc.: " + limpeza.getDescricao() + " | Funcionario: " + limpeza.getFuncionario().getNome() + " " + limpeza.getFuncionario().getSobrenome() + " | Quarto: " + limpeza.getQuarto().getIdQuarto() + "\n");
			}
			
			System.out.println("Informe o (COD) da limpeza que deseja deletar:"); limpezaDAO.deletar(sc.nextLong());
			System.out.println("\n> Limpeza deletada com sucesso!\n");
		}
		menu = 0; // ZERA A VARIAVEL PARA O MENU RODAR NOVAMENTE -->
	}

        @Override
	public void quarto() {
            	System.out.println("------------\n1. Listar\n2. Inserir\n3. Editar\n4. Deletar\n------------");
		menu = sc.nextInt();
		if (menu == 1) { //LISTAR QUARTOS -->
			List<Quarto> listaQuarto = quartoDAO.pesquisar(); //PERCORRE TABELA QUARTO
			for (Quarto quarto : listaQuarto) {
				System.out.println("Num: " + quarto.getIdQuarto() + " | Categoria: " +quarto.getCategoria().getTipo() + " | Disponivel: " + quarto.isDisponivel() + " | Limpo: " + quarto.isLimpo());
			}
		} else if (menu == 2) { //INSERIR QUARTO -->
                        Quarto quarto = new Quarto();
			Categoria categoriaQuarto = new Categoria();
                        
                        List<Categoria> listaCategorias = categoriaDAO.buscarTodos(); // PERCORRE A TABELA CATEGORIA
			for (Categoria categoria : listaCategorias) {
				System.out.println("COD: " + categoria.getIdCategoria() + " | Tipo: " + categoria.getTipo() + " | Desc.: " + categoria.getDescricao() + " | Valor Diária: " + categoria.getValorDiaria() + "\n");
			}
			
                        System.out.println("Informe a categoria do quarto:"); categoriaQuarto.setIdCategoria(sc.nextInt()); //juntar com daocategoria depois
			System.out.println("Digite 1 para confirmar:");
                        
                        quarto.setCategoria(categoriaQuarto);
                        quartoDAO.salvar(quarto);
                        System.out.println("\n> Quarto num. (" + quarto.getIdQuarto() + ") cadastrado com sucesso!\n");
			
		} else if (menu == 3) { //EDITAR QUARTO
			
			List<Quarto> listaQuarto = quartoDAO.pesquisar(); //PERCORRE TABELA QUARTO
			for (Quarto quarto : listaQuarto) {
				System.out.println("Num: " + quarto.getIdQuarto() + " | Categoria: " +quarto.getCategoria().getTipo() + " | Disponivel: " + quarto.isDisponivel() + " | Limpo: " + quarto.isLimpo());
			}
			
			Quarto quarto = new Quarto();
			System.out.println("\nInforme o (Num) do quarto que deseja editar:"); quarto.setIdQuarto(sc.nextLong());
                        
                        Categoria categoria = new Categoria();
			System.out.println("Informe o (ID) da nova categoria para o quarto:"); categoria.setIdCategoria(sc.nextInt()); 
                        
                        quarto.setCategoria(categoria);
			quartoDAO.editarCategoria(quarto);
			System.out.println("\n> Quarto editado com sucesso!\n");
		} else if (menu == 4) { //DELETAR QUARTO
			
			List<Quarto> listaQuarto = quartoDAO.pesquisar(); //PERCORRE TABELA QUARTO
			for (Quarto quarto : listaQuarto) {
				System.out.println("Num: " + quarto.getIdQuarto() + " | Categoria: " +quarto.getCategoria().getTipo() + " | Disponivel: " + quarto.isDisponivel() + " | Limpo: " + quarto.isLimpo());
			}
			
			System.out.println("Informe o (Num) do quarto que deseja deletar:"); quartoDAO.deletar(sc.nextLong());
			System.out.println("\n> Quarto deletado com sucesso!\n");
		}
		menu = 0; // ZERA A VARIAVEL PARA O MENU RODAR NOVAMENTE -->
		
	}

        @Override
	public void categoria() {
		System.out.println("------------\n1. Listar\n2. Inserir\n3. Editar\n4. Deletar\n------------");
		menu = sc.nextInt();
		if (menu == 1) { // LISTAR CATEGORIA -->
			List<Categoria> listaCategorias = categoriaDAO.buscarTodos(); // PERCORRE A TABELA CATEGORIA
			for (Categoria categoria : listaCategorias) {
				System.out.println("COD: " + categoria.getIdCategoria() + " | Tipo: " + categoria.getTipo() + " | Desc.: " + categoria.getDescricao() + " | Valor Diária: " + categoria.getValorDiaria() + "\n");
			}
		} else if (menu == 2) { // INSERIR CATEGORIA -->
			Categoria categoria = new Categoria();
			Scanner sc = new Scanner(System.in); // GAMBIARRA PRA O NEXTLINE NAO PULAR ETAPAS
			System.out.println("Informe o tipo da categoria:");
			categoria.setTipo(sc.nextLine());
			System.out.println("Informe uma descricao se necessario:");
			categoria.setDescricao(sc.nextLine());
			System.out.println("Informe o valor da diária:");
			categoria.setValorDiaria(sc.nextDouble());
			categoriaDAO.salvar(categoria);
			System.out.println("\n> Categoria (" + categoria.getTipo() + ") cadastrada com sucesso!\n");
		} else if (menu == 3) { // EDITAR CATEGORIA

			List<Categoria> listaCategorias = categoriaDAO.buscarTodos(); // PERCORRE TABELA CATEGORIA
			for (Categoria categoria : listaCategorias) {
				System.out.println("COD: " + categoria.getIdCategoria() + " | Tipo: " + categoria.getTipo() + " | Desc.: " + categoria.getDescricao() + " | Valor Diária: " + categoria.getValorDiaria() + "\n");
			}

			Categoria categoria = new Categoria();
			System.out.println("Informe o (COD) da categoria que deseja editar:");
			categoria.setIdCategoria(sc.nextInt());
			Scanner sc = new Scanner(System.in); // GAMBIARRA PRA O NEXTLINE NAO PULAR ETAPAS
			System.out.println("Informe o tipo da categoria:");
			categoria.setTipo(sc.nextLine());
			System.out.println("Informe uma descricao se necessario:");
			categoria.setDescricao(sc.nextLine());
			System.out.println("Informe o valor da diária:");
			categoria.setValorDiaria(sc.nextDouble());
			categoriaDAO.editar(categoria);
			System.out.println("\n> Categoria editada com sucesso!\n");
		} else if (menu == 4) { // DELETAR CATEGORIA

			List<Categoria> listaCategorias = categoriaDAO.buscarTodos(); // PERCORRE TABELA CATEGORIA
			for (Categoria categoria : listaCategorias) {
				System.out.println("COD: " + categoria.getIdCategoria() + " | Tipo: " + categoria.getTipo() + " | Desc.: " + categoria.getDescricao() + " | Valor Diária: " + categoria.getValorDiaria() + "\n");
			}
			System.out.println("Informe o (COD) da categoria que deseja deletar:");
			categoriaDAO.deletarPorId(sc.nextInt());
			System.out.println("\n> Categoria deletada com sucesso!\n");
		}
		menu = 0; // ZERA A VARIAVEL PARA O MENU RODAR NOVAMENTE -->
		
	}

	@Override
	public void reserva() {
		System.out.println("------------\n1. Listar\n2. Inserir\n3. Editar\n4. Check-out\n5. Deletar\n------------");
		menu = sc.nextInt();
		if (menu == 1) { // LISTAR RESERVAS -->
			
			List<Reserva> listaReservas = reservaDAO.buscarTodos(); // PERCORRE TABELA RESERVA
			for (Reserva reserva : listaReservas) {
				System.out.println("ID: " + reserva.getIdReserva() + " | Data de entrada: " + reserva.getDataSqlEntrada() + " | Data de saida: " + reserva.getDataSqlSaida() + " | Numero do quarto: " + reserva.getQuarto().getIdQuarto() + " | Cliente: " + reserva.getCliente().getNome() + " " +reserva.getCliente().getSobrenome());
			}
			
		} else if (menu == 2) { // INSERIR RESERVA -->
			
			Reserva reserva = new Reserva();
			System.out.println("Informe a data de entrada da reserva: (dd/MM/yyyy)"); reserva.setDataEntrada(sc.next());
			System.out.println("Informe a data de saida da reserva: (dd//MM/yyyy)"); reserva.setDataSaida(sc.next());
			
			List<Categoria> listaCategorias = categoriaDAO.buscarTodos();
			for (Categoria categoria : listaCategorias) {
				System.out.println("COD: " + categoria.getIdCategoria() + " | Tipo: " + categoria.getTipo() + " | Desc.: "	+ categoria.getDescricao() + " | Valor Diaria: " + categoria.getValorDiaria() + "\n");
			}
			
			System.out.println("Informe o ID da categoria escolhida:");
			reserva.setQuarto(reservaDAO.sortearQuarto(sc.nextInt()));
			
			List<Cliente> listaClientes = clienteDAO.buscarTodos(); //PERCORRE TABELA CLIENTE
			for (Cliente cliente : listaClientes) {
				System.out.println("ID: " + cliente.getIdCliente() + " | Nome: " + cliente.getNome() + " " + cliente.getSobrenome() +  " | Login: " + cliente.getLogin() +  " | Senha: " + cliente.getSenha() +  " | CPF: " + cliente.getCpf() +  " | Telefone: " + cliente.getTelefone() + "\n");
			}
			
			System.out.println("Informe o ID do cliente: ");
			reserva.setCliente(clienteDAO.buscarPorId(sc.nextLong()));

			reservaDAO.salvar(reserva);
			System.out.println("\n> Reserva (" + reserva.getIdReserva() + ") cadastrado com sucesso! \n");
			
		} else if (menu == 3) { // EDITAR RESERVA
			
			List<Reserva> listaReservas = reservaDAO.buscarTodos(); // PERCORRE TABELA RESERVA
			for (Reserva reserva : listaReservas) {
				System.out.println("ID: " + reserva.getIdReserva() + " | Data de entrada: " + reserva.getDataSqlEntrada() + " | Data de saida: " + reserva.getDataSqlSaida() + " | Numero do quarto: " + reserva.getQuarto().getIdQuarto() + " | Cliente: " + reserva.getCliente().getNome() + " " +reserva.getCliente().getSobrenome());
			}

			Reserva reserva = new Reserva();
			System.out.println("Informe o (ID) da reserva que deseja editar:");	reserva.setIdReserva(sc.nextLong());
			System.out.println("-- Insira os novos dados --");
			System.out.println("Informe a data de entrada da reserva: (dd/MM/yyyy)"); reserva.setDataEntrada(sc.next());
			System.out.println("Informe a data de saida da reserva: (dd//MM/yyyy)"); reserva.setDataSaida(sc.next());
			
			reservaDAO.editar(reserva);
			System.out.println("\n> Reserva editada com sucesso!\n");
			
		} else if (menu == 4) {//CHECKOUT
			
			List<Reserva> listaReservas = reservaDAO.buscarTodos(); // PERCORRE TABELA RESERVA
			for (Reserva reserva : listaReservas) {
				System.out.println("ID: " + reserva.getIdReserva() + " | Data de entrada: " + reserva.getDataSqlEntrada() + " | Data de saida: " + reserva.getDataSqlSaida() + " | Numero do quarto: " + reserva.getQuarto().getIdQuarto() + " | Cliente: " + reserva.getCliente().getNome() + " " +reserva.getCliente().getSobrenome());
			}
                        
                        Reserva reserva = new Reserva();
                        System.out.println("Informe o (ID) da reserva que deseja realizar check-out:"); reserva.setIdReserva(sc.nextLong());
                        reservaDAO.checkout(reserva);//pegar informacoes reserva/quarto
                        
                        Quarto quarto = new Quarto(); //mudar status quarto
                        quarto.setIdQuarto(reserva.getQuarto().getIdQuarto());
                        quarto.setStatusDisponivel(1);
                        quarto.setStatusLimpeza(0);
                        quartoDAO.editarDisponivel(quarto);
                        quartoDAO.editarLimpeza(quarto);
                        
                        reservaDAO.deletarPorId(reserva.getIdReserva());//deleta a reserva
                                
			System.out.println("\n> Check-out realizado com sucesso!\n");
		} else if (menu == 5) {//DELETAR
			
			List<Reserva> listaReservas = reservaDAO.buscarTodos(); // PERCORRE TABELA RESERVA
			for (Reserva reserva : listaReservas) {
				System.out.println("ID: " + reserva.getIdReserva() + " | Data de entrada: " + reserva.getDataSqlEntrada() + " | Data de saida: " + reserva.getDataSqlSaida() + " | Numero do quarto: " + reserva.getQuarto().getIdQuarto() + " | Cliente: " + reserva.getCliente().getNome() + " " +reserva.getCliente().getSobrenome());
			}
                        
                        
                        Reserva reserva = new Reserva();
                        System.out.println("Informe o (ID) da reserva que deseja deletar:"); reserva.setIdReserva(sc.nextLong());
                        reservaDAO.checkout(reserva);//pegar informacoes reserva/quarto
                        
                        Quarto quarto = new Quarto(); //mudar status quarto
                        quarto.setIdQuarto(reserva.getQuarto().getIdQuarto());
                        quarto.setStatusDisponivel(1);
                        quarto.setStatusLimpeza(1);
                        quartoDAO.editarDisponivel(quarto);
                        quartoDAO.editarLimpeza(quarto);
                        
                        reservaDAO.deletarPorId(reserva.getIdReserva());//deleta a reserva
                                
			System.out.println("\n> Reserva deletada com sucesso!\n");
		}
		menu = 0; // ZERA A VARIAVEL PARA O MENU RODAR NOVAMENTE -->
	}

        @Override
	public void cliente() {
		System.out.println("------------\n1. Listar\n2. Inserir\n3. Editar\n4. Deletar\n------------");
		menu = sc.nextInt();
		if (menu == 1) { //LISTAR CLIENTE -->
			List<Cliente> listaClientes = clienteDAO.buscarTodos(); //PERCORRE TABELA CLIENTE
			for (Cliente cliente : listaClientes) {
				System.out.println("ID: " + cliente.getIdCliente() + " | Nome: " + cliente.getNome() + " " + cliente.getSobrenome() +  " | Login: " + cliente.getLogin() +  " | Senha: " + cliente.getSenha() +  " | CPF: " + cliente.getCpf() +  " | Telefone: " + cliente.getTelefone() + "\n");
			}
		} else if (menu == 2) { //INSERIR CLIENTE -->
			Cliente cliente = new Cliente();
			System.out.println("Informe o primeiro nome do cliente:"); cliente.setNome(sc.next());
			System.out.println("Informe o sobrenome do cliente:"); cliente.setSobrenome(sc.next());
			System.out.println("Informe um nome de usuario para o cliente:"); cliente.setLogin(sc.next());
			System.out.println("Informe uma senha para o cliente:"); cliente.setSenha(sc.next());
			System.out.println("Informe o CPF do cliente:"); cliente.setCpf(sc.next());
			System.out.println("Informe o telefone do cliente:"); cliente.setTelefone(sc.next());
						
			clienteDAO.salvar(cliente);
			System.out.println("\n> Cliente (" + cliente.getNome() + " " + cliente.getSobrenome() + ") cadastrado com sucesso!\n");
		} else if (menu == 3) { //EDITAR CLIENTE
			
			List<Cliente> listaClientes = clienteDAO.buscarTodos(); //PERCORRE TABELA CLIENTE
			for (Cliente cliente : listaClientes) {
				System.out.println("ID: " + cliente.getIdCliente() + " | Nome: " + cliente.getNome() + " " + cliente.getSobrenome() +  " | Login: " + cliente.getLogin() +  " | Senha: " + cliente.getSenha() +  " | CPF: " + cliente.getCpf() +  " | Telefone: " + cliente.getTelefone() + "\n");
			}
			
			Cliente cliente = new Cliente();
			System.out.println("Informe o (ID) do cliente que deseja editar:"); cliente.setIdCliente(sc.nextLong());
			System.out.println("-- Insira os novos dados --");
			System.out.println("Informe o primeiro nome do cliente:"); cliente.setNome(sc.next());
			System.out.println("Informe o sobrenome do cliente:"); cliente.setSobrenome(sc.next());
			System.out.println("Informe um nome de usuario para o cliente:"); cliente.setLogin(sc.next());
			System.out.println("Informe uma senha para o cliente:"); cliente.setSenha(sc.next());
			System.out.println("Informe o CPF do cliente:"); cliente.setCpf(sc.next());
			System.out.println("Informe o telefone do cliente:"); cliente.setTelefone(sc.next());
			
			clienteDAO.editar(cliente);
			System.out.println("\n> Cliente editado com sucesso!\n");
		} else if (menu == 4) { //DELETAR CLIENTE
			
			List<Cliente> listaClientes = clienteDAO.buscarTodos(); //PERCORRE TABELA CLIENTE
			for (Cliente cliente : listaClientes) {
				System.out.println("ID: " + cliente.getIdCliente() + " | Nome: " + cliente.getNome() + " " + cliente.getSobrenome() +  " | Login: " + cliente.getLogin() +  " | Senha: " + cliente.getSenha() +  " | CPF: " + cliente.getCpf() +  " | Telefone: " + cliente.getTelefone() + "\n");
			}
			
			System.out.println("Informe o (ID) do cliente que deseja deletar:"); clienteDAO.deletarPorId(sc.nextLong());
			System.out.println("\n> Cliente deletado com sucesso!\n");
		}
		menu = 0; // ZERA A VARIAVEL PARA O MENU RODAR NOVAMENTE -->
	}


	

}