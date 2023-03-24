package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;


public class PuitsTest {

	@Test
	void testConstructeur1() {
		Puits puits1 = new Puits();
		assertEquals(10,puits1.getLargeur(),"la largeur");
		assertEquals(20,puits1.getProfondeur(),"la profondeur");
	}
	
	@Test
	void testConstructeur2() {
		Puits puits2 = new Puits(3,8);
		assertEquals(3,puits2.getLargeur(),"la largeur");
		assertEquals(8,puits2.getProfondeur(),"la profondeur");
	}
	
	@Test
	void testSetGetPieceSuivanteO() {
		Puits puits3 = new Puits();
		Coordonnees coord = new Coordonnees(5,6);
		Couleur coul = Couleur.BLEU;
		OPiece newP = new OPiece(coord,coul);
		puits3.setPieceSuivante(newP);
		assertEquals(newP, puits3.getPieceSuivante(),"piece suivante");
	}
	
	
	@Test
	void testSetGetPieceSuivanteI() {
		Puits puits3 = new Puits();
		Coordonnees coord = new Coordonnees(5,6);
		Couleur coul = Couleur.BLEU;
		IPiece newP = new IPiece(coord,coul);
		puits3.setPieceSuivante(newP);
		assertEquals(newP, puits3.getPieceSuivante(),"piece suivante");
	}
	
	@Test
	void testSetProfondeurOk() {
		Puits puits4 = new Puits();
		puits4.setProfondeur(23);
		assertEquals(23,puits4.getProfondeur(),"profondeur");
	}
	@Test
	void testSetLargeurOK() {
		Puits puits5 = new Puits();
		puits5.setLargeur(9);
		assertEquals(9,puits5.getLargeur(),"largeur");
	}
	
	@Test
	void testSetGetPieceActuelleO() {
		Puits puits3 = new Puits();
		Coordonnees coord = new Coordonnees(5,6);
		Couleur coul = Couleur.BLEU;
		OPiece newPO= new OPiece(coord,coul);
		IPiece newPI = new IPiece(coord,coul);
		puits3.setPieceSuivante(newPO);
		puits3.setPieceSuivante(newPI);
		assertEquals(newPO, puits3.getPieceActuelle(),"piece suivante");
	}
	
	@Test
	void testToString() {
		Puits puits3 = new Puits();
		Coordonnees coord = new Coordonnees(5,6);
		Couleur coul = Couleur.BLEU;
		OPiece newPO= new OPiece(coord,coul);
		IPiece newPI = new IPiece(coord,coul);
		puits3.setPieceSuivante(newPO);
		puits3.setPieceSuivante(newPI);
		String supposed = "Puits : Dimension 10 x 20\nPiece Actuelle : "+ newPO.toString() +"\nPiece Suivante : "+newPI.toString();
		assertEquals(supposed, puits3.toString(),"vghzd");
	}
}

