package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import controller.VerificaContato;

import util.Formatador;

public class ContatoDAO {
	
	public static void cadastrar(Contato contato) {
		String SQL = "INSERT INTO contato(nome, telefone, email) VALUES (?, ?, ?)";
		try(
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstm = conn.prepareStatement(SQL);
			)
		{
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getTelefone());
			pstm.setString(3, contato.getEmail());
			
			pstm.execute();
			
			ConnectionFactory.fecharConexoes(pstm, conn);
			
		}
		catch(SQLException sqlEx) {
			
		}
		catch(ClassNotFoundException classEx) {
			
		}
		catch(Exception ex) {
			
		}
	}
	
	public static List<Contato> listar(){
		List<Contato> contatos = new ArrayList<Contato>();
		String SQL = "SELECT * FROM contato ORDER BY id_contato";
		Contato contato;
		try(Connection conn = ConnectionFactory.getConnection();
			Statement stm = conn.createStatement();
			ResultSet query = stm.executeQuery(SQL);
		){	
			while(query.next()) {
				contato = fetchContato(query);
				contatos.add(contato);
			}
			ConnectionFactory.fecharConexoes(query, stm, conn);
		}
		catch(SQLException sqlEx) {
			System.out.println("Erro no select");
			sqlEx.printStackTrace();
		}
		catch(ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		}
		return contatos;
	}
	
	private static Contato fetchContato(ResultSet query) throws SQLException {
		long id = query.getLong(1);
		String nome = query.getString(2);
		String telefone = Formatador.toTelefone(query.getString(3));
		String email = query.getString(4);
		
		if(VerificaContato.emailPreenchido(email)) {
			return new Contato(id, nome, telefone, email);
		}
		return new Contato(id, nome, telefone);
	}
	
	public static Contato buscarContato(long id) {
		String SQL = "SELECT * FROM contato WHERE id_contato = ?";
		ResultSet query = null;
		Contato contato = null;
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstm = conn.prepareStatement(SQL);
		){
			pstm.setLong(1, id);
			query = pstm.executeQuery();
			query.next();
			contato = fetchContato(query);
			
			ConnectionFactory.fecharConexoes(query, pstm, conn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return contato;
	}

	public static void editar(Contato contato) {
		String SQL = "UPDATE contato SET nome = ?, telefone = ?, email = ? WHERE id_contato = ?";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstm = conn.prepareStatement(SQL);
			){
				pstm.setString(1, contato.getNome());
				pstm.setString(2, contato.getTelefone());
				pstm.setString(3, contato.getEmail());
				pstm.setLong(4, contato.getId());
				
				pstm.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void deletar(long id) {
		String SQL = "DELETE FROM contato WHERE id_contato = ?";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstm = conn.prepareStatement(SQL);	
			){
				pstm.setLong(1, id);
				pstm.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
}
