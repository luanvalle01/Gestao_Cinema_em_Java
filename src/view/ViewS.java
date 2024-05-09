package view;

import java.io.IOException;

public class ViewS {
	
	public static void limpar_tela()
	{
		 try {
			 if (System.getProperty("os.name").contains("Windows"))
		    	new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			 else
				 Runtime.getRuntime().exec("clear");
		 } catch (IOException | InterruptedException ex) {}
	}
	
	public static String construir_linha(int tamanho) {
		StringBuilder temp = new StringBuilder("");
		temp.setLength(tamanho);
		
		temp.setCharAt(0, '|');
		for(int i = 1; i < tamanho - 2; i++)
			temp.setCharAt(i, ' ');
		
		temp.setCharAt(tamanho - 1, '|');
		
		return temp.toString();
	}
	
	public static String construir_linha(int tamanho, String texto) {
		StringBuilder temp = new StringBuilder("");
		temp.setLength(tamanho);
		int max_size = texto.length();
		if(max_size > tamanho - 2)
			max_size = tamanho - 2;
		
		int i = 0;
				
		temp.setCharAt(i, '|');
		temp.setCharAt(i + 1, ' ');
		i = 2;
		for(; i - 2 < max_size; i++)
			temp.setCharAt(i, texto.charAt(i - 2));
		
		for(; i < tamanho - 2; i++)
			temp.setCharAt(i, ' ');
		
		temp.setCharAt(tamanho - 1, '|');
		
		return temp.toString();
	}
	
	public static String construir_linha(int tamanho, String texto, boolean is_titulo) {
		StringBuilder temp = new StringBuilder("");
		temp.setLength(tamanho);
		
		int i = 1;
		int start = (tamanho/2) - (texto.length()/2);
				
		temp.setCharAt(0, '|');
		for(; i < start; i++)
			temp.setCharAt(i, '_');
		
		for(; i  - start < texto.length(); i++)
			temp.setCharAt(i, texto.charAt(i - start));
		
		for(; i < tamanho - 2; i++)
			temp.setCharAt(i, '_');
		
		temp.setCharAt(tamanho -1, '|');
		
		return temp.toString();
	}
}
