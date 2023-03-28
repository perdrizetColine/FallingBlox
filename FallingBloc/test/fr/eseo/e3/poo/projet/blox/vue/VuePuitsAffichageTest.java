package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;

//import static org.junit.jupiter.api.Assertions.fail;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;



public class VuePuitsAffichageTest {

	@Test
	private void testConstructeurPuits() {
		JFrame frame = new JFrame("Puits");
		
		VuePuits VuePuits = new VuePuits(new Puits());
		
		frame.add(VuePuits);
		
		frame.setSize(VuePuits.getDimension());
		
		frame.setLocationRelativeTo(null);//centre sur l'écran
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
	}
	
	@Test
	private void testConstructeurPuitsTaille() {
		JFrame frame = new JFrame("Puits et taille");
		Puits puits = new Puits();
		VuePuits VuePuits = new VuePuits(puits,67);
		frame.add(VuePuits);
		frame.setSize(VuePuits.getDimension());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public VuePuitsAffichageTest() {
		testConstructeurPuits();
		testConstructeurPuitsTaille();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new VuePuitsAffichageTest();
			}
		});
	}
}


/*import javax swing.SwingUtilities;

public class IhmTest {

	public IhmTest() {
		testPanneau();
	}
	
	public void testPanneau () {
		// Le code de test //
	}
	
	public static void main (String [] args) {
		SwingUtilities.invokeLater(new Runnable () {
			@Override
			public void run() {
				new IhmTest ();
			}
		});
	}
}		 
*/