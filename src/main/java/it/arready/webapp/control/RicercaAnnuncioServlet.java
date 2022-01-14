package it.arready.webapp.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.arready.webapp.model.Annuncio;
import it.arready.webapp.model.Immobile.StatoImmobile;
import it.arready.webapp.service.AnnuncioService;
import it.arready.webapp.service.ServiceException;
import it.arready.webapp.service.impl.AnnuncioServiceImpl;

/**
 * Servlet implementation class RicercaAnnuncioServlet
 */
@WebServlet(name = "ricerca-annuncio", urlPatterns = { "/ricerca-annuncio" })
public class RicercaAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AnnuncioService annuncioService = new AnnuncioServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RicercaAnnuncioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Annuncio> annunci = null;
		
		try {
			annunci = new ArrayList<Annuncio>();
			
			float prezzoMin = Float.parseFloat(request.getParameter("prezzoMin"));
			float prezzoMax = Float.parseFloat(request.getParameter("prezzoMax"));
			String statoImmobileString = request.getParameter("statoImmobile");
			StatoImmobile statoImmobile = null;
			for(StatoImmobile s : StatoImmobile.values()) {
				if(s.getNome().equals(statoImmobileString)) statoImmobile = s;
			}
			int bagni = Integer.parseInt(request.getParameter("bagni"));
			int piano = Integer.parseInt(request.getParameter("piano"));
			int numeroLocali = Integer.parseInt(request.getParameter("numeroLocali"));
			float superficie = Float.parseFloat(request.getParameter("superficie"));
			String citta = request.getParameter("citta");
			String titolo = request.getParameter("titolo");
			
			
			annuncioService.orderByFind(prezzoMin, prezzoMax, numeroLocali, bagni, superficie, piano, statoImmobile, citta, titolo);
			request.setAttribute("annunci", annunci);
			request.getRequestDispatcher("tutti_annunci.jsp").forward(request, response);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("error.html");
		}
	}

}
