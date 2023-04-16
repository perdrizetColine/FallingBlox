package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceRotation extends MouseAdapter {
	
	private VuePuits vuePuits;
	private Puits puits;
	
	public PieceRotation(VuePuits vuepuits) {
		this.vuePuits = vuepuits;
		this.puits = this.vuePuits.getPuits();
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		if(SwingUtilities.isRightMouseButton(event)) {
			if(possibleDroite()) {
				this.puits.getPieceActuelle().tourner(true);
			}
		}else if(SwingUtilities.isLeftMouseButton(event)) {
			if(possibleGauche()) {
				this.puits.getPieceActuelle().tourner(false);
			}
		}
	}
	
	
	private boolean possibleDroite() {
		//this.puits.getPieceActuelle().tourner(true)
		Piece pieceCopie = this.puits.getPieceActuelle();
		pieceCopie.tourner(true);
		int coteI = coteI(pieceCopie);
		int coteJ = coteJ(pieceCopie);
		int coteH = coteH(pieceCopie);
		int coteB = coteB(pieceCopie);
		if(coteJ < 0 | coteI > this.puits.getLargeur() | coteH < 0 | coteB > this.puits.getProfondeur()) {
			return false;
		}else {
			return true;
		}
	}
	private boolean possibleGauche() {
		Piece pieceCopie = this.puits.getPieceActuelle();
		pieceCopie.tourner(false);
		int coteI = coteI(pieceCopie);
		int coteJ = coteJ(pieceCopie);
		int coteH = coteH(pieceCopie);
		int coteB = coteB(pieceCopie);
		if(coteJ < 0 | coteI > this.puits.getLargeur() | coteH < 0 | coteB > this.puits.getProfondeur()) {
			return false;
		}else {
			return true;
		}
	}
	private int coteI(Piece piece) {
		int coteI = piece.getElements().get(0).getCoordonnees().getAbscisse();
		for(int i = 1; i>piece.getElements().size();i++) {
			if(piece.getElements().get(i).getCoordonnees().getAbscisse()>coteI) {
				coteI = piece.getElements().get(i).getCoordonnees().getAbscisse();
			}
		}
		return coteI;//abscisse la plus à droite
	}
	private int coteJ(Piece piece) {
		int coteJ = piece.getElements().get(0).getCoordonnees().getAbscisse();
		for(int j = 1; j>piece.getElements().size();j++) {
			if(piece.getElements().get(j).getCoordonnees().getAbscisse()<coteJ) {
				coteJ = piece.getElements().get(j).getCoordonnees().getAbscisse();
			}
		}
		return coteJ;//abscisse la plus à gauche
	}
	private int coteH(Piece piece) {
		int coteH = piece.getElements().get(0).getCoordonnees().getOrdonnee();
		for(int h = 1; h>piece.getElements().size();h++) {
			if(piece.getElements().get(h).getCoordonnees().getOrdonnee()<coteH) {
				coteH = piece.getElements().get(h).getCoordonnees().getOrdonnee();
			}
		}
		return coteH;//ordonnée la plus haute
	}
	private int coteB(Piece piece) {
		int coteB = piece.getElements().get(0).getCoordonnees().getOrdonnee();
		for(int b = 1; b>piece.getElements().size();b++) {
			if(piece.getElements().get(b).getCoordonnees().getOrdonnee()>coteB) {
				coteB = piece.getElements().get(b).getCoordonnees().getOrdonnee();
			}
		}
		return coteB;//ordonée la plus basse
	}
	
}