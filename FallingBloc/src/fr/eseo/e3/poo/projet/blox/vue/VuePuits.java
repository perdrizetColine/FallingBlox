package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import  java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePuits extends JPanel implements PropertyChangeListener{
	
	public static final int TAILLE_PAR_DEFAUT = 10;
	private Puits puits;
	int taille;
	private Dimension dimension;
	private VuePiece vuePiece;
		
	public VuePuits (Puits puits) {
		this.puits = puits;
		this.taille = TAILLE_PAR_DEFAUT;
		this.dimension = new Dimension(this.taille*this.puits.getLargeur(),
				this.taille*this.puits.getProfondeur());
		setPreferredSize(this.dimension);
		setBackground(Color.WHITE);
		puits.addPropertyChangeListener(this);

	}
	
	public VuePuits (Puits puits, int taille) {
		this.puits = puits;
		this.taille = taille;
		this.dimension = new Dimension(this.taille*this.puits.getLargeur(),
				this.taille*this.puits.getProfondeur());
		setPreferredSize(dimension);
		setBackground(Color.WHITE);
		puits.addPropertyChangeListener(this);

}
	
	public Puits getPuits() {
		return this.puits;
	}
	
	public int getTaille() {
		return this.taille;
	}
	
	public Dimension getDimension() {
		return this.dimension;
	}
	
	public VuePiece getVuePiece() {
		return this.vuePiece;
	}
	
	public void setPuits(Puits puits) {
		this.puits = puits;
		setPreferredSize(new Dimension(getTaille()*getPuits().getLargeur(),
				getTaille()*getPuits().getProfondeur()));
	}
	
	public void setTaille (int taille) {
		this.taille = taille;
		setPreferredSize(new Dimension(getTaille()*getPuits().getLargeur(),
				getTaille()*getPuits().getProfondeur()));
	}
	
	public void setDimension (Dimension dimension) {
		this.dimension = dimension;
	}
	
	private void setVuePiece(VuePiece vuePiece) {
		this.vuePiece = vuePiece;
	}
	
	protected void paintComponent ( Graphics g) {
		//background blanc initialisé dans les constructeurs
		
		super.paintComponent(g);
		
		/* appel vers super pour remplir le fond du JPanel */
		/*Le paramètre g est copie en utilisant la méthode copie()
		* puis converti en instance de Graphics2D grâce à
		* un transtypage (cast) explicite.*/
		
		Graphics2D g2D = (Graphics2D)g.create();
		g2D.setColor(Color.LIGHT_GRAY);
		
		/* Nous utiliserons l'instance de Graphics2D*/		
		
		for (int i = 0; i<this.puits.getProfondeur();i++) {
			g2D.drawLine(0,i*getTaille(), getTaille()*getPuits().getLargeur(), i*getTaille());
		}
		for (int j = 0;j<this.puits.getLargeur(); j++) {
			g2D.drawLine(j*getTaille(),0,j*getTaille(),getTaille()*getPuits().getProfondeur());
		}
		
		if (this.vuePiece !=null) {
			this.vuePiece.afficherPiece(g2D);
		}
		//A Graphics object cannot be used after dispose has been called.
		/*Puis nous liberons la memoire*/
		
		g2D.dispose();
		
	}
	
	public void propertyChange(PropertyChangeEvent event) {
		Piece pieceAct = (Piece) event.getNewValue();
		Piece pieceOld = (Piece) event.getOldValue();
		if (!pieceAct.equals(pieceOld)) {
			this.setVuePiece(new VuePiece(pieceAct,this.getTaille()));
		}
		
	}
	
}

//package fr.eseo.e3.poo.projet.blox.vue;
//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Color;
//import java.beans.PropertyChangeEvent;
//import java.beans.PropertyChangeSupport;
//import fr.eseo.e3.poo.projet.blox.modele.Puits;
//import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
//
//public class VuePuits extends javax.swing.JPanel implements java.beans.PropertyChangeListener{
//	public static final int TAILLE_PAR_DEFAUT = 12;
//	private int taille;
//	private Puits puits;
//	private Dimension dimension;// = new Dimension(TAILLE_PAR_DEFAUT*18,TAILLE_PAR_DEFAUT*20);
//	private Color color; 
//	private VuePiece vuePiece;
//	
//	public VuePuits(Puits puits) {
//		this.puits = puits;
//		this.taille = TAILLE_PAR_DEFAUT;
//		this.dimension = new Dimension(this.taille*this.puits.getLargeur(),this.taille*this.puits.getProfondeur());
//		this.setPreferredSize(dimension);
//		this.color = Color.WHITE;
//		setBackground(this.color);
//	}
//	public VuePuits(Puits puits, int taille) {
//		this.puits = puits;
//		this.taille = taille;
//		this.dimension = new Dimension(this.taille*this.puits.getLargeur(),this.taille*this.puits.getProfondeur());
//		this.setPreferredSize(dimension);
//		this.color = Color.WHITE;
//		setBackground(this.color);
//	}
//	public Puits getPuits() {
//		return this.puits;
//	}
//	public int getTaille() {
//		return this.taille;
//	}
//	public Dimension getDimension() {
//		return this.dimension;
//	}
//	public VuePiece getVuePiece() {
//		return this.vuePiece;
//	}
//	public void setPuits(Puits puits) {
//		this.puits = puits;
//		this.setPreferredSize(new Dimension(getTaille()*getPuits().getLargeur(),
//				getTaille()*getPuits().getProfondeur()));
//	}
//	public void setTaille(int taille) {
//		this.taille = taille;
//		this.setPreferredSize(new Dimension(getTaille()*getPuits().getLargeur(),
//				getTaille()*getPuits().getProfondeur()));
//	}
//	private void setVuePiece(VuePiece vuePiece) {
//		this.vuePiece = new VuePiece(getPuits().getPieceActuelle(),getTaille());
//	}
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
////		appel vers super pour remplir le fond du JPanel */
////		Le paramètre g est copie en utilisant la méthode copie()
////		puis converti en instance de Graphics2D grâce à
////		un transtypage (cast) explicite.
//		Graphics2D g2D = (Graphics2D)g.create();/* Nous utiliserons l'instance de Graphics2D*/
//		g2D.setColor(Color.LIGHT_GRAY);
//		for(int i = 0; i<=this.getPuits().getLargeur();i++) {
//			g2D.drawLine(getTaille()*i, 0, getTaille()*i, getTaille()*getPuits().getProfondeur());
//		}
//		for(int i = 0; i<=this.getPuits().getProfondeur();i++) {
//			g2D.drawLine(0, getTaille()*i, getTaille()*getPuits().getLargeur(), getTaille()*i);
//		}
//		if(this.vuePiece!=null) {
//			getVuePiece().afficherPiece(g2D);
//		}
//		g2D.dispose();/*Puis nous liberons la memoire*/
//	}
//	@Override
//	public void propertyChange(PropertyChangeEvent evt) {
//		Piece pieceActu = (Piece) evt.getNewValue();
//		Piece pieceActuAn = (Piece) evt.getOldValue();
//		if(!pieceActu.equals(pieceActuAn)) {
//			this.setVuePiece(new VuePiece(pieceActu, this.getTaille()));
//		}
//	}
////	public void propertyChange(PropertyChangeEvent evt) {
////		// TODO Auto-generated method stub
////		if(evt.getPropertyName().equals("evenement")) {
////			this.setVuePiece(new VuePiece((Piece) evt.getNewValue(), getTaille()));
////		}
////	}
//}