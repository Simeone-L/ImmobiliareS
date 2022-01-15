package it.arready.webapp.dao;

import java.sql.Connection;
import java.util.List;

import it.arready.webapp.model.Annuncio;
import it.arready.webapp.model.Annuncio.Ordinamento;
import it.arready.webapp.model.Annuncio.StatoVendita;
import it.arready.webapp.model.Immobile.StatoImmobile;

public interface AnnuncioDAO {

	void save(Connection conn, Annuncio annuncio) throws DAOException;

	void update(Connection conn, Annuncio annuncio) throws DAOException;

	void delete(Connection conn, Annuncio annuncio) throws DAOException;

	Annuncio findById(Connection conn, int id) throws DAOException;

	Annuncio findByTitolo(Connection conn, String titolo) throws DAOException;

	List<Annuncio> orderByFind(Connection conn, Float prezzoMin, Float prezzoMax, Integer numLocali, Integer numBagni,
			Float superficieMin, Float superficieMax, Integer piano, StatoImmobile statoImmobile, String citta,
			String titolo, String provincia, String indirizzo, Integer numeroCivico, StatoVendita statoVendita,
			Ordinamento ordinamento) throws DAOException;

}
