package helpers;

public class Criptografia {

	public static String criar_hash(String senha) {
		int buffer = 0;
		StringBuilder hash = new StringBuilder(senha.toString());
		
		for(int i = 0; i < hash.length(); i++) {
			buffer = senha.charAt(i);
			
			if(buffer < 64)
				buffer = buffer + (i -10);
			else
				buffer = buffer + (30 - (i -10));
			
			if(buffer == 124)
				buffer++;
			
			hash.setCharAt(i, (char)buffer);
		}
		
		return hash.toString();
	}
	
	static String deshashear(String hash) {//APENAS PARA TESTES
		int buffer = 0;
		StringBuilder senha = new StringBuilder(hash.toString());
		
		for(int i = 0; i < senha.length(); i++) {
			buffer = senha.charAt(i);
			
			if(buffer < 64)
				buffer = buffer - (i - 10);
			else
				buffer = buffer - 30 + (i -10);
			
			if(buffer == 124)
				buffer--;
			
			senha.setCharAt(i, (char)buffer);
		}
		
		return senha.toString();
	}
}
