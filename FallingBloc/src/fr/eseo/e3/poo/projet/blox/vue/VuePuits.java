package fr.eseo.e3.poo.projet.blox.vue;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
public class VuePuits extends javax.swing.JPanel {
	
	//Attributs
	public static final int TAILLE_PAR_DEFAUT = 50;
	private int taille;
	private Puits puits;
	//Constructeurs
	public VuePuits(Puits puits) {
		this.puits = puits;
		this.taille = TAILLE_PAR_DEFAUT;
	}
	
	public VuePuits(Puits puits, int taille) {
		this.puits = puits;
		this.taille = taille;
	}
	
	//Mutateurs
	public Puits getPuits() {
		return this.puits;
	}
	
	public int getTaille() {
		return this.taille;
	}
	
	public void setPuits(Puits puits) {
		this.puits = puits;
	}
	
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
//	//Méthode
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		/* appel vers super pour remplir le fond du JPanel */
//		/*Le paramètre g est copie en utilisant la méthode copie()
//		* puis converti en instance de Graphics2D grâce à
//		* un transtypage (cast) explicite.
//		*/
//		Graphics2D g2D = (Graphics2D)g.create();
//		/* Nous utiliserons l'instance de Graphics2D*/
//		/*Puis nous liberons la memoire*/
//		g2D.dispose();
//	}
}
