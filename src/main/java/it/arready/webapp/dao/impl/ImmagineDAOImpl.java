package it.arready.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.arready.webapp.dao.DAOException;
import it.arready.webapp.dao.DBUtil;
import it.arready.webapp.dao.ImmagineDAO;
import it.arready.webapp.model.Immagine;
import it.arready.webapp.model.Immobile;

public class ImmagineDAOImpl implements ImmagineDAO {

	@Override
	public void save(Connection conn, Immagine immagine) throws DAOException {
		String sql = "INSERT INTO immagine(immagine_url, principale, immobile_id) VALUES(?,?,?)";
		// System.out.println(sql);
		PreparedStatement stat = null;
		ResultSet genKey = null;
		try {
			stat = conn.prepareStatement(sql, new String[] { "id" });
			stat.setString(1, immagine.getImmagineUrl());
			stat.setBoolean(2, immagine.isPrincipale());
			stat.setInt(3, immagine.getImmobile().getId());
			stat.executeUpdate();
			genKey = stat.getGeneratedKeys();
			if (genKey.next()) {
				immagine.setId(genKey.getInt(1));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(genKey);
			DBUtil.close(stat);
		}

	}

	@Override
	public void update(Connection conn, Immagine immagine) throws DAOException {
		String sql = "UPDATE immagine SET immagine_url=?, principale=? WHERE id=?";
		// System.out.println(sql);
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(sql);
			stat.setString(1, immagine.getImmagineUrl());
			stat.setBoolean(2, immagine.isPrincipale());
			stat.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(stat);
		}
	}

	@Override
	public List<Immagine> findByImmobile(Connection conn, Immobile immobile) throws DAOException {
		String sql = "SELECT * FROM immagine inner join IMMOBILE on immobile.id = immagine.immobile_id";
		// System.out.println(sql);
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<Immagine> immagini = new ArrayList<Immagine>();
		try {
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {
				Immagine immagine = new Immagine();
				immagine.setId(rs.getInt(1));
				immagine.setImmagineUrl(rs.getString(2));
				immagine.setPrincipale(rs.getBoolean(3));
				immagini.add(immagine);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stat);
		}
		return immagini;
	}

	@Override
	public void delete(Connection conn, Immagine immagine) throws DAOException {
		String sql = "DELETE FROM immagine WHERE id=?";
		// System.out.println(sql);
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1, immagine.getId());
			stat.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(stat);
		}
	}

}
