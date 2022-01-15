package it.arready.webapp.service.impl;

import java.sql.Connection;
import java.util.List;

import it.arready.webapp.dao.AnnuncioDAO;
import it.arready.webapp.dao.DAOException;
import it.arready.webapp.dao.DBUtil;
import it.arready.webapp.dao.DataSource;
import it.arready.webapp.dao.ImmobileDAO;
import it.arready.webapp.dao.IndirizzoDAO;
import it.arready.webapp.dao.impl.AnnuncioDAOImpl;
import it.arready.webapp.dao.impl.ImmobileDAOImpl;
import it.arready.webapp.dao.impl.IndirizzoDAOImpl;
import it.arready.webapp.model.Annuncio;
import it.arready.webapp.model.Annuncio.Ordinamento;
import it.arready.webapp.model.Annuncio.StatoVendita;
import it.arready.webapp.model.Immobile.StatoImmobile;
import it.arready.webapp.service.AnnuncioService;
import it.arready.webapp.service.ServiceException;

public class AnnuncioServiceImpl implements AnnuncioService {

	private IndirizzoDAO indirizzoDAO = new IndirizzoDAOImpl();
	private ImmobileDAO immobileDAO = new ImmobileDAOImpl();
	private AnnuncioDAO annuncioDAO = new AnnuncioDAOImpl();

	@Override
	public void save(Annuncio annuncio) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			indirizzoDAO.save(connection, annuncio.getImmobile().getIndirizzo());
			immobileDAO.save(connection, annuncio.getImmobile());
			annuncioDAO.save(connection, annuncio);
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
	public void update(Annuncio annuncio) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			indirizzoDAO.update(connection, annuncio.getImmobile().getIndirizzo());
			immobileDAO.update(connection, annuncio.getImmobile());
			annuncioDAO.update(connection, annuncio);
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
	public void delete(Annuncio annuncio) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			annuncioDAO.delete(connection, annuncio);
			immobileDAO.delete(connection, annuncio.getImmobile());
			indirizzoDAO.delete(connection, annuncio.getImmobile().getIndirizzo());
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
	public Annuncio findById(int id) throws ServiceException {
		Annuncio annuncio = null;
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			annuncio = annuncioDAO.findById(connection, id);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return annuncio;
	}

	@Override
	public Annuncio findByTitolo(String titolo) throws ServiceException {
		Annuncio annuncio = null;
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			annuncio = annuncioDAO.findByTitolo(connection, titolo);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return annuncio;
	}

	@Override
	public List<Annuncio> orderByFind(Float prezzoMin, Float prezzoMax, Integer numLocali, Integer numBagni,
			Float superficieMin, Float superficieMax, Integer piano, StatoImmobile statoImmobile, String citta,
			String titolo, String provincia, String indirizzo, Integer numeroCivico, StatoVendita statoVendita,
			Ordinamento ordinamentoPrezzo, Ordinamento ordinamentoSuperficie) throws ServiceException {
		List<Annuncio> annunci = null;
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			annunci = annuncioDAO.orderByFind(connection, prezzoMin, prezzoMax, numLocali, numBagni, superficieMin,
					superficieMax, piano, statoImmobile, citta, titolo, titolo, titolo, piano, null, ordinamentoPrezzo,
					ordinamentoSuperficie);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
		return annunci;
	}

}
