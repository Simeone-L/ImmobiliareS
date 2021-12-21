package it.arready.webapp.model;

public class Immagine {

	private int id;
	private String immagineUrl;
	private boolean principale;
	private Immobile immobile;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getImmagineUrl() {
		return immagineUrl;
	}
	
	public void setImmagineUrl(String immagineUrl) {
		this.immagineUrl = immagineUrl;
	}
	
	public boolean isPrincipale() {
		return principale;
	}
	
	public void setPrincipale(boolean principale) {
		this.principale = principale;
	}
	
	public Immobile getImmobile() {
		return immobile;
	}
	
	public void setImmobile(Immobile immobile) {
		this.immobile = immobile;
	}
	
}
