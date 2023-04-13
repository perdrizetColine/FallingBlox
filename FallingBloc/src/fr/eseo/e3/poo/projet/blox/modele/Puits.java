package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Puits {

	public static final int LARGEUR_PAR_DEFAUT = 10;
	public static final int PROFONDEUR_PAR_DEFAUT = 15;
	public static final String MODIFICATION_PIECE_ACTUELLE  = "modification piece actuelle";
	public static final String MODIFICATION_PIECE_SUIVANTE = "modification piece suivante";
	private Piece pieceActuelle;
	private Piece pieceSuivante;
	private PropertyChangeSupport pcs; 
	
	public int largeur;
	public int profondeur;
	
	public Puits() {
		this.largeur = LARGEUR_PAR_DEFAUT;
		this.profondeur = PROFONDEUR_PAR_DEFAUT;
		this.pcs = new PropertyChangeSupport(this);
	}
	
	public Puits(int largeur, int profondeur) {
		if(profondeur<15) {
			throw new IllegalArgumentException("trop petite profondeur");
		}else if(profondeur>25) {
			throw new IllegalArgumentException("trop grande profondeur");
		}else if(largeur<5) {
			throw new IllegalArgumentException("trop petite largeur");
		}else if(largeur>15) {
			throw new IllegalArgumentException("trop grande largeur");
		}else{
			this.largeur = largeur;
			this.profondeur = profondeur;
		}
	this.pcs = new PropertyChangeSupport(this);
	}
		
	public Piece getPieceActuelle() {
		return pieceActuelle;
	}
	
	public Piece getPieceSuivante() {
		return pieceSuivante;
	}
	
	public int getProfondeur() {
		return profondeur;
	}
	
	public int getLargeur() {
		return largeur;
	}

	public void setPieceActuelle(Piece pieceActuelle) {
		this.pieceActuelle = pieceActuelle;
	}

	public void setPieceSuivante(Piece pieceSuivante) {
		if(getPieceSuivante()==null) {
			this.pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, null, pieceSuivante);
		}else{
			this.pieceActuelle = getPieceSuivante();
			this.pieceActuelle.setPosition(getLargeur()/2, -4);
			this.pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, getPieceSuivante(), pieceSuivante);
		}
		this.pieceSuivante = pieceSuivante;
		
	}

	public void setProfondeur(int profondeur) {
		if (profondeur<15) {
			throw new IllegalArgumentException("profondeur trop petite");
		}else if (profondeur>25) {
			throw new IllegalArgumentException("profondeur trop grande");
		}else {
			this.profondeur = profondeur;
		}
	}

	public void setLargeur(int largeur) {
		if (largeur<5) {
			throw new IllegalArgumentException("largeur trop petite");
		}else if (largeur>15) {
			throw new IllegalArgumentException("largeur trop grande");
		}else {
			this.largeur = largeur;
		}
	}

	@Override
	public String toString() {
		String pieceAct = "";
		if(getPieceActuelle()!=null) { 
			pieceAct += getPieceActuelle().toString();
		}else {
			pieceAct += "<aucune>";
		}
		String pieceSui = "";
		if(getPieceSuivante()!=null) {
			pieceSui += getPieceSuivante().toString();
		}else {
			pieceSui += "<aucune>\n";
		}
		return "Puits : Dimension "+getLargeur()+" x "+getProfondeur()
		+"\nPiece Actuelle : "+ pieceAct.replaceAll("[\n\r]$", "") 
		+"\nPiece Suivante : "+ pieceSui;
	}
	
	public void addPropertyChangeListener (PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);
	}
	
	

	

	
	
}

//package fr.eseo.e3.poo.projet.blox.modele;
//import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
//public class Puits {
//	private int largeur;
//	private int profondeur;
//	private Piece pieceActuelle;
//	private Piece pieceSuivante;
//	public static final int LARGEUR_PAR_DEFAUT = 10;
//	public static final int PROFONDEUR_PAR_DEFAUT = 20;
//	public static final String MODIFICATION_PIECE_ACTUELLE = "evenement";
//	public Puits() {
//		this.profondeur = PROFONDEUR_PAR_DEFAUT;
//		this.largeur = LARGEUR_PAR_DEFAUT;
//	}
//	public Puits(int largeur, int profondeur) {
//		if(profondeur<15) {
//			throw new IllegalArgumentException("trop petite profondeur");
//		}else if(profondeur>25) {
//			throw new IllegalArgumentException("trop grande profondeur");
//		}else if(largeur<5) {
//			throw new IllegalArgumentException("trop petite largeur");
//		}else if(largeur>15) {
//			throw new IllegalArgumentException("trop grande largeur");
//		}else{
//			this.largeur = largeur;
//			this.profondeur = profondeur;
//		}
//	}
//	public Piece getPieceActuelle() {
//		return this.pieceActuelle;
//	}	
//	public Piece getPieceSuivante() {
//		return this.pieceSuivante;
//	}	
//	public int getProfondeur() {
//		return this.profondeur;
//	}	
//	public int getLargeur() {
//		return this.largeur;
//	}
//	public void setProfondeur(int longu) {
//		if(longu<15) {
//			throw new IllegalArgumentException("trop petite profondeur");
//		}else if(longu>25) {
//			throw new IllegalArgumentException("trop grande profondeur");
//		}else{
//			this.profondeur = longu;
//		}
//	}
//	public void setLargeur(int larg) {
//		if(larg<5) {
//			throw new IllegalArgumentException("trop petite largeur");
//		}else if(larg>15) {
//			throw new IllegalArgumentException("trop grande largeur");
//		}else{
//			this.largeur = larg;
//		}
//	}
//	public void setPieceSuivante(Piece pieceSuivante) {
//		if(getPieceSuivante()!=null) {
//			this.pieceActuelle = getPieceSuivante();
//			this.pieceActuelle.setPosition(getProfondeur()/2, -4);	
//		}
//		this.pieceSuivante = pieceSuivante;
//	}
//	@Override
//	public String toString() {
//		String pieceAct = "";
//		if(getPieceActuelle()!=null) { 
//			pieceAct += getPieceActuelle().toString();
//		}else {
//			pieceAct += "<aucune>";
//		}
//		String pieceSui = "";
//		if(getPieceSuivante()!=null) {
//			pieceSui += getPieceSuivante().toString();
//		}else {
//			pieceSui += "<aucune>\n";
//		}
//		return "Puits : Dimension "+getLargeur()+" x "+getProfondeur()
//		+"\nPiece Actuelle : "+ pieceAct.replaceAll("[\n\r]$", "") 
//		+"\nPiece Suivante : "+ pieceSui;
//	}
//}
