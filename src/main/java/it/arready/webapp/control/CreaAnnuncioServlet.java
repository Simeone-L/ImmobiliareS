package it.arready.webapp.control;

import java.io.IOException;

import it.arready.webapp.model.Annuncio;
import it.arready.webapp.model.Utente;
import it.arready.webapp.service.impl.UtenteServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/crea-annuncio")
public class CreaAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtenteServiceImpl utente = new UtenteServiceImpl();
       
    public CreaAnnuncioServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Annuncio annuncio = new Annuncio();
		
	}

}
