package it.arready.webapp.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.arready.webapp.model.Annuncio;
import it.arready.webapp.model.Annuncio.Ordinamento;
import it.arready.webapp.model.Annuncio.StatoVendita;
import it.arready.webapp.model.Immobile.StatoImmobile;
import it.arready.webapp.service.AnnuncioService;
import it.arready.webapp.service.ServiceException;
import it.arready.webapp.service.impl.AnnuncioServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RicercaAnnuncioServlet
 */

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Annuncio> annunci = null;

		try {
			annunci = new ArrayList<Annuncio>();

			float prezzoMin = Float.parseFloat(request.getParameter("prezzoMin"));
			float prezzoMax = Float.parseFloat(request.getParameter("prezzoMax"));
			String statoImmobileString = request.getParameter("statoImmobile");
			StatoImmobile statoImmobile = null;
			for (StatoImmobile s : StatoImmobile.values()) {
				if (s.getNome().equals(statoImmobileString))
					statoImmobile = s;
			}
			int bagni = Integer.parseInt(request.getParameter("bagni"));
			int piano = Integer.parseInt(request.getParameter("piano"));
			int numeroLocali = Integer.parseInt(request.getParameter("numeroLocali"));
			float superficieMin = Float.parseFloat(request.getParameter("superficieMin"));
			float superficieMax = Float.parseFloat(request.getParameter("superficieMax"));
			String citta = request.getParameter("citta");
			String titolo = request.getParameter("titolo");
			String provincia = request.getParameter("provincia");
			String indirizzo = request.getParameter("indirizzo");
			int numeroCivico = Integer.parseInt(request.getParameter("numeroCivico"));

			String statoVenditaString = request.getParameter("statoVendita");
			StatoVendita statoVendita = null;
			for (StatoVendita sV : StatoVendita.values()) {
				if (sV.getNome().equals(statoVenditaString))
					statoVendita = sV;

			}

			String oPString = request.getParameter("ordinamentoPrezzo");
			Ordinamento ordinamentoPrezzo = null;
			for (Ordinamento ordinam : Ordinamento.values()) {
				if (ordinam.getOrdinam().equals(oPString))
					;
				ordinamentoPrezzo = ordinam;
			}

			String oSString = request.getParameter("ordinamentoSuperficie");
			Ordinamento ordinamentoSuperficie = null;
			for (Ordinamento ordinam : Ordinamento.values()) {
				if (ordinam.getOrdinam().equals(oSString))
					;
				ordinamentoPrezzo = ordinam;
			}

			annuncioService.orderByFind(prezzoMin, prezzoMax, numeroLocali, bagni, superficieMin, superficieMax, piano,
					statoImmobile, citta, titolo, provincia, indirizzo, numeroCivico, statoVendita, ordinamentoPrezzo,
					ordinamentoSuperficie);
			request.setAttribute("annunci", annunci);
			request.getRequestDispatcher("tutti_annunci.jsp").forward(request, response);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("error.html");
		}
	}

}
