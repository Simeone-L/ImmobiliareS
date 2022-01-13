package it.arready.webapp.control;

import java.io.IOException;

import it.arready.webapp.model.Utente;
import it.arready.webapp.service.ServiceException;
import it.arready.webapp.service.UtenteService;
import it.arready.webapp.service.impl.UtenteServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtenteService utenteService = new UtenteServiceImpl();

	public RegistrazioneServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utente utente = new Utente();
		utente.setUsername(request.getParameter("username"));
		utente.setNome(request.getParameter("nome"));
		utente.setCognome(request.getParameter("cognome"));
		utente.setEmail(request.getParameter("email"));
		utente.setPassword(request.getParameter("password"));

		if (validate(request)) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}

		try {
			utenteService.save(utente);
			HttpSession session = request.getSession();
			session.setAttribute("utente", utente);
			session.setAttribute("username", utente.getUsername());
			session.setAttribute("nome", utente.getNome());
			session.setAttribute("cognome", utente.getCognome());
			session.setAttribute("email", utente.getEmail());
			session.setAttribute("password", utente.getPassword());
			request.getRequestDispatcher("").forward(request, response);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("error.html");
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
			hasErrors = true;
		}
		if (cognome == null || cognome.trim().isEmpty()) {
			request.setAttribute("errorCognome", "Campo Obbligatorio");
			hasErrors = true;
		}
		if (email == null || email.trim().isEmpty()) {
			request.setAttribute("errorEmail", "Campo Obbligatorio");
			hasErrors = true;
		}
		if (password == null || cognome.trim().isEmpty()) {
			request.setAttribute("errorPassword", "Campo Obbligatorio");
			hasErrors = true;
		}

		return hasErrors;
	}
}
