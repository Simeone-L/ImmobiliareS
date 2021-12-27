package it.arready.webapp.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.arready.webapp.model.Utente;
import it.arready.webapp.service.ServiceException;
import it.arready.webapp.service.UtenteService;
import it.arready.webapp.service.impl.UtenteServiceImpl;

@WebServlet("/LoginServlet")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtenteService utenteService = new UtenteServiceImpl();

	public RegistrazioneServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utente utente = new Utente();
		utente.setNome("nome");
		utente.setNome("cognome");
		utente.setEmail("email");
		utente.setPassword("password");

		if (validate(request)) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}

		try {
			utenteService.save(utente);
			HttpSession session = request.getSession();
			session.setAttribute("utente", utente);
			session.setAttribute("nome", utente.getNome());
			session.setAttribute("cognome", utente.getCognome());
			session.setAttribute("email", utente.getEmail());
			session.setAttribute("password", utente.getPassword());

			request.getRequestDispatcher("").forward(request, response);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("");
		}

		doGet(request, response);
	}

	private boolean validate(HttpServletRequest request) {

		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		boolean hasErrors = false;

		if (nome == null || nome.trim().isEmpty()) {
			request.setAttribute("errorNome", "Campo Obbligatorio");
		}
		if (cognome == null || cognome.trim().isEmpty()) {
			request.setAttribute("errorCognome", "Campo Obbligatorio");
		}
		if (email == null || email.trim().isEmpty()) {
			request.setAttribute("errorEmail", "Campo Obbligatorio");
		}
		if (password == null || cognome.trim().isEmpty()) {
			request.setAttribute("errorPassword", "Campo Obbligatorio");
		}
	}
}
