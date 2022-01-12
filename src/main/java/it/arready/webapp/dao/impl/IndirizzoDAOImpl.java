package it.arready.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.arready.webapp.dao.DAOException;
import it.arready.webapp.dao.DBUtil;
import it.arready.webapp.dao.IndirizzoDAO;
import it.arready.webapp.model.Indirizzo;

public class IndirizzoDAOImpl implements IndirizzoDAO {

	@Override
	public void save(Connection connection, Indirizzo indirizzo) throws DAOException {
		String sql = "INSERT INTO indirizzo(provincia,citta,via,numero_civico,immobile_id) VALUES(?,?,?,?)";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;
		try {
			statement = connection.prepareStatement(sql, new String[] { "id" });
			statement.setString(1, indirizzo.getProvincia());
			statement.setString(2, indirizzo.getCitta());
			statement.setString(3, indirizzo.getVia());
			statement.setInt(4, indirizzo.getNumeroCivico());
			statement.executeUpdate();

			generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				indirizzo.setId(generatedKeys.getInt(1));
			}
			System.out.println(indirizzo);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(generatedKeys);
			DBUtil.close(statement);
		}
	}

	@Override
	public void update(Connection connection, Indirizzo indirizzo) throws DAOException {
		String sql = "UPDATE indirizzo SET provincia=?,citta=?, via=?, numero_civico=? WHERE id=?";
		System.out.println(sql);
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, indirizzo.getProvincia());
			statement.setString(2, indirizzo.getCitta());
			statement.setString(3, indirizzo.getVia());
			statement.setInt(4, indirizzo.getNumeroCivico());
			statement.executeUpdate();
			statement.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(statement);
		}
	}

	@Override
	public void delete(Connection connection, Indirizzo indirizzo) throws DAOException {
		String sql = "DELETE FROM indirizzo WHERE id=?";
		System.out.println(sql);
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, indirizzo.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(statement);
		}

	}

	@Override
	public List<Indirizzo> findAll(Connection connection) throws DAOException {
		String sql = "SELECT * FROM indirizzo";
		System.out.println(sql);
		List<Indirizzo> indirizzi = new ArrayList<Indirizzo>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Indirizzo indirizzo = new Indirizzo();
				indirizzo.setId(resultSet.getInt(1));
				indirizzo.setProvincia(resultSet.getString(2));
				indirizzo.setCitta(resultSet.getString(3));
				indirizzo.setVia(resultSet.getString(4));
				indirizzo.setNumeroCivico(resultSet.getInt(5));
				// immobile = (Immobile) resultSet.getObject(6);
				indirizzi.add(indirizzo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return indirizzi;
	}

}
