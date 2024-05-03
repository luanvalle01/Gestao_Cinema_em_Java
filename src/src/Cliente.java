package src;

import helpers.Cpf;
import helpers.Criptografia;

public class Cliente {
	private String cpf;
	private String nome;
	private String hash;
	
	public Cliente(String cpf, String nome, String senha) {
		cpf = Cpf.limpar(cpf);
		if(Cpf.validar(cpf) && senha.length() > 3 && senha.length() < 10) {
			this.cpf = cpf;
			
			set_nome(nome);
			set_hash(senha);
		}	
	}
	
	//SETTERS
	public void set_nome(String nome){
		this.nome = nome;
	}
	private void set_hash(String senha){//HASH É GERADO A PARTIR DO OBJETO CRIPTOGRAFIA
		this.hash = Criptografia.criar_hash(senha);
	}
	
	//GETTERS
	public boolean existe() {
		if(this.cpf != null)
			return true;
		
		return false;
	}
	
	public String get_cpf(){
		return this.cpf;
	}
	
	public String get_nome(){
		return this.nome;
	}
	
	
	public boolean validar_senha(String senha){
		if(this.hash.equals(Criptografia.criar_hash(senha)))
			return true;
		
		return false;
	}
	
	//INFOS
	public String get_infos(){
		return(this.cpf+"|"+this.nome+"|"+this.hash);
	}
}
