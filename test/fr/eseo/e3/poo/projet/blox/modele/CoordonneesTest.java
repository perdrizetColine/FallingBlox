package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CoordonneesTest {

	@Test
	void testConstructeur() {
		Coordonnees coord = new Coordonnees(3,4);
		assertEquals(3,coord.getAbscisse(),"Abscisse doit être à 3");
		assertEquals(4,coord.getOrdonnee(),"Ordonnee doit être à 4");
	}
	
	@Test
	void testSetteurAbscisse() {
		Coordonnees coord = new Coordonnees(3,4);
		assertEquals(3,coord.getAbscisse(),"Abscisse doit être à 3");
		assertEquals(4,coord.getOrdonnee(),"Ordonnee doit être à 4");
		coord.setAbscisse(6);
		coord.setOrdonnee(7);
		assertEquals(6,coord.getAbscisse(),"Abscisse doit être à 6");
	}
	
	@Test
	void testSetteurOrdonnee() {
		Coordonnees coord = new Coordonnees(3,4);
		assertEquals(3,coord.getAbscisse(),"Abscisse doit être à 3");
		assertEquals(4,coord.getOrdonnee(),"Ordonnee doit être à 4");
		coord.setAbscisse(6);
		coord.setOrdonnee(7);
		assertEquals(7,coord.getOrdonnee(),"Ordonnee doit être à 7");
	}
	
	@Test
	void testToString() {
		Coordonnees coord = new Coordonnees(3,4);
		assertEquals("(3, 4)",coord.toString(),"To string doit donner (3, 4)");
	}
	
	@Test
	void testEqualsFaux() {
		Coordonnees coord = new Coordonnees(3,4);
		assertFalse(coord.equals(),"pas égal");
	}
	
	@Test
	void testEqualsVrai() {
		Coordonnees coord = new Coordonnees(3,3);
		assertTrue(coord.equals(),"pas égal");
	}
	
	@Test
	void testEqualsObjSame() {
		Coordonnees coord1 = new Coordonnees(3,4);
		Coordonnees coord2 = new Coordonnees(3,4);
		assertTrue(coord1.equals(coord2), "objets pareils");
	}
	
	@Test
	void testEqualsObjPasSame() {
		Coordonnees coord1 = new Coordonnees(3,4);
		Coordonnees coord2 = new Coordonnees(5,4);
		assertFalse(coord1.equals(coord2), "objets pas pareils");
	}
	
	@Test
	void testEqualsObjNull() {
		Coordonnees coord1 = new Coordonnees(3,4);
		Coordonnees coord2 = null;
		assertFalse(coord1.equals(coord2), "objets pas initialisé");
	}
	
	@Test
	void testHashCode() {
		Coordonnees coord = new Coordonnees(3,4);
		assertEquals(coord.hashCode(),1058,"resultat hashCode");
	}
}
