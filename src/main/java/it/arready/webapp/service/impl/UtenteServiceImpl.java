package it.arready.webapp.service.impl;

import java.sql.Connection;
import java.util.List;

import it.arready.webapp.dao.DAOException;
import it.arready.webapp.dao.DBUtil;
import it.arready.webapp.dao.DataSource;
import it.arready.webapp.dao.UtenteDAO;
import it.arready.webapp.dao.impl.UtenteDAOImpl;
import it.arready.webapp.model.Utente;
import it.arready.webapp.service.ServiceException;
import it.arready.webapp.service.UtenteService;


public class UtenteServiceImpl implements UtenteService {

	private UtenteDAO utenteDAO = new UtenteDAOImpl();
	
	@Override
	public void save(Utente utente) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			utenteDAO.save(connection, utente);
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
	public void update(Utente utente) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			utenteDAO.update(connection, utente);
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
	public void delete(Utente utente) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			utenteDAO.delete(connection, utente);
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
	public Utente findById(int id) throws ServiceException {
		Connection connection = null;
		Utente utente = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			utente = utenteDAO.findById(connection, id);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}	
		return utente;
	}

	@Override
	public List<Utente> findAll() throws ServiceException {
		List<Utente> utenti = null;
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			utenti = utenteDAO.findAll(connection);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return utenti;
	}

	@Override
	public Utente findByUsername(String username) throws ServiceException {
		Utente utente = null;
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			utente = utenteDAO.findByUsername(connection, username);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}	
		return utente;
	}

}
