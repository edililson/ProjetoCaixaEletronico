package br.start.latam.ProjetoCaixa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
  * @author Edililson David
 */
public class ArquivoTxt {
	//Serve para poder ler o arquivo
    public static ArrayList<String> read(String Caminho){
        ArrayList<String> contasJson = new ArrayList<String>();
        try {
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha="";
            try {
                linha = lerArq.readLine();
                while(linha!=null){
                	//Aqui ele está lendo o arquivo e  pegando as quebras de linhas que estão no .txt
                	contasJson.add(linha);
                    linha = lerArq.readLine();
                }
                arq.close();
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
        }
        return contasJson;
    }
    
    public static void rewrite(String Caminho,ArrayList<String> Texto){
    	String novoArquivo = "";
    	for (String string : Texto) {
    		novoArquivo += string + "\n"; 
		}
    	
    	write(Caminho, novoArquivo, false);
    }
    
    //Serve para esquever no arquivo
    //TODO atualizar para não sobreescrever o arquivo e escrever as novas contas no final do arquivo
    public static boolean write(String Caminho,String Texto, boolean finalDoArquivo1){
        try {
            FileWriter arq = new FileWriter(Caminho, finalDoArquivo1);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.append(Texto + "\n");
            //gravarArq.println(Texto);
            gravarArq.close();
            return true;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}
