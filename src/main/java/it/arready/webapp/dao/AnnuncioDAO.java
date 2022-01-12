package it.arready.webapp.dao;

import java.sql.Connection;
import java.util.List;

import it.arready.webapp.model.Annuncio;
import it.arready.webapp.model.Immobile.StatoImmobile;

public interface AnnuncioDAO {

	void save(Connection conn, Annuncio annuncio) throws DAOException;

	void update(Connection conn, Annuncio annuncio) throws DAOException;

	void delete(Connection conn, Annuncio annuncio) throws DAOException;

	Annuncio findById(Connection conn, int id) throws DAOException;

	Annuncio findByTitolo(Connection conn, String titolo) throws DAOException;

	List<Annuncio> orderByFind(Connection conn, Float prezzoMin, Float prezzoMax, Integer numLocali, Integer numBagni,
			Float superficie, Integer piano, StatoImmobile statoImmobile, String citta) throws DAOException;

}
