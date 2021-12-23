package it.arready.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.arready.webapp.dao.DAOException;
import it.arready.webapp.dao.ImmobileDAO;
import it.arready.webapp.model.Immobile;
import it.arready.webapp.model.Immobile.StatoImmobile;

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
			stringParameters.add("prezzo=? ");
			acceptParameters.add(prezzo);
		}	
		
		if(numLocali != null) stringParameters.add("num_locali=? ");
		
		if(numBagni != null) stringParameters.add("numBagni=? ");
		
		if(superficie != null) stringParameters.add("superficie=? ");
		
		if(piano != null) stringParameters.add("piano=? ");
		
		if(statoImmobile != null) stringParameters.add("stato_immobile=? ");
		
		if(citta != null) stringParameters.add("citta=? ");
				
		if(stringParameters.size() > 0) {
			sql += "WHERE ";
		
			for(int i=0; i<stringParameters.size(); i++) {
				if(i != stringParameters.size()-1) {
					sql += stringParameters.get(i)+"AND ";
				}
			}
		}
		
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet rs = null;
			try {
				statement= connection.prepareStatement(sql);
				for(int i = 0; i<acceptParameters.size(); i++) {
					if(acceptParameters.getClass().getName() == "java.lang.Float" ) {
						statement.setFloat(i+1, (Float)acceptParameters.get(i));
					}
				}
				rs = statement.executeQuery(sql);
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
		
		System.out.println(sql);
		return immobili;
	}

}
