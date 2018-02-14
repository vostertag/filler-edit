import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

public class Fenetre extends JFrame{
	
	private String title;
	private int width=500, height=500;
	private Grille grille;
	private FenetreJeu fen;
	private Jeu jeu;
	private int sizeBloc;
	
	public Fenetre(){
		super();
		FenetreJeu fenetre = new FenetreJeu();
	}
	
	public Fenetre(String title, int width, int height, int sizeBloc, FenetreJeu fen){
		this.title=title;
		this.width=width;
		this.height=height;
		this.sizeBloc=sizeBloc;
		Jeu jeu = new Jeu();
		Grille grille = new Grille(this.width,this.height);
		this.grille=grille;
		this.jeu=jeu;
		this.fen=fen;
		fen.setGrille(this.grille);
		fen.setSizeBloc(this.sizeBloc);
		fen.setJeu(this.jeu);
		setTitle(title);
		if(width*sizeBloc+7<=sizeBloc*12){
			setSize(sizeBloc*12,height*sizeBloc+30+50);
		}
		else{
			setSize(width*sizeBloc+7,height*sizeBloc+30+50);
		}
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(fen);
		setVisible(true);
		edit();	
	}
	
	public void edit(){
		int nbJoueur = jeu.addPlayer(fen);
		fen.repaint();
		Mouse clic = new Mouse(jeu,grille,fen);
		fen.addMouseListener(clic);
		this.addWindowListener(new WindowAdapter(){
		    public void windowClosing(WindowEvent ev)
		   {
				int exit = JOptionPane.showConfirmDialog(fen, "Souhaitez-vous enregistrer cette partie ?");
				if(exit==0){
					jeu.setFogOfWar(JOptionPane.showConfirmDialog(fen, "Souhaitez-vous du brouillard de guerre?"));
					if (jeu.getFogOfWar()== 0){
						jeu.setViewDistance(Integer.parseInt(JOptionPane.showInputDialog(fen, "Combien de cases de distance ?")));
					}	
					boolean onPeut = true;
					boolean joueur = false;
					for(int i=0 ; i<grille.hauteur ; i++){
						for(int j=0 ; j<grille.largeur ; j++){
							if(grille.plateau[i][j].getCouleur() == "aucune"){
								onPeut=false;
							}
						}
					}
					for(int k=0 ; k<jeu.listeJoueurs.length ; k++){
						if(jeu.listeJoueurs[k].listeCases.length==0){
							onPeut=false;
						}
					}
					if(onPeut){
						try {
							jeu.numeroJoueur=0;						
							Date date = new Date();
							File fichier =  new File("C:/Users/victo/Documents/Filler/EDITfiller" + date.toString().replaceAll(" ", "").replaceAll(":", "") + ".txt");
							fichier.createNewFile();
							FileWriter ffw=new FileWriter(fichier);
							String laFen = toString2();
							ffw.write(laFen);  
							ffw.close(); // fermer le fichier à la fin des traitements
							
						}
						catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.exit(0);
				}
				else{
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
					JOptionPane.showMessageDialog(fen,  "Veuillez remplir la grille et/ou donnez au moins une case à chaque joeur !");
					}
				}
				else if (exit==1){
					System.exit(0);
				}
				else{
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}
		   }});
	}
	
	public Fenetre(String title, int width, int height, int sizeBloc, String[] grille, String[] jeu){
		this.title=title;
		this.sizeBloc=sizeBloc;
		this.width=width;
		this.height=height;
		this.grille = new Grille(grille);
		this.jeu = new Jeu(jeu, this.grille);
		this.fen=fen;
		setTitle(title);
		setSize(width*sizeBloc+7,height*sizeBloc+30+50);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(fen);
		setVisible(true);
		play(true);
	}
	
	public String toString2() {
		return "Fenetre [title=" + title + ":width=" + width + ": height=" + height + ": sizeBloc=" + sizeBloc + ": grille=" + grille.toString() + ": fen="
				+ fen.toString() + ": jeu=" + jeu.toString() + ":]";
	}



