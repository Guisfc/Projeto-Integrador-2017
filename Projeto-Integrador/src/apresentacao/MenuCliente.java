package apresentacao;

import java.util.List;

import pojo.Autenticacao;
import pojo.Categoria;
import pojo.Cliente;
import pojo.Reserva;


public class MenuCliente extends MenuFuncionario {
    
	public MenuCliente() {
		
	}

        @Override
	public void categoria() {
		System.out.println("------------\n1. Listar\n------------");
		menu = sc.nextInt();
		if (menu == 1) { // LISTAR CATEGORIA -->
			List<Categoria> listaCategorias = categoriaDAO.buscarTodos(); // PERCORRE A TABELA CATEGORIA
			for (Categoria categoria : listaCategorias) {
				System.out.println("COD: " + categoria.getIdCategoria() + " | Tipo: " + categoria.getTipo() + " | Desc.: " + categoria.getDescricao() + " | Valor Diária: " + categoria.getValorDiaria() + "\n");
			}
		}
		menu = 0; // ZERA A VARIAVEL PARA O MENU RODAR NOVAMENTE -->
	}
        
	public void reserva(Autenticacao usuario) {
    		System.out.println("------------\n1. Realizar reserva\n------------");
    		menu = sc.nextInt();
    		if (menu == 1) { // INSERIR RESERVA -->
    			
    			Reserva reserva = new Reserva();
    			System.out.println("Informe a data de entrada da reserva: (dd/MM/yyyy)"); reserva.setDataEntrada(sc.next());
    			System.out.println("Informe a data de saida da reserva: (dd//MM/yyyy)"); reserva.setDataSaida(sc.next());
    			
    			List<Categoria> listaCategorias = categoriaDAO.buscarTodos();
    			for (Categoria categoria : listaCategorias) {
    				System.out.println("COD: " + categoria.getIdCategoria() + " | Tipo: " + categoria.getTipo() + " | Desc.: "	+ categoria.getDescricao() + " | Valor Diaria: " + categoria.getValorDiaria() + "\n");
    			}
    			
    			System.out.println("Informe o ID da categoria escolhida:");
    			reserva.setQuarto(reservaDAO.sortearQuarto(sc.nextInt()));
    			reserva.setCliente(clienteDAO.buscarPorId(usuario.getId())); 
    			
    			reservaDAO.salvar(reserva);
    			System.out.println("\n> Reserva (" + reserva.getIdReserva() + ") cadastrada com sucesso! \n");
    			
    		}
    		menu = 0; // ZERA A VARIAVEL PARA O MENU RODAR NOVAMENTE -->
	}
        
	public void cliente(Autenticacao usuario) {
		System.out.println("------------\n1. Editar informacoes pessoais\n------------");
		menu = sc.nextInt();
		if (menu == 1) { //EDITAR CLIENTE -->
                        Cliente cliente = new Cliente();
			cliente.setIdCliente(usuario.getId());
			System.out.println("-- Insira os novos dados --");
			System.out.println("Informe seu primeiro nome:"); cliente.setNome(sc.next());
			System.out.println("Informe seu sobrenome:"); cliente.setSobrenome(sc.next());
			System.out.println("Crie um nome de usuario:"); cliente.setLogin(sc.next());
			System.out.println("Crie uma senha:"); cliente.setSenha(sc.next());
			System.out.println("Informe seu CPF:"); cliente.setCpf(sc.next());
			System.out.println("Informe seu telefone:"); cliente.setTelefone(sc.next());
			
			clienteDAO.editar(cliente);
			System.out.println("\n> Suas informacoes foram editadas com sucesso!\n");
			
		}
		menu = 0; // ZERA A VARIAVEL PARA O MENU RODAR NOVAMENTE -->
	}


}