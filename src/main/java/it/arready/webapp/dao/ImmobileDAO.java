package it.arready.webapp.dao;

import java.sql.Connection;
import java.util.List;

import it.arready.webapp.model.Immobile;
import it.arready.webapp.model.Immobile.StatoImmobile;

public interface ImmobileDAO {

	void save(Connection connection, Immobile immobile) throws DAOException;

	void update(Connection connection, Immobile immobile) throws DAOException;

	
	void delete(Connection connection, Immobile immobile) throws DAOException;
	
	Immobile findById(Connection connection, int id) throws DAOException;

	List<Immobile> orderByFind(Connection connection, Float prezzoMin, Float prezzoMax, Integer numLocali, Integer numBagni,
			Float superficie, Integer piano, StatoImmobile statoImmobile, String citta)
			throws DAOException;

}
