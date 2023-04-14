package fr.eseo.e3.poo.projet.blox.controleur;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuitsAffichageTest;

public class PieceDeplacementTest {

	public PieceDeplacementTest() {
		//testPieceDeplacement();
		testPieceDeplacement2();
			
	}
	
	private void testPieceDeplacement() {
		JFrame jframe = new JFrame("Test deplacelement");
		Puits puits = new Puits();
		VuePuits vuepuits = new VuePuits(puits,50);
		OPiece opiece = new OPiece(new Coordonnees(2,4),Couleur.ROUGE);
		puits.setPieceActuelle(opiece);
		
		PieceDeplacement pieceDeplacement = new PieceDeplacement(vuepuits);
		vuepuits.addMouseMotionListener(pieceDeplacement);
		vuepuits.addMouseListener(pieceDeplacement);
		vuepuits.addMouseWheelListener(pieceDeplacement);
		
		jframe.add(vuepuits);
		jframe.setSize(vuepuits.getDimension());
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}
	
	private void testPieceDeplacement2() {
		JFrame jframe = new JFrame("Test deplacelement2");
		Puits puits = new Puits();
		VuePuits vuepuits = new VuePuits(puits,50);
		UsineDePiece.setMode(1);
		Piece piece = UsineDePiece.genererPiece();
		puits.setPieceSuivante(piece);
		PieceDeplacement pieceDeplacement = new PieceDeplacement(vuepuits);
		jframe.add(vuepuits);
		jframe.setSize(vuepuits.getDimension());
		vuepuits.addMouseMotionListener(pieceDeplacement);
		vuepuits.addMouseListener(pieceDeplacement);
		vuepuits.addMouseWheelListener(pieceDeplacement);
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}
	
	public static void main(String [] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PieceDeplacementTest();
			}
		}
		);
	}
	
	
}
