package fr.eseo.e3.poo.projet.blox.modele.pieces;
import java.util.List;
import java.util.ArrayList;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

abstract public class Piece {
	//attributs
		private List<Element> elements;
		
		public Piece(Coordonnees coordonnees, Couleur couleur) {
			this.elements = new ArrayList<Element>();
			this.setElements(coordonnees, couleur);
		}
		
		protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);
		
		public List<Element> getElements(){
			return this.elements;
		}
		
		public String toString() {
			return "Piece :\n	"+elements.get(0).toString()+"\n	"+elements.get(1).toString()+"\n	"+elements.get(2).toString()+"\n	"+elements.get(3).toString()+"\n";
		}
		
		public void setPosition(int abscisse, int ordonnee) {
			Coordonnees newCoord = new Coordonnees(abscisse, ordonnee);
			this.setElements(newCoord, this.getElements().get(0).getCouleur());		
		}
}
