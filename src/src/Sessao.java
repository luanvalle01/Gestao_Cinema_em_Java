package src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sessao {
	static int qtd_sessoes;
	private int id;

	private int id_filme;
	private int id_sala;
	private LocalDateTime data;

	public Sessao(Filme filme, Sala sala, String data){
		if(filme.existe()) {
			this.id_filme = filme.get_id();
			this.id_sala = sala.get_id();
			set_data(data);
			
			this.id = qtd_sessoes++;
		}
	}
	
	public Sessao(String linha_arquivo) {
		String dados[] = linha_arquivo.split("\\|");
		
		//Retira 'T' da String da data para conversão correta
		StringBuilder data = new StringBuilder("yyyy-MM-dd HH:mm:ss");
		data.insert(0, dados[3].toString());
		data.setCharAt(10, ' ');
		
		//Insere segundos caso necessário
		if(data.charAt(17) == 'y') {
			data.insert(16,":00");
		}
		
		data.setLength(19);;
		
		if(dados.length == 4) {
			this.id = Integer.parseInt(dados[0]);
			this.id_filme = Integer.parseInt(dados[1]);
			this.id_sala = Integer.parseInt(dados[2]);
			set_data(data.toString());
			
			qtd_sessoes++;
		}
	}
	
	private void set_data(String data) {
		this.data = LocalDateTime.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	//GETTERS
	public int get_id(){
		return this.id;
	}
	
	public int get_id_filme(){
		return this.id_filme;
	}
	

	public int get_id_sala(){
		return this.id_sala;
	}

	public LocalDateTime get_data(){
		return this.data;
	}
	
	public static LocalDateTime now() {
		return LocalDateTime.now();
	}
	
	public String get_infos() {
		return(this.id+"|"+this.id_filme +"|"+this.id_sala+"|"+this.get_data());
	}
}
