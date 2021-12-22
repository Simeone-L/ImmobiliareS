package it.arready.webapp.dao;

import java.sql.Connection;
import java.util.List;

import it.arready.webapp.model.Indirizzo;

public interface IndirizzoDAO {
	
	void save(Connection connection, Indirizzo indirizzo) throws DAOException;
	
	void update(Connection connection, Indirizzo indirizzo) throws DAOException;
	
	void delete(Connection connection, Indirizzo indirizzo) throws DAOException;
	
	List<Indirizzo> findAll(Connection connection) throws DAOException;
	
	

}
