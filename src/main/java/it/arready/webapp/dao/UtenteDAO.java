package it.arready.webapp.dao;

import java.sql.Connection;
import java.util.List;

import it.arready.webapp.model.Utente;

public interface UtenteDAO {
	void save(Connection connection, Utente utente) throws DAOException;

	void update(Connection connection, Utente utente) throws DAOException;
	
	void delete(Connection connection, Utente utente) throws DAOException;
	
	Utente findById(Connection connection, int id) throws DAOException;

	Utente findByUsername(Connection connection, String username) throws DAOException;

	List<Utente> findAll(Connection connection) throws DAOException;
	
	
}
