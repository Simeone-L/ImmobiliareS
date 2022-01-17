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
import it.arready.webapp.model.Annuncio.Ordinamento;
import it.arready.webapp.model.Annuncio.StatoVendita;
import it.arready.webapp.model.Immobile;
import it.arready.webapp.model.Immobile.StatoImmobile;
import it.arready.webapp.model.Indirizzo;
import it.arready.webapp.model.Utente;

public class AnnuncioDAOImpl implements AnnuncioDAO {

	@Override
	public void save(Connection conn, Annuncio annuncio) throws DAOException {
		String sql = "INSERT INTO annuncio(data_annuncio, utente_id, immobile_id, stato_vendita_id) VALUES(?,?,?,?)";
		PreparedStatement stat = null;
		ResultSet genKey = null;
		try {
			stat = conn.prepareStatement(sql, new String[] { "id" });
			stat.setDate(1, new java.sql.Date(annuncio.getDataAnnuncio().getTime()));
			stat.setInt(2, annuncio.getUtente().getId());
			stat.setInt(3, annuncio.getImmobile().getId());
			stat.setInt(4, annuncio.getStatoVendita().getI());
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
		String sql = "UPDATE annuncio SET stato_vendita_id=? WHERE id=?";
		System.out.println(sql);
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1, annuncio.getStatoVendita().getI());
			stat.setInt(2, annuncio.getId());
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
				annuncio.setDataAnnuncio(resultSet.getDate(2));
				annuncio.setStatoVendita(StatoVendita.corrispondenzaStato(resultSet.getInt(4)));
				Immobile immobile = new Immobile();
				immobile.setId(resultSet.getInt(6));
				immobile.setDescrizione(resultSet.getString(7));
				immobile.setPrezzo(resultSet.getFloat(8));
				immobile.setNumLocali(resultSet.getInt(9));
				immobile.setNumBagni(resultSet.getInt(10));
				immobile.setSuperficie(resultSet.getFloat(11));
				immobile.setPiano(resultSet.getInt(12));
				immobile.setVenduto(resultSet.getBoolean(13));
				immobile.setStatoImmobile(StatoImmobile.corrispondenzaStato(resultSet.getInt(14)));
				Indirizzo indirizzo = new Indirizzo();
				indirizzo.setId(resultSet.getInt(16));
				indirizzo.setProvincia(resultSet.getString(17));
				indirizzo.setCitta(resultSet.getString(18));
				indirizzo.setVia(resultSet.getString(19));
				indirizzo.setNumeroCivico(resultSet.getInt(20));
				Utente utente = new Utente();
				utente.setId(resultSet.getInt(21));
				utente.setUsername(resultSet.getString(22));
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
				annuncio.setDataAnnuncio(resultSet.getDate(2));
				annuncio.setStatoVendita(StatoVendita.corrispondenzaStato(resultSet.getInt(4)));
				Immobile immobile = new Immobile();
				immobile.setId(resultSet.getInt(6));
				immobile.setDescrizione(resultSet.getString(7));
				immobile.setPrezzo(resultSet.getFloat(8));
				immobile.setNumLocali(resultSet.getInt(9));
				immobile.setNumBagni(resultSet.getInt(10));
				immobile.setSuperficie(resultSet.getFloat(11));
				immobile.setPiano(resultSet.getInt(12));
				immobile.setVenduto(resultSet.getBoolean(13));
				immobile.setStatoImmobile(StatoImmobile.corrispondenzaStato(resultSet.getInt(14)));
				Indirizzo indirizzo = new Indirizzo();
				indirizzo.setId(resultSet.getInt(16));
				indirizzo.setProvincia(resultSet.getString(17));
				indirizzo.setCitta(resultSet.getString(18));
				indirizzo.setVia(resultSet.getString(19));
				indirizzo.setNumeroCivico(resultSet.getInt(20));
				Utente utente = new Utente();
				utente.setId(resultSet.getInt(21));
				utente.setUsername(resultSet.getString(22));
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
	public List<Annuncio> orderByFind(Connection conn, Float prezzoMin, Float prezzoMax, Integer numLocali,
			Integer numBagni, Float superficieMin, Float superficieMax, Integer piano, StatoImmobile statoImmobile,
			String citta, String titolo, String provincia, String indirizzo, Integer numeroCivico,
			StatoVendita statoVendita, Ordinamento ordinamentoPrezzo, Ordinamento ordinamentoSuperficie)
			throws DAOException {
		String sql = "SELECT * FROM annuncio " + "INNER JOIN immobile ON annuncio.immobile_id = immobile.id "
				+ "INNER JOIN indirizzo ON indirizzo.id = immobile.indirizzo_id "
				+ "INNER JOIN utente ON utente.id = annuncio.utente_id ";
		List<String> stringParameters = new ArrayList<String>();
		List<Object> acceptParameters = new ArrayList<Object>();
		List<Annuncio> annunci = new ArrayList<Annuncio>();
//		if (statoImmobile != null) sql += "INNER JOIN stato_immobile ON stato_immobile.id = immobile.stato_immobile_id ";

//		if(citta != null) sql += "INNER JOIN indirizzo ON indirizzo.id = immobile.indirizzo_id ";

//		stringParameters.add("prezzo BETWEEN ? AND ? ORDER BY prezzo ASC");
//
//		if (!(prezzoMin != null) && !(prezzoMax != null)) {
//			prezzoMin = 0f;
//			acceptParameters.add(prezzoMin);
//
//			prezzoMax = 5000000f;
//			acceptParameters.add(prezzoMax);
//		} else {
//			if (prezzoMin > prezzoMax) {
//				Float cambio = prezzoMin;
//				prezzoMin = prezzoMax;
//				prezzoMax = cambio;
//
//				acceptParameters.add(prezzoMin);
//				acceptParameters.add(prezzoMax);
//
//			} else if (prezzoMin < prezzoMax) {
//				{
//					acceptParameters.add(prezzoMin);
//					acceptParameters.add(prezzoMax);
//				}
//			}
//		}

		stringParameters.add("prezzo BETWEEN ? ");

		if (prezzoMin == 0) {
//			prezzoMin = 0f;
			acceptParameters.add(prezzoMin);
		} else {
			if (prezzoMin > prezzoMax) {
				Float cambio = prezzoMin;
				prezzoMin = prezzoMax;
				prezzoMax = cambio;

				acceptParameters.add(prezzoMin);

			} else {
				if (prezzoMin < prezzoMax) {
					acceptParameters.add(prezzoMin);
				}
			}
		}

		stringParameters.add("? ORDER BY prezzo ?");

		if (prezzoMax == 5000000) {
//			prezzoMax = 5000000f;
			acceptParameters.add(prezzoMax);
			acceptParameters.add(superficieMin);
		} else {
			if (prezzoMax < prezzoMin) {
				Float cambio = prezzoMax;
				prezzoMax = prezzoMin;
				prezzoMin = cambio;

				acceptParameters.add(prezzoMax);
				acceptParameters.add(ordinamentoPrezzo);
			} else {
				if (prezzoMax > prezzoMin) {
					acceptParameters.add(prezzoMax);
					acceptParameters.add(ordinamentoPrezzo);
				}
			}
		}

		stringParameters.add("superficie BETWEEN ?");
		if (superficieMin == 0) {
//			superficieMin = 0f;
			acceptParameters.add(superficieMin);
		} else {
			if (superficieMin > superficieMax) {
				Float cambio = superficieMin;
				superficieMin = superficieMax;
				superficieMax = cambio;

				acceptParameters.add(superficieMin);
			} else if (superficieMin < superficieMax) {
				acceptParameters.add(superficieMin);
			}
		}

		stringParameters.add("? ORDER BY superficie ?");
		if (!(superficieMax != 100000)) {
//			superficieMax = 100000f;
			acceptParameters.add(superficieMax);
			acceptParameters.add(ordinamentoSuperficie);
		} else {
			if (superficieMax < superficieMin) {
				Float cambio = superficieMax;
				superficieMax = superficieMin;
				superficieMin = cambio;

				acceptParameters.add(superficieMax);
				acceptParameters.add(ordinamentoSuperficie);
			} else if (superficieMax > superficieMin) {
				acceptParameters.add(superficieMax);
				acceptParameters.add(ordinamentoSuperficie);
			}

		}
		
		if (indirizzo != "qualsiasi") {
			stringParameters.add("via=?");
			acceptParameters.add(indirizzo);
		}

		if (numeroCivico != 0) {
			stringParameters.add("num");
			acceptParameters.add(numeroCivico);
		}

		if (numLocali != 0) {
			stringParameters.add("num_locali=?");
			acceptParameters.add(numLocali);
		}

		if (numBagni != 0) {
			stringParameters.add("numBagni=?");
			acceptParameters.add(numBagni);
		}

		if (piano != -10) {
			stringParameters.add("piano=?");
			acceptParameters.add(piano);
		}

		if (statoImmobile != StatoImmobile.DEFAULT) {
			stringParameters.add("stato_immobile_id=?");
			acceptParameters.add(statoImmobile.getI());
		}

		if (citta != "qualsiasi") {
			stringParameters.add("citta=?");
			acceptParameters.add(citta);
		}

		if (titolo != "qualsiasi") {
			stringParameters.add("titolo LIKE %?%");
			acceptParameters.add(titolo);
		}

		if (provincia != "qualsiasi") {
			stringParameters.add("provincia=?");
			acceptParameters.add(provincia);
		}

		if (indirizzo != "qualsiasi") {
			stringParameters.add("indirizzo=?");
			acceptParameters.add(indirizzo);
		}

		if (statoVendita != StatoVendita.DEFAULT) {
			stringParameters.add("stato_vendita=?");
			acceptParameters.add(statoVendita.getI());
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
			statement = conn.prepareStatement(sql);
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
				annuncio.setDataAnnuncio(resultSet.getDate(2));
				annuncio.setStatoVendita(StatoVendita.corrispondenzaStato(resultSet.getInt(4)));
				Immobile immobile = new Immobile();
				immobile.setId(resultSet.getInt(6));
				immobile.setDescrizione(resultSet.getString(7));
				immobile.setPrezzo(resultSet.getFloat(8));
				immobile.setNumLocali(resultSet.getInt(9));
				immobile.setNumBagni(resultSet.getInt(10));
				immobile.setSuperficie(resultSet.getFloat(11));
				immobile.setPiano(resultSet.getInt(12));
				immobile.setVenduto(resultSet.getBoolean(13));
				immobile.setStatoImmobile(StatoImmobile.corrispondenzaStato(resultSet.getInt(14)));
				Indirizzo indirizzo1 = new Indirizzo();
				indirizzo1.setId(resultSet.getInt(16));
				indirizzo1.setProvincia(resultSet.getString(17));
				indirizzo1.setCitta(resultSet.getString(18));
				indirizzo1.setVia(resultSet.getString(19));
				indirizzo1.setNumeroCivico(resultSet.getInt(20));
				Utente utente = new Utente();
				utente.setId(resultSet.getInt(21));
				utente.setUsername(resultSet.getString(22));
				immobile.setIndirizzo(indirizzo1);
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
