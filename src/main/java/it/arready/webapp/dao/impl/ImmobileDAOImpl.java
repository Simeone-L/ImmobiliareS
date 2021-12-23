package it.arready.webapp.dao.impl;

import java.sql.Connection;
import java.util.List;

import it.arready.webapp.dao.DAOException;
import it.arready.webapp.dao.ImmobileDAO;
import it.arready.webapp.model.Immobile;

public class ImmobileDAOImpl implements ImmobileDAO {

	@Override
	public void save(Connection connection, Immobile immobile) throws DAOException {
		
	}

	@Override
	public void update(Connection connection, Immobile immobile) throws DAOException {
		
	}

	@Override
	public Immobile findById(Connection connection, int id) throws DAOException {
		return null;
	}

	@Override
	public List<Immobile> findAll(Connection connection, Immobile immobile) throws DAOException {
		return null;
	}

	@Override
	public List<Immobile> findByCitta(Connection connection, String citta) throws DAOException {
		return null;
	}

	@Override
	public List<Immobile> orderByPrezzo(Connection connection) throws DAOException {
		return null;
	}

	@Override
	public List<Immobile> orderBySuperficie(Connection connection) throws DAOException {
		return null;
	}

	@Override
	public List<Immobile> orderByPriceFromTo(Connection connection, int priceMin, int priceMax) throws DAOException {
		return null;
	}
	
}
