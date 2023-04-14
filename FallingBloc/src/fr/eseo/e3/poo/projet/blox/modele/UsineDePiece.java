package fr.eseo.e3.poo.projet.blox.modele;
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import java.util.Random;
public class UsineDePiece {
	public static final int ALEATOIRE_COMPLET =0;
	public static final int ALEATOIRE_PIECE = 2;
	public static final int CYCLIC = 1;
	public static int modeDeFonctionnement;
	
	
	private UsineDePiece() {
	}
	
	public static void setMode(int mode) {
		switch(mode) {
		case 0:
			modeDeFonctionnement = ALEATOIRE_COMPLET;
			break;
		case 1:
			modeDeFonctionnement = CYCLIC;
			break;
		default :
			modeDeFonctionnement = ALEATOIRE_PIECE;
			break;
		}
	}
	public static int cycle = 0;

	public static Piece genererPiece() {
		Coordonnees coordo = new Coordonnees (2,3);
		Random random = new Random();
		Piece piece = null;
		int aleacomplet = random.nextInt(10);
		if (modeDeFonctionnement == CYCLIC) {
			if (cycle == 0) {
				cycle = 1;
				piece= new OPiece(coordo, Couleur.ROUGE);
			}else if (cycle == 1) {
				cycle = 0;
				piece = new IPiece(coordo, Couleur.ORANGE);
			}
		}else if (modeDeFonctionnement == ALEATOIRE_COMPLET) {
			if (aleacomplet%2 == 0) {
				piece = new OPiece(coordo, Couleur.ROUGE);
			}else {
				piece = new IPiece(coordo, Couleur.ORANGE);
			}
		}else if (modeDeFonctionnement == ALEATOIRE_PIECE) {
			if (aleacomplet%2 == 0) {
				piece = new OPiece(coordo, Couleur.ROUGE);
			}else {
				piece = new IPiece(coordo, Couleur.ORANGE);
			}
		}
		return piece;
	}
	
//	public static Piece genererPiece() {
//		Random o = new Random();
//		int b = o.nextInt(2);
//		if(modeDeFonctionnement == ALEATOIRE_COMPLET) {
//			switch(b) {
//			case 0:
//				return new OPiece(new Coordonnees(2,3), Couleur.ROUGE);
//			default:
//				return new IPiece(new Coordonnees(2,3), Couleur.ORANGE);
//			}
//		}else if(modeDeFonctionnement == CYCLIC){
//			if(pp==0) {
//				pp+=1;
//				return new OPiece(new Coordonnees(2,3), Couleur.ROUGE);
//			}else {
//				pp-=1;
//				return new IPiece(new Coordonnees(2,3), Couleur.ORANGE);
//			}
//		}else {
//			switch(b) {
//			case 0:
//				return new OPiece(new Coordonnees(2,3), Couleur.ROUGE);
//			default:
//				return new IPiece(new Coordonnees(2,3), Couleur.ORANGE);
//			}
//		}
//	}
}