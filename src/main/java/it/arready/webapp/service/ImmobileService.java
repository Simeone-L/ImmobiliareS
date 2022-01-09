package it.arready.webapp.service;

import java.sql.Connection;
import java.util.List;

import it.arready.webapp.dao.DAOException;
import it.arready.webapp.model.Immobile;
import it.arready.webapp.model.Immobile.StatoImmobile;

public interface ImmobileService {

	void save(Immobile immobile) throws ServiceException;

	void update(Immobile immobile) throws ServiceException;

	Immobile findById(int id) throws ServiceException;

	List<Immobile> orderByFind(Float prezzoMin, Float prezzoMax, Integer numLocali, Integer numBagni,
			Float superficie, Integer piano, StatoImmobile statoImmobile, String citta)
			throws ServiceException;

}
