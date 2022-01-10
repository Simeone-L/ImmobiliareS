package it.arready.webapp.model;

import java.util.Date;

public class Annuncio {

	private int id;
	private Date dataAnnuncio;
	private Immobile immobile;
	private StatoVendita statoVendita;
	private Utente utente;

	public enum StatoVendita {
		AFFITTO(1, "Affitto"), AFFITTO_A_RISCATTO(2, "Affitto a riscatto"), VENDITA(3, "Vendita");

		StatoVendita(int i, String nome) {

		}

	}

	public Annuncio() {
		super();
	}

	public Annuncio(int id, Date dataAnnuncio, Immobile immobile, StatoVendita statoVendita, Utente utente) {
		super();
		this.id = id;
		this.dataAnnuncio = dataAnnuncio;
		this.immobile = immobile;
		this.statoVendita = statoVendita;
		this.utente = utente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataAnnuncio() {
		return dataAnnuncio;
	}

	public void setDataAnnuncio(Date dataAnnuncio) {
		this.dataAnnuncio = dataAnnuncio;
	}

	public Immobile getImmobile() {
		return immobile;
	}

	public void setImmobile(Immobile immobile) {
		this.immobile = immobile;
	}

	public StatoVendita getStatoVendita() {
		return statoVendita;
	}

	public void setStatoVendita(StatoVendita statoVendita) {
		this.statoVendita = statoVendita;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}
