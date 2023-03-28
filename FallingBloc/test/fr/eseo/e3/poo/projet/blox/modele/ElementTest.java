package fr.eseo.e3.poo.projet.blox.modele;
 
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ElementTest {

	@Test
	void testConstructeurVide() {
		Coordonnees coord = new Coordonnees(5,6);
		Element element = new Element(coord);
		assertEquals(coord,element.getCoordonnees(),"les coordonnees");
		assertEquals(coord.getAbscisse(),element.getCoordonnees().getAbscisse(),"l'abscisse");
		assertEquals(coord.getOrdonnee(),element.getCoordonnees().getOrdonnee(),"l'ordonnee");
		assertEquals(Couleur.ROUGE,element.getCouleur(),"la couleur");
	}
	
	@Test
	void testConstructeurAbscisseOrdonnee() {
		int abscisse = 2;
		int ordonnee = 9;
		Coordonnees coord = new Coordonnees(abscisse,ordonnee);
		Element element = new Element(abscisse, ordonnee);
		assertEquals(coord,element.getCoordonnees(),"les coordonnees");
		assertEquals(coord.getAbscisse(),element.getCoordonnees().getAbscisse(),"l'abscisse");
		assertEquals(coord.getOrdonnee(),element.getCoordonnees().getOrdonnee(),"l'ordonnee");
		assertEquals(Couleur.ROUGE,element.getCouleur(),"la couleur");
	}
	
	@Test
	void TestConstructeurCoordonneesCouleur() {
		Coordonnees coord = new Coordonnees(5,2);
		Couleur couleur = Couleur.VIOLET;
		Element element = new Element(coord, couleur);
		assertEquals(coord,element.getCoordonnees(),"les coordonnees");
		assertEquals(coord.getAbscisse(),element.getCoordonnees().getAbscisse(),"l'abscisse");
		assertEquals(coord.getOrdonnee(),element.getCoordonnees().getOrdonnee(),"l'ordonnee");
		assertEquals(Couleur.VIOLET,element.getCouleur(),"la couleur");
	}
	
	@Test
	void testConstructeurAbscisseOrdonneeCouleur() {
		int abscisse = 7;
		int ordonnee = 6;
		Coordonnees coord = new Coordonnees(abscisse,ordonnee);
		Couleur couleur = Couleur.JAUNE;
		Element element = new Element(abscisse, ordonnee, couleur);
		assertEquals(coord,element.getCoordonnees(),"les coordonnees");
		assertEquals(coord.getAbscisse(),element.getCoordonnees().getAbscisse(),"l'abscisse");
		assertEquals(coord.getOrdonnee(),element.getCoordonnees().getOrdonnee(),"l'ordonnee");
		assertEquals(Couleur.JAUNE,element.getCouleur(),"la couleur");
	}
	
	@Test
	void testSetCoordonnees() {
		Coordonnees coord = new Coordonnees(5,6);
		Coordonnees coordbis = new Coordonnees(7,8);
		Element element = new Element(coord);
		assertEquals(coord,element.getCoordonnees(),"les coordonnees");
		assertEquals(coord.getAbscisse(),element.getCoordonnees().getAbscisse(),"l'abscisse");
		assertEquals(coord.getOrdonnee(),element.getCoordonnees().getOrdonnee(),"l'ordonnee");
		element.setCoordonnees(coordbis);
		assertEquals(coordbis,element.getCoordonnees(),"les coordonnees");
		assertEquals(coordbis.getAbscisse(),element.getCoordonnees().getAbscisse(),"l'abscisse");
		assertEquals(coordbis.getOrdonnee(),element.getCoordonnees().getOrdonnee(),"l'ordonnee");
	}
	
	@Test
	void testSetCouleur() {
		Coordonnees coord = new Coordonnees(5,6);
		//Couleur Couleur = 
		Element element = new Element(coord);
		assertEquals(Couleur.ROUGE,element.getCouleur(),"la couleur");
		element.setCouleur(Couleur.ORANGE);
		assertEquals(Couleur.ORANGE,element.getCouleur(),"la couleur");
	}
	
	@Test
	void testToString() {
		Coordonnees coord = new Coordonnees(8,5);
		Element element = new Element(coord);
		assertEquals("(8, 5) - ROUGE",element.toString(),"string incorrect");
	}
	
	@Test
	void testHashCode() {
		Coordonnees coord = new Coordonnees(2,9);
		Element element = new Element(coord);
		assertEquals(element.hashCode(),element.hashCode(),"hasCode non");
	}
	
	@Test
	void testEqualsObjetPareil() {
		Coordonnees coord = new Coordonnees(4,1);
		Element element1 = new Element(coord);
		Element element2 = new Element(coord);
		assertTrue(element1.equals(element2),"objets pareils");
	}
	
	@Test
	void testEqualsPasPareil() {
		Coordonnees coord1 = new Coordonnees(34,18);
		Coordonnees coord2 = new Coordonnees(78,2);
		Element element1 = new Element(coord1);
		Element element2 = new Element(coord2);
		assertFalse(element1.equals(element2),"objets pas pareils");
	}
	
	@Test
	void testEqualsNull() {
		Coordonnees coord = new Coordonnees(34,18);
		Element element1 = new Element(coord);
		Element element2 = null;
		assertFalse(element1.equals(element2),"objets pas pareils");
	}
	
	@Test
	void testEqualsPasObjetPareil() {
		Coordonnees coord = new Coordonnees(34,18);
		Element element = new Element(coord);
		Couleur couleur = Couleur.CYAN;
		assertFalse(element.equals(couleur),"objets pas pareils");
	}
	
	@Test
	void testEqualsObjetLuiMeme() {
		Coordonnees coord = new Coordonnees(6,98);
		Element element = new Element(coord);
		assertTrue(element.equals(element),"objet lui même");
	}
	
	void testEqualsCouleursChangent() {
		Coordonnees coord = new Coordonnees(5,2);
		Couleur couleur = Couleur.VIOLET;
		Couleur autre = Couleur.CYAN;
		Element element = new Element(coord, couleur);
		Element elementAutre = new Element(coord, autre);
		assertFalse(element.equals(elementAutre),"couleur change");
	}
}

