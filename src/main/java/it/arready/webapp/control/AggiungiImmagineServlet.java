package it.arready.webapp.control;

import java.io.IOException;

import it.arready.webapp.model.Immagine;
import it.arready.webapp.model.Immobile;
import it.arready.webapp.service.ImmagineService;
import it.arready.webapp.service.ServiceException;
import it.arready.webapp.service.impl.ImmagineServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AggiungiImmagineServlet
 */
@WebServlet(name = "aggiungi-immagine", urlPatterns = { "/aggiungi-immagine" })
public class AggiungiImmagineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ImmagineService immagineService = new ImmagineServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AggiungiImmagineServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Immagine immagine = null;
		Immobile immobile = null;

		try {
			immagine = new Immagine();
			immagine.setId(Integer.parseInt(request.getParameter("img_id")));
			immagine.setImmagineUrl(request.getParameter("imgUrl"));
			immagine.setPrincipale(false);
			immobile = new Immobile();
			immobile.setId(Integer.parseInt(request.getParameter("immb_id")));
			immagine.setImmobile(immobile);

			immagineService.inserimentoImmagine(immagine);

			response.sendRedirect("annuncio.jsp");
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("error.html");
		}
	}

}
