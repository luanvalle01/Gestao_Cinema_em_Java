package src;

public class Ingresso {
	static long qtdIngressos;
	
	private long id;
	private int id_sessao;
	private String cpf;
	
	public Ingresso(Sessao sessao, Cliente cliente) {
		this.id_sessao = sessao.get_id();
		this.cpf = cliente.get_cpf();
		
		this.id = qtdIngressos++;
	}
	
	//SETTERS
	public void set_cpf(String novo_cpf) {
		this.cpf = novo_cpf.toString();
	}
	
	
	//GETTERS
	public long get_id() {
		return this.id;
	}
	
	public int get_sessao_id() {
		return this.id_sessao;
	}
	
	public String get_cliente_cpf() {
		return this.cpf;
	}
	
	//INFOS
	public String get_infos(){
		return(this.id+"|"+this.get_sessao_id()+"|"+this.cpf);
	}
	
}
