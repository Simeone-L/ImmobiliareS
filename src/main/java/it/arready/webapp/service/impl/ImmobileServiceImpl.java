package it.arready.webapp.service.impl;

import java.util.List;

import it.arready.webapp.model.Immobile;
import it.arready.webapp.service.ImmobileService;
import it.arready.webapp.service.ServiceException;

public class ImmobileServiceImpl implements ImmobileService {

	@Override
	public void save(Immobile immobile) throws ServiceException {

	}

	@Override
	public void update(Immobile immobile) throws ServiceException {

	}

	@Override
	public Immobile findById(int id) throws ServiceException {
		return null;
	}

	@Override
	public List<Immobile> findAll() throws ServiceException {
		return null;
	}

	@Override
	public List<Immobile> findByCitta(String citta) throws ServiceException {
		return null;
	}

	@Override
	public List<Immobile> orderByPrezzo() throws ServiceException {
		return null;
	}

	@Override
	public List<Immobile> orderBySuperficie() throws ServiceException {
		return null;
	}

	@Override
	public List<Immobile> orderByPriceFromTo(int priceMin, int priceMax) throws ServiceException {
		return null;
	}

}
