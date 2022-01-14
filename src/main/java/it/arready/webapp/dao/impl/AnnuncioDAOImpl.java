package it.arready.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.arready.webapp.dao.AnnuncioDAO;
import it.arready.webapp.dao.DAOException;
import it.arready.webapp.dao.DBUtil;
import it.arready.webapp.model.Annuncio;
import it.arready.webapp.model.Annuncio.StatoVendita;
import it.arready.webapp.model.Immobile;
import it.arready.webapp.model.Immobile.StatoImmobile;
import it.arready.webapp.model.Indirizzo;
import it.arready.webapp.model.Utente;

public class AnnuncioDAOImpl implements AnnuncioDAO {

	@Override
	public void save(Connection conn, Annuncio annuncio) throws DAOException {
		String sql = "INSERT INTO annuncio(data_annuncio, titolo_annuncio, utente_id, immobile_id, stato_vendita_id) VALUES(?,?,?,?,?)";
		PreparedStatement stat = null;
		ResultSet genKey = null;
		try {
			stat = conn.prepareStatement(sql, new String[] { "id" });
			stat.setDate(1, new java.sql.Date(annuncio.getDataAnnuncio().getTime()));
			stat.setString(2, annuncio.getTitoloAnnuncio());
			stat.setInt(3, annuncio.getUtente().getId());
			stat.setInt(4, annuncio.getImmobile().getId());
			stat.setInt(5, annuncio.getStatoVendita().getI());
			stat.executeUpdate();
			genKey = stat.getGeneratedKeys();
			if (genKey.next()) {
				annuncio.setId(genKey.getInt(1));
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
	public void update(Connection conn, Annuncio annuncio) throws DAOException {
		String sql = "UPDATE annuncio SET titolo_annuncio = ?, stato_vendita_id=? WHERE id=?";
		System.out.println(sql);
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(sql);
			stat.setString(1, annuncio.getTitoloAnnuncio());
			stat.setInt(2, annuncio.getStatoVendita().getI());
			stat.setInt(3, annuncio.getId());
			stat.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(stat);
		}
	}

	@Override
	public void delete(Connection conn, Annuncio annuncio) throws DAOException {
		String sql = "DELETE FROM annuncio WHERE id=?";
		System.out.println(sql);
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, annuncio.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(statement);
		}
	}

	@Override
	public Annuncio findByTitolo(Connection conn, String titolo) throws DAOException {
		String sql = "select * from annuncio " + "join immobile on immobile.id = annuncio.immobile_id "
				+ "join indirizzo on indirizzo.id = immobile.indirizzo_id "
				+ "join utente on utente.id = annuncio.utente_id " + "where annuncio.titolo = ?";
		System.out.println(sql);
		Annuncio annuncio = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, titolo);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				annuncio = new Annuncio();
				annuncio.setId(resultSet.getInt(1));
				annuncio.setTitoloAnnuncio(resultSet.getString(2));
				annuncio.setDataAnnuncio(resultSet.getDate(3));
				annuncio.setStatoVendita(StatoVendita.corrispondenzaStato(resultSet.getInt(5)));
				Immobile immobile = new Immobile();
				immobile.setId(resultSet.getInt(7));
				immobile.setDescrizione(resultSet.getString(8));
				immobile.setPrezzo(resultSet.getFloat(9));
				immobile.setNumLocali(resultSet.getInt(10));
				immobile.setNumBagni(resultSet.getInt(11));
				immobile.setSuperficie(resultSet.getFloat(12));
				immobile.setPiano(resultSet.getInt(13));
				immobile.setVenduto(resultSet.getBoolean(14));
				immobile.setStatoImmobile(StatoImmobile.corrispondenzaStato(resultSet.getInt(15)));
				Indirizzo indirizzo = new Indirizzo();
				indirizzo.setId(resultSet.getInt(17));
				indirizzo.setProvincia(resultSet.getString(18));
				indirizzo.setCitta(resultSet.getString(19));
				indirizzo.setVia(resultSet.getString(20));
				indirizzo.setNumeroCivico(resultSet.getInt(21));
				Utente utente = new Utente();
				utente.setId(resultSet.getInt(22));
				utente.setUsername(resultSet.getString(23));
				immobile.setIndirizzo(indirizzo);
				annuncio.setImmobile(immobile);
				annuncio.setUtente(utente);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return annuncio;
	}

