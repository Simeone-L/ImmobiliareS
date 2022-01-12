package it.arready.webapp.dao;

import java.sql.Connection;

import it.arready.webapp.model.Immobile;

public interface ImmobileDAO {

	void save(Connection connection, Immobile immobile) throws DAOException;

	void update(Connection connection, Immobile immobile) throws DAOException;

	void delete(Connection connection, Immobile immobile) throws DAOException;

}
