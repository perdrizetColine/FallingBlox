package fr.eseo.e3.poo.projet.blox.modele;
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import java.util.Random;
//import java.util.random.*;
public class UsineDePiece {
	//attributs
	public static final int ALEATOIRE_COMPLET =0;
	public static final int ALEATOIRE_PIECE = 2;
	public static final int CYCLIC = 1;
	public static int modeDeFonctionnement = ALEATOIRE_PIECE;
	
	//Constructeur
	private UsineDePiece() {
	}
	
	//Methodes
	
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
	static int pp = 0;
	public static Piece genererPiece() {
		//Coordonnees coordonnees = new Coordonnees(2,3);
		Random randomObj2 = new Random();
		int b =randomObj2.nextInt(1);
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
		/*
																																		• Complètement aléatoire
																																		Choisir un type de pièce aléatoirement, en utilisant une couleur aléatoire
		
																																		• Type aléatoire
																																		Choisir un type de pièce aléatoirement, en utilisant la même couleur (comme défini dans la figure 1) pour la
																																		même type de pièce
		
																																		• Cyclique
																																		Choisir dans l’ordre les Pièces (OPiece, puis IPiece, …, OPiece, …) comme décrit dans l’étiquette de la figure
																																		1 en respectant les couleurs utilisées dans la figure 1
		*/
//		switch(n) {
//		case 0:
//			OPiece OP = new OPiece(coordonnees,Couleur.ROUGE);
//			return OP;
//		default :
//			IPiece IP = new IPiece(coordonnees,Couleur.VERT);
//			return IP;
//		}
		
	}

}