	@Override
	public Annuncio findById(Connection conn, int id) throws DAOException {
		String sql = "select * from annuncio " + "join immobile on immobile.id = annuncio.immobile_id "
				+ "join indirizzo on indirizzo.id = immobile.indirizzo_id "
				+ "join utente on utente.id = annuncio.utente_id " + "where annuncio.id = ?";
		System.out.println(sql);
		Annuncio annuncio = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				annuncio = new Annuncio();
				annuncio.setId(resultSet.getInt(1));
				annuncio.setTitoloAnnuncio(resultSet.getString(2));
				annuncio.setDataAnnuncio(resultSet.getDate(3));
				annuncio.setStatoVendita(StatoVendita.corrispondenzaStato(resultSet.getInt(5)));
				Immobile immobile = new Immobile();
				immobile.setId(resultSet.getInt(7));
				immobile.setDescrizione(resultSet.getString(8));
				immobile.setPrezzo(resultSet.getFloat(9));
				immobile.setNumLocali(resultSet.getInt(10));
				immobile.setNumBagni(resultSet.getInt(11));
				immobile.setSuperficie(resultSet.getFloat(12));
				immobile.setPiano(resultSet.getInt(13));
				immobile.setVenduto(resultSet.getBoolean(14));
				immobile.setStatoImmobile(StatoImmobile.corrispondenzaStato(resultSet.getInt(15)));
				Indirizzo indirizzo = new Indirizzo();
				indirizzo.setId(resultSet.getInt(17));
				indirizzo.setProvincia(resultSet.getString(18));
				indirizzo.setCitta(resultSet.getString(19));
				indirizzo.setVia(resultSet.getString(20));
				indirizzo.setNumeroCivico(resultSet.getInt(21));
				Utente utente = new Utente();
				utente.setId(resultSet.getInt(22));
				utente.setUsername(resultSet.getString(23));
				immobile.setIndirizzo(indirizzo);
				annuncio.setImmobile(immobile);
				annuncio.setUtente(utente);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return annuncio;
	}

