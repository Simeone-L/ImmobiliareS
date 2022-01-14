package it.arready.webapp.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.arready.webapp.model.Annuncio;
import it.arready.webapp.model.Annuncio.StatoVendita;
import it.arready.webapp.model.Immagine;
import it.arready.webapp.model.Immobile;
import it.arready.webapp.model.Immobile.StatoImmobile;
import it.arready.webapp.model.Indirizzo;
import it.arready.webapp.model.Utente;
import it.arready.webapp.service.AnnuncioService;
import it.arready.webapp.service.ImmagineService;
import it.arready.webapp.service.ServiceException;
import it.arready.webapp.service.UtenteService;
import it.arready.webapp.service.impl.AnnuncioServiceImpl;
import it.arready.webapp.service.impl.ImmagineServiceImpl;
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
	private AnnuncioService annuncioService = new AnnuncioServiceImpl();
	private UtenteService utenteService = new UtenteServiceImpl();
	private ImmagineService immagineService = new ImmagineServiceImpl();

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
			annuncioService.save(annuncio);
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

			String statoImmobileString = request.getParameter("statoImmobile");
			StatoImmobile statoImmobile = StatoImmobile.corrispondenzaStatoString(statoImmobileString);
			immobile.setStatoImmobile(statoImmobile);
			immobile.setIndirizzo(indirizzo);

			// inizio annuncio
			annuncio.setDataAnnuncio(data);
			annuncio.setImmobile(immobile);
			for (StatoVendita statoVendita : StatoVendita.values()) {
				if (annuncio.getStatoVendita().equals(statoVendita)) {
					annuncio.setStatoVendita(statoVendita);
				}
			}

			String statoVenditaString = request.getParameter("statoVendita");
			StatoVendita statoVendita = StatoVendita.corrispondenzaStatoString(statoVenditaString);
			annuncio.setStatoVendita(statoVendita);
			// session.getAttribute X, utenteDAOFindByX
			String username = (String) session.getAttribute("username");
			utente = utenteService.findByUsername(username);
			annuncio.setUtente(utente);

			// inizio immagine
//
//			for (int i = 0; i <= immagini.size(); i++) {
			Immagine immagine1 = new Immagine();
			immagine1.setImmagineUrl(request.getParameter("immagineUrl1"));
			immagine1.setImmobile(immobile);
			immagine1.setPrincipale(true);

			if (request.getParameter("immagineUrl2") != null) {
				Immagine immagine2 = new Immagine();
				immagine2.setImmagineUrl(request.getParameter("immagineUrl2"));
				immagine2.setImmobile(immobile);
				immagine2.setPrincipale(false);
			}

			if (request.getParameter("immagineUrl3") != null) {
				Immagine immagine3 = new Immagine();
				immagine3.setImmagineUrl(request.getParameter("immagineUrl3"));
				immagine3.setImmobile(immobile);
				immagine3.setPrincipale(false);
			}
			if (request.getParameter("immagineUrl4") != null) {
				Immagine immagine4 = new Immagine();
				immagine4.setImmagineUrl(request.getParameter("immagineUrl4"));
				immagine4.setImmobile(immobile);
				immagine4.setPrincipale(false);
			}
			if (request.getParameter("immagineUrl5") != null) {
				Immagine immagine5 = new Immagine();
				immagine5.setImmagineUrl(request.getParameter("immagineUrl5"));
				immagine5.setImmobile(immobile);
				immagine5.setPrincipale(false);
			}
//				
//				immagini.add(immagine);
//
//				if (!(request.getParameter("immagineUrl") != null)) {
//					break;
//				}
//			}

			request.getRequestDispatcher("").forward(request, response);
			response.sendRedirect("/ricerca_completa.html");
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("error.html");
		}
		doGet(request, response);

	}

}