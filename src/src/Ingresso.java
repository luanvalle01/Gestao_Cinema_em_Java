package src;

public class Ingresso {
	static int qtdIngressos;
	
	private int id;
	private int id_sessao;
	private String cpf;
	
	private int coordenada[];
	
	public Ingresso(Sessao sessao, Cliente cliente, int coluna, int fileira) {
		this.id_sessao = sessao.get_id();
		this.cpf = cliente.get_cpf();

		coordenada = new int[2];
		this.coordenada[0] =coluna;
		this.coordenada[1] = fileira;

		this.id = qtdIngressos++;
	}
	
	public Ingresso(String linha_arquivo) {
		String dados[] = linha_arquivo.split("\\|");
		
		if(dados.length == 5) {
			this.id = Integer.parseInt(dados[0]);
			this.id_sessao = Integer.parseInt(dados[1]);
			this.cpf = dados[2];
			
			coordenada = new int[2];
			this.coordenada[0] = Integer.parseInt(dados[3]);
			this.coordenada[1] = Integer.parseInt(dados[4]);
			
			qtdIngressos++;
		}
	}
	
	//SETTERS
	public void set_cpf(String novo_cpf) {
		this.cpf = novo_cpf.toString();
	}
	
	
	//GETTERS
	public Integer get_id() {
		return this.id;
	}
	
	public int get_sessao_id() {
		return this.id_sessao;
	}
	
	public String get_cliente_cpf() {
		return this.cpf;
	}
	
	public int get_x() {
		return this.coordenada[0];
	}
	public int get_y() {
		return this.coordenada[1];
	}
	
	//INFOS
	public String get_infos(){
		return(this.id+"|"+this.id_sessao+"|"+this.cpf+"|"+this.coordenada[0]+"|"+this.coordenada[1]);
	}
	
}
