package it.arready.webapp.service.impl;

import java.sql.Connection;
import java.util.List;

import it.arready.webapp.dao.DAOException;
import it.arready.webapp.dao.DBUtil;
import it.arready.webapp.dao.DataSource;
import it.arready.webapp.dao.ImmobileDAO;
import it.arready.webapp.dao.impl.ImmobileDAOImpl;
import it.arready.webapp.model.Immobile;
import it.arready.webapp.model.Immobile.StatoImmobile;
import it.arready.webapp.service.ImmobileService;
import it.arready.webapp.service.ServiceException;

public class ImmobileServiceImpl implements ImmobileService {

	private ImmobileDAO immobileDAO = new ImmobileDAOImpl();
	
	@Override
	public void save(Immobile immobile) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			immobileDAO.save(connection, immobile);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
	}
	

	@Override
	public void update(Immobile immobile) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			immobileDAO.update(connection, immobile);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
	}
	
	
	
	
	public void delete(Immobile immobile) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			immobileDAO.delete(connection, immobile);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Immobile findById(int id) throws ServiceException {
		Immobile immobile = null;
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			immobile = immobileDAO.findById(connection, id);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return immobile;
	}

	

	@Override
	public List<Immobile> orderByPriceFromTo(int priceMin, int priceMax) throws ServiceException {
		return null;
	}


	@Override
	public List<Immobile> orderByFind(Connection connection, Float prezzo, Integer numLocali, Integer numBagni,
			Float superficie, Integer piano, StatoImmobile statoImmobile, String citta) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
