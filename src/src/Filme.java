package src;

public class Filme {
	static int qtd_filmes;
	private  int id;

	private String nome;
	private int ano;
	private int duracao;//Minutos
	private String descricao;
	
	private boolean exists;

	public Filme(String nome, int ano, int duracao, String desc) {
		this.exists = false;
		
		if(set_nome(nome) && set_ano(ano) && set_duracao(duracao) && set_descricao(desc)) {
			this.id = qtd_filmes++;
			this.exists = true;
		}
	}
	
	public Filme(String linha_arquivo) {
		String dados[] = linha_arquivo.split("\\|");
		
		if(dados.length == 5) {
			this.id = Integer.parseInt(dados[0]);
			this.nome = dados[1];
			this.ano = Integer.parseInt(dados[2]);
			this.duracao = Integer.parseInt(dados[3]);
			this.descricao = dados[4];
			
			this.exists = true;
			qtd_filmes++;
		}
	}

	//SETTERS
	public boolean set_nome(String n){
		if(n.isEmpty())
			return false;

		this.nome = n;
		return true;
	}

	public boolean set_ano(int a){
		if(a < 1888)
			return false;

		this.ano = a;
		return true;
	}

	public boolean set_duracao(int d){
		if(d < 1)
			return false;

		this.duracao = d;
		return true;
	}

	public boolean set_descricao(String d){
		if(d.isEmpty())
			return false;

		this.descricao = d;
		return true;
	}

	//GETTERS
	public boolean existe() {
		return this.exists;
	}
	
	public int get_id(){
		return this.id;
	}
	
	public String get_nome(){
		return this.nome;
	}
	
	public int get_ano(){
		return this.ano;
	}
	
	public int get_duracao(){
		return this.duracao;
	}
	
	public String get_descricao(){
		return this.descricao;
	}

	public String get_infos(){
		return(this.id+"|"+this.nome+"|"+this.ano+"|"+this.duracao+"|"+this.descricao);
	}
}
