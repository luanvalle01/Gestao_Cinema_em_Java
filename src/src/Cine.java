package src;
import java.util.ArrayList;

public class Cine {
	private ArrayList<Cliente>clientes;
	private ArrayList<Sala>salas;
	private ArrayList<Filme>filmes;
	private ArrayList<Sessao>sessoes;
	private ArrayList<Ingresso>ingressos;
	
	public Cine(){
		clientes  = new ArrayList<Cliente>();
		salas  = new ArrayList<Sala>();
		filmes  = new ArrayList<Filme>();
		sessoes  = new ArrayList<Sessao>();
		ingressos  = new ArrayList<Ingresso>();
	}
	
	//CADASTROS | true: bem sucedido | false : mal sucedido
	//Adicionar verificação de duplicidade
	public boolean cadastrar_cliente(String cpf, String nome, String senha){
		Cliente buffer = new Cliente(cpf, nome, senha);
		if(buffer.existe()) {
			clientes.add(buffer);
			return true;
		}
		return false;
	}

	public boolean cadastrar_sala(String nome_sala, int colunas, int fileiras){
		Sala buffer = new Sala(nome_sala, colunas, fileiras);
		salas.add(buffer);
		return true;
	}

	public boolean cadastrar_filme(String nome, int ano, int duracao, String desc){
		Filme buffer = new Filme(nome, ano, duracao, desc);
		if(buffer.existe()) {
			filmes.add(buffer);
			return true;
		}
		return false;
	}

	public boolean cadastrar_sessao(Filme filme, Sala sala, String data){
		Sessao buffer = new Sessao(filme, sala, data);
		if(buffer.get_data() != null) {
			sessoes.add(buffer);
			return true;
		}
		return false;
	}
	
	public boolean cadastrar_ingresso(Sessao sessao, Cliente cliente){
		Ingresso buffer = new Ingresso(sessao, cliente);
		ingressos.add(buffer);
		return true;
	}
	
	//EXIBIR (DEBUG)
	public void print_clientes(){
		System.out.println("Clientes");
		for(Cliente i : this.clientes)
			System.out.println(i.get_infos());
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
}
