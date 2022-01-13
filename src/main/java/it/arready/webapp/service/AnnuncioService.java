package it.arready.webapp.service;

import java.util.List;

import it.arready.webapp.model.Annuncio;
import it.arready.webapp.model.Immobile.StatoImmobile;

public interface AnnuncioService {

	void save(Annuncio annuncio) throws ServiceException;

	void update(Annuncio annuncio) throws ServiceException;
	
	void delete(Annuncio annuncio) throws ServiceException;

	Annuncio findById(int id) throws ServiceException;

	List<Annuncio> orderByFind(Float prezzoMin, Float prezzoMax, Integer numLocali, Integer numBagni,
			Float superficie, Integer piano, StatoImmobile statoImmobile, String citta)
			throws ServiceException;

}
