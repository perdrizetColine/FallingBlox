package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class OPieceTest {

	@Test
	void testConstructeur() {
		Coordonnees coord1 = new Coordonnees(5,9);
		Couleur couleur1 = Couleur.VERT;
		OPiece OPiece1 = new OPiece(coord1, couleur1);
		assertEquals(4,OPiece1.getElements().size(),"liste pleine");
	}
	
	@Test
	void testSetElements() {
		Coordonnees coord2 = new Coordonnees(6,5);
		Couleur couleur2 = Couleur.ROUGE;
		OPiece OPiece2 = new OPiece(coord2, couleur2);
		
		assertEquals(Couleur.ROUGE,OPiece2.getElements().get(0).getCouleur(),"couleur 1");
		assertEquals(Couleur.ROUGE,OPiece2.getElements().get(1).getCouleur(),"couleur 2");
		assertEquals(Couleur.ROUGE,OPiece2.getElements().get(2).getCouleur(),"couleur 3");
		assertEquals(Couleur.ROUGE,OPiece2.getElements().get(3).getCouleur(),"couleur 4");
		
		assertEquals(coord2,OPiece2.getElements().get(0).getCoordonnees(),"coordonnes 1");
		assertEquals(new Coordonnees(7,5),OPiece2.getElements().get(1).getCoordonnees(),"coordonnes 2");
		assertEquals(new Coordonnees(6,4),OPiece2.getElements().get(2).getCoordonnees(),"coordonnes 2");
		assertEquals(new Coordonnees(7,4),OPiece2.getElements().get(3).getCoordonnees(),"coordonnes 2");
	} 
	
	@Test
	void testSetElement2() {
		Coordonnees coord2 = new Coordonnees(6,5);
		Couleur couleur2 = Couleur.ROUGE;
		OPiece OPiece2 = new OPiece(coord2, couleur2);
		assertEquals(4, OPiece2.getElements().size(),"la taille de la liste est incorecte");
	}
	
	@Test
	void testToString() {
		Coordonnees coord3 = new Coordonnees(6,5);
		Couleur couleur3 = Couleur.CYAN;
		OPiece OPiece3 = new OPiece(coord3, couleur3);
		String stringAttendu = "OPiece :\n	(6, 5) - CYAN\n	(7, 5) - CYAN\n	(6, 4) - CYAN\n	(7, 4) - CYAN\n";
		assertEquals(stringAttendu,OPiece3.toString(),"to string");
	}
	
	@Test
	void testSetPosition() {
		Coordonnees coord = new Coordonnees(6,5);
		OPiece OPiece = new OPiece(coord, Couleur.CYAN);
		OPiece.setPosition(3, 3);
		assertEquals(new Coordonnees(3,3), OPiece.getElements().get(0).getCoordonnees(),"coordonnees new");
	}
}
