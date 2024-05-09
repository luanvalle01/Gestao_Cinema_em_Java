package src;
import java.util.ArrayList;

import helpers.FileManager;

//PROGRAMAR VIEW
/*FUNCOES DE BUSCA DE
 *CLIENTES (Apenas user)
 *SALAS (Apenas admin)
 *FILMES (Apenas admin)
 *SESSOES (Apenas admin)
 *INGRESSOS (Apenas user)
 */

/*FUNCOES DE VISUALIZAÇÃO DE
 *CLIENTES (Apenas admin)
 *SALAS (user: apenas sala específica | admin: todos os filtros)
 *FILMES (ambos)
 *SESSOES (user: p/ filme específico | admin: todos os filtros)
 *INGRESSOS (Apenas user)
 */

//CRIAR TELAS QUE EXIBAM APENAS OS INFORMAÇÕES CONVENIENTES PARA CLIENTE
//APENAS SESSÕES FUTURAS
//APENAS FILMES EM SESSÕES FUTURAS...

public class Cine {
	private boolean debug;
	
	private String cliente;
	private ArrayList<String>buffer;

	private ArrayList<Cliente>clientes;
	private ArrayList<Sala>salas;
	private ArrayList<Filme>filmes;
	private ArrayList<Sessao>sessoes;
	private ArrayList<Ingresso>ingressos;
	
	public Cine(boolean debug){
		//Setup do programa
		this.debug = debug;
		this.cliente = new String();
		buffer = new ArrayList<String>();
		
		clientes  = new ArrayList<Cliente>();
		salas  = new ArrayList<Sala>();
		filmes  = new ArrayList<Filme>();
		sessoes  = new ArrayList<Sessao>();
		ingressos  = new ArrayList<Ingresso>();
		
		FileManager.ler_arquivo("clientes.txt", buffer);
		for(String linhas : buffer) {
			clientes.add(new Cliente(linhas));
		}
		
		FileManager.ler_arquivo("salas.txt", buffer);
		for(String linhas : buffer) {
			salas.add(new Sala(linhas));
		}
		
		FileManager.ler_arquivo("filmes.txt", buffer);
		for(String linhas : buffer) {
			filmes.add(new Filme(linhas));
		}
		
		FileManager.ler_arquivo("sessoes.txt", buffer);
		for(String linhas : buffer) {
			sessoes.add(new Sessao(linhas));
		}
		
		FileManager.ler_arquivo("ingressos.txt", buffer);
		for(String linhas : buffer) {
			ingressos.add(new Ingresso(linhas));
		}
	}

	//CADASTROS
	public boolean cadastrar_cliente(String cpf, String nome, String senha){
		boolean duplicado = false;
		
		//Verifica duplicidade
		for(Cliente cliente : this.clientes) {
			if(cliente.get_cpf().equals(cpf))
				duplicado = true;
		}
		
		Cliente buffer = new Cliente(cpf, nome, senha);
		if(buffer.existe() && !duplicado) {
			clientes.add(buffer);
			
			FileManager.escrever_ultima_linha("clientes.txt", buffer.get_infos());
			return true;
		}
		return false;
	}

	public boolean cadastrar_sala(String nome_sala, int colunas, int fileiras){
		Sala buffer = new Sala(nome_sala, colunas, fileiras);
		salas.add(buffer);
		FileManager.escrever_ultima_linha("salas.txt", buffer.get_infos());
		
		return true;
	}

	public boolean cadastrar_filme(String nome, int ano, int duracao, String desc){
		Filme buffer = new Filme(nome, ano, duracao, desc);
		
		if(buffer.existe()) {
			filmes.add(buffer);
			FileManager.escrever_ultima_linha("filmes.txt", buffer.get_infos());
			
			return true;
		}
		return false;
	}

	public boolean cadastrar_sessao(Filme filme, Sala sala, String data){
		Sessao buffer = new Sessao(filme, sala, data);
		if(buffer.get_data() != null) {
			sessoes.add(buffer);
			FileManager.escrever_ultima_linha("sessoes.txt", buffer.get_infos());
			
			return true;
		}
		return false;
	}
	
