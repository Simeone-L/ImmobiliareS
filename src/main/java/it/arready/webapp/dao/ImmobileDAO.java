package it.arready.webapp.dao;

import java.sql.Connection;
import java.util.List;

import it.arready.webapp.model.Immobile;

public interface ImmobileDAO {

	void save(Connection connection, Immobile immobile) throws DAOException;

	void update(Connection connection, Immobile immobile) throws DAOException;

	Immobile findById(Connection connection, int id) throws DAOException;

	List<Immobile> findAll(Connection connection, Immobile immobile) throws DAOException;

	List<Immobile> findByCitta(Connection connection, String citta) throws DAOException;

	List<Immobile> orderByPrezzo(Connection connection) throws DAOException;

	List<Immobile> orderBySuperficie(Connection connection) throws DAOException;
	
	List<Immobile> orderByPriceFromTo (Connection connection, int priceMin, int priceMax) throws DAOException;

}
