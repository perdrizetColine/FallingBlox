package fr.eseo.e3.poo.projet.blox.modele.pieces;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;

public class IPieceTest {

	@Test 
	void testConstructeur() {
		Coordonnees coord = new Coordonnees(6,5);
		Couleur couleur = Couleur.ROUGE;
		IPiece IPiece = new IPiece(coord, couleur);
		
		assertEquals(Couleur.ROUGE,IPiece.getElements().get(0).getCouleur(),"couleur 1");
		assertEquals(Couleur.ROUGE,IPiece.getElements().get(1).getCouleur(),"couleur 2");
		assertEquals(Couleur.ROUGE,IPiece.getElements().get(2).getCouleur(),"couleur 3");
		assertEquals(Couleur.ROUGE,IPiece.getElements().get(3).getCouleur(),"couleur 4");
		
		assertEquals(coord,IPiece.getElements().get(0).getCoordonnees(),"coordonnes 1");
		assertEquals(new Coordonnees(6,6),IPiece.getElements().get(1).getCoordonnees(),"coordonnes 2");
		assertEquals(new Coordonnees(6,3),IPiece.getElements().get(2).getCoordonnees(),"coordonnes 2");
		assertEquals(new Coordonnees(6,4),IPiece.getElements().get(3).getCoordonnees(),"coordonnes 2");
	}
	
	@Test
	void testToString() {
		Coordonnees coord = new Coordonnees(6,5);
		Couleur couleur = Couleur.CYAN;
		IPiece IPiece = new IPiece(coord, couleur);
		String stringAttendu = "IPiece :\n	(6, 5) - CYAN\n	(6, 6) - CYAN\n	(6, 3) - CYAN\n	(6, 4) - CYAN\n";
		assertEquals(stringAttendu,IPiece.toString(),"to string");
	}

}
