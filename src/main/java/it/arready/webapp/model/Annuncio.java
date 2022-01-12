package it.arready.webapp.model;

import java.util.Date;

public class Annuncio {

	private int id;
	private Date dataAnnuncio;
	private String titolo;
	private Immobile immobile;
	private StatoVendita statoVendita;
	private Utente utente;

	public enum StatoVendita {
		AFFITTO(1, "Affitto"), AFFITTO_A_RISCATTO(2, "Affitto a riscatto"), VENDITA(3, "Vendita");

		private final int i;
		private final String nome;

		StatoVendita(int i, String nome) {
			this.i = i;
			this.nome = nome;
		}

		public static StatoVendita corrispondenzaStato(int sI) {
			for (StatoVendita statoVendita : StatoVendita.values()) {
				if (statoVendita.i == sI)
					return statoVendita;
			}
			return null;
		}

		public static StatoVendita corrispondenzaStatoString(String sI) {
			for (StatoVendita statoVendita : StatoVendita.values()) {
				if (statoVendita.nome.equals(sI))
					return statoVendita;
			}
			return null;
		}

		public int getI() {
			return i;
		}

		public String getNome() {
			return nome;
		}

	}

	public Annuncio() {
		super();
	}

	public Annuncio(int id, String titolo, Date dataAnnuncio, Immobile immobile, StatoVendita statoVendita,
			Utente utente) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.dataAnnuncio = dataAnnuncio;
		this.immobile = immobile;
		this.statoVendita = statoVendita;
		this.utente = utente;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
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

	@Override
	public String toString() {
		return "Annuncio [id=" + id + ", dataAnnuncio=" + dataAnnuncio + ", immobile=" + immobile + ", statoVendita="
				+ statoVendita + ", utente=" + utente + "]";
	}

}
