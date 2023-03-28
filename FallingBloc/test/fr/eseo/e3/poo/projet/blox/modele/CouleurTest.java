package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CouleurTest {
 
	@Test
	void testCouleur() {
		Couleur vert = Couleur.VERT;
		assertEquals(Couleur.VERT, vert,"la couleur vert est VERT");
		assertEquals(java.awt.Color.GREEN,vert.getCouleurPourAffichage());
	}

}
