package it.arready.webapp.service;

import java.util.List;

import it.arready.webapp.model.Immobile;

public interface ImmobileService {

	void save(Immobile immobile) throws ServiceException;

	void update(Immobile immobile) throws ServiceException;

	Immobile findById(int id) throws ServiceException;

	List<Immobile> findAll(Immobile immobile) throws ServiceException;

	List<Immobile> findByCitta(String citta) throws ServiceException;

	List<Immobile> orderByPrezzo() throws ServiceException;

	List<Immobile> orderBySuperficie() throws ServiceException;

	List<Immobile> orderByPriceFromTo(int priceMin, int priceMax) throws ServiceException;
}
