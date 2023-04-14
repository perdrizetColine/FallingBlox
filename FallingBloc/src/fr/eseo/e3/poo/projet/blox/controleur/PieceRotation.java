package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
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
			if(possible()) {
				this.puits.getPieceActuelle().tourner(true);
			}
		}else if(SwingUtilities.isLeftMouseButton(event)) {
			if(possible()) {
				this.puits.getPieceActuelle().tourner(false);
			}
		}
	}
	
	
	private boolean possible() {
		int coteI = coteI();
		int coteJ = coteJ();
		int coteH = coteH();
		int coteB = coteB();
		if(coteJ < 0 | coteI > this.puits.getLargeur() | coteH < 0 | coteB > this.puits.getProfondeur()) {
			return false;
		}else {
			return true;
		}
	}
	private int coteI() {
		int coteI = this.puits.getPieceActuelle().getElements().get(0).getCoordonnees().getAbscisse();
		for(int i = 1; i>this.puits.getPieceActuelle().getElements().size();i++) {
			if(this.puits.getPieceActuelle().getElements().get(i).getCoordonnees().getAbscisse()>coteI) {
				coteI = this.puits.getPieceActuelle().getElements().get(i).getCoordonnees().getAbscisse();
			}
		}
		return coteI;
	}
	private int coteJ() {
		int coteJ = this.puits.getPieceActuelle().getElements().get(0).getCoordonnees().getAbscisse();
		for(int j = 1; j>this.puits.getPieceActuelle().getElements().size();j++) {
			if(this.puits.getPieceActuelle().getElements().get(j).getCoordonnees().getAbscisse()<coteJ) {
				coteJ = this.puits.getPieceActuelle().getElements().get(j).getCoordonnees().getAbscisse();
			}
		}
		return coteJ;
	}
	private int coteH() {
		int coteH = this.puits.getPieceActuelle().getElements().get(0).getCoordonnees().getOrdonnee();
		for(int h = 1; h>this.puits.getPieceActuelle().getElements().size();h++) {
			if(this.puits.getPieceActuelle().getElements().get(h).getCoordonnees().getOrdonnee()<coteH) {
				coteH = this.puits.getPieceActuelle().getElements().get(h).getCoordonnees().getOrdonnee();
			}
		}
		return coteH;
	}
	private int coteB() {
		int coteB = this.puits.getPieceActuelle().getElements().get(0).getCoordonnees().getOrdonnee();
		for(int b = 1; b>this.puits.getPieceActuelle().getElements().size();b++) {
			if(this.puits.getPieceActuelle().getElements().get(b).getCoordonnees().getOrdonnee()>coteB) {
				coteB = this.puits.getPieceActuelle().getElements().get(b).getCoordonnees().getOrdonnee();
			}
		}
		return coteB;
	}
}