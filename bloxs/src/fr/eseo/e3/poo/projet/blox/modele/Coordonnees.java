package fr.eseo.e3.poo.projet.blox.modele;

public class Coordonnees {
	//attributs
	private int abscisse;
	private int ordonnee;
	
	//constructeur
	public Coordonnees(int abscisse, int ordonnee) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}
	
	//Getteurs
	public int getAbscisse() {
		return this.abscisse;
	}
	public int getOrdonnee() {
		return this.ordonnee;
	}
	
	//Setteurs
	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}
	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}
	
	//methodes
	@Override
	public String toString() {
		return "("+getAbscisse()+", "+getOrdonnee()+")";
	}
	
	public boolean equals() {
		return getAbscisse()==getOrdonnee();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + abscisse;
		result = prime * result + ordonnee;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Coordonnees other = (Coordonnees) obj;
		if(abscisse != other.abscisse)
			return false;
		if(ordonnee != other.ordonnee)
			return false;
		return true;
	}
	
	
}
