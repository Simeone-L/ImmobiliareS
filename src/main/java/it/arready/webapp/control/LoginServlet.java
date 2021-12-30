package it.arready.webapp.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.arready.webapp.model.Utente;
import it.arready.webapp.service.ServiceException;
import it.arready.webapp.service.UtenteService;
import it.arready.webapp.service.impl.UtenteServiceImpl;

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
			
			if(utente == null || !utente.getPassword().equals(request.getParameter("Password"))) {
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
