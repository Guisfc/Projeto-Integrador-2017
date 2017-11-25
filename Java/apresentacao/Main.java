package apresentacao;

import java.util.Scanner;
import persistencia.ClienteDAO;
import pojo.Cliente;

public class Main {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        MenuImpl hotel = new MenuImpl(); //INSTANCIA OBJETO PARA UTILIZAR METODOS DE MENU -->

        int menu; //USADA PARA ENTRAR NAS OPCOES -->

        

        do {
            System.out.println("--- Seja bem-vindo(a) ---\n1. Entrar\n2. Cadastre-se\n-------------------------");
            menu = sc.nextInt();
            if (menu == 1) {
                hotel.autenticar(); //FAZ A AUTENTICACAO DO USUARIO
            } else if (menu == 2) {
                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente cliente = new Cliente();
                System.out.println("Informe seu primeiro nome: (ex: Carlos)"); cliente.setNome(sc.next());
                System.out.println("Informe seu sobrenome: (ex: Silva)"); cliente.setSobrenome(sc.next());
                System.out.println("Crie um nome de usuario:"); cliente.setLogin(sc.next());
                System.out.println("Crie uma senha:"); cliente.setSenha(sc.next());
                System.out.println("Informe seu CPF:"); cliente.setCpf(sc.next());
                System.out.println("Informe seu telefone:"); cliente.setTelefone(sc.next());
                clienteDAO.salvar(cliente);
                System.out.println("Cadastrou-se com sucesso!\n");
            }
        } while (menu != 1);

        // INICIO DO MENU -->
        do {
            System.out.println("\n--- Menu ---\n1. Setores\n2. Funcionarios\n3. Clientes\n4. Limpeza\n5. Quartos\n6. Sair\n------------");
            menu = sc.nextInt();
            switch (menu) {
                case 1: // SETORES -->
                    hotel.setor();
                    break;

                case 2: // FUNCIONARIOS -->
                    hotel.funcionario();
                    break;

                case 3: // CLIENTES -->
                    hotel.cliente();
                    break;

                case 4: // LIMPEZA -->
                    hotel.limpeza();
                    break;

                case 5:
                    hotel.quarto(); // QUARTOS -->
                    break;

                case 6: //FECHAR SISTEMA -->
                    System.out.println("Sistema fechado com sucesso!");
                    break;
            }

        } while (menu != 6); //MUDAR CASE AO ADICIONAR NOVAS OPCOES
        // FIM DO MENU -->

    }

}
