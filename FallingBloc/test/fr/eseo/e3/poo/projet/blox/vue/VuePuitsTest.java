package fr.eseo.e3.poo.projet.blox.vue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class VuePuitsTest {

	@Test
	void testConstructeurPuits() {
		Puits puits = new Puits();
		VuePuits vp = new VuePuits(puits);
		assertEquals(puits,vp.getPuits(),"le puits doit être celui initialisé");
		assertEquals(12,vp.getTaille(),"la taille doit être celle par défaut");
	}
	
	@Test
	void testConstructeurPuitsTaille() {
		Puits puits = new Puits();
		VuePuits vp = new VuePuits(puits,80);
		assertEquals(puits,vp.getPuits(),"le puits doit être celui initialisé");
		assertEquals(80,vp.getTaille(),"la taille doit être celle par défaut");
	}
	
	@Test
	void testSetTaille() {
		Puits puits = new Puits();
		VuePuits vp = new VuePuits(puits,80);
		assertEquals(80,vp.getTaille(),"la taille doit être celle par défaut");
		vp.setTaille(130);
		assertEquals(130,vp.getTaille(),"la taille doit être celle par défaut");		
	}
	
	@Test
	void testSetPuits() {
		Puits puits = new Puits();
		VuePuits vp = new VuePuits(puits,80);
		assertEquals(puits,vp.getPuits(),"le puits doit être celui initialisé");
		Puits puits2 = new Puits();
		vp.setPuits(puits2);
		assertEquals(puits2,vp.getPuits(),"le puits doit être celui initialisé");

	}

}
