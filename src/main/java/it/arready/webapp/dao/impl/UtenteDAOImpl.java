package it.arready.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.arready.webapp.dao.DAOException;
import it.arready.webapp.dao.DBUtil;
import it.arready.webapp.dao.UtenteDAO;
import it.arready.webapp.model.Utente;


public class UtenteDAOImpl implements UtenteDAO {

	@Override
	public void save(Connection connection, Utente utente) throws DAOException {
		String sql = "INSERT INTO utente(username,password, nome, cognome, email) VALUES(?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;
		try {
			statement = connection.prepareStatement(sql, new String[] { "id" });
			statement.setString(1, utente.getUsername());
			statement.setString(2, utente.getPassword());
			statement.setString(3, utente.getNome());
			statement.setString(4, utente.getCognome());
			statement.setString(5, utente.getEmail());
			statement.executeUpdate();
			System.out.println(utente);
			
			generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				utente.setId(generatedKeys.getInt(1));
			}
			System.out.println(utente);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(generatedKeys);
			DBUtil.close(statement);
		}
	}


	@Override
	public void update(Connection connection, Utente utente) throws DAOException {
		String sql = "UPDATE utente SET username=?,password=?, nome=?, cognome=?, email=? WHERE id=?";
		System.out.println(sql);
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, utente.getUsername());
			statement.setString(2, utente.getPassword());
			statement.setString(3, utente.getNome());
			statement.setString(4, utente.getCognome());
			statement.setString(5, utente.getEmail());
			statement.setInt(6, utente.getId());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(statement);
		}
		
	}

	@Override
	public void delete(Connection connection, Utente utente) throws DAOException {
		String sql = "DELETE FROM utente WHERE id=?";
		System.out.println(sql);
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, utente.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(statement);
		}
		
	}

	@Override
	public Utente findById(Connection connection, int id) throws DAOException {
		String sql = "SELECT * FROM utente WHERE id=?";
		System.out.println(sql);
		Utente utente = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				utente = new Utente();
				utente.setId(resultSet.getInt(1));
				utente.setUsername(resultSet.getString(2));
				utente.setPassword(resultSet.getString(3));
				utente.setNome(resultSet.getString(4));
				utente.setCognome(resultSet.getString(5));
				utente.setEmail(resultSet.getString(6));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return utente;
	}

	@Override
	public Utente findByUsername(Connection connection, String username) throws DAOException {
		String sql = "SELECT * FROM utente WHERE username=?";
		System.out.println(sql);
		Utente utente = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				utente = new Utente();
				utente.setId(resultSet.getInt(1));
				utente.setUsername(resultSet.getString(2));
				utente.setPassword(resultSet.getString(3));
				utente.setNome(resultSet.getString(4));
				utente.setCognome(resultSet.getString(5));
				utente.setEmail(resultSet.getString(6));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return utente;
	}

	@Override
	public List<Utente> findAll(Connection connection) throws DAOException {
		String sql = "SELECT * FROM utente";
		System.out.println(sql);
		List<Utente> utenti = new ArrayList<Utente>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Utente utente = new Utente();
				utente.setId(resultSet.getInt(1));
				utente.setUsername(resultSet.getString(2));
				utente.setPassword(resultSet.getString(3));
				utente.setNome(resultSet.getString(4));
				utente.setCognome(resultSet.getString(5));
				utente.setEmail(resultSet.getString(6));
				utenti.add(utente);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return utenti;
	}

}