	public boolean cadastrar_ingresso(Sessao sessao, Cliente cliente, int coluna, int fileira){
		Ingresso buffer = new Ingresso(sessao, cliente, coluna, fileira);
		ingressos.add(buffer);
		FileManager.escrever_ultima_linha("ingressos.txt", buffer.get_infos());
		
		return true;
	}
	
	//VALIDAR
	public boolean validar_login(String cpf, String senha) {
		Cliente temp = get_cliente(cpf);
		
		if(temp == null)
			return false;
		
		this.cliente = cpf;
		return temp.validar_senha(senha);
	}
	
	public boolean is_reservado(int coluna, int fileira, ArrayList<Integer> ids_ingressos){
		Ingresso ingresso;
		//Verifica lista de ingressos, se coincidir com a coordenada desejada o mesmo está indisponível
		for(int id_ingresso : ids_ingressos) {
			ingresso = get_ingresso(id_ingresso);
			if(ingresso.get_x() == coluna && ingresso.get_y() == fileira)
				return true;
		}
		
		return false;
	}
	
	//GETTERS
	public Cliente get_cliente(String cpf){

		for(Cliente cliente : this.clientes) {
			if(cliente.get_cpf().equals(cpf))
				return cliente;
		}
		
		return null;
	}

	public Sala get_sala(int id){ return salas.get(id);}

	public Filme get_filme(int id){ return filmes.get(id);}

	public Sessao get_sessao(int id){ return sessoes.get(id);}
	
	public Ingresso get_ingresso(int id){ return ingressos.get(id);}
	
	public void get_filmes_futuros(ArrayList<Integer> ids_filmes) {
		
		//Obtém filmes em sessoes futuras
		for(Sessao sessao : this.sessoes) {
			if(sessao.get_data().isAfter(Sessao.now())) {
				//Evita duplicidades
				if(!ids_filmes.contains(sessao.get_id_filme()))
					ids_filmes.add(sessao.get_id_filme());
			}
		}
	}
	
	public void get_sessoes_filme(int id_filme, ArrayList<Integer> ids_sessoes) {
		
		//Obtém sessões com o respectivo filme
		for(Sessao sessao : this.sessoes) {
			if(sessao.get_id_filme() == id_filme) {
				//Evita duplicidades
				if(!ids_sessoes.contains(sessao.get_id()))
					ids_sessoes.add(sessao.get_id());
			}
		}
	}
	
	public void get_ingressos_sessao(int id_sessao, ArrayList<Integer> ids_ingressos) {
		
		//Obtém ingressos referentes à uma sessão
		for(Ingresso ingresso : this.ingressos) {
			if(ingresso.get_sessao_id() == id_sessao) {
				//Evita duplicidades
				if(!ids_ingressos.contains(ingresso.get_id()))
					ids_ingressos.add(ingresso.get_id());
			}
		}
	}
	
	public void get_ingressos_cliente(ArrayList<Integer> ids_ingressos) {
		//Obtém ingressos referentes à uma sessão
		for(Ingresso ingresso : this.ingressos) {
			if(ingresso.get_cliente_cpf().equals(this.cliente)) {
				//Evita duplicidades
				if(!ids_ingressos.contains(ingresso.get_id()))
					ids_ingressos.add(ingresso.get_id());
			}
		}
	}
	
	public String get_cliente_logado() {
		return this.cliente;
	}
	
	//EXIBIR (APENAS PARA DEBUG)
	public void print_clientes(){
		System.out.println("Clientes");
		
		if(this.debug) {
			for(Cliente i : this.clientes)
				System.out.println(i.get_infos());
		}
		else {
			for(Cliente i : this.clientes)
				System.out.println(i.get_infos_normal());
		}
	}

	public void print_salas(){
		System.out.println("Salas");
		for(Sala i : this.salas)
			System.out.println(i.get_infos());
	}

	public void print_filmes(){
		System.out.println("Filmes");
		for(Filme i : this.filmes)
			System.out.println(i.get_infos());
	}

	public void print_sessoes(){
		System.out.println("Sessoes");
		for(Sessao i : this.sessoes)
			System.out.println(i.get_infos());
	}
	
	public void print_ingressos(){
		System.out.println("Ingressos");
		for(Ingresso i : this.ingressos)
			System.out.println(i.get_infos());
	}

}
