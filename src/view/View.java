package view;

import java.util.ArrayList;

import src.Cine;
import src.Sala;

//VIEW LOGIN
public class View {
	
	final static int LARGURA_TELA = 50;
	
	//Main
	public static void view_000() {
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "BEM VINDO AO CINEMA", true));
		System.out.println(ViewS.construir_linha(LARGURA_TELA));
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "[1] Login"));
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "[2] Cadastrar"));
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "[3] Sair"));
		System.out.println(ViewS.construir_linha(LARGURA_TELA));
		System.out.print  ("|   >");
	}
	
	//Cadastro
	public static void view_001(int sub_state) {
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "BEM VINDO AO CINEMA", true));
		System.out.println(ViewS.construir_linha(LARGURA_TELA));
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "- Cadastro -"));
		System.out.println(ViewS.construir_linha(LARGURA_TELA));
		
		if(sub_state == 0)
			System.out.println(ViewS.construir_linha(LARGURA_TELA));
		else if(sub_state == -1)
			System.out.println(ViewS.construir_linha(LARGURA_TELA, "CPF inválido ou duplicado!"));
		else if(sub_state > 2)
			System.out.println(ViewS.construir_linha(LARGURA_TELA, "CADASTRO EFETUADO COM SUCESSO!"));
		
		if(sub_state < 1) {
			System.out.println(ViewS.construir_linha(LARGURA_TELA, "Digite seu CPF:"));
			System.out.println(ViewS.construir_linha(LARGURA_TELA, "Digite 'v' para voltar"));
		}
		
		if(sub_state == 1)
			System.out.println(ViewS.construir_linha(LARGURA_TELA, "Digite seu nome:"));
		else if(sub_state == 2)
			System.out.println(ViewS.construir_linha(LARGURA_TELA, "Digite sua senha:"));
		else if(sub_state == 3)
			System.out.println(ViewS.construir_linha(LARGURA_TELA, "Pressione ENTER para login"));
		System.out.println(ViewS.construir_linha(LARGURA_TELA));
		System.out.print  ("|   >");
		
	}
	
	//Login
	public static void view_002(int sub_state) {
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "BEM VINDO DE VOLTA", true));
		System.out.println(ViewS.construir_linha(LARGURA_TELA));
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "- Login -"));
		System.out.println(ViewS.construir_linha(LARGURA_TELA));
		
		if(sub_state == 0)
			System.out.println(ViewS.construir_linha(LARGURA_TELA));
		else if(sub_state == -1)
			System.out.println(ViewS.construir_linha(LARGURA_TELA, "CPF ou senha inválida!"));
		else if(sub_state == 2)
			System.out.println(ViewS.construir_linha(LARGURA_TELA, "LOGIN EFETUADO COM SUCESSO!"));
		
		if(sub_state < 1) {
			System.out.println(ViewS.construir_linha(LARGURA_TELA, "Digite seu CPF:"));
			System.out.println(ViewS.construir_linha(LARGURA_TELA, "Digite 'v' para voltar"));
		}
		
		else if(sub_state == 1)
			System.out.println(ViewS.construir_linha(LARGURA_TELA, "Digite sua senha:"));
		else if(sub_state == 2)
			System.out.println(ViewS.construir_linha(LARGURA_TELA, "Pressione ENTER para entrar"));
		
		System.out.println(ViewS.construir_linha(LARGURA_TELA));
		System.out.print  ("|   >");
	}
	
	public static void view_003() {
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "BEM VINDO AO CINEMA", true));
		System.out.println(ViewS.construir_linha(LARGURA_TELA));
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "[1] Filmes em cartaz"));
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "[2] Meus ingressos"));
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "[3] Voltar"));
		System.out.println(ViewS.construir_linha(LARGURA_TELA));
		System.out.print  ("|   >");
	}
	
	//Filmes
	public static void view_011(Cine cinema) {
		System.out.println(ViewS.construir_linha(106, "FILMES EM CARTAZ", true));
		System.out.println(ViewS.construir_linha(106));
		System.out.print(ViewS.construir_linha(8, "id"));
		System.out.print(ViewS.construir_linha(30, "nome"));
		System.out.print(ViewS.construir_linha(8, "ano"));
		System.out.print(ViewS.construir_linha(10, "duracão"));
		System.out.println(ViewS.construir_linha(50, "descrição"));
		
		//Obtém filmes em futuras sessões
		ArrayList<Integer> ids_filmes = new ArrayList<Integer>();
		cinema.get_filmes_futuros(ids_filmes);
		
		for(Integer id : ids_filmes) {
			//Printa id de cada filme da lista
			System.out.print(ViewS.construir_linha(8, String.valueOf( cinema.get_filme(id).get_id())));
			//Printa nome de cada filme da lista
			System.out.print(ViewS.construir_linha(30, cinema.get_filme(id).get_nome()));
			//Printa ano de cada filme da lista
			System.out.print(ViewS.construir_linha(8, String.valueOf( cinema.get_filme(id).get_ano())));
			//Printa duração de cada filme da lista
			System.out.print(ViewS.construir_linha(10, String.valueOf(cinema.get_filme(id).get_duracao() + " min")));
			//Printa descrição de cada filme da lista
			System.out.println(ViewS.construir_linha(50, String.valueOf(cinema.get_filme(id).get_descricao())));
		}
		
		System.out.println(ViewS.construir_linha(106));
		System.out.println(ViewS.construir_linha(106, "Digite o id do filme para ver sessoes"));
		System.out.println(ViewS.construir_linha(106, "Digite 'v' para sair"));
		System.out.println(ViewS.construir_linha(106, "Digite 'i' para ver seus ingressos"));
		System.out.println(ViewS.construir_linha(106));
		System.out.print  ("|   >");
	}
	
	//Ingressos
	public static void view_012(Cine cinema) {
		ArrayList<Integer> ids_ingressos = new ArrayList<Integer>();
		//Obtém ingressos relacionados ao cliente logado
		cinema.get_ingressos_cliente(ids_ingressos);
		
		System.out.println(ViewS.construir_linha(102, "INGRESSOS", true));
		
		//Cabeçalho tabela
		System.out.print(ViewS.construir_linha(10, "id"));
		System.out.print(ViewS.construir_linha(32, "data e hora"));
		System.out.print(ViewS.construir_linha(32, "sala"));
		System.out.println(ViewS.construir_linha(32, "fileira e coluna"));
		
		for(Integer id : ids_ingressos) {
			//Printa id de cada ingresso da lista
			System.out.print(ViewS.construir_linha(10, Integer.toString(id)));
			//Printa data e hora de cada ingresso da lista
			System.out.print(ViewS.construir_linha(32, cinema.get_sessao(cinema.get_ingresso(id).get_sessao_id()).get_data().toString()));
			//Printa sala de cada ingresso da lista
			System.out.print(ViewS.construir_linha(32, cinema.get_sala(cinema.get_sessao(cinema.get_ingresso(id).get_sessao_id()).get_id_sala()).get_nome()));
			//Printa coluna e fileira
			System.out.println(ViewS.construir_linha(32, cinema.get_ingresso(id).get_x() + " , " + cinema.get_ingresso(id).get_y()));
		}

		System.out.println(ViewS.construir_linha(102, "pressione ENTER para voltar"));
		System.out.println(ViewS.construir_linha(102));
		System.out.print  ("|   >");
	}
	
	//Sessao
	public static void view_013(Cine cinema, int id_filme) {
		System.out.println(ViewS.construir_linha(106, "SESSÕES DO FILME " + cinema.get_filme(id_filme).get_nome().toUpperCase(), true));
		System.out.println(ViewS.construir_linha(106));
		System.out.println(ViewS.construir_linha(106, "Descrição:"));
		
		//Garante que a descrição inteira seja exibida
		int i = 1;
		String descricao = new String(cinema.get_filme(id_filme).get_descricao());
		do{
			System.out.println(ViewS.construir_linha(106, descricao.toString()));
			if(descricao.length() > 103)
				descricao = descricao.substring(103 * i++);
			else
				break;
		}
		while(descricao.length() > 0);
		
		System.out.println(ViewS.construir_linha(106, "Sessões Futuras:", true));
		//Cabeçalho tabela
		System.out.print(ViewS.construir_linha(8, "id"));
		System.out.print(ViewS.construir_linha(49, "data e hora"));
		System.out.println(ViewS.construir_linha(49, "sala"));

		
		//Obtém sessões do filme escolhido
		ArrayList<Integer> ids_sessoes = new ArrayList<Integer>();
		cinema.get_sessoes_filme(id_filme, ids_sessoes);
			
		for(Integer id : ids_sessoes) {
			//Printa id de cada sessão da lista
			System.out.print(ViewS.construir_linha(8, String.valueOf(cinema.get_sessao(id).get_id())));
			//Printa data e hora de cada sessão da lista
			System.out.print(ViewS.construir_linha(49, cinema.get_sessao(id).get_data().toString()));
			//Printa sala de cada sessão da lista
			System.out.println(ViewS.construir_linha(49, cinema.get_sala(cinema.get_sessao(id).get_id_sala()).get_nome()));
		}
		
		if(ids_sessoes.isEmpty())
			System.out.println(ViewS.construir_linha(106, "Nenhuma sessão encontrada"));

		System.out.println(ViewS.construir_linha(106));
		System.out.println(ViewS.construir_linha(106, "Digite o id da sessão"));
		System.out.println(ViewS.construir_linha(106, "Digite 'v' para sair"));
		System.out.println(ViewS.construir_linha(106));
		System.out.print  ("|   >");
	}
	
	//Sala
	public static void view_014(Cine cinema, int id_sessao, ArrayList<Integer> ids_ingressos) {
		Sala sala = cinema.get_sala(cinema.get_sessao(id_sessao).get_id_sala());
		int largura_sala = sala.get_colunas();
		int altura_sala = sala.get_fileiras();
		int largura_tela = 0;
		
		//Obtém largura necessária da tela
		StringBuilder buffer = new StringBuilder("| ");
		for(int i = 0; i < largura_sala; i++)
			buffer.append(i + " ");
		largura_tela = buffer.length() + 5;
		
		//Título
		System.out.println(ViewS.construir_linha(largura_tela, "SESSÃO " + cinema.get_sessao(id_sessao).get_data().toString().toUpperCase(), true));
		System.out.println(ViewS.construir_linha(largura_tela));
		
		//Printa id's dos assentos
		System.out.print("|    ");
		for(int i = 0; i < largura_sala; i++)
			System.out.print(i + " ");
		System.out.println(" |");
		
		//Obtém lista de ingressos relacionados a sessão
		cinema.get_ingressos_sessao(id_sessao, ids_ingressos);
		
		//Exibe Sala
		for(int i = 0; i < altura_sala; i++) {
			System.out.print("| " + i);
			if(i < 10)
				System.out.print("  ");
			else
				System.out.print(" ");
			
			for(int j = 0; j < largura_sala; j++) {
				if(cinema.is_reservado(j, i, ids_ingressos))
					System.out.print("X ");
				else
					System.out.print("H ");
				
				if(j > 9)
					System.out.print(" ");
			}
			
			System.out.println(" |");
		}
		
		System.out.println(ViewS.construir_linha(largura_tela, "TELA", true));
		System.out.println(ViewS.construir_linha(largura_tela));
		System.out.println(ViewS.construir_linha(largura_tela, "Digite a coluna e a fileira desejada no seguinte formato:"));
		System.out.println(ViewS.construir_linha(largura_tela, "Coluna,Fileira"));
		System.out.println(ViewS.construir_linha(largura_tela));
		System.out.print  ("|   >");
	}
	
	//Confirmar compra
	public static void view_015(Cine cinema, int id_sessao, int coluna, int fileira){
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "CONFIRMAR COMPRA" + cinema.get_sessao(id_sessao).get_data().toString(), true));
		System.out.println(ViewS.construir_linha(LARGURA_TELA));
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "OPÇÃO ESCOLHIDA: " + coluna + " " + fileira));
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "Digite sua senha para confirmar compra"));
		System.out.println(ViewS.construir_linha(LARGURA_TELA));
		System.out.print  ("|   >");
	}
	
	//Assento Indisponível
	public static void view_016() {
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "ERRO 405", true));
		System.out.println(ViewS.construir_linha(LARGURA_TELA));
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "OPÇÃO ESCOLHIDA IDISPONÍVEL!"));
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "pressione ENTER para ver opções"));
		System.out.println(ViewS.construir_linha(LARGURA_TELA));
		System.out.print  ("|   >");
	}
	
	//Senha Inválida
	public static void view_017() {
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "ERRO 403", true));
		System.out.println(ViewS.construir_linha(LARGURA_TELA));
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "Senha inválida"));
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "pressione ENTER para voltar"));
		System.out.println(ViewS.construir_linha(LARGURA_TELA));
		System.out.print  ("|   >");
	}
	
	//Ingresso Comprado!
	public static void view_018() {
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "SUCESSO 404", true));
		System.out.println(ViewS.construir_linha(LARGURA_TELA));
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "Ingresso comprado com sucesso"));
		System.out.println(ViewS.construir_linha(LARGURA_TELA, "pressione ENTER para ver ingressos!"));
		System.out.println(ViewS.construir_linha(LARGURA_TELA));
		System.out.print  ("|   >");
	}
}
