package it.arready.webapp.control;

import java.io.IOException;

import it.arready.webapp.model.Annuncio;
import it.arready.webapp.service.AnnuncioService;
import it.arready.webapp.service.impl.AnnuncioServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dettaglio-annuncio")
public class DettaglioAnnuncio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AnnuncioService annuncioService = new AnnuncioServiceImpl();
	

	public DettaglioAnnuncio() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Annuncio annuncio = null;
		
				
		
	}

}
