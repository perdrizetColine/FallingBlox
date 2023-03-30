package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePiece {
	
	//Attributs
	public static final double MULTIPLIER_TEINTE = 0.5;
	private final int taille;
	private final Piece piece;
	
	//Constructeur
	public VuePiece(Piece piece, int taille){
		this.piece = piece;
		this.taille = taille;
	}
	
	//Méthodes
	public Color teinte(Color couleur){
		Color col = this.piece.getElements().get(0).getCouleur().getCouleurPourAffichage();
		double colR = col.getRed();
		double colG = col.getGreen();
		double colB = col.getBlue();
		colR = colR + (255 - colR) * MULTIPLIER_TEINTE;
		colG = colG + (255 - colG) * MULTIPLIER_TEINTE;
		colB = colB + (255 - colB) * MULTIPLIER_TEINTE;
		int cR = (int) colR;
		int cG = (int) colG;
		int cB = (int) colB;
		java.awt.Color c = new java.awt.Color(cR, cG,cB);
		return c.brighter();
	}
	
	public void afficherPiece(Graphics2D g2D) {
		Color col = this.piece.getElements().get(0).getCouleur().getCouleurPourAffichage();
		g2D.setColor(col);
		g2D.fill3DRect(taille, taille, taille, taille, false);
	}
}
