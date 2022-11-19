package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(ConnectionConfig.DRIVER);
		return DriverManager.getConnection(ConnectionConfig.URL);
 	}
	
	public static void fecharConexao(AutoCloseable conexao) {
		if(conexao != null) {
			try {
				conexao.close();
			} catch (Exception e) {
				System.out.println("Erro ao fechar a conexão");
				e.printStackTrace();
			}
		}
	}
	
	public static void fecharConexoes(AutoCloseable... conexoes) {
		for(AutoCloseable conexao: conexoes) {
			fecharConexao(conexao);
		}
	}
	

}
