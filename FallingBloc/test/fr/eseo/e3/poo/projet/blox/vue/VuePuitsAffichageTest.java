package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.JFrame;

//import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
//import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.SwingUtilities;

public class VuePuitsAffichageTest {

	public VuePuitsAffichageTest() {
		
		testConstructeurPuits();
		testConstructeurPuitsTaille();
		testUsinePiece();
	}
	
	private void testConstructeurPuits() {
		JFrame jframe = new JFrame("Puits");
		Puits puits = new Puits();
		VuePuits vuepuits = new VuePuits(puits);
		jframe.add(vuepuits);
		jframe.setSize(vuepuits.getDimension());
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}
	
	private void testConstructeurPuitsTaille() {
		JFrame jframe = new JFrame("Puits et taille");
		Puits puits = new Puits();
		VuePuits vuepuits = new VuePuits(puits,55);
		jframe.add(vuepuits);
		jframe.setSize(vuepuits.getDimension());
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}
	
	private void testUsinePiece() {
		JFrame jframe = new JFrame("Test avec vuepiece");
		Puits puits = new Puits();
		VuePuits vuepuits = new VuePuits(puits);
		UsineDePiece.setMode(1);
		Piece piece = UsineDePiece.genererPiece();
		puits.setPieceSuivante(piece);
		VuePiece vuepiece = new VuePiece(piece,5);
		//votre instance de VuePuits est enregistré comme 
		//listener de votre instance de Puits
		puits.addPropertyChangeListener(vuepuits);
		jframe.add(vuepuits);
		//jframe.add(vuepiece);
		jframe.setSize(vuepuits.getDimension());
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
		
	}
	public static void main(String [] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VuePuitsAffichageTest();
			}
		}
		);
	}
	
	
	
}


//package fr.eseo.e3.poo.projet.blox.vue;
//import javax.swing.JFrame;
//import javax.swing.SwingUtilities;
//import org.junit.jupiter.api.Test;
//import fr.eseo.e3.poo.projet.blox.modele.Puits;
//import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
//import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
//public class VuePuitsAffichageTest {
//	
//	@Test
//	private void testConstructeurPuits() {
//		UsineDePiece.setMode(1);
//		JFrame frame = new JFrame("Puits");
//		Piece piece = UsineDePiece.genererPiece();
//
//		Puits puits = new Puits();
//		
//		puits.setPieceSuivante(piece);
//		VuePuits VuePuits = new VuePuits(puits);
//		frame.add(VuePuits);
//		frame.setSize(VuePuits.getDimension());
//		frame.setLocationRelativeTo(null);//centre sur l'écran
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);	
//	}
//	@Test
//	private void testConstructeurPuitsTaille() {
//		JFrame frame = new JFrame("Puits et taille");
//		Puits puits = new Puits();
//		VuePuits VuePuits = new VuePuits(puits,67);
//		frame.add(VuePuits);
//		frame.setSize(VuePuits.getDimension());
//		frame.setLocationRelativeTo(null);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//	}
//	public VuePuitsAffichageTest() {
//		testConstructeurPuits();
//		testConstructeurPuitsTaille();
//	}
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable(){
//			@Override
//			public void run() {
//				new VuePuitsAffichageTest();
//			}
//		});
//	}
//}