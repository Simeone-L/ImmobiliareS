package it.arready.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.arready.webapp.dao.DAOException;
import it.arready.webapp.dao.DBUtil;
import it.arready.webapp.dao.ImmobileDAO;
import it.arready.webapp.model.Immobile;
import it.arready.webapp.model.Immobile.StatoImmobile;
import it.arready.webapp.model.Indirizzo;

public class ImmobileDAOImpl implements ImmobileDAO {

	@Override
	public void save(Connection connection, Immobile immobile) throws DAOException {
		String sql = "INSERT INTO immobile(descrizione,prezzo,num_locali,num_bagni,superficie,piano,venduto,stato_immobile,indirizzo_id) VALUES(?,?,?,?,?,?,?,?)";
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

	@Override
	public Immobile findById(Connection connection, int id) throws DAOException {
		String sql = "SELECT * FROM immobile JOIN indirizzo ON immobile.indirizzo_id = indirizzo.id WHERE immobile.id=?";
		System.out.println(sql);
		Immobile immobile = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				immobile.setId(resultSet.getInt(1));
				immobile.setDescrizione(resultSet.getString(2));
				immobile.setPrezzo(resultSet.getFloat(3));
				immobile.setNumLocali (resultSet.getInt(4));
				immobile.setNumBagni(resultSet.getInt(5));
				immobile.setSuperficie(resultSet.getFloat(6));
				immobile.setPiano(resultSet.getInt(7));
				immobile.setVenduto(resultSet.getBoolean(8));
				immobile.setStatoImmobile(StatoImmobile.corrispondenzaStato(resultSet.getInt(9)));
				Indirizzo indirizzo = new Indirizzo();
				indirizzo.setId(resultSet.getInt(11));
				indirizzo.setProvincia(resultSet.getString(12));
				indirizzo.setCitta(resultSet.getString(13));
				indirizzo.setVia(resultSet.getString(14));
				indirizzo.setNumeroCivico(resultSet.getInt(15));
				indirizzo.setImmobile(immobile);
				immobile.setIndirizzo(indirizzo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return immobile;
	}

	@Override
	public List<Immobile> orderByPriceFromTo(Connection connection, int priceMin, int priceMax) throws DAOException {
		return null;
	}

	@Override
	public List<Immobile> orderByFind(Connection connection, Float prezzo, Integer numLocali, Integer numBagni,
			Float superficie, Integer piano, StatoImmobile statoImmobile, String citta)
			throws DAOException {
		String sql = "SELECT * FROM immobile ";
		List<String> stringParameters = new ArrayList<String>();
		List<Object> acceptParameters = new ArrayList<Object>();
		List<Immobile> immobili = new ArrayList<Immobile>();
		if (statoImmobile != null) sql += "INNER JOIN stato_immobile ON stato_immobile(id)=immobile.stato_immobile_id ";
		
		if(citta != null) sql += "INNER JOIN indirizzo ON indirizzo(id)=immobile.indirizzo_id ";
		
		if(prezzo != null) { 
			stringParameters.add("prezzo=?");
			acceptParameters.add(prezzo);
		}	
		
		if(numLocali != null) {
			stringParameters.add("num_locali=?");
			acceptParameters.add(numLocali);
		}
		
		if(numBagni != null) {
			stringParameters.add("numBagni=?");
			acceptParameters.add(numBagni);
		}
		
		if(superficie != null) {
			stringParameters.add("superficie=?");
			acceptParameters.add(superficie);
		}
		
		if(piano != null) {
			stringParameters.add("piano=?");
			acceptParameters.add(piano);
		}
		
		if(statoImmobile != null) {
			stringParameters.add("stato_immobile=?");
			acceptParameters.add(statoImmobile);
		}
		
		if(citta != null) {
			stringParameters.add("citta=?");
			acceptParameters.add(citta);
		}
				
		if(stringParameters.size() > 0) {
			sql += "WHERE ";
		
			for(int i=0; i<stringParameters.size(); i++) {
				if(i != stringParameters.size()-1) {
					sql += stringParameters.get(i)+" AND ";
				} else {
					sql += stringParameters.get(i);
				}
			}
		}
		
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet rs = null;
			try {
				statement= connection.prepareStatement(sql);
				for(int i = 0; i<acceptParameters.size(); i++) {
					if(acceptParameters.get(i).getClass().getName() == "java.lang.Float" ) {
						statement.setFloat(i+1, Float.parseFloat(acceptParameters.get(i).toString()));
					}
					if(acceptParameters.get(i).getClass().getName() == "java.lang.Integer" ) {
						statement.setInt(i+1, Integer.parseInt(acceptParameters.get(i).toString()));
					}
					if(acceptParameters.get(i).getClass().getName() == "java.lang.String" ) {
						statement.setString(i+1, acceptParameters.get(i).toString());
					}
					if(acceptParameters.get(i).getClass().getName() == "it.arready.webapp.model.Immobile.StatoImmobile") {
						statement.setString(i+1, ((StatoImmobile)acceptParameters.get(i)).getNome());
					}
				}
				rs = statement.executeQuery();
				while(rs.next()) {
					Immobile immobile = new Immobile();
					immobile.setId(rs.getInt(1));
					immobile.setDescrizione(rs.getString(2));
					immobile.setPrezzo(rs.getFloat(3));
					immobile.setNumLocali(rs.getInt(4));
					immobile.setNumBagni(rs.getInt(5));
					immobile.setSuperficie(rs.getFloat(6));
					immobile.setPiano(rs.getInt(7));
					immobile.setVenduto(rs.getBoolean(8));
					immobili.add(immobile);
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				throw new DAOException(e.getMessage(), e);
			}
		return immobili;
	}

}