	public void couleurDepart(Grille grille, Jeu jeu, int i, int j, int nbJoueursLa){
		boolean aPersonne = false;
		for(int k=0 ; k<nbJoueursLa ; k++){
			if(grille.plateau[i][j].getCouleur().equals(jeu.listeJoueurs[k].couleur)){
				aPersonne = true;
			}
		}
		while(aPersonne){
			int alea = (int) (Math.random() * 6);
			String[] listeCouleurs = {"rouge","orange","vert","bleu","violet","jaune"};
			grille.plateau[i][j].setCouleur(listeCouleurs[alea]);
			aPersonne=false;
			for(int k=0 ; k<nbJoueursLa ; k++){
				if(grille.plateau[i][j].getCouleur().equals(jeu.listeJoueurs[k].couleur)){
					aPersonne = true;
				}
			}
		}
	}
	
	public void play(boolean save){
		JOptionPane.showMessageDialog(fen, "Bienvenue dans l'éditeur. Nous allons commencer par créer la grille.");
//		if(!save){
//			int nbJoueur = jeu.addPlayer(fen);
//			for(int k=0 ; k<nbJoueur ; k++){
//				if(k<2){
//					grille.plateau[k*(width-1)][k*(height-1)].changeJoueur(jeu.listeJoueurs[k]);
//					couleurDepart(grille, jeu,k*(width-1),k*(height-1),k);
//					grille.plateau[k*(width-1)][k*(height-1)].changeJoueur(jeu.listeJoueurs[k]);
//					jeu.listeJoueurs[k].ajouterCase(grille.plateau[k*(width-1)][k*(height-1)]);
//					jeu.listeJoueurs[k].couleur = grille.plateau[k*(width-1)][k*(height-1)].getCouleur();
//				}
//				else if(k==2){
//					grille.plateau[0][height-1].changeJoueur(jeu.listeJoueurs[k]);
//					couleurDepart(grille, jeu, 0, height-1,k);
//					grille.plateau[0][(height-1)].changeJoueur(jeu.listeJoueurs[k]);
//					jeu.listeJoueurs[k].ajouterCase(grille.plateau[0][(height-1)]);
//					jeu.listeJoueurs[k].couleur = grille.plateau[0][(height-1)].getCouleur();
//				}
//				else{
//					grille.plateau[width-1][0].changeJoueur(jeu.listeJoueurs[k]);
//					couleurDepart(grille, jeu,width-1,0,k);
//					grille.plateau[width-1][0].changeJoueur(jeu.listeJoueurs[k]);
//					jeu.listeJoueurs[k].ajouterCase(grille.plateau[width-1][0]);
//					jeu.listeJoueurs[k].couleur = grille.plateau[width-1][0].getCouleur();
//				}
//			}
//		}
//		fen.repaint();
//		Mouse clic = new Mouse(jeu,grille,fen);
//		fen.addMouseListener(clic);
//		this.addWindowListener(new WindowAdapter(){
//		    public void windowClosing(WindowEvent ev)
//		   {
//				int exit = JOptionPane.showConfirmDialog(fen, "Souhaitez-vous enregistrer cette partie ?");
//				if(exit==0){
//					try {
//						Date date = new Date();
//						File fichier =  new File("C:/Users/victo/Documents/Filler/filler" + date.toString().replaceAll(" ", "").replaceAll(":", "") + ".txt");
//						fichier.createNewFile();
//						FileWriter ffw=new FileWriter(fichier);
//						String laFen = toString2();
//						ffw.write(laFen);  
//						ffw.close(); // fermer le fichier à la fin des traitements
//					} catch (FileNotFoundException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					System.exit(0);
//				}
//				else if (exit==1){
//					System.exit(0);
//				}
//				else{
//					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//				}
//		   }});
	}
}
