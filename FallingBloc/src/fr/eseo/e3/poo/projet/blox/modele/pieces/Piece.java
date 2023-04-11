package fr.eseo.e3.poo.projet.blox.modele.pieces;
import java.util.List;
import java.util.ArrayList;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
abstract public class Piece {
	private List<Element> elements;
	private Puits puits;
	public Piece(Coordonnees coordonnees, Couleur couleur) {
		this.elements = new ArrayList<Element>();
		this.setElements(coordonnees, couleur);
	} 
	protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);
	public List<Element> getElements(){
		return this.elements;
	}
	public String toString() {
		return "Piece :\n	"+elements.get(0).toString()
				+"\n	"+elements.get(1).toString()
				+"\n	"+elements.get(2).toString()
				+"\n	"+elements.get(3).toString()+"\n";
	}
	public void setPosition(int abscisse, int ordonnee) {
		Coordonnees newCoord = new Coordonnees(abscisse, ordonnee);
		this.setElements(newCoord, this.getElements().get(0).getCouleur());		
	}
	public Puits getPuits() {
		return this.puits;
	}
	public void setPuits(Puits puits) {
		this.puits = puits; 
	}
}