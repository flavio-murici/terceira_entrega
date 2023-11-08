package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuario = usuarioDAO.buscarUsuario(id);

			request.setAttribute("usuario", usuario);

			RequestDispatcher rd = request.getRequestDispatcher("atualizar.jsp");
			rd.forward(request, response);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Usuario usuario = new Usuario();
			usuario.setId(Integer.parseInt(request.getParameter("id")));
			usuario.setNome(request.getParameter("nome"));
			usuario.setCpf(request.getParameter("cpf"));
			usuario.setEmail(request.getParameter("email"));
			usuario.setTelefone(request.getParameter("telefone"));
			usuario.setLogin(request.getParameter("login"));
			usuario.setSenha(request.getParameter("senha"));
			

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.atualizarUsuario(usuario, usuario.getId());

			response.sendRedirect("ReadController");
		} catch (Exception e) {

		}

	}

}
