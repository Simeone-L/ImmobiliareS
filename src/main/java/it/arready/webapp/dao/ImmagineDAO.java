package it.arready.webapp.dao;

import java.sql.Connection;
import java.util.List;

import it.arready.webapp.model.Immagine;

public interface ImmagineDAO {
	
	void save(Connection conn, Immagine immagine) throws DAOException;
	
	void update(Connection conn, Immagine immagine) throws DAOException;
	
	List<Immagine> findByAll(Connection conn) throws DAOException;
	
	void delete(Connection conn, Immagine immagine) throws DAOException;

}
