package fr.eseo.e3.poo.projet.blox.vue;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
public class VuePuits extends javax.swing.JPanel {
	
	//Attributs
	public static final int TAILLE_PAR_DEFAUT = 12;
	private int taille;
	private Puits puits;
	private Dimension dimension;// = new Dimension(TAILLE_PAR_DEFAUT*18,TAILLE_PAR_DEFAUT*20);
	private Color color; 
	
	//Constructeurs
	public VuePuits(Puits puits) {
		this.puits = puits;
		this.taille = TAILLE_PAR_DEFAUT;
		this.dimension = new Dimension(this.taille*this.puits.getLargeur(),this.taille*this.puits.getProfondeur());
		this.setPreferredSize(dimension);
		this.color = Color.WHITE;
		setBackground(this.color);

	}
	
	public VuePuits(Puits puits, int taille) {
		this.puits = puits;
		this.taille = taille;
		this.dimension = new Dimension(this.taille*this.puits.getLargeur(),this.taille*this.puits.getProfondeur());
		this.setPreferredSize(dimension);
		this.color = Color.WHITE;
		setBackground(this.color);
	}
	
	//Mutateurs
	public Puits getPuits() {
		return this.puits;
	}
	
	public int getTaille() {
		return this.taille;
	}
	
	public Dimension getDimension() {
		return this.dimension;
	}
	
	public void setPuits(Puits puits) {
		this.puits = puits;
		this.setPreferredSize(new Dimension(this.taille*this.puits.getLargeur(),this.taille*this.puits.getProfondeur()));
	}
	
	public void setTaille(int taille) {
		this.taille = taille;
		this.setPreferredSize(new Dimension(this.taille*this.puits.getLargeur(),this.taille*this.puits.getProfondeur()));
	}
	
//	public void setDimension(Dimension dimension) {
//		this.setPreferredSize(dimension);
//	}
	
	//Méthode
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		/* appel vers super pour remplir le fond du JPanel */
		/*Le paramètre g est copie en utilisant la méthode copie()
		* puis converti en instance de Graphics2D grâce à
		* un transtypage (cast) explicite.
		*/
		
		Graphics2D g2D = (Graphics2D)g.create();
		
		/* Nous utiliserons l'instance de Graphics2D*/
		
		for(int i = 0; i<=this.getPuits().getLargeur();i++) {
			g2D.setColor(Color.LIGHT_GRAY);
			g2D.drawLine(getTaille()*i, 0, getTaille()*i, getTaille()*getPuits().getProfondeur());
		}
		for(int i = 0; i<=this.getPuits().getProfondeur();i++) {
			g2D.setColor(Color.LIGHT_GRAY);
			g2D.drawLine(0, getTaille()*i, getTaille()*getPuits().getLargeur(), getTaille()*i);
		}

		
		/*Puis nous liberons la memoire*/
		g2D.dispose();
	}
}

/*
 * JFrame t = new JFrame();
 * JPanel pan = new JPanel (new GridLayout (3,3));
 * Border blackline = BorderFactory.createLineBorder(Color.black,1); 
 * for(int i = 0; i<9;i++){
 *    JPanel ptest = new JPanel();
 *    ptest.setBorder(blackline);
 *    pan.add(ptest);
 * }
 * pan.setBorder(blackline);
 * t.add(pan);
 * t.setVisible(true);
 * 
 * panel.setLayout(new GridLayout(3, // nb de cases dans une ligne
 *       						3, // nb de cases dans une colonne
 *       						1, // épaisseur des traits horizontaux
 *    						    1)); // épaisseur des traits verticaux
 * panel.setBackground(Color.BLACK); // Couleur des traits

 */




