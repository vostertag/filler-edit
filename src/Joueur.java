import javax.swing.JOptionPane;
public class Joueur extends Entity{
	
	public Joueur(Jeu jeu, String pseudo)
	//Fonction permettant de créer un nouveau joueur
	{
		super(jeu, pseudo);
	}
	
	public Joueur(String[] infos, String[] cases, Grille grille){
		super(infos, cases, grille);
	}

	@Override
	public void joue(Grille grille, Jeu jeu, int x, int y, FenetreJeu fen)
	//Fonction permettant à un joueur de jouer une manche
	{
		
	}

}