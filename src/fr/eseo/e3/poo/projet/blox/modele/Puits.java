package fr.eseo.e3.poo.projet.blox.modele;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;


public class Puits {
	//attributs
	private int largeur;
	private int profondeur;
	private Piece pieceActuelle;
	private Piece pieceSuivante;

	//Constantes
	public static final int LARGEUR_PAR_DEFAUT = 10;
	public static final int PROFONDEUR_PAR_DEFAUT = 20;
	
	//Constructeur 
	public Puits() {
		this.profondeur = PROFONDEUR_PAR_DEFAUT;
		this.largeur = LARGEUR_PAR_DEFAUT;
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
	}
	
	//accesseurs
	public Piece getPieceActuelle() {
		return this.pieceActuelle;
	}
	
	public Piece getPieceSuivante() {
		return this.pieceSuivante;
	}
	
	public int getProfondeur() {
		return this.profondeur;
	}
	
	public int getLargeur() {
		return this.largeur;
	}
	
	public void setProfondeur(int longu) {
		if(longu<15) {
			throw new IllegalArgumentException("trop petit");
		}else if(longu>25) {
			throw new IllegalArgumentException("trop grand");
		}else{
			this.profondeur = longu;
		}
	}
	
	public void setLargeur(int larg) {
		if(larg<5) {
			throw new IllegalArgumentException("trop petit");
		}else if(larg>15) {
			throw new IllegalArgumentException("trop grand");
		}else{
			this.largeur = larg;
		}
	}
	
	//mutateurs
	public void setPieceSuivante(Piece pieceSuivante) {
		if(getPieceSuivante()!=null) {
			this.pieceActuelle = this.pieceSuivante;
			this.pieceActuelle.setPosition(this.profondeur/2, -4);	
		}
		this.pieceSuivante = pieceSuivante;
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
		if(getPieceActuelle()!=null) {
			pieceSui += getPieceSuivante().toString();
		}else {
			pieceSui += "<aucune>\n";
		}
		return "Puits : Dimension "+getLargeur()+" x "+getProfondeur()+
				"\nPiece Actuelle : "+ pieceAct +
				"\nPiece Suivante : "+ pieceSui;
	}
}
