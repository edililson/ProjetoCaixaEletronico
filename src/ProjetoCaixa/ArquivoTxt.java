package ProjetoCaixa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
  * @author Edililson David
 */
public class ArquivoTxt {
	//Serve para poder ler o arquivo
    public static String Read(String Caminho){
        String conteudo = "";
        try {
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha="";
            try {
                linha = lerArq.readLine();
                while(linha!=null){
                	//Aqui ele est� lendo o arquivo e  pegando as quebras de linhas que est�o no .txt
                    conteudo += linha+"\r\n";
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: N�o foi poss�vel ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo n�o encontrado!");
            return "";
        }
    }
    
    //Serve para esquever no arquivo
    //TODO atualizar para n�o sobreescrever o arquivo e escrever as novas contas no final do arquivo
    public static boolean Write(String Caminho,String Texto, boolean finalDoArquivo1){
        try {
            FileWriter arq = new FileWriter(Caminho, finalDoArquivo1);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.append(Texto);
            //gravarArq.println(Texto);
            gravarArq.close();
            return true;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
