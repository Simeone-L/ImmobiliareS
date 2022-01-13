package it.arready.webapp.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.arready.webapp.model.Immagine;
import it.arready.webapp.model.Immobile;
import it.arready.webapp.service.ImmagineService;
import it.arready.webapp.service.ServiceException;
import it.arready.webapp.service.impl.ImmagineServiceImpl;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
			response.sendRedirect("annuncio.html");
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("error.html");
		}
	}

}
