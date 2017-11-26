package apresentacao;

import java.util.Scanner;
import persistencia.ClienteDAO;
import pojo.Autenticacao;
import pojo.Cliente;

public class Main {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        Autenticacao usuario = new Autenticacao(); //USUARIO PARA LOGAR
        
        int menu; //USADA PARA ENTRAR NAS OPCOES -->
        
        // INICIO TELA LOGIN/CADASTRO -->
        do {
            System.out.println("--- Seja bem-vindo(a) ---\n1. Entrar\n2. Cadastre-se\n-------------------------");
            menu = sc.nextInt();
            if (menu == 1) {

                usuario.autenticar(usuario); //FAZ A AUTENTICACAO DO USUARIO
            } else if (menu == 2) {
                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente cliente = new Cliente();
                System.out.println("Informe seu primeiro nome: (ex: Carlos)");
                cliente.setNome(sc.next());
                System.out.println("Informe seu sobrenome: (ex: Silva)");
                cliente.setSobrenome(sc.next());
                System.out.println("Crie um nome de usuario:");
                cliente.setLogin(sc.next());
                System.out.println("Crie uma senha:");
                cliente.setSenha(sc.next());
                System.out.println("Informe seu CPF:");
                cliente.setCpf(sc.next());
                System.out.println("Informe seu telefone:");
                cliente.setTelefone(sc.next());
                clienteDAO.salvar(cliente);
                System.out.println("Cadastrou-se com sucesso!\n");
            }
        } while (menu != 1);
        // FIM TELA LOGIN/CADASTRO -->

        
        
        //###INICIO MENUS###
        
        // ADMINISTRADOR -->
        if (usuario.getTipo() == 3) { //SE USUARIO = ADMINISTRADOR - EXECUTAR MENU ADMIN
            MenuAdministrador menuAdministrador = new MenuAdministrador();
            do {
                System.out.println("\n--- Menu ---\n1. Setores\n2. Funcionarios\n3. Clientes\n4. Limpeza\n5. Quartos\n6. Categoria\n7. Reservas\n8. Sair\n------------");
                menu = sc.nextInt();
                switch (menu) {
                    case 1: // SETORES -->//PRONTO####
                        menuAdministrador.setor();
                        break;

                    case 2: // FUNCIONARIOS -->//PRONTO####
                        menuAdministrador.funcionario();
                        break;

                    case 3: // CLIENTES -->//PRONTO####
                        menuAdministrador.cliente();
                        break;

                    case 4: // LIMPEZA -->//PRONTO####
                        menuAdministrador.limpeza();
                        break;

                    case 5: // QUARTOS -->//PRONTO####
                        menuAdministrador.quarto();
                        break;
                        
                    case 6: // CATEGORIA -->//PRONTO####
                        menuAdministrador.categoria();
                        break;
                        
                    case 7: // RESERVA -->//PRONTO####
                        menuAdministrador.reserva();
                        break;

                    case 8: //FECHAR SISTEMA -->
                        System.out.println("Sistema fechado com sucesso!");
                        break;
                }

            } while (menu != 8); //MUDAR CASE AO ADICIONAR NOVAS OPCOES
            // FIM DO MENU -->
        } //FIM ADMINISTRADOR -->

        

        // CLIENTE -->
        if (usuario.getTipo() == 1) { //SE USUARIO = CLIENTE - EXECUTAR MENU CLIENTE
            MenuCliente menuCliente = new MenuCliente();
            do {
                System.out.println("\n--- Menu ---\n1. Reservar\n2. Categorias\n3. Informacoes\n4. Sair\n------------");
                menu = sc.nextInt();
                switch (menu) {
                    case 1: // RESERVAR -->//PRONTO####
                        menuCliente.reserva(usuario);
                        break;

                    case 2: // CATEGORIA -->//PRONTO####
                        menuCliente.categoria();
                        break;

                    case 3: // INFO --> //PRONTO####
                        menuCliente.cliente(usuario);
                        break;

                    case 4: //FECHAR SISTEMA -->
                        System.out.println("Sistema fechado com sucesso!");
                        break;
                }

            } while (menu != 4); //MUDAR CASE AO ADICIONAR NOVAS OPCOES
            // FIM DO MENU -->
        } //FIM CLIENTE -->
        
        
        // FUNCIONARIO -->
        if (usuario.getTipo() == 2) { //SE USUARIO = FUNCIONARIO - EXECUTAR MENU FUNCIONARIO
            MenuFuncionario menuFuncionario = new MenuFuncionario();
            do {
                System.out.println("\n--- Menu ---\n1. Setores\n2. Clientes\n3. Limpeza\n4. Quartos\n5. Reserva\n6. Categorias\n7. Sair\n------------");
                menu = sc.nextInt();
                switch (menu) {
                    case 1: // SETORES --> //PRONTO####
                        menuFuncionario.setor();
                        break;

                    case 2: // CLIENTES --> //PRONTO####
                        menuFuncionario.cliente();
                        break;

                    case 3: // LIMPEZA --> //PRONTO####
                        menuFuncionario.limpeza(usuario);
                        break;

                    case 4: // QUARTOS --> //PRONTO####
                        menuFuncionario.quarto(); 
                        break;

                    case 5: //RESERVA --> //PRONTO####
                        menuFuncionario.reserva();
                        break;
                        
                    case 6: //CATEGORIA --> //PRONTO####
                        menuFuncionario.categoria();
                        break;
                        
                    case 7: //FECHAR SISTEMA -->
                        System.out.println("Sistema fechado com sucesso!");
                        break;
                }

            } while (menu != 7); //MUDAR CASE AO ADICIONAR NOVAS OPCOES
            // FIM DO MENU -->
        } //FIM FUNCIONARIO -->

    }

}
