package it.arready.webapp.control;

import java.io.IOException;

import it.arready.webapp.model.Immobile;
import it.arready.webapp.service.ImmobileService;
import it.arready.webapp.service.ServiceException;
import it.arready.webapp.service.impl.ImmobileServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/dettaglio-annuncio")
public class DettaglioAnnuncio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ImmobileService immobileService = new ImmobileServiceImpl();

	public DettaglioAnnuncio() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int immobileId = request.getParameter("id");
		Immobile immobile = null;
		try {
			
			immobile = immobileService.findById(immobileId);
			
			HttpSession session = request.getSession();
			session.setAttribute("id", immobile.getId());
			request.getRequestDispatcher("").forward(request, response);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("");
		}

	}

}
