package it.arready.webapp.model;

import java.util.Date;

public class Annuncio {

	private int id;
	private String titoloAnnuncio;
	private Date dataAnnuncio;
	private Immobile immobile;
	private StatoVendita statoVendita;
	private Utente utente;
	private Ordinamento ordinam;

	public enum Ordinamento {
		ASC(4, "ASC"), DESC(5, "DESC");

		private final int x;
		private final String ordinam;

		Ordinamento(int x, String ordinam) {
			this.x = x;
			this.ordinam = ordinam;
		}

		public static Ordinamento corrispondenzeOrdinamento(int o) {

			for (Ordinamento ordine : Ordinamento.values()) {
				if (ordine.x == o)
					return ordine;
			}
			return null;
		}

		public static Ordinamento corrispondenzaOrdinamentoString(String o) {
			for (Ordinamento ordine : Ordinamento.values()) {
				if (ordine.ordinam.equals(o))
					return ordine;
			}
			return null;
		}

		public int getX() {
			return x;
		}

		public String getOrdinam() {
			return ordinam;
		}
	}

	public enum StatoVendita {
		AFFITTO(1, "Affitto"), AFFITTO_A_RISCATTO(2, "Affitto a riscatto"), VENDITA(3, "Vendita"),
		DEFAULT(0, "Default");

		private final int i;
		private final String nome;

		StatoVendita(int i, String nome) {
			this.i = i;
			this.nome = nome;
		}

		public static StatoVendita corrispondenzaStato(int sV) {
			for (StatoVendita statoVendita : StatoVendita.values()) {
				if (statoVendita.i == sV)
					return statoVendita;
			}
			return null;
		}

		public static StatoVendita corrispondenzaStatoString(String sV) {
			for (StatoVendita statoVendita : StatoVendita.values()) {
				if (statoVendita.nome.equals(sV))
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitoloAnnuncio() {
		return titoloAnnuncio;
	}

	public void setTitoloAnnuncio(String titoloAnnuncio) {
		this.titoloAnnuncio = titoloAnnuncio;
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
		return "Annuncio [id=" + id + ", titoloAnnuncio=" + titoloAnnuncio + ", dataAnnuncio=" + dataAnnuncio
				+ ", immobile=" + immobile + ", statoVendita=" + statoVendita + ", utente=" + utente + ", ordinam="
				+ ordinam + "]";
	}

}
