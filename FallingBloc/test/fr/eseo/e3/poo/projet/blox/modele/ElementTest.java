package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ElementTest {

	@Test
	void testConstructeurVide() {
		Coordonnees coord1 = new Coordonnees(5,6);
		Element element1 = new Element(coord1);
		assertEquals(coord1,element1.getCoordonnees(),"les coordonnees");
		assertEquals(coord1.getAbscisse(),element1.getCoordonnees().getAbscisse(),"l'abscisse");
		assertEquals(coord1.getOrdonnee(),element1.getCoordonnees().getOrdonnee(),"l'ordonnee");
		assertEquals(Couleur.ROUGE,element1.getCouleur(),"la couleur");
	}
	
	@Test
	void testConstructeurAbscisseOrdonnee() {
		int abscisse = 2;
		int ordonnee = 9;
		Coordonnees coord2 = new Coordonnees(abscisse,ordonnee);
		Element element2 = new Element(abscisse, ordonnee);
		assertEquals(coord2,element2.getCoordonnees(),"les coordonnees");
		assertEquals(coord2.getAbscisse(),element2.getCoordonnees().getAbscisse(),"l'abscisse");
		assertEquals(coord2.getOrdonnee(),element2.getCoordonnees().getOrdonnee(),"l'ordonnee");
		assertEquals(Couleur.ROUGE,element2.getCouleur(),"la couleur");
	}
	
	@Test
	void TestConstructeurCoordonneesCouleur() {
		Coordonnees coord3 = new Coordonnees(5,2);
		Couleur couleur3 = Couleur.VIOLET;
		Element element3 = new Element(coord3, couleur3);
		assertEquals(coord3,element3.getCoordonnees(),"les coordonnees");
		assertEquals(coord3.getAbscisse(),element3.getCoordonnees().getAbscisse(),"l'abscisse");
		assertEquals(coord3.getOrdonnee(),element3.getCoordonnees().getOrdonnee(),"l'ordonnee");
		assertEquals(Couleur.VIOLET,element3.getCouleur(),"la couleur");
	}
	
	@Test
	void testConstructeurAbscisseOrdonneeCouleur() {
		int abscisse = 7;
		int ordonnee = 6;
		Coordonnees coord4 = new Coordonnees(abscisse,ordonnee);
		Couleur couleur4 = Couleur.JAUNE;
		Element element4 = new Element(abscisse, ordonnee, couleur4);
		assertEquals(coord4,element4.getCoordonnees(),"les coordonnees");
		assertEquals(coord4.getAbscisse(),element4.getCoordonnees().getAbscisse(),"l'abscisse");
		assertEquals(coord4.getOrdonnee(),element4.getCoordonnees().getOrdonnee(),"l'ordonnee");
		assertEquals(Couleur.JAUNE,element4.getCouleur(),"la couleur");
	}
	
	@Test
	void testSetCoordonnees() {
		Coordonnees coord5 = new Coordonnees(5,6);
		Coordonnees coord5bis = new Coordonnees(7,8);
		Element element5 = new Element(coord5);
		assertEquals(coord5,element5.getCoordonnees(),"les coordonnees");
		assertEquals(coord5.getAbscisse(),element5.getCoordonnees().getAbscisse(),"l'abscisse");
		assertEquals(coord5.getOrdonnee(),element5.getCoordonnees().getOrdonnee(),"l'ordonnee");
		element5.setCoordonnees(coord5bis);
		assertEquals(coord5bis,element5.getCoordonnees(),"les coordonnees");
		assertEquals(coord5bis.getAbscisse(),element5.getCoordonnees().getAbscisse(),"l'abscisse");
		assertEquals(coord5bis.getOrdonnee(),element5.getCoordonnees().getOrdonnee(),"l'ordonnee");
	}
	
	@Test
	void testSetCouleur() {
		Coordonnees coord6 = new Coordonnees(5,6);
		Couleur Couleur6 = Couleur.ORANGE;
		Element element6 = new Element(coord6);
		assertEquals(Couleur.ROUGE,element6.getCouleur(),"la couleur");
		element6.setCouleur(Couleur6);
		assertEquals(Couleur.ORANGE,element6.getCouleur(),"la couleur");
	}
	
	@Test
	void testToString() {
		Coordonnees coord7 = new Coordonnees(8,5);
		Element element7 = new Element(coord7);
		assertEquals("(8, 5) - ROUGE",element7.toString(),"string incorrect");
	}
	
	@Test
	void testHashCode() {
		Coordonnees coord8 = new Coordonnees(2,9);
		Element element8 = new Element(coord8);
		assertEquals(element8.hashCode(),element8.hashCode(),"hasCode non");
	}
	
	@Test
	void testEqualsObjetPareil() {
		Coordonnees coord9 = new Coordonnees(4,1);
		Element element9_1 = new Element(coord9);
		Element element9_2 = new Element(coord9);
		assertTrue(element9_1.equals(element9_2),"objets pareils");
	}
	
	@Test
	void testEqualsPasPareil() {
		Coordonnees coord10_1 = new Coordonnees(34,18);
		Coordonnees coord10_2 = new Coordonnees(78,2);
		Element element10_1 = new Element(coord10_1);
		Element element10_2 = new Element(coord10_2);
		assertFalse(element10_1.equals(element10_2),"objets pas pareils");
	}
	
	@Test
	void testEqualsNull() {
		Coordonnees coord11 = new Coordonnees(34,18);
		Element element11_1 = new Element(coord11);
		Element element11_2 = null;
		assertFalse(element11_1.equals(element11_2),"objets pas pareils");
	}
	
	@Test
	void testEqualsPasObjetPareil() {
		Coordonnees coord12 = new Coordonnees(34,18);
		Element element12 = new Element(coord12);
		Couleur couleur12 = Couleur.CYAN;
		assertFalse(element12.equals(couleur12),"objets pas pareils");
	}
	
	@Test
	void testEqualsObjetLuiMeme() {
		Coordonnees coord12 = new Coordonnees(6,98);
		Element element12 = new Element(coord12);
		assertTrue(element12.equals(element12),"objet lui même");
	}
	
	void testEqualsCouleursChangent() {
		Coordonnees coord3 = new Coordonnees(5,2);
		Couleur couleur3 = Couleur.VIOLET;
		Couleur autre = Couleur.CYAN;
		Element element3 = new Element(coord3, couleur3);
		Element elementAutre = new Element(coord3, autre);
		assertFalse(element3.equals(elementAutre),"couleur change");
	}
}