	@Override
	public List<Annuncio> orderByFind(Connection connection, Float prezzoMin, Float prezzoMax, Integer numLocali,
			Integer numBagni, Float superficie, Integer piano, StatoImmobile statoImmobile, String citta, String titolo)
			throws DAOException {
		String sql = "SELECT * FROM annuncio " + "INNER JOIN immobile ON annuncio.immobile_id = immobile.id "
				+ "INNER JOIN indirizzo ON indirizzo.id = immobile.indirizzo_id "
				+ "INNER JOIN utente ON utente.id = annuncio.utente_id ";
		List<String> stringParameters = new ArrayList<String>();
		List<Object> acceptParameters = new ArrayList<Object>();
		List<Annuncio> annunci = new ArrayList<Annuncio>();
//		if (statoImmobile != null) sql += "INNER JOIN stato_immobile ON stato_immobile.id = immobile.stato_immobile_id ";

//		if(citta != null) sql += "INNER JOIN indirizzo ON indirizzo.id = immobile.indirizzo_id ";

		stringParameters.add("prezzo BETWEEN ? AND ? ORDER BY prezzo ASC");
		if (!(prezzoMin != null) && !(prezzoMax != null)) {
			prezzoMin = 0f;
			acceptParameters.add(prezzoMin);

			prezzoMax = 5000000f;
			acceptParameters.add(prezzoMax);
		} else {
			if (prezzoMin > prezzoMax) {
				Float cambio = prezzoMin;
				prezzoMin = prezzoMax;
				prezzoMax = cambio;

				acceptParameters.add(prezzoMin);
				acceptParameters.add(prezzoMax);

			} else {
				if (prezzoMin < prezzoMax) {
					acceptParameters.add(prezzoMin);
					acceptParameters.add(prezzoMax);
				}
			}
		}

		if (numLocali != null) {
			stringParameters.add("num_locali=?");
			acceptParameters.add(numLocali);
		}

		if (numBagni != null) {
			stringParameters.add("numBagni=?");
			acceptParameters.add(numBagni);
		}

		if (superficie != null) {
			stringParameters.add("superficie=?");
			acceptParameters.add(superficie);
		}

		if (piano != null) {
			stringParameters.add("piano=?");
			acceptParameters.add(piano);
		}

		if (statoImmobile != null) {
			stringParameters.add("stato_immobile_id=?");
			acceptParameters.add(statoImmobile.getI());
		}

		if (citta != null) {
			stringParameters.add("citta=?");
			acceptParameters.add(citta);
		}

		if (titolo != null) {
			stringParameters.add("titolo LIKE %?%");
			acceptParameters.add(titolo);
		}

		if (stringParameters.size() > 0) {
			sql += "WHERE ";

			for (int i = 0; i < stringParameters.size(); i++) {
				if (i != stringParameters.size() - 1) {
					sql += stringParameters.get(i) + " AND ";
				} else {
					sql += stringParameters.get(i);
				}
			}
		}

		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			for (int i = 0; i < acceptParameters.size(); i++) {
				if (acceptParameters.get(i).getClass().getName() == "java.lang.Float") {
					statement.setFloat(i + 1, Float.parseFloat(acceptParameters.get(i).toString()));
				}
				if (acceptParameters.get(i).getClass().getName() == "java.lang.Integer") {
					statement.setInt(i + 1, Integer.parseInt(acceptParameters.get(i).toString()));
				}
				if (acceptParameters.get(i).getClass().getName() == "java.lang.String") {
					statement.setString(i + 1, acceptParameters.get(i).toString());
				}
//					if(acceptParameters.get(i).getClass().getName() == "it.arready.webapp.model.Immobile.StatoImmobile") {
//						statement.setString(i+1, ((StatoImmobile)acceptParameters.get(i)).getNome());
//					}
			}
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Annuncio annuncio = new Annuncio();
				annuncio.setId(resultSet.getInt(1));
				annuncio.setTitoloAnnuncio(resultSet.getString(2));
				annuncio.setDataAnnuncio(resultSet.getDate(3));
				annuncio.setStatoVendita(StatoVendita.corrispondenzaStato(resultSet.getInt(5)));
				Immobile immobile = new Immobile();
				immobile.setId(resultSet.getInt(7));
				immobile.setDescrizione(resultSet.getString(8));
				immobile.setPrezzo(resultSet.getFloat(9));
				immobile.setNumLocali(resultSet.getInt(10));
				immobile.setNumBagni(resultSet.getInt(11));
				immobile.setSuperficie(resultSet.getFloat(12));
				immobile.setPiano(resultSet.getInt(13));
				immobile.setVenduto(resultSet.getBoolean(14));
				immobile.setStatoImmobile(StatoImmobile.corrispondenzaStato(resultSet.getInt(15)));
				Indirizzo indirizzo = new Indirizzo();
				indirizzo.setId(resultSet.getInt(17));
				indirizzo.setProvincia(resultSet.getString(18));
				indirizzo.setCitta(resultSet.getString(19));
				indirizzo.setVia(resultSet.getString(20));
				indirizzo.setNumeroCivico(resultSet.getInt(21));
				Utente utente = new Utente();
				utente.setId(resultSet.getInt(22));
				utente.setUsername(resultSet.getString(23));
				immobile.setIndirizzo(indirizzo);
				annuncio.setImmobile(immobile);
				annuncio.setUtente(utente);
				annunci.add(annuncio);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		}
		return annunci;
	}

}
