package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import model.Usuario;

public class UsuarioDAO {

	private Connection connection;
	private String sql;

	public UsuarioDAO() throws SQLException {
		connection = DatabaseConnection.createConnection();
	}

	public void closeConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void criarUsuario(Usuario usuario) {
		sql = "INSERT INTO Usuarios ( nome, cpf, email, telefone, login, senha ) VALUES (?, ? , ? , ? ,?, ?)";
		System.out.println(sql);
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getCpf());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getTelefone());
			stmt.setString(5, usuario.getLogin());
			stmt.setString(6, usuario.getSenha());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao se cadastrar!");
			e.printStackTrace();

		}
	}

	public List<Usuario> listarTodos() {

		sql = "SELECT * from Usuarios";
		List<Usuario> usuarios = new ArrayList<>();
		ResultSet rs = null;
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("Id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));

				usuarios.add(usuario);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return usuarios;

	}

	public Usuario buscarUsuario(int id) {
		Usuario usuario = null;
		String sql = "SELECT * FROM Usuarios WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				usuario = new Usuario();
				usuario.setId(id);
				usuario.setNome(resultado.getString("nome"));
				usuario.setCpf(resultado.getString("cpf"));
				usuario.setEmail(resultado.getString("email"));
				usuario.setTelefone(resultado.getString("telefone"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				
			}
		} catch (SQLException e) {
			System.out.println("Erro encontrado:" + e);
			e.printStackTrace();
		}

		return usuario;
	}

	public void atualizarUsuario(Usuario usuario, int id) {
		String sql = "UPDATE Usuarios SET  nome = ?, cpf = ? , email = ?  WHERE ID = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getCpf());
			stmt.setString(3, usuario.getEmail());
			stmt.setInt(4, id);
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
				System.out.println("Erro encontrado:" + e);
			e.printStackTrace();
		}
	}

	public void excluirUsuario(int id) {
		String sql = "DELETE FROM Usuarios WHERE ID = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
