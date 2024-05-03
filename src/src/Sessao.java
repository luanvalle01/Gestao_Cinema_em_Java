package src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sessao {
	static int qtd_sessoes;
	private int id;

	private int id_filme;
	private Sala sala;
	private LocalDateTime data;

	public Sessao(Filme filme, Sala sala, String data){
		if(filme.existe()) {
			this.id_filme = filme.get_id();
			this.sala = sala;
			this.data = LocalDateTime.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	
			this.id = qtd_sessoes++;
		}
	}

	//GETTERS
	public int get_id(){
		return this.id;
	}
	
	public int get_id_filme(){
		return this.id_filme;
	}
	
	public Sala get_sala(){
		return this.sala;
	}
	public int get_id_sala(){
		return this.sala.get_id();
	}

	public LocalDateTime get_data(){
		return this.data;
	}
	
	public String get_infos() {
		return(this.id+"|"+this.id_filme +"|"+this.sala.get_id()+"|"+this.get_data());
	}
}
