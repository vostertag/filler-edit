import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.princeton.cs.introcs.StdDraw;

public class FenetreJeu extends JPanel{
	
	private Grille grille;
	private int sizeBloc;
	private Jeu jeu;
	
	public FenetreJeu(Grille grille, int size,Jeu jeu){
		this.grille = grille;
		this.sizeBloc = size;
		this.jeu = jeu;
	}
	
	
	
	public Grille getGrille() {
		return grille;
	}



	public void setGrille(Grille grille) {
		this.grille = grille;
	}



	public Jeu getJeu() {
		return jeu;
	}



	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}



	public void setSizeBloc(int sizeBloc) {
		this.sizeBloc = sizeBloc;
	}



	public FenetreJeu(){
		JOptionPane.showMessageDialog(this, "Bienvenue dans l'éditeur ! Commençons par créer notre grille.");
		int hauteur = 0;
		int largeur = 0;
		int sizeBloc = 0;
		try{
			hauteur = largeur = Integer.parseInt(JOptionPane.showInputDialog(this, "Quelle largeur et hauteur de grille ?"));
			this.sizeBloc = Integer.parseInt(JOptionPane.showInputDialog(this, "Quelle taille pour les cases ?"));
			new Fenetre("Filler - HADRATOR Team", hauteur, largeur, this.sizeBloc, this);
		}
		catch (NumberFormatException e) {
			  JOptionPane.showMessageDialog(this,  "Veuillez saisir un nombre !");
			}
	}
	
	@Override
	public String toString() {
		return "FenetreJeu [sizeBloc=" + sizeBloc + "]";
	}



	public int getSizeBloc(){
		return sizeBloc;
	}
	
	public void paintComponent(Graphics g){
		for(int k=0 ; k<=1 ; k++){
		for (int i = 0; i < grille.hauteur; i++){
			for (int j = 0; j < grille.largeur; j++){
				String couleur = grille.plateau[i][j].getCouleur();
				if(couleur.equals("aucune")){
					g.setColor(Color.black);
					g.drawRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
				}
				if(couleur.equals("rouge"))
				{
					g.setColor(Color.red);
					if(k==0){
					if(grille.plateau[i][j].getJoueur() != 0){	
						g.fillRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
					}
					}
					if(k==1){
					if(grille.plateau[i][j].getJoueur() == 0){
						g.fillRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
						g.setColor(Color.black);
						g.drawRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
					}
					}
					
				}
				if(couleur.equals("orange"))
				{
					g.setColor(Color.orange);
					if(k==0){
						if(grille.plateau[i][j].getJoueur() != 0){	
							g.fillRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
						}
						}
						if(k==1){
						if(grille.plateau[i][j].getJoueur() == 0){
							g.fillRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
							g.setColor(Color.black);
							g.drawRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
						}
						}
				}
				if(couleur.equals("bleu"))
				{
					g.setColor(Color.blue);
					if(k==0){
						if(grille.plateau[i][j].getJoueur() != 0){	
							g.fillRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
						}
						}
						if(k==1){
						if(grille.plateau[i][j].getJoueur() == 0){
							g.fillRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
							g.setColor(Color.black);
							g.drawRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
						}
						}
				}
				if(couleur.equals("vert"))
				{
					g.setColor(Color.green);
					if(k==0){
						if(grille.plateau[i][j].getJoueur() != 0){	
							g.fillRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
						}
						}
						if(k==1){
						if(grille.plateau[i][j].getJoueur() == 0){
							g.fillRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
							g.setColor(Color.black);
							g.drawRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
						}
						}
				}
				if(couleur.equals("violet"))
				{
					g.setColor(Color.magenta);
					if(k==0){
						if(grille.plateau[i][j].getJoueur() != 0){	
							g.fillRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
						}
						}
						if(k==1){
						if(grille.plateau[i][j].getJoueur() == 0){
							g.fillRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
							g.setColor(Color.black);
							g.drawRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
						}
						}
				}
				if(couleur.equals("jaune"))
				{
					g.setColor(Color.yellow);
					if(k==0){
						if(grille.plateau[i][j].getJoueur() != 0){	
							g.fillRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
						}
						}
						if(k==1){
						if(grille.plateau[i][j].getJoueur() == 0){
							g.fillRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
							g.setColor(Color.black);
							g.drawRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
						}
						}
				}
				if(couleur.equals("gris"))
				{
					g.setColor(Color.gray);
					if(k==0){
						if(grille.plateau[i][j].getJoueur() != 0){	
							g.fillRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
						}
						}
						if(k==1){
						if(grille.plateau[i][j].getJoueur() == 0){
							g.fillRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
							g.setColor(Color.black);
							g.drawRect(j*sizeBloc, (grille.hauteur-1-i)*sizeBloc, sizeBloc, sizeBloc);
						}
						}
				}
			}
			}
		}
		g.setColor(Color.red);
		g.fillRect(2, grille.hauteur*sizeBloc+10, sizeBloc, sizeBloc);
		g.setColor(Color.black);
		g.drawRect(2, grille.hauteur*sizeBloc+10, sizeBloc, sizeBloc);
		g.setColor(Color.green);
		g.fillRect(2+sizeBloc, grille.hauteur*sizeBloc+10, sizeBloc, sizeBloc);
		g.setColor(Color.black);
		g.drawRect(2+sizeBloc, grille.hauteur*sizeBloc+10, sizeBloc, sizeBloc);
		g.setColor(Color.yellow);
		g.fillRect(2+2*sizeBloc, grille.hauteur*sizeBloc+10, sizeBloc, sizeBloc);
		g.setColor(Color.black);
		g.drawRect(2+2*sizeBloc, grille.hauteur*sizeBloc+10, sizeBloc, sizeBloc);
		g.setColor(Color.magenta);
		g.fillRect(2+3*sizeBloc, grille.hauteur*sizeBloc+10, sizeBloc, sizeBloc);
		g.setColor(Color.black);
		g.drawRect(2+3*sizeBloc, grille.hauteur*sizeBloc+10, sizeBloc, sizeBloc);
		g.setColor(Color.orange);
		g.fillRect(2+4*sizeBloc, grille.hauteur*sizeBloc+10, sizeBloc, sizeBloc);
		g.setColor(Color.black);
		g.drawRect(2+4*sizeBloc, grille.hauteur*sizeBloc+10, sizeBloc, sizeBloc);
		g.setColor(Color.blue);
		g.fillRect(2+5*sizeBloc, grille.hauteur*sizeBloc+10, sizeBloc, sizeBloc);
		g.setColor(Color.black);
		g.drawRect(2+5*sizeBloc, grille.hauteur*sizeBloc+10, sizeBloc, sizeBloc);
		g.setColor(Color.gray);
		g.fillRect(2+6*sizeBloc, grille.hauteur*sizeBloc+10, sizeBloc, sizeBloc);
		g.setColor(Color.black);
		g.drawRect(2+6*sizeBloc, grille.hauteur*sizeBloc+10, sizeBloc, sizeBloc);
		for(int k=0; k<=jeu.listeJoueurs.length;k++){
			g.setColor(Color.WHITE);
			g.fillRect(2+(7+k)*sizeBloc+10, grille.hauteur*sizeBloc+10, sizeBloc, sizeBloc);
			if(jeu.numeroJoueur == k-1){
				g.setColor(new Color(0,0,250,80));
				g.fillRect(2+(7+k)*sizeBloc+10, grille.hauteur*sizeBloc+10, sizeBloc, sizeBloc);
			}
			g.setColor(Color.black);
			g.drawRect(2+(7+k)*sizeBloc+10, grille.hauteur*sizeBloc+10, sizeBloc, sizeBloc);
			g.drawString(Integer.toString(k), 2+(7+k)*sizeBloc+10+sizeBloc/2-2, grille.hauteur*sizeBloc+10+sizeBloc/2+5);
		}
	}
	
	public void paintContour(Graphics g, Color couleur,int posX, int posY, Grille grille, int sizeBloc){
		g.setColor(couleur);
		boolean up = false;
		boolean down = false;
		boolean right = false;
		boolean left = false;
		if(posX-1<0){
			left=true;
		}
		else if(grille.plateau[posX-1][posY].getJoueur() == 0){
			left=true;
		}
		if(posX+1>grille.largeur-1){
			right=true;
		}
		else if(grille.plateau[posX+1][posY].getJoueur() == 0){
			right=true;
		}
		if(posY-1<0){
			up=true;
		}
		else if(grille.plateau[posX][posY-1].getJoueur() == 0){
			up=true;
		}
		if(posY+1>grille.hauteur-1){
			down=true;
		}
		else if(grille.plateau[posX][posY+1].getJoueur() == 0){
			down=true;
		}
		if(up){
			g.drawLine(posX*sizeBloc, (grille.hauteur-1-posY)*sizeBloc,posX*sizeBloc+sizeBloc,(grille.hauteur-1-posY)*sizeBloc);
		}
		if(down){
			g.drawLine(posX*sizeBloc, (grille.hauteur-1-posY)*sizeBloc+sizeBloc,posX*sizeBloc+sizeBloc,(grille.hauteur-1-posY)*sizeBloc+sizeBloc);
		}
		if(left){
			g.drawLine(posX*sizeBloc, (grille.hauteur-1-posY)*sizeBloc,posX*sizeBloc,(grille.hauteur-1-posY)*sizeBloc+sizeBloc+1);
		}
		if(right){
			g.drawLine(posX*sizeBloc+sizeBloc, (grille.hauteur-1-posY)*sizeBloc,posX*sizeBloc+sizeBloc,(grille.hauteur-1-posY)*sizeBloc+sizeBloc);
		}
	}
}
