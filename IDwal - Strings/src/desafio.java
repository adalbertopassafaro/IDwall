import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.Spliterator;

public class desafio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		desafio desafio = new desafio();
		String txt;
		int comprimento;
		txt = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\r\n" + 
				"\r\n" + 
				"And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";
		comprimento = 40;
		
		String palavras[] = new String[txt.split(" ").length];
		palavras = txt.split(" ");
		
		for(int i=0;i<palavras.length;i++) {
			if(i==0) {
				desafio.gravaArquivoPrimeiralinha(palavras[i]);
			}
			else {
				if(desafio.lerUltimaLinha().length()+palavras[i].length()+1 <=40) {
					desafio.gravaArquivoDemaisLinhas(" ");
					desafio.gravaArquivoDemaisLinhas(palavras[i]);
				}else {
					desafio.gravaArquivoDemaisLinhas("\n");
					desafio.gravaArquivoDemaisLinhas(palavras[i]);
					
				}
			}
		}
		System.out.println(desafio.lerUltimaLinha()); 
		System.out.println(desafio.lerUltimaLinha().split(" ").length); 
		System.out.println(desafio.lerUltimaLinha().length()); 
	}

	public void gravaArquivoPrimeiralinha(String txt) {
		FileWriter arquivo;
		try {
			arquivo = new FileWriter(new File("Arquivo.txt"));
			arquivo.write(txt);
			arquivo.close();
		}catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
	}
	}
	public void gravaArquivoDemaisLinhas(String txt) {
		FileWriter arquivo;
		try {
			arquivo = new FileWriter(new File("Arquivo.txt"),true);
			arquivo.write(txt);
			arquivo.close();
		}catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
	}
	}
	public String lerUltimaLinha() {
		String ultimo="";
	
		try {
			InputStream is = new FileInputStream("arquivo.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String line = "";
			while (line != null) {
				line = br.readLine();
				if (line != null) {
					ultimo = line;
				}
			}

			//System.out.println(ultimo);
			br.close();
			return ultimo;
		} catch (IOException e) {
			e.printStackTrace();
	}
		return ultimo;
	}
	}
	
