package it.arready.webapp.service;

import java.util.List;

import it.arready.webapp.model.Immagine;
import it.arready.webapp.model.Immobile;

public interface ImmagineService {
	
	void inserimentoImmagine(Immagine immagine) throws ServiceException;
	
	List<Immagine> elencoImmagini(Immobile immobile) throws ServiceException;
	
	void modificaImmagine(Immagine immagine) throws ServiceException;
	
	Immagine immaginePrincipale(Immobile immobile) throws ServiceException;
	
	void eliminaImmagine(Immagine immagine) throws ServiceException;

}
