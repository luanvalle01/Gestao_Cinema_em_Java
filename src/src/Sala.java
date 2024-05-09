package src;

public class Sala{
	static int qtd_salas;
	private int id;

	private String nome;
	private int colunas;
	private int fileiras;
	private int capacidade;
	
	public Sala(String nome_sala, int colunas, int fileiras){
		this.nome = nome_sala;		
		this.colunas = colunas;
		this.fileiras = fileiras;
		
		this.capacidade = colunas * fileiras;
		
		this.id = qtd_salas++;
	}
	
	public Sala(String linha_arquivo) {
		String dados[] = linha_arquivo.split("\\|");
		
		if(dados.length == 5) {
			this.id = Integer.parseInt(dados[0]);
			this.nome = dados[1];
			this.colunas = Integer.parseInt(dados[2]);
			this.fileiras = Integer.parseInt(dados[3]);
			this.capacidade = Integer.parseInt(dados[4]);
			
			qtd_salas++;
		}
	}
	
	//GETTERS
	public int get_id() {
		return this.id;
	}
	
	public String get_nome() {
		return this.nome;
	}
	
	public int get_colunas() {
		return this.colunas;
	}
	public int get_fileiras() {
		return this.fileiras;
	}
	
	public int get_capacidade() {
		return this.capacidade;
	}
	
	public String get_infos() {
		return(this.id+"|"+this.nome +"|"+this.colunas+"|"+this.fileiras+"|"+this.capacidade);
	}
}
