package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;


public class PuitsTest {

	@Test
	void testConstructeurVide() {
		Puits puits1 = new Puits();
		assertEquals(10,puits1.getLargeur(),"la largeur");
		assertEquals(20,puits1.getProfondeur(),"la profondeur");
	}
	
	@Test
	void testConstructeurLargeurEtProfondeur() {
		Puits puits2 = new Puits(12,19);
		assertEquals(12,puits2.getLargeur(),"la largeur");
		assertEquals(19,puits2.getProfondeur(),"la profondeur");
	}
	
	@Test 
	void testConstructeur2tropPetiteProfondeur() {
		try {
			Puits puits = new Puits(8,10);
			fail("doit envoyer une erreur");
		}catch(IllegalArgumentException iae) {
		    assertEquals("trop petite profondeur",iae.getMessage(),"trop petite profondeur");
		}
	}
	@Test 
	void testConstructeur2tropGrandeProfondeur() {
		try {
			Puits puits = new Puits(8,40);
			fail("doit envoyer une erreur");
		}catch(IllegalArgumentException iae) {
		    assertEquals("trop grande profondeur",iae.getMessage(),"trop grande profondeur");
		}
	}
	@Test 
	void testConstructeur2tropPetiteLargeur() {
		try {
			Puits puits = new Puits(3,16);
			fail("doit envoyer une erreur");
		}catch(IllegalArgumentException iae) {
		    assertEquals("trop petite largeur",iae.getMessage(),"trop petite largeur");
		}
	}
	@Test 
	void testConstructeur2tropGrandeLargeur() {
		try {
			Puits puits = new Puits(90,20);
			fail("doit envoyer une erreur");
		}catch(IllegalArgumentException iae) {
		    assertEquals("trop grande largeur",iae.getMessage(),"trop grande largeur");
		}
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
		String supposed = "Puits : Dimension 10 x 20\nPiece Actuelle : "+ newPO.toString().replaceAll("[\n\r]$", "")  +"\nPiece Suivante : "+newPI.toString();
																							//String.replace(newPO.toString().lastIndexOf("\n"),newPO.toString().lastIndexOf("\n")+1,"")
		assertEquals(supposed, puits3.toString(),"vghzd");
	}
	@Test
	void testToStringVide() {
		Puits puits3 = new Puits();
		String supposed = "Puits : Dimension 10 x 20\nPiece Actuelle : <aucune>\nPiece Suivante : <aucune>\n";
		assertEquals(supposed, puits3.toString(),"vghzd");
	}
	
	@Test
	void testProfondeurTropPetite() {
		Puits puits5 = new Puits();
		try {
			puits5.setProfondeur(1);
		    fail("normalement ça envoi un truc");
		  }catch(IllegalArgumentException iae){
		    assertEquals("trop petite profondeur",iae.getMessage(),"trop petit");
		  }
	}
	
	@Test
	void testProfondeurTropGrande() {
		Puits puits5 = new Puits();
		try {
			puits5.setProfondeur(56);
		    fail("normalement ça envoi un truc");
		  }catch(IllegalArgumentException iae){
		    assertEquals("trop grande profondeur",iae.getMessage(),"trop grand");
		  }
	}
	
	@Test
	void testLargeurTropPetite() {
		Puits puits = new Puits();
		try {
			puits.setLargeur(2);
			fail("normalement ça nevoie une erreur");
		}catch(IllegalArgumentException iae){
			assertEquals("trop petite largeur",iae.getMessage(),"trop petit");
		}
	}
	
	@Test
	void testLargeurTropGrande() {
		Puits puits = new Puits();
		try {
			puits.setLargeur(78);
			fail("normalement ça nevoie une erreur");
		}catch(IllegalArgumentException iae){
			assertEquals("trop grande largeur",iae.getMessage(),"trop grand");
		}
	}
}

