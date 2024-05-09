package src;
import java.util.ArrayList;
import java.util.Scanner;

import helpers.Cpf;
import view.View;
import view.ViewS;

public class Main {

	public static void main(String[] args){
		String state = "000";
		Cine cinema = new Cine(false);
		Scanner reader = new Scanner(System.in);
		
		int sub_state = 0;
		String input[] = new String[3];
		
		/*
		cinema.print_clientes();
		cinema.print_salas();
		cinema.print_filmes();
		cinema.print_sessoes();
		cinema.print_ingressos();
		*/
		
		System.out.println(ViewS.construir_linha(50,"pressione ENTER para iniciar", true));
		reader.nextLine();
		
		while(!state.equals("-00")) {
			
			//TELA INICIAL
			if(state.equals("000")) {
				sub_state = 0;
				
				ViewS.limpar_tela();
				View.view_000();
				
				//Impede entrada vazia
				while((input[0] = reader.nextLine()).isEmpty()) {}
							
				if(input[0].charAt(0) == '1') {
					//Vai para tela de login
					state = "002";
				}
				else if(input[0].charAt(0) == '2') {
					//Vai para tela de cadastro
					state = "001";
				}
				else if(input[0].charAt(0) == '3') {
					ViewS.limpar_tela();
					state = "-00";
				}
			}
			
			//CADASTRO DE USUÁRIO
			else if(state.equals("001")) {
				ViewS.limpar_tela();
				
				View.view_001(sub_state);
				
				//Input CPF
				if(sub_state < 1) {
					//Impede entrada vazia
					while((input[0] = reader.nextLine()).isEmpty()) {}
				
					if(Cpf.validar(input[0]))
						sub_state = 1;
					else
						sub_state = -1;
					
					//Voltar
					if(input[0].charAt(0) == 'v' || input[0].charAt(0) == 'V')
						state = "000";
				}
				
				//Input Nome
				else if(sub_state == 1) {
					//Impede entrada vazia
					while((input[1] = reader.nextLine()).isEmpty()) {}
					sub_state = 2;
				}
				
				//Input Senha
				else if(sub_state == 2){
					//Impede entrada vazia
					while((input[2] = reader.nextLine()).isEmpty()) {}
					
					//Valida cadastro e cadastra com senha hash
					if(cinema.cadastrar_cliente(input[0], input[1], input[2]))
						sub_state = 3;
					else
						sub_state = -1; //Caso o cadastro falhe volta para etapa inicial
				}
				
				//Ir para login
				else if(sub_state == 3) {
					reader.nextLine();
					//Reseta sub_state para a próxima tela
					sub_state = 0;
					//Vai para login
					state = "002";
				}
			}
			
			//LOGIN
			else if(state.equals("002")) {
				ViewS.limpar_tela();
				
				View.view_002(sub_state);
				
				//Input CPF
				if(sub_state < 1) {
					//Impede entrada vazia
					while((input[0] = reader.nextLine()).isEmpty()) {}
					
					sub_state = 1;
					
					//Voltar
					if(input[0].charAt(0) == 'v' || input[0].charAt(0) == 'V')
						state = "000";
				}
				//Input senha
				else if(sub_state == 1) {
					//Impede entrada vazia
					while((input[1] = reader.nextLine()).isEmpty()) {}
					
					//Validação de login e atribuição de usuario
					if(cinema.validar_login(input[0], input[1]))
						sub_state = 2;
					else
						sub_state = -1;
				}
				//CONFIRMAÇÃO DE LOGIN
				else if(sub_state == 2) {
					reader.nextLine();
					
					//Reseta sub state
					sub_state = 0;
					//Próxima tela
					state = "003";
				}
			}
			
			//Ingressos
			else if(state.equals("003")) {
				ViewS.limpar_tela();
				
				View.view_003();
				
				//Impede entrada vazia
				while((input[0] = reader.nextLine()).isEmpty()) {}
				
				if(input[0].charAt(0) == '1')
					state = "011";
				else if(input[0].charAt(0) == '2')
					state = "012";
				else if(input[0].charAt(0) == '3')
					state = "000";
			}
			
			//FILMES
			else if(state.equals("011")) {
				ViewS.limpar_tela();
				
				View.view_011(cinema);
				
				//Impede entrada vazia
				while((input[0] = reader.nextLine()).isEmpty()) {}
				
				if(input[0].charAt(0) == 'v' || input[0].charAt(0) == 'V') {
					state = "003";
				}
				else if(input[0].charAt(0) == 'i' || input[0].charAt(0) == 'I') {
					//Reseta sub_state
					sub_state = 0;
					//tela de ingressos
					state = "012";
				}
				else {
					//sub_state passa a ser o id escolhido(filme)
					sub_state = Integer.parseInt(input[0]);
					state = "013";
				}
			}
			
			//Ingressos
			else if(state.equals("012")) {
				ViewS.limpar_tela();
				
				View.view_012(cinema);
				
				reader.nextLine();
				
				state = "003";
			}
			
			//Sessões
			else if(state.equals("013")) {
				ViewS.limpar_tela();
				
				View.view_013(cinema, sub_state);
				
				//Impede entrada vazia
				while((input[0] = reader.nextLine()).isEmpty()) {}
					
				if(input[0].charAt(0) == 'v' || input[0].charAt(0) == 'V') {
					state = "011";
				}
				else {
					//sub_state passa a ser o id escolhido(sessao)
					sub_state = Integer.parseInt(input[0]);
					state = "014";
				}
			}
			
			//Sala
			else if(state.equals("014")) {
				ViewS.limpar_tela();
				
				//Lista de ingressos relacionados à sessão
				ArrayList<Integer> ids_ingressos = new ArrayList<Integer>();
				//sub_state = id_sessao
				View.view_014(cinema, sub_state, ids_ingressos);
				
				//Impede entrada vazia
				while((input[0] = reader.nextLine()).isEmpty()) {}
					
				if(input[0].charAt(0) == 'v' || input[0].charAt(0) == 'V') {
					state = "011";
				}
				else {
					String temp[] = input[0].split(",");
					
					if(temp.length == 2 ) {
						if(!cinema.is_reservado(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), ids_ingressos))
							state = "015";
						else
							state = "016";
					}
					else {
						state = "016";
					}
				}
			}
			//Confirmar compra
			else if(state.equals("015")) {
				ViewS.limpar_tela();
				
				String temp[] = input[0].split(",");
				int coluna = Integer.parseInt(temp[0]);
				int fileira = Integer.parseInt(temp[1]);
				//sub_state = sessao
				View.view_015(cinema, sub_state, Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
				
				//Senha
				while((input[0] = reader.nextLine()).isEmpty()) {}
				
				//Validação de senha
				if(cinema.validar_login(cinema.get_cliente_logado(), input[0])) {
					cinema.cadastrar_ingresso(cinema.get_sessao(sub_state), cinema.get_cliente(cinema.get_cliente_logado()), coluna, fileira);
					state = "018";
				}
				else {
					state = "017";
				}
				
			}
			
			//Assento Ocupado
			else if(state.equals("016")) {
				ViewS.limpar_tela();
				
				View.view_016();
				
				reader.nextLine();
				state = "014";
			}
			
			//Assento Ocupado
			else if(state.equals("017")){
				ViewS.limpar_tela();
				
				View.view_017();
				
				reader.nextLine();
				state = "014";
			}
			
			//Ingresso comprado
			else if(state.equals("018")) {
				ViewS.limpar_tela();
				
				View.view_018();
				
				reader.nextLine();
				//Vai para meus ingressos
				state = "012";
			}
		}
	}

}
