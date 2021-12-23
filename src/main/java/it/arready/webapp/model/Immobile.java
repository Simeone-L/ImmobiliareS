package it.arready.webapp.model;

public class Immobile {

	private int id;
	private String descrizione;
	private float prezzo;
	private int numLocali;
	private int numBagni;
	private float superficie;
	private int piano;
	private StatoImmobile statoImmobile;
	private boolean venduto;

	public enum StatoImmobile {
		NUOVO(1, "Nuovo"), IN_COSTRUZIONE(2, "In Costruzione"), RISTRUTTURATO(3, "Ristrutturato"), BUONO(4, "Buono"),
		ABITABILE(5, "Abitabile"), DA_RISTRUTTURARE(6, "Abitabile"), OTTIMO(7, "Ottimo");

		StatoImmobile(int i, String nome) {
		}
	}

	public Immobile() {
		super();
	}

	public Immobile(int id, String descrizione, float prezzo, int numLocali, int numBagni, float superficie, int piano,
			boolean venduto) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.numLocali = numLocali;
		this.numBagni = numBagni;
		this.superficie = superficie;
		this.piano = piano;
		this.venduto = venduto;
	}

	public StatoImmobile getStatoImmobile() {
		return statoImmobile;
	}

	public void setStatoImmobile(StatoImmobile statoImmobile) {
		this.statoImmobile = statoImmobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public int getNumLocali() {
		return numLocali;
	}

	public void setNumLocali(int numLocali) {
		this.numLocali = numLocali;
	}

	public int getNumBagni() {
		return numBagni;
	}

	public void setNumBagni(int numBagni) {
		this.numBagni = numBagni;
	}

	public float getSuperficie() {
		return superficie;
	}

	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}

	public int getPiano() {
		return piano;
	}

	public void setPiano(int piano) {
		this.piano = piano;
	}

	public boolean isVenduto() {
		return venduto;
	}

	public void setVenduto(boolean venduto) {
		this.venduto = venduto;
	}

	@Override
	public String toString() {
		return "Immobile: \nid " + id + ", descrizione " + descrizione + ", prezzo " + prezzo + ", numLocali "
				+ numLocali + ", numBagni " + numBagni + ", superficie " + superficie + ", piano " + piano
				+ ", venduto " + venduto;
	}

}
