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

			Float prezzoMin = 0f;
			if (request.getParameter("prezzoMin") != "0")
				Float.parseFloat(request.getParameter("prezzoMin"));

			Float prezzoMax = 5000000f;
			if (request.getParameter("prezzoMax") != "5000000")
				Float.parseFloat(request.getParameter("prezzoMax"));

			Integer bagni = 0;
			if (request.getParameter("bagni") != "0")
				bagni = Integer.parseInt(request.getParameter("bagni"));

			Integer piano = -10;
			if (request.getParameter("piano") != "-10")
				piano = Integer.parseInt(request.getParameter("piano"));

			Integer numeroLocali = 0;
			if (request.getParameter("numeroLocali") != "0")
				numeroLocali = Integer.parseInt(request.getParameter("numeroLocali"));

			Float superficieMin = 0f;
			if (request.getParameter("superficieMin") != "0")
				Float.parseFloat(request.getParameter("superficieMin"));

			Float superficieMax = 100000f;
			if (request.getParameter("superficieMax") != "100000")
				Float.parseFloat(request.getParameter("superficieMax"));

			String citta = "qualsiasi";
			if (request.getParameter("citta") != "qualsiasi")
				citta = request.getParameter("citta");

			String titolo = "qualsiasi";
			if (request.getParameter("titolo") != "qualsiasi")
				titolo = request.getParameter("titolo");

			String provincia = "qualsiasi";
			if (request.getParameter("provincia") != null)
				provincia = request.getParameter("provincia");

			String indirizzo = "qualsiasi";
			if (request.getParameter("indirizzo") != "qualsiasi")
				indirizzo = request.getParameter("indirizzo");

			Integer numeroCivico = 0;
			if (request.getParameter("numeroCivico") != "0")
				numeroCivico = Integer.parseInt(request.getParameter("numeroCivico"));
			
			String statoImmobileString = "qualsiasi";
			StatoImmobile statoImmobile = StatoImmobile.DEFAULT;
			if (request.getParameter("statoImmobile") != "qualsiasi") {
				statoImmobileString = request.getParameter("statoImmobile");
				for (StatoImmobile s : StatoImmobile.values()) {
					if (s.getNome().equals(statoImmobileString))
						statoImmobile = s;
				}
			}

			String statoVenditaString = "qualsiasi";
			StatoVendita statoVendita = StatoVendita.DEFAULT;
			if (request.getParameter("statoVendita") != "qualsiasi") {
				statoVenditaString = request.getParameter("statoVendita");
				for (StatoVendita sV : StatoVendita.values()) {
					if (sV.getNome().equals(statoVenditaString))
						statoVendita = sV;
				}
			}

			String oPString = "crescente";
			Ordinamento ordinamentoPrezzo = Ordinamento.ASC;
			if (request.getParameter("ordinamentoPrezzo") != "crescente") {
				oPString = request.getParameter("ordinamentoPrezzo");
				ordinamentoPrezzo = null;
				for (Ordinamento ordinam : Ordinamento.values()) {
					if (ordinam.getOrdinam().equals(oPString))
						;
					ordinamentoPrezzo = ordinam;
				}
			}

			String oSString = "crescente";
			Ordinamento ordinamentoSuperficie = Ordinamento.ASC;
			if (request.getParameter("ordinamentoSuperficie") != "crescente") {
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
