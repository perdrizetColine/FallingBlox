package fr.eseo.e3.poo.projet.blox.modele;
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import java.util.Random;
public class UsineDePiece {
	public static final int ALEATOIRE_COMPLET =0;
	public static final int ALEATOIRE_PIECE = 2;
	public static final int CYCLIC = 1;
	public static int modeDeFonctionnement = ALEATOIRE_PIECE;
	
	private static int pp = 0;
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
	public static Piece genererPiece() {
		Random o = new Random();
		int b = o.nextInt(2);
		if(modeDeFonctionnement == ALEATOIRE_COMPLET) {
			switch(b) {
			case 0:
				return new OPiece(new Coordonnees(2,3), Couleur.ROUGE);
			default:
				return new IPiece(new Coordonnees(2,3), Couleur.ORANGE);
			}
		}else if(modeDeFonctionnement == CYCLIC){
			if(pp==0) {
				pp+=1;
				return new OPiece(new Coordonnees(2,3), Couleur.ROUGE);
			}else {
				pp-=1;
				return new IPiece(new Coordonnees(2,3), Couleur.ORANGE);
			}
		}else {
			switch(b) {
			case 0:
				return new OPiece(new Coordonnees(2,3), Couleur.ROUGE);
			default:
				return new IPiece(new Coordonnees(2,3), Couleur.ORANGE);
			}
		}
	}
}