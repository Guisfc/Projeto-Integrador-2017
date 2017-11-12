package apresentacao;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		MenuImpl hotel = new MenuImpl(); //INSTANCIA OBJETO PARA UTILIZAR METODOS DE MENU -->

		int menu; //USADA PARA ENTRAR NAS OPCOES -->

		// INICIO DO MENU -->
		do {
			System.out.println("--- Menu ---\n1. Setores\n2. Funcionarios\n3. Limpeza\n4. Sair\n------------");
			menu = sc.nextInt();
			switch (menu) {
				case 1: // SETORES -->
					hotel.setor();
					break;
					
				case 2: // FUNCIONARIOS -->
					hotel.funcionario();
					break;
					
				case 3: // LIMPEZA -->
					hotel.limpeza();
					break;
					
				case 4: //FECHAR SISTEMA -->
					System.out.println("Sistema fechado com sucesso!");
					break;
			}
			
		} while (menu != 4); //MUDAR CASE AO ADICIONAR NOVAS OPCOES
		// FIM DO MENU -->

	}

}
