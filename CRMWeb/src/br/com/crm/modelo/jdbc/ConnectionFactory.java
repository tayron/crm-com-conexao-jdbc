package br.com.crm.modelo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.crm.modelo.excecoes.ExcecaoModelo;

/**
 * Classe que disponibiliza e gerencia uma coneçao com o banco de dados
 */
public class ConnectionFactory {

	/**
	 * Armazena o nome do banco de dados
	 */
	private final static String dbName = "crm";
	
	/**
	 * Armazena o nome do usuário do banco de dados
	 */
	private final static String dbUser = "root";
	
	/**
	 * Armazena a senha do usuário do banco de dados
	 */
	private final static String dbPassword = "123456";
	
	/**
	 * Cria e retorna uma conexão com banco de dados
	 * 
	 * @return
	 * @throws ExcecaoModelo
	 */
	public static Connection getConnection() throws ExcecaoModelo{
		Connection conn = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/" + dbName +"?user=" + dbUser + "&password=" + dbPassword);
		}catch (Exception e) {
			throw new ExcecaoModelo(e.getMessage());
		}
		
		return conn;
	}
	
	/**
	 * Fecha a coneção com o banco de dados
	 *  
	 * @param conn
	 * @throws ExcecaoModelo
	 */
	public static void closeConnection(Connection conn)	throws ExcecaoModelo{
		close(conn, null, null);
	}
	
	/**
	 * Fecha a conexão com o banco de dados
	 * 
	 * @param conn
	 * @param smt
	 * @throws ExcecaoModelo
	 */
	public static void closeConnection(Connection conn, Statement smt) throws ExcecaoModelo{
		close(conn, smt, null);
	}
	
	/**
	 * Fecha umaconexão com o banco de dados
	 * 
	 * @param conn
	 * @param smt
	 * @param rs
	 * @throws ExcecaoModelo
	 */
	public static void closeConnection(Connection conn,	Statement smt, ResultSet rs) throws ExcecaoModelo{
		close(conn, smt, rs);
	}
	
	/**
	 * Fecha todas as conexões com o banco de dados
	 * 
	 * @param conn
	 * @param smt
	 * @param rs
	 * @throws ExcecaoModelo
	 */
	private static void close(Connection conn, Statement smt, ResultSet rs) 
			throws ExcecaoModelo {
		try {
			if(conn != null){
				conn.close();
			}
			if(smt != null){
				smt.close();
			}
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			throw new ExcecaoModelo(e.getMessage());
		}
	}
}
