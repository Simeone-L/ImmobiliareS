package it.arready.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.arready.webapp.dao.DAOException;
import it.arready.webapp.dao.DBUtil;
import it.arready.webapp.dao.ImmobileDAO;
import it.arready.webapp.model.Immobile;

public class ImmobileDAOImpl implements ImmobileDAO {

	@Override
	public void save(Connection connection, Immobile immobile) throws DAOException {
		String sql = "INSERT INTO immobile(descrizione,prezzo,num_locali,num_bagni,superficie,piano,venduto,stato_immobile,indirizzo_id) VALUES(?,?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;
		try {
			statement = connection.prepareStatement(sql, new String[] { "id" });
			statement.setString(1, immobile.getDescrizione());
			statement.setFloat(2, immobile.getPrezzo());
			statement.setInt(3, immobile.getNumLocali());
			statement.setInt(4 , immobile.getNumBagni());
			statement.setFloat(5 , immobile.getSuperficie());
			statement.setInt(6 , immobile.getPiano());
			statement.setBoolean(7, immobile.isVenduto());
			statement.setString(8, immobile.getStatoImmobile().getNome());
			statement.setInt(9, immobile.getIndirizzo().getId());
			statement.executeUpdate();
			generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				immobile.setId(generatedKeys.getInt(1));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(generatedKeys);
			DBUtil.close(statement);
		}
	}

	@Override
	public void update(Connection connection, Immobile immobile) throws DAOException {
		String sql = "UPDATE immobile SET descrizione=?,prezzo=?,num_locali=?,num_bagni=?,superficie=?,piano=?,venduto=?,stato_immobile=?,indirizzo_id=? WHERE id=?";
		System.out.println(sql);
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, immobile.getDescrizione());
			statement.setFloat(2, immobile.getPrezzo());
			statement.setInt(3, immobile.getNumLocali());
			statement.setInt(4 , immobile.getNumBagni());
			statement.setFloat(5 , immobile.getSuperficie());
			statement.setInt(6 , immobile.getPiano());
			statement.setBoolean(7, immobile.isVenduto());
			statement.setString(8, immobile.getStatoImmobile().getNome());
			statement.setInt(9, immobile.getIndirizzo().getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(statement);
		}
	}

	public void delete(Connection connection, Immobile immobile) throws DAOException {
		String sql = "DELETE FROM immobile WHERE id=?";
		System.out.println(sql);
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, immobile.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(statement);
		}
	}

}
