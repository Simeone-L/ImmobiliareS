package it.arready.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		System.out.println(sql);
		List<Object> parameters = new ArrayList<Object>();
		if (statoImmobile != null) {
			sql += "INNER JOIN stato_immobile ON stato_immobile(id)=immobile.stato_immobile_id ";
			System.out.println(sql);
		}
		
		if (citta != null) {
			sql += "INNER JOIN indirizzo ON indirizzo(id)=immobile.indirizzo_id ";
			System.out.println(sql);
		}
		
		if (prezzo != null) {
			parameters.add("prezzo=? ");
		}
		
		if(numLocali != null) {
			parameters.add("num_locali=? ");
		}
		
		if(numBagni != null) {
			parameters.add("numBagni=? ");
		}
		
		if(superficie != null) {
			parameters.add("superficie=? ");
		}
		
		if(piano != null) {
			parameters.add("piano=? ");
		}
		
		if(statoImmobile != null) {
			parameters.add("stato_immobile=? ");
		}
		
		if(citta != null) {
			parameters.add("citta=? ");
		}
				
		sql += "WHERE ";
		System.out.println(sql);
		
		for(int i=0; i<parameters.size(); i++) {
			if(i != parameters.size()-1) {
				sql += parameters.get(i)+"AND ";
			}
		}
		PreparedStatement statement = null;
			try {
				statement= connection.prepareStatement(sql);
				
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				throw new DAOException(e.getMessage(), e);
			}
		
		System.out.println(sql);
		return null;
	}

}
