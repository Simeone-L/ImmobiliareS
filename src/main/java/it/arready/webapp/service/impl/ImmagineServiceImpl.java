package it.arready.webapp.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.arready.webapp.dao.DAOException;
import it.arready.webapp.dao.DBUtil;
import it.arready.webapp.dao.DataSource;
import it.arready.webapp.dao.ImmagineDAO;
import it.arready.webapp.dao.impl.ImmagineDAOImpl;
import it.arready.webapp.model.Immagine;
import it.arready.webapp.service.ImmagineService;
import it.arready.webapp.service.ServiceException;

public class ImmagineServiceImpl implements ImmagineService {
	
	private ImmagineDAO immagineDAO = new ImmagineDAOImpl();

	@Override
	public void InserimentoImmagine(Immagine immagine) throws ServiceException {
		Connection conn = null;
		try {
			conn = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(conn, false);
			immagineDAO.save(conn, immagine);
			DBUtil.commit(conn);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
			DBUtil.rollback(conn);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public List<Immagine> ElencoImmagini() throws ServiceException {
		Connection conn = null;
		List<Immagine> immagini = new ArrayList<Immagine>();
		try {
			conn = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(conn, false);
			immagini = immagineDAO.findAll(conn);
			DBUtil.commit(conn);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
			DBUtil.rollback(conn);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(conn);
		}
		return immagini;
	}

	@Override
	public void ModificaImmagine(Immagine immagine) throws ServiceException {
		Connection conn = null;
		try {
			conn = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(conn, false);
			immagineDAO.update(conn, immagine);
			DBUtil.commit(conn);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
			DBUtil.rollback(conn);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public void EliminaImmagine(Immagine immagine) throws ServiceException {
		Connection conn = null;
		try {
			conn = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(conn, false);
			immagineDAO.delete(conn, immagine);
			DBUtil.commit(conn);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
			DBUtil.rollback(conn);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(conn);
		}
	}
	
}
