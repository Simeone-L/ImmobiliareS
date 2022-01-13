package it.arready.webapp.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.arready.webapp.model.Annuncio;
import it.arready.webapp.model.Immagine;
import it.arready.webapp.model.Immobile;
import it.arready.webapp.service.AnnuncioService;
import it.arready.webapp.service.ImmagineService;
import it.arready.webapp.service.ServiceException;
import it.arready.webapp.service.impl.AnnuncioServiceImpl;
import it.arready.webapp.service.impl.ImmagineServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dettaglio-annuncio")
public class DettaglioAnnuncio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AnnuncioService annuncioService = new AnnuncioServiceImpl();
	private ImmagineService immagineService = new ImmagineServiceImpl();

	public DettaglioAnnuncio() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Immagine immagine = null;
			String idS = request.getParameter("id");
			int id = Integer.parseInt(idS);
			Annuncio annuncio = annuncioService.findById(id);
			List<Immagine> immagini = immagineService.ElencoImmagini(annuncio.getImmobile());

			request.getRequestDispatcher("").forward(request, response);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());

		}

	}

}
