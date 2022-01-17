
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Annuncio> annunci = null;

		try {
			annunci = new ArrayList<Annuncio>();

			Float prezzoMin = Float.parseFloat(request.getParameter("prezzoMin"));
			Float prezzoMax = Float.parseFloat(request.getParameter("prezzoMax"));

			StatoImmobile statoImmobile = null;
			if (request.getParameter("statoImmobile") != null) {
				String statoImmobileString = request.getParameter("statoImmobile");
				for (StatoImmobile s : StatoImmobile.values()) {
					if (s.getNome().equals(statoImmobileString))
						statoImmobile = s;
				}
			}

			Integer bagni = 0;
			if (request.getParameter("bagni") != null)
				bagni = Integer.parseInt(request.getParameter("bagni"));

			Integer piano = null;
			if (request.getParameter("piano") != null)
				piano = Integer.parseInt(request.getParameter("piano"));

			Integer numeroLocali = null;
			if (request.getParameter("numeroLocali") != null)
				numeroLocali = Integer.parseInt(request.getParameter("numeroLocali"));

			Float superficieMin = Float.parseFloat(request.getParameter("superficieMin"));

			Float superficieMax = Float.parseFloat(request.getParameter("superficieMax"));

			String citta = null;
			if (request.getParameter("citta") != null)
				citta = request.getParameter("citta");

			String titolo = null;
			if (request.getParameter("titolo") != null)
				titolo = request.getParameter("titolo");

			String provincia = null;
			if (request.getParameter("provincia") != null)
				provincia = request.getParameter("provincia");

			String indirizzo = null;
			if (request.getParameter("indirizzo") != null)
				indirizzo = request.getParameter("indirizzo");

			Integer numeroCivico = null;
			if (request.getParameter("numeroCivico") != null)
				numeroCivico = Integer.parseInt(request.getParameter("numeroCivico"));

			String statoVenditaString = null;
			StatoVendita statoVendita = null;
			if (request.getParameter("statoVendita") != null) {
				statoVenditaString = request.getParameter("statoVendita");
				for (StatoVendita sV : StatoVendita.values()) {
					if (sV.getNome().equals(statoVenditaString))
						statoVendita = sV;

				}
			}

			String oPString = null;
			Ordinamento ordinamentoPrezzo = null;
			if (request.getParameter("ordinamentoPrezzo") != null) {
				oPString = request.getParameter("ordinamentoPrezzo");
				ordinamentoPrezzo = null;
				for (Ordinamento ordinam : Ordinamento.values()) {
					if (ordinam.getOrdinam().equals(oPString))
						;
					ordinamentoPrezzo = ordinam;
				}
			}

			String oSString = null;
			Ordinamento ordinamentoSuperficie = null;
			if (request.getParameter("ordinamentoSuperficie") != null) {
				oSString = request.getParameter("ordinamentoSuperficie");
				ordinamentoSuperficie = null;
				for (Ordinamento ordinam : Ordinamento.values()) {
					if (ordinam.getOrdinam().equals(oSString))
						;
					ordinamentoSuperficie = ordinam;
				}
			}

			annunci = annuncioService.orderByFind(prezzoMin, prezzoMax, numeroLocali, bagni, superficieMin,
					superficieMax, piano, statoImmobile, citta, titolo, provincia, indirizzo, numeroCivico,
					statoVendita, ordinamentoPrezzo, ordinamentoSuperficie);
			request.setAttribute("annunci", annunci);
			request.getRequestDispatcher("tutti_annunci.jsp").forward(request, response);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("error.html");
		}
	}

}