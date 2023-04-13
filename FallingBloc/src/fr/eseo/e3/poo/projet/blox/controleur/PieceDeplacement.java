package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacement implements MouseMotionListener{
	 
	private VuePuits vuePuits;
	private Puits puits; 
	//ajout d'une valeur pour la colonne par défaut
	private int colonne = -1;
	
	public PieceDeplacement (VuePuits vuepuits) {
		this.vuePuits = vuePuits;
		//initialiser puits avec le puit de vuePuits
		this.puits = vuePuits.getPuits();
		vuePuits.addMouseMotionListener(this);
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
			//verifie le numero de la colonne du dessous du pointeur
			int pointeur = event.getX()/this.vuePuits.getTaille();
			//si colonne est appelé pour la premiere fois 
			if (this.colonne == -1) {
				this.colonne = pointeur;
			}else if (this.colonne!=pointeur) {
				//faire le deplacement si on a pas d'exception
				try {
					this.puits.getPieceActuelle().deplacerDe(pointeur,0);
					this.colonne = pointeur;
				}catch (Exception e) {
					//le deplacement lève un exception 
					//donc on fait rien 
				}
				
			}
		}
	}
	
	@Override
	public void mouseDragged (MouseEvent event) {}
	
	public void mouseEntered(MouseEvent event) {
		//quelque chose
	}
	
	public void mouseWheelMoved(MouseEvent event) {
		//quelque chose
	}

}
