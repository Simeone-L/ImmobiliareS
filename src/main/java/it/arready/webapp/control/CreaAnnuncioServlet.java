package it.arready.webapp.control;

import java.io.IOException;
import java.sql.Date;

import it.arready.webapp.model.Annuncio;
import it.arready.webapp.model.Annuncio.StatoVendita;
import it.arready.webapp.model.Immobile;
import it.arready.webapp.model.Utente;
import it.arready.webapp.service.ImmobileService;
import it.arready.webapp.service.ServiceException;
import it.arready.webapp.service.UtenteService;
import it.arready.webapp.service.impl.ImmobileServiceImpl;
import it.arready.webapp.service.impl.UtenteServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/crea-annuncio")
public class CreaAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtenteService utente = new UtenteServiceImpl();
	private ImmobileService immobileService = new ImmobileServiceImpl();

	public CreaAnnuncioServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Utente utente = new Utente();
		Immobile immobile = new Immobile();
		immobile.setDescrizione("descrizione");
		immobile.setPrezzo(0);
		immobile.setNumLocali(0);
		immobile.setNumBagni(0);
		immobile.setSuperficie(0);
		immobile.setPiano(0);
		immobile.setStatoImmobile(null);
		immobile.setVenduto(false);
		immobile.getIndirizzo();

		Date data = new Date(0);

		try {

			immobileService.save(immobile);
			HttpSession session = request.getSession();
			session.setAttribute("immobile", immobile);
			session.setAttribute("descrizione", immobile.getDescrizione());
			session.setAttribute("prezzo", immobile.getPrezzo());
			session.setAttribute("numero locali", immobile.getNumLocali());
			session.setAttribute("numBagni", immobile.getNumBagni());
			session.setAttribute("superficie", immobile.getSuperficie());
			session.setAttribute("piano", immobile.getPiano());
			session.setAttribute("Stato Immobile", immobile.getStatoImmobile());
			session.setAttribute("indirizzo", immobile.getIndirizzo());

		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("error.html");
		}

		Annuncio annuncio = new Annuncio();

		annuncio.setDataAnnuncio(data);
		annuncio.setImmobile(immobile);

		for (StatoVendita statoVendita : StatoVendita.values()) {
			if (statoVendita.equals(StatoVendita.values())) {
				annuncio.setStatoVendita(statoVendita);
			}

		}

		// Qui ci andrebbe l'annuncioService.save con la seconda sessione HTTP

		annuncio.setUtente(utente);

		request.getRequestDispatcher("").forward(request, response);

	}

}