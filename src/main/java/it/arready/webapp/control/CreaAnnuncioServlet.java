package it.arready.webapp.control;

import java.io.IOException;
import java.util.Date;

import it.arready.webapp.model.Annuncio;
import it.arready.webapp.model.Annuncio.StatoVendita;
import it.arready.webapp.model.Immobile;
import it.arready.webapp.model.Indirizzo;
import it.arready.webapp.model.Utente;
import it.arready.webapp.service.ImmobileService;
import it.arready.webapp.service.ServiceException;
import it.arready.webapp.service.impl.ImmobileServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/crea-annuncio")
public class CreaAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ImmobileService immobileService = new ImmobileServiceImpl();

	public CreaAnnuncioServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Utente utente = new Utente();
		// session.getAttribute X, utenteDAOFindByX
		Immobile immobile = null;
		Date data = new Date();
		Indirizzo indirizzo = new Indirizzo();
		Annuncio annuncio = new Annuncio();
		annuncio.setDataAnnuncio(data);
		annuncio.setImmobile(immobile);

		for (StatoVendita statoVendita : StatoVendita.values()) {
			if (annuncio.getStatoVendita().equals(StatoVendita.values())) {
				annuncio.setStatoVendita(statoVendita);
			}

		}

		try {

			immobileService.save(immobile); // (indirizzo, immobile, annuncio)

			HttpSession session = request.getSession();

			session.setAttribute("provincia", indirizzo.getProvincia());
			session.setAttribute("citta", indirizzo.getCitta());
			session.setAttribute("via", indirizzo.getVia());
			session.setAttribute("numeroCivico", indirizzo.getNumeroCivico());

			session.setAttribute("immobile", immobile);
			session.setAttribute("descrizione", immobile.getDescrizione());
			session.setAttribute("prezzo", immobile.getPrezzo());
			session.setAttribute("numero locali", immobile.getNumLocali());
			session.setAttribute("numBagni", immobile.getNumBagni());
			session.setAttribute("superficie", immobile.getSuperficie());
			session.setAttribute("piano", immobile.getPiano());
			session.setAttribute("Stato Immobile", immobile.getStatoImmobile());
			session.setAttribute("indirizzo", immobile.getIndirizzo());

//			session.setAttribute("", annuncio.get);

		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("error.html");
		}

		annuncio.setUtente(utente);

		request.getRequestDispatcher("").forward(request, response);

	}

}