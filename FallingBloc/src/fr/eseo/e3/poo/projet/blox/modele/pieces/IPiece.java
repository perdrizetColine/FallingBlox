package fr.eseo.e3.poo.projet.blox.modele.pieces;
//import java.util.List;
//import java.util.ArrayList;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;


public class IPiece extends Piece {
	//attributs
	
	public IPiece(Coordonnees coordonnees, Couleur couleur) {
		super(coordonnees, couleur);
	}

	@Override
	protected void setElements(Coordonnees coordonnees, Couleur couleur) {
		super.getElements().removeAll(getElements());
		Coordonnees coord2 = new Coordonnees(coordonnees.getAbscisse(),coordonnees.getOrdonnee()+1);           
		Coordonnees coord3 = new Coordonnees(coordonnees.getAbscisse(),coordonnees.getOrdonnee()-2);
		Coordonnees coord4 = new Coordonnees(coordonnees.getAbscisse(),coordonnees.getOrdonnee()-1);
		
		super.getElements().add(new Element(coordonnees, couleur));//ex 6,5
		super.getElements().add(new Element(coord2, couleur));     //ex 7,5
		super.getElements().add(new Element(coord3, couleur));     //ex 6,4
		super.getElements().add(new Element(coord4, couleur));     //ex 7,4 
	} 
	
	
	@Override
	public String toString() {
		return "IPiece :\n	"+super.getElements().get(0).toString()
				+"\n	"+super.getElements().get(1).toString()+"\n	"
				+super.getElements().get(2).toString()+"\n	"
				+super.getElements().get(3).toString()+"\n";
	}
}
//public class IPiece extends Piece{
//	
//	public IPiece(Coordonnees coordonnees, Couleur couleur) {
//		super(coordonnees, couleur);
//
//	}
//	
//	@Override
//	protected void setElements(Coordonnees coordonnees, Couleur couleur) {
//		Coordonnees coord2 = new Coordonnees(coordonnees.getAbscisse(),coordonnees.getOrdonnee()+1);           
//		Coordonnees coord3 = new Coordonnees(coordonnees.getAbscisse(),coordonnees.getOrdonnee()+2);
//		Coordonnees coord4 = new Coordonnees(coordonnees.getAbscisse(),coordonnees.getOrdonnee()+3);
//		
//		super.getElements().add(new Element(coordonnees, couleur));//ex 6,5
//		super.getElements().add(new Element(coord2, couleur));     //ex 7,5
//		super.getElements().add(new Element(coord3, couleur));     //ex 6,4
//		super.getElements().add(new Element(coord4, couleur));     //ex 7,4 
//	}
//	
//	
//	@Override
//	public String toString() {
//		return "IPiece :\n	"+super.getElements().get(0).toString()+"\n	"+super.getElements().get(1).toString()+"\n	"+super.getElements().get(2).toString()+"\n	"+super.getElements().get(3).toString()+"\n";
//	}
//
//}
