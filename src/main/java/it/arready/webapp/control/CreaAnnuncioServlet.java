package it.arready.webapp.control;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.arready.webapp.model.Annuncio;
import it.arready.webapp.model.Annuncio.StatoVendita;
import it.arready.webapp.model.Immobile;
import it.arready.webapp.model.Immobile.StatoImmobile;
import it.arready.webapp.model.Indirizzo;
import it.arready.webapp.model.Utente;
import it.arready.webapp.service.AnnuncioService;
import it.arready.webapp.service.ServiceException;
import it.arready.webapp.service.UtenteService;
import it.arready.webapp.service.impl.AnnuncioServiceImpl;
import it.arready.webapp.service.impl.UtenteServiceImpl;

@WebServlet("/crea-annuncio")
public class CreaAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AnnuncioService annuncioService = new AnnuncioServiceImpl();
	private UtenteService utenteService = new UtenteServiceImpl();

	public CreaAnnuncioServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Date data = null;

		Immobile immobile = null;
		Utente utente = null;
		Indirizzo indirizzo = null;
		Annuncio annuncio = null;

		try {
//			immobileService.save(immobile); // (indirizzo, immobile, annuncio)
			HttpSession session = request.getSession();

			immobile = new Immobile();
			utente = new Utente();
			indirizzo = new Indirizzo();
			annuncio = new Annuncio();

			// inizio indirizzo
			indirizzo.setProvincia(request.getParameter("provincia"));
			indirizzo.setCitta(request.getParameter("citta"));
			indirizzo.setVia(request.getParameter("via"));
			// cast del civico
			String civicoString = request.getParameter("numeroCivico");
			int civicoInt = Integer.parseInt(civicoString);
			indirizzo.setNumeroCivico(civicoInt);

			// inizio immobile
			immobile.setDescrizione(request.getParameter("descrizione"));
			// cast prezzo, locali, bagni, superficie, piano
			String prezzoAsString = request.getParameter("prezzo");
			float prezzoFloat = Float.parseFloat(prezzoAsString);
			immobile.setPrezzo(prezzoFloat);

			String numLocaliString = request.getParameter("numLocali");
			int numLocaliInt = Integer.parseInt(numLocaliString);
			immobile.setNumLocali(numLocaliInt);

			String numBagniString = request.getParameter("numBagni");
			int numBagniInt = Integer.parseInt(numBagniString);
			immobile.setNumBagni(numBagniInt);

			String superficieString = request.getParameter("superficie");
			float superficieFloat = Float.parseFloat(superficieString);
			immobile.setSuperficie(superficieFloat);

			String pianoString = request.getParameter("piano");
			int pianoInt = Integer.parseInt(pianoString);
			immobile.setPiano(pianoInt);

			for (StatoImmobile statoImmobile : StatoImmobile.values()) {
				if (immobile.getStatoImmobile().equals(statoImmobile)) {
					immobile.setStatoImmobile(statoImmobile);
				}
			}
			immobile.setIndirizzo(indirizzo);

			// inizio annuncio
			annuncio.setDataAnnuncio(data);
			annuncio.setImmobile(immobile);
			for (StatoVendita statoVendita : StatoVendita.values()) {
				if (annuncio.getStatoVendita().equals(statoVendita)) {
					annuncio.setStatoVendita(statoVendita);
				}
			}
			// session.getAttribute X, utenteDAOFindByX
			String nome = (String) session.getAttribute("nome");
			utente = utenteService.findByUsername(nome);
			annuncio.setUtente(utente);

			request.getRequestDispatcher("").forward(request, response);

		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("error.html");
		}
		doGet(request, response);
	}

}