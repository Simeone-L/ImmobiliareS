package it.arready.webapp.service;

import java.util.List;

import it.arready.webapp.model.Utente;

public interface UtenteService {
	void save(Utente utente) throws ServiceException;

	void update(Utente utente) throws ServiceException;

	void delete(Utente utente) throws ServiceException;

	Utente findById(int id) throws ServiceException;

	List<Utente> findAll() throws ServiceException;
	
	Utente findByUsername(String username) throws ServiceException;
}
