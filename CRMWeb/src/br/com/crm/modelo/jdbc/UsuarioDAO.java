package br.com.crm.modelo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crm.entidades.pessoas.Usuario;
import br.com.crm.modelo.IBaseDAO;
import br.com.crm.modelo.IUsuarioDAO;
import br.com.crm.modelo.excecoes.ExcecaoModelo;

/**
 * Classe DAO para que manipula dos dao do usuário no banco
 */
public class UsuarioDAO implements IBaseDAO<Usuario>, IUsuarioDAO{

	/**
	 * {@link IBaseDAO#excluir(Usuario)}
	 */
	@Override
	public void incluir(Usuario t) throws ExcecaoModelo {
		Connection conn = ConnectionFactory.getConnection();
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into usuarios (nome, endereco, cpf, ativo, login, senha) ");
		sql.append("values(?,?,?,?,?,?)");
		
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql.toString());
			int cont = 1;

			ps.setString(cont++, t.getNome());
			ps.setString(cont++, t.getEndereco());
			ps.setString(cont++, t.getCpf());

			if (t.getAtivo()) {
				ps.setString(cont++, "1"); // 1 = true
			} else {
				ps.setString(cont++, "0"); // 0 = false
			}

			ps.setString(cont++, t.getLogin());
			ps.setString(cont++, t.getSenha());

			ps.execute();
		} catch (Exception e) {
			throw new ExcecaoModelo(e.getMessage());
		}finally{
			ConnectionFactory.closeConnection(conn, ps);
		}
		
	}

	/**
	 * {@link IBaseDAO#alterar(Usuario)}
	 */
	@Override
	public void alterar(Usuario t) throws ExcecaoModelo {
		
		Connection conn = ConnectionFactory.getConnection();
		
		StringBuffer sql = new StringBuffer();
		sql.append("update usuarios set nome = ?, cpf = ?, endereco = ?, ");
		sql.append("login = ?, senha = ?, ativo = ? ");
		sql.append("where usuarios.id = ? ");
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql.toString());
			int cont = 1;
			
			ps.setString(cont++, t.getNome());
			ps.setString(cont++, t.getCpf());
			ps.setString(cont++, t.getEndereco());
			ps.setString(cont++, t.getLogin());
			ps.setString(cont++, t.getSenha());
			
			if (t.getAtivo()) {
				ps.setString(cont++, "1"); // 1 = true
			} else {
				ps.setString(cont++, "0"); // 0 = false
			}

			ps.setInt(cont++, t.getId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new ExcecaoModelo(e.getMessage());
		}finally{
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	/**
	 * {@link IBaseDAO#excluir(Usuario)}
	 */
	@Override
	public void excluir(Usuario t) throws ExcecaoModelo {
		
		Connection conn = ConnectionFactory.getConnection();		
		StringBuffer sql = new StringBuffer();
		
		sql.append("delete from usuarios ");
		sql.append("where usuarios.id = ? ");
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, t.getId());			
			ps.executeUpdate();
		} catch (Exception e) {
			throw new ExcecaoModelo(e.getMessage());
		}finally{
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	/**
	 * {@link IBaseDAO#listar()}
	 */
	@Override
	public List<Usuario> listar() throws ExcecaoModelo {

		Connection conn = ConnectionFactory.getConnection();		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select u.id, u.nome, u.endereco, u.cpf, u.ativo, ");
		sql.append("u.login, u.senha ");
		sql.append("from usuarios u ");
				
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		try {
			ps = conn.prepareStatement(sql.toString());			
			rs = ps.executeQuery();
			
			while(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				
				if(rs.getString("ativo").equals("1")){
					usuario.setAtivo(true);
				}else{
					usuario.setAtivo(false);
				}
				
				listaUsuarios.add(usuario);
			}
			
		} catch (Exception e) {
			throw new ExcecaoModelo(e.getMessage());
		}finally{
			ConnectionFactory.closeConnection(conn,ps, rs);
		}
		
		return listaUsuarios;
	}

	/**
	 * {@link IBaseDAO#recuperar(Usuario)}
	 */
	@Override
	public Usuario recuperar(Usuario usuarioEncontrar) throws ExcecaoModelo {
		
		if(usuarioEncontrar.getId() == null){
			throw new ExcecaoModelo("Impossível recuperar o usuário sem o seu código de identificação.");
		}
		
		Usuario usuario = new Usuario();
		Connection conn = ConnectionFactory.getConnection();
		StringBuffer sql = new StringBuffer();;
		
		sql.append("select u.id, u.nome, u.endereco, u.cpf, u.ativo, ");
		sql.append("u.login, u.senha ");
		sql.append("from usuarios u ");
		sql.append("where u.id = ?");
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, usuarioEncontrar.getId());			
			rs = ps.executeQuery();						
			
			rs.first();
			
			usuario.setId(rs.getInt("id"));
			usuario.setNome(rs.getString("nome"));
			usuario.setEndereco(rs.getString("endereco"));
			usuario.setCpf(rs.getString("cpf"));
			usuario.setLogin(rs.getString("login"));
			usuario.setSenha(rs.getString("senha"));
			
			if(rs.getString("ativo").equals("1")){
				usuario.setAtivo(true);
			}else{
				usuario.setAtivo(false);
			}			
			
		} catch (Exception e) {
			throw new ExcecaoModelo(e.getMessage());
		}finally{
			ConnectionFactory.closeConnection(conn, ps, rs);
		}		
		
		return usuario;
	}
	
	/**
	 * {@link IUsuarioDAO#consultar(String, String)}
	 */
	@Override
	public Boolean consultar(String login, String senha) throws ExcecaoModelo {
		Connection conn = ConnectionFactory.getConnection();
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select id from usuarios ");
		sql.append("where usuarios.login = ? ");
		sql.append("and usuarios.senha = ? ");
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean retorno = false;
		
		try {
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, login);
			ps.setString(2, senha);
			rs = ps.executeQuery();
			
			retorno = rs.next();
		} catch (Exception e) {
			throw new ExcecaoModelo(e.getMessage());
		}finally{
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
		
		return retorno;
	}
}
