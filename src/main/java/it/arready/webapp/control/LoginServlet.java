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

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UtenteService utenteService = new UtenteServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		Utente utente = null;
		
		try {
			utente = utenteService.findByUsername(user);
			
			if(utente == null || !utente.getPassword().equals(request.getParameter("password"))) {
				request.setAttribute("errorLogin", "Username o Password errati");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("username", utente.getUsername());
			request.getRequestDispatcher("").forward(request, response);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("");
		}
		
	}

}
