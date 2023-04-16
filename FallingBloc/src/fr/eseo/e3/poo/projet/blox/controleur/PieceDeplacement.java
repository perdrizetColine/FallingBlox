package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacement extends MouseAdapter{
	 
	private VuePuits vuePuits;
	private Puits puits; 
	private int colonne = -1;
	
	public PieceDeplacement (VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = vuePuits.getPuits();
		this.vuePuits.addMouseMotionListener(this);
	}
	/*
	public PieceDeplacement (Puits puits, VuePuits vuepuits) {
		this.puits = puits;
		this.vuePuits = vuePuits;
		//pour dire qu'aucun element n'a déjà été crée
		this.colonne = -1;
		this.vuePuits.addMouseMotionListener(this);
	}*/
	
	@Override
	public void mouseMoved(MouseEvent event) {
		if (this.puits.getPieceActuelle()!=null) {
			int p = event.getX()/this.vuePuits.getTaille();
			if (this.colonne == -1) {
				this.colonne = p;
			}else if (this.colonne!=p) {
				try {
					this.puits.getPieceActuelle().deplacerDe(p-this.colonne,0);
					this.colonne = p;
				}catch (Exception exception) {
				}
				
			}
		}
	}
	
	@Override
	public void mouseDragged (MouseEvent event) {
		
	}
	
	public void mouseEntered(MouseEvent event) {
		//quelque chose
		this.colonne=-1;
	}
	
//	public void mouseWheelMoved(MouseEvent event) {
//		//quelque chose
//	}
	
	public void mouseWheelMoved(MouseWheelEvent event) {
		if(this.puits.getPieceActuelle()!=null) {
			if(event.getWheelRotation()>0) {
				this.puits.getPieceActuelle().deplacerDe(0, 1);
			}
		}
	}

}
