package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConnectionConfig {
	
	public static final String
		
		URL = String.format("jdbc:mysql://localhost:3306/agenda?"
				+ "useTimezone=true&serverTimezone=UTC&"
				+ "user=root&password=%s",getSenha()),
		DRIVER = "com.mysql.cj.jdbc.Driver";

	private static String getSenha() {
		File arquivo = new File("/home/abdul/.mysql/credenciais/root.txt");
		try(FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			){
			return br.readLine();
		}
		catch(IOException e) {
			throw new RuntimeException("Erro na operação do arquivo");
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(ConnectionConfig.URL);
	}
	
}
