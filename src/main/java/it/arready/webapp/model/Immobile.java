package it.arready.webapp.model;

public class Immobile {

	private int id;
	private String descrizione;
	private float prezzo;
	private int numLocali;
	private int numBagni;
	private float superficie;
	private int piano;
	private boolean venduto;

	public enum StatoImmobile {
		NUOVO, INCOSTRUZIONE, RISTRUTTURATO, BUONO, ABITABILE, DARISTRUTTURARE, OTTIMO
	}

}
