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
		//Coordonnees newCoord = new Coordonnees(abscisse, ordonnee);
		this.setElements(new Coordonnees(abscisse, ordonnee), this.getElements().get(0).getCouleur());		
	}
//	public void setPosition ( int abscisse, int ordonnee ) {
//		this.setElements(new Coordonnees(abscisse,ordonnee), this.elements.get(0).getCouleur());
//
//	}
	
	public Puits getPuits() {
		return this.puits;
	}
	
	public void setPuits( Puits puits) {
		this.puits = puits;
	}
	
	public void deplacerDe(int deltaX, int deltaY) throws IllegalArgumentException{
		/*if (deltaX>1 | deltaY<0 | deltaY>1) {
			throw new IllegalArgumentException("erreur");
		}else {
			for (Element elem : this.elements) {
				elem.deplacerDe(deltaX, deltaY);
			}
		}*/
		if (this.getElements().get(0)==null) {
			throw new NullPointerException("pas de piece");
		}else {
			if (deltaX>1) {
				throw new IllegalArgumentException("le deplacement sur X");
			}else if (deltaY>1 | deltaY<0) {
				throw new IllegalArgumentException("le deplacement sur Y");
			}else{
				for (Element el: this.elements) {
					el.deplacerDe(deltaX, deltaY);
				}
			}
		}
	}
	
	public void tourner(boolean sensHoraire) {
		if (this.getClass()==IPiece.class) {
			//on prend les coordonnees de notre element central pour pouvoir mettre
			//la piece à l'origine
			int ab = getElements().get(0).getCoordonnees().getAbscisse();
			int or = getElements().get(0).getCoordonnees().getOrdonnee();
			//mettre la piece (tous les elements) à l'origine
			for (Element elem : this.getElements()) {
				elem.setCoordonnees(new Coordonnees(elem.getCoordonnees().getAbscisse()-ab,
						elem.getCoordonnees().getOrdonnee()-or));
			}
			//faire la rotation de 90° dans le sens horaire
			if (sensHoraire) {
				for (Element el : getElements()) {
					//recuperer les coordonnees de l'element de la piece
					int x = el.getCoordonnees().getAbscisse();
					int y = el.getCoordonnees().getOrdonnee();
					//faire tourner
					el.setCoordonnees(new Coordonnees(-y,x));
				}
			//faire la rotation de 90° vers la gauche
			}else {
				for (Element el : getElements()) {
					//recuperer les coordonnees de l'element de la piece
					int x = el.getCoordonnees().getAbscisse();
					int y = el.getCoordonnees().getOrdonnee();
					//faire tourner
					el.setCoordonnees(new Coordonnees(y,-x));
				}
			}
			//remettre la piece (tous les elements) a leur place
			for (Element el : getElements()) {
				el.setCoordonnees(new Coordonnees(el.getCoordonnees().getAbscisse()+ab,
						el.getCoordonnees().getOrdonnee()+or));
			}
		}
	}
}
