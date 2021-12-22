package it.arready.webapp.model;

public class Indirizzo {
	
	private int id;
	private String provincia;
	private String citta;
	private String via;
	private int numeroCivico;
	private Immobile immobile;
	
	
	public Indirizzo() {
		super();
	}
	
	public Indirizzo(int id, String provincia, String citta, String via, int numeroCivico, Immobile immobile) {
		super();
		this.id = id;
		this.provincia = provincia;
		this.citta = citta;
		this.via = via;
		this.numeroCivico = numeroCivico;
		this.immobile = immobile;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public int getNumeroCivico() {
		return numeroCivico;
	}
	public void setNumeroCivico(int numeroCivico) {
		this.numeroCivico = numeroCivico;
	}
	
	public Immobile getImmobile() {
		return immobile;
	}

	public void setImmobile(Immobile immobile) {
		this.immobile = immobile;
	}

	@Override
	public String toString() {
		return "Indirizzo [id=" + id + ", provincia=" + provincia + ", citta=" + citta + ", via=" + via
				+ ", numeroCivico=" + numeroCivico + ", immobile=" + immobile + "]";
	}

	
	
	
	

}
