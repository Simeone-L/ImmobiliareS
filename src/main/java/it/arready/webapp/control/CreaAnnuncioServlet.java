package it.arready.webapp.control;

import java.io.IOException;
import java.sql.Date;

import it.arready.webapp.model.Annuncio;
import it.arready.webapp.model.Annuncio.StatoVendita;
import it.arready.webapp.model.Immobile;
import it.arready.webapp.model.Utente;
import it.arready.webapp.service.UtenteService;
import it.arready.webapp.service.impl.UtenteServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/crea-annuncio")
public class CreaAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtenteService utente = new UtenteServiceImpl();

	public CreaAnnuncioServlet() {
		super();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utente utente = new Utente();

		Date data = new Date(0);

		Immobile immobile = new Immobile();
		
		Annuncio annuncio = new Annuncio();

		annuncio.setDataAnnuncio(data);
		annuncio.setImmobile(immobile);

		for (StatoVendita statoVendita : StatoVendita.values()) {
			if (statoVendita.equals(StatoVendita.values())) {
				annuncio.setStatoVendita(statoVendita);
			}
			
		}
		annuncio.setUtente(utente);

		request.getRequestDispatcher("").forward(request, response);

	}

}