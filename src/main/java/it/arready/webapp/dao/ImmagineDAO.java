package it.arready.webapp.dao;

import java.sql.Connection;
import java.util.List;

import it.arready.webapp.model.Immagine;
import it.arready.webapp.model.Immobile;

public interface ImmagineDAO {

	void save(Connection conn, Immagine immagine) throws DAOException;

	void update(Connection conn, Immagine immagine) throws DAOException;
	
	List<Immagine> findImmobileImg(Connection conn, Immobile immobile) throws DAOException;
	
	Immagine findPrincipale(Connection conn, Immobile immobile) throws DAOException;

	void delete(Connection conn, Immagine immagine) throws DAOException;

}
