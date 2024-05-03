package helpers;

public class Cpf {
	
	public static String limpar(String cpf){
		// Remove pontos
		StringBuilder temp = new StringBuilder(cpf.toString());
		int i = 0;
		int j = 0;
		
		for(i = 0; i < temp.length(); i ++)
			temp.setCharAt(i, '\0');
		
		i = 0;
		while(j < cpf.length() && i < temp.length()) {
			if(cpf.charAt(j) != '.' && cpf.charAt(j) != '-' && cpf.charAt(j) != ',')
				temp.setCharAt(i++, cpf.charAt(j));
			
			j++;
		}
		
		return temp.toString();
	}
	
	public static boolean validar(String cpf) {
		short validacoes = 0;
		int sum = 0, res = 0;
		int j = 10;
		
		//Primeira verificação
		for(int i = 0; i < 9; i++) {
			sum += Character.getNumericValue(cpf.charAt(i)) * j;
			j--;
		}

		res = sum%11;
		if(res <= 1 && cpf.charAt(10) == '0')
			validacoes++;
			
		else if(res > 2 && Character.getNumericValue(cpf.charAt(9)) == 11 - res)
			validacoes++;
		
		//Segunda verificação
		sum = 0;
		j = 11;
		for(int i = 0; i < 10; i++)
			sum += Character.getNumericValue(cpf.charAt(i)) * j--;
			
		res = sum%11;
		if(res <= 1 && cpf.charAt(9) == '0')
			validacoes++;
			
		else if(res >= 2 && Character.getNumericValue(cpf.charAt(10)) == 11 - res)
			validacoes++;
		
		if(validacoes == 2)
			return true;
		
		return false;
	}
}
