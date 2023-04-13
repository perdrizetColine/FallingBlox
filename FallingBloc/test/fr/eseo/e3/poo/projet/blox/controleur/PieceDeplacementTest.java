package fr.eseo.e3.poo.projet.blox.controleur;

import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacementTest {

	public  PieceDeplacementTest() {
		testPieceDeplacement();
			
	}
	
private void testPieceDeplacement() {
	Puits puits = new Puits();
	OPiece opiece = new OPiece(new Coordonnees(2,4),Couleur.ROUGE);
	puits.setPieceActuelle(opiece);
	VuePuits vuePuits = new VuePuits(puits);
	PieceDeplacement pieceDeplacement = new PieceDeplacement(vuePuits);
	vuePuits.addMouseMotionListener(pieceDeplacement);
	JFrame jframe = new JFrame("Test deplacelement");
	jframe.add(vuePuits);
	jframe.setSize(vuePuits.getDimension());
	jframe.setLocationRelativeTo(null);
	jframe.setVisible(true);
}
	
}
