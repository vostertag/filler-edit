import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

import javax.swing.JOptionPane;
	
public class Mouse implements MouseListener{
	
	public int x;
	public int y;
	public Jeu jeu;
	public Grille grille;
	public FenetreJeu fen;
	public String couleur;
	
	public Mouse(Jeu jeu, Grille grille,FenetreJeu fen){
		this.jeu = jeu;
		this.grille=grille;
		this.fen=fen;
		this.couleur="rouge";
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		this.x=((int)e.getX())/fen.getSizeBloc();
		this.y=((int)e.getY())/fen.getSizeBloc();
		if(e.getY()>=grille.hauteur*fen.getSizeBloc()+10 || e.getY()>=grille.hauteur*fen.getSizeBloc()+10+fen.getSizeBloc())
		{
			if(e.getX() >= 2 && e.getX()<= 2+fen.getSizeBloc()){
				this.couleur="rouge";
			}
			if(e.getX() >= 2+fen.getSizeBloc() && e.getX()<= 2+fen.getSizeBloc()+fen.getSizeBloc()){
				this.couleur="vert";
			}
			if(e.getX() >= 2+2*fen.getSizeBloc() && e.getX()<= 2+2*fen.getSizeBloc()+fen.getSizeBloc()){
				this.couleur="jaune";
			}
			if(e.getX() >= 2+3*fen.getSizeBloc() && e.getX()<= 2+3*fen.getSizeBloc()+fen.getSizeBloc()){
				this.couleur="violet";
			}
			if(e.getX() >= 2+4*fen.getSizeBloc() && e.getX()<= 2+4*fen.getSizeBloc()+fen.getSizeBloc()){
				this.couleur="orange";
			}
			if(e.getX() >= 5*fen.getSizeBloc() && e.getX()<= 2+5*fen.getSizeBloc()+fen.getSizeBloc()){
				this.couleur="bleu";
			}
			if(e.getX() >= 5*fen.getSizeBloc() && e.getX()<= 2+5*fen.getSizeBloc()+fen.getSizeBloc()){
				this.couleur="bleu";
			}
			if(e.getX() >= 6*fen.getSizeBloc() && e.getX()<= 2+6*fen.getSizeBloc()+fen.getSizeBloc()){
				this.couleur="gris";
			}
			for(int k=0; k<=jeu.listeJoueurs.length;k++){
				if(e.getX()>=2+(7+k)*fen.getSizeBloc()+10 && e.getX()<=2+(7+k)*fen.getSizeBloc()+10+fen.getSizeBloc()){
					jeu.numeroJoueur = k-1;
				}
			}
		}
		if ((x>=0 && x<grille.largeur) && (y>=0 && y<grille.hauteur)){
			if(jeu.numeroJoueur==-1){
				grille.plateau[grille.largeur - 1 - y][x].setCouleur(couleur);
				grille.plateau[grille.largeur - 1 - y][x].setJoueur(0);
			}
			else{
				if(this.couleur=="gris"){
					JOptionPane.showMessageDialog(fen,  "Un joueur ne peut être gris.");
				}
				else{
					boolean nope = false;
					for(int k=0 ; k<jeu.listeJoueurs.length ; k++){
						if(k!=jeu.numeroJoueur){
							if(jeu.listeJoueurs[k].couleur == couleur){
								nope=true;
							}
						}
					}
					if(!nope){
						grille.plateau[grille.largeur - 1 - y][x].setCouleur(couleur);
						grille.plateau[grille.largeur - 1 - y][x].setJoueur(0);
						jeu.listeJoueurs[jeu.numeroJoueur].ajouterCase(grille.plateau[grille.largeur - 1 - y][x]);
						jeu.listeJoueurs[jeu.numeroJoueur].couleur=couleur;
						for (int k=0 ; k<jeu.listeJoueurs[jeu.numeroJoueur].listeCases.length ; k++){
							{
								jeu.listeJoueurs[jeu.numeroJoueur].listeCases[k].setCouleur(couleur);
								grille.testCase(couleur, jeu.listeJoueurs[jeu.numeroJoueur].listeCases[k].getI() + 1, jeu.listeJoueurs[jeu.numeroJoueur].listeCases[k].getJ(), jeu.listeJoueurs[jeu.numeroJoueur],jeu);
								grille.testCase(couleur, jeu.listeJoueurs[jeu.numeroJoueur].listeCases[k].getI() - 1, jeu.listeJoueurs[jeu.numeroJoueur].listeCases[k].getJ(), jeu.listeJoueurs[jeu.numeroJoueur],jeu);
								grille.testCase(couleur, jeu.listeJoueurs[jeu.numeroJoueur].listeCases[k].getI(), jeu.listeJoueurs[jeu.numeroJoueur].listeCases[k].getJ() + 1, jeu.listeJoueurs[jeu.numeroJoueur],jeu);
								grille.testCase(couleur, jeu.listeJoueurs[jeu.numeroJoueur].listeCases[k].getI(), jeu.listeJoueurs[jeu.numeroJoueur].listeCases[k].getJ() - 1, jeu.listeJoueurs[jeu.numeroJoueur
								                                                                                                                                                                ],jeu);
							}
						}
					}
					else{
						JOptionPane.showMessageDialog(fen,  "Les joueurs doivent être de couleurs différentes !");
					}
				}
			}
		}
		fen.repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {}
		//Invoked when a mouse button has been pressed on a component.
	@Override
	public void mouseReleased(MouseEvent e) {}
		//Invoked when a mouse button has been released on a component.
	@Override
	public void mouseEntered(MouseEvent e) {}
		//Invoked when the mouse enters a component.
	@Override
	public void mouseExited(MouseEvent e) {}
		//Invoked when the mouse exits a component.
	
	

}
