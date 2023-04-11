package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;

public class UsineDePieceTest {

	@Test 
	void testSetModeALEATOIRE_PIECE() {
		UsineDePiece.setMode(2);
		assertEquals(UsineDePiece.ALEATOIRE_PIECE, UsineDePiece.modeDeFonctionnement,"on doit être en mode ALEATOIRE_PIECE");
	}
	
	@Test
	void testSetModeALEATOIRECOMPLET() {
		UsineDePiece.setMode(0);
		assertEquals(UsineDePiece.ALEATOIRE_COMPLET,UsineDePiece.modeDeFonctionnement,"on doit être en mode ALEATOIRE_COMPLET");
	}

	@Test
	void testSetCYCLIC() {
		UsineDePiece.setMode(1);
		assertEquals(UsineDePiece.CYCLIC,UsineDePiece.modeDeFonctionnement,"on doit être en mode CYCLIC");
	}
	
	@Test
	void testGenererPieceModeALEATOIRECOMPLET() {
		UsineDePiece.setMode(0);
		Piece p = UsineDePiece.genererPiece();
		if(p.getClass()==IPiece.class) {
			assertEquals(IPiece.class, p.getClass(),"la piece doit être une Ipiece");
		}else {
			assertEquals(OPiece.class, p.getClass(),"la piece doit être une Opiece");
		} 
		Piece p2 = UsineDePiece.genererPiece();
		if(p2.getClass()==IPiece.class) {
			assertEquals(IPiece.class, p2.getClass(),"la piece doit être une Ipiece");
		}else {
			assertEquals(OPiece.class,p2.getClass(),"la piece doit être une Opiece");
		}
		Piece p3 = UsineDePiece.genererPiece();
		if(p3.getClass()==IPiece.class) {
			assertEquals(IPiece.class, p3.getClass(),"la piece doit être une Ipiece");
		}else {
			assertEquals(OPiece.class,p3.getClass(),"la piece doit être une Opiece");
		}
		Piece p4 = UsineDePiece.genererPiece();
		if(p4.getClass()==IPiece.class) {
			assertEquals(IPiece.class, p4.getClass(),"la piece doit être une Ipiece");
		}else {
			assertEquals(OPiece.class,p4.getClass(),"la piece doit être une Opiece");
		}
		Piece p5 = UsineDePiece.genererPiece();
		if(p5.getClass()==IPiece.class) {
			assertEquals(IPiece.class,p5.getClass(),"la piece doit être une Ipiece");
		}else {
			assertEquals(OPiece.class,p5.getClass(),"la piece doit être une Opiece");
		}
	}
	
	@Test
	void testGenererPieceModeCYCLIC() {
		UsineDePiece.setMode(1);
		assertEquals(OPiece.class,UsineDePiece.genererPiece().getClass(),"la pièce doit être une OPiece");
		assertEquals(IPiece.class,UsineDePiece.genererPiece().getClass(),"la pièce doit être une IPiece");
		assertEquals(OPiece.class,UsineDePiece.genererPiece().getClass(),"la pièce doit être une OPiece");
		assertEquals(IPiece.class,UsineDePiece.genererPiece().getClass(),"la pièce doit être une IPiece");
		assertEquals(OPiece.class,UsineDePiece.genererPiece().getClass(),"la pièce doit être une OPiece");
		assertEquals(IPiece.class,UsineDePiece.genererPiece().getClass(),"la pièce doit être une IPiece");
	}
	
	@Test
	void testGenererPieceModeALEATOIREPIECE() {
		UsineDePiece.setMode(2);
		Piece p = UsineDePiece.genererPiece();
		if(p.getClass()==IPiece.class) {
			assertEquals(IPiece.class, p.getClass(),"la piece doit être une Ipiece");
		}else {
			assertEquals(OPiece.class, p.getClass(),"la piece doit être une Opiece");
		}
		Piece p2 = UsineDePiece.genererPiece();
		if(p2.getClass()==IPiece.class) {
			assertEquals(IPiece.class, p2.getClass(),"la piece doit être une Ipiece");
		}else {
			assertEquals(OPiece.class, p2.getClass(),"la piece doit être une Opiece");
		}
		Piece p3 = UsineDePiece.genererPiece();
		if(p3.getClass()==IPiece.class) {
			assertEquals(IPiece.class, p3.getClass(),"la piece doit être une Ipiece");
		}else {
			assertEquals(OPiece.class, p3.getClass(),"la piece doit être une Opiece");
		}
		Piece p4 = UsineDePiece.genererPiece();
		if(p4.getClass()==IPiece.class) {
			assertEquals(IPiece.class, p4.getClass(),"la piece doit être une Ipiece");
		}else {
			assertEquals(OPiece.class, p4.getClass(),"la piece doit être une Opiece");
		}
	}
}
 