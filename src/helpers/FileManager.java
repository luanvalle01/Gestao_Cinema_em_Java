package helpers;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.ArrayList;

public class FileManager {

    public static void criar_arquivo(String nome_arquivo) {
        try {
            File file = new File(nome_arquivo);
            if (file.createNewFile()) {
                System.out.println("Arquivo criado: " + file.getName());
            } else {
                System.out.println("O arquivo já existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao criar o arquivo.");
            e.printStackTrace();
        }
    }
    
    //Le o arquivo para uma lista de strings
    public static void ler_arquivo(String nome_arquivo, ArrayList<String> buffer) {
        buffer.clear();
        criar_arquivo(nome_arquivo);
    	
    	try (BufferedReader reader = new BufferedReader(new FileReader(nome_arquivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.add(line);
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo.");
            e.printStackTrace();
        }
    }
    
    //Escreve um array de srtrings em um arquivo
    public static void escrever_arquivo(String nome_arquivo, ArrayList<String> linhas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nome_arquivo))) {
            for (String linha : linhas) {
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo.");
            e.printStackTrace();
        }
    }
    
    //Escreve na ultima linha do arquivo
    public static void escrever_ultima_linha(String nome_arquivo, String texto){
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter(nome_arquivo, true))) {
    		writer.write(texto);
    		writer.newLine(); // Adiciona uma nova linha após o conteúdo
        } catch (IOException e) {
        	System.out.println("Ocorreu um erro ao escrever na última linha do arquivo.");
        	e.printStackTrace();
        }
    }
}

