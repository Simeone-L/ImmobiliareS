package it.arready.webapp.service;

import java.util.List;

import it.arready.webapp.model.Immagine;

public interface ImmagineService {
	
	void InserimentoImmagine(Immagine immagine) throws ServiceException;
	
	List<Immagine> ElencoImmagini() throws ServiceException;
	
	void ModificaImmagine(Immagine immagine) throws ServiceException;
	
	void EliminaImmagine(Immagine immagine) throws ServiceException;

}
