
public class IA extends Entity{
	
	public IA(Jeu jeu, String pseudo){
		super(jeu, pseudo);
	}
	
	public IA(String[] infos, String[] cases, Grille grille){
		super(infos, cases, grille);
	}
	
	
	public int NombreCasesBordure(IA joueur, Grille grille){
		Case[] CasesBordure = new Case[0];
		int nombreCasesBordures =0;
		for(int i=0 ; i<grille.hauteur ; i++){
			for (int j=0 ; j<grille.largeur; j++){
				if(i!=0 && j!=0 && i!=grille.hauteur-1 && j!=grille.largeur-1){				
					int n=0;
					if(grille.plateau[i+1][j].getJoueur()==joueur.numero){
						n++;
					}
					if(grille.plateau[i-1][j].getJoueur()==joueur.numero){
						n++;
					}
					if(grille.plateau[i][j+1].getJoueur()==joueur.numero){
						n++;				
					}
					if(grille.plateau[i][j-1].getJoueur()==joueur.numero){
						n++;
					}
					if(n==1||n==2||n==3){
						nombreCasesBordures++;
					}
				}	

				else if (i==0 && j!=0 && j!=grille.largeur-1){
					int n=0;
					if(grille.plateau[i+1][j].getJoueur()==joueur.numero){
						n++;
					}
					if(grille.plateau[i][j+1].getJoueur()==joueur.numero){
						n++;				
					}
					if(grille.plateau[i][j-1].getJoueur()==joueur.numero){
						n++;				
					}
					if(n==1||n==2){
						nombreCasesBordures++;}
				}

				else if (i==grille.hauteur-1 && j!=0 && j!=grille.largeur-1){
					int n=0;
					if(grille.plateau[i-1][j].getJoueur()==joueur.numero){
						n++;
					}
					if(grille.plateau[i][j+1].getJoueur()==joueur.numero){
						n++;				
					}
					if(grille.plateau[i][j-1].getJoueur()==joueur.numero){
						n++;				
					}
					if(n==1||n==2){
						nombreCasesBordures++;}
				}

				else if (j==0 && i!=0 && i!=grille.hauteur-1){
					int n=0;
					if(grille.plateau[i+1][j].getJoueur()==joueur.numero){
						n++;
					}
					if(grille.plateau[i-1][j].getJoueur()==joueur.numero){
						n++;				
					}
					if(grille.plateau[i][j+1].getJoueur()==joueur.numero){
						n++;				
					}
					if(n==1||n==2){
						nombreCasesBordures++;}
				}

				else if (j==grille.largeur-1 && i!=0 && i!=grille.hauteur-1){
					int n=0;
					if(grille.plateau[i+1][j].getJoueur()==joueur.numero){
						n++;
					}
					if(grille.plateau[i-1][j].getJoueur()==joueur.numero){
						n++;				
					}
					if(grille.plateau[i][j-1].getJoueur()==joueur.numero){
						n++;				
					}
					if(n==1||n==2){
						nombreCasesBordures++;}
				}
				
				else if (i==grille.hauteur-1 && j==0){
					int n=0;
					if(grille.plateau[i-1][j].getJoueur()==joueur.numero){
						n++;				
					}
					if(grille.plateau[i][j+1].getJoueur()==joueur.numero){
						n++;				
					}
					if(n==1){
						nombreCasesBordures++;}
				}

				else if (i==0 && j==grille.largeur-1){
					int n=0;
					if(grille.plateau[i+1][j].getJoueur()==joueur.numero){
						n++;				
					}
					if(grille.plateau[i][j-1].getJoueur()==joueur.numero){
						n++;				
					}
					if(n==1){
						nombreCasesBordures++;}
				}

			}
		}
		return nombreCasesBordures;
	}
	
	
	public void joue(Grille grille, Jeu jeu, int x, int y, FenetreJeu fen){
		
		boolean joue = true;
		while (joue){Case[] copyListeCases = new Case[this.listeCases.length];
		for(int w=0; w < this.listeCases.length; w++){
			copyListeCases[w]=this.listeCases[w];
		}

		int casesAccessibles = this.NombreCasesBordure(this, grille);

		Case[][] copyPlateau = new Case[grille.hauteur][grille.largeur];
		for (int i = 0; i < grille.largeur; i++){
			for (int j = 0; j < grille.hauteur; j++){
				copyPlateau[i][j] = new Case(i,j);
			}
		}	

		for(int L=0 ; L<grille.hauteur ; L++){
			for (int H=0; H<grille.largeur;H++){
				copyPlateau[L][H].setCouleur(grille.plateau[L][H].getCouleur());
				copyPlateau[L][H].setJoueur(grille.plateau[L][H].getJoueur());
			}
		}
		
		int copyScore = this.score;
		

		int[] gains= {0,0,0,0,0};
		String[] listeCouleurs = {"rouge","orange","vert","bleu","violet","jaune"};	
		String[] listeCouleursPossibles = new String [5];						

		int j=0;												
		for(int l=0 ; l<6 ; l++){
			for(int z=0 ; z<jeu.listeJoueurs.length ;z++)
			{
				if(jeu.listeJoueurs[z].numero != this.numero)
				{	
					if(!listeCouleurs[l].equals(jeu.listeJoueurs[z].couleur))
					{
						if(j<5){
							listeCouleursPossibles[j]=(listeCouleurs[l]);
							j++;
						}
					}
				}
			}
		}

		if (this.score < grille.hauteur*grille.largeur/3){
			for(int l=0 ; l<5 ; l++){
				String choixProvisoire = listeCouleursPossibles[l];
				System.out.println(choixProvisoire);
				System.out.println("\n");
				grille.changeCase(jeu.listeJoueurs[this.numero-1], choixProvisoire, jeu);	
				int nouveauCasesAccessibles = this.NombreCasesBordure(this, grille);
				int gain = nouveauCasesAccessibles - casesAccessibles;
				gains[l]=gain;	
				System.out.println("\n");
	
				for(int L=0 ; L<grille.hauteur ; L++){
					for (int H=0; H<grille.largeur;H++){
						grille.plateau[L][H].setCouleur(copyPlateau[L][H].getCouleur());
						grille.plateau[L][H].setJoueur(copyPlateau[L][H].getJoueur());
					}
				}
	
				jeu.listeJoueurs[this.numero-1].listeCases=copyListeCases;
				jeu.listeJoueurs[this.numero-1].score = copyScore;
			}
	
			System.out.println("listeCouleursPossibles");
			System.out.println(listeCouleursPossibles[0]);
			System.out.println(listeCouleursPossibles[1]);
			System.out.println(listeCouleursPossibles[2]);
			System.out.println(listeCouleursPossibles[3]);
			System.out.println(listeCouleursPossibles[4]);
			System.out.println("\n");						
			System.out.println("gainsPossibles");
			System.out.println(gains[0]);
			System.out.println(gains[1]);
			System.out.println(gains[2]);
			System.out.println(gains[3]);
			System.out.println(gains[4]);
			System.out.println("\n");
			}
		
		else {
			for(int l=0 ; l<5 ; l++){
				String choixProvisoire = listeCouleursPossibles[l];
				System.out.println(choixProvisoire);
				System.out.println("\n");
				grille.changeCase(jeu.listeJoueurs[this.numero-1], choixProvisoire, jeu);	
				int gain = this.score - copyScore;
				gains[l]=gain;	
				System.out.println("\n");
	
				for(int L=0 ; L<grille.hauteur ; L++){
					for (int H=0; H<grille.largeur;H++){
						grille.plateau[L][H].setCouleur(copyPlateau[L][H].getCouleur());
						grille.plateau[L][H].setJoueur(copyPlateau[L][H].getJoueur());
					}
				}
	
				jeu.listeJoueurs[this.numero-1].listeCases=copyListeCases;
				jeu.listeJoueurs[this.numero-1].score = copyScore;
			}
	
			System.out.println("listeCouleursPossibles");
			System.out.println(listeCouleursPossibles[0]);
			System.out.println(listeCouleursPossibles[1]);
			System.out.println(listeCouleursPossibles[2]);
			System.out.println(listeCouleursPossibles[3]);
			System.out.println(listeCouleursPossibles[4]);
			System.out.println("\n");						
			System.out.println("gainsPossibles");
			System.out.println(gains[0]);
			System.out.println(gains[1]);
			System.out.println(gains[2]);
			System.out.println(gains[3]);
			System.out.println(gains[4]);
			System.out.println("\n");
		}
			

		int max= 0;
		int maxIndex=0;
		for (int i = 0; i < gains.length; i++){
			int newmax = gains[i];
			if (newmax > max){
				max=newmax;
				maxIndex = i;
			}}		
		String couleur =listeCouleursPossibles[maxIndex];
		System.out.println("\n");
		System.out.println(couleur);
		grille.changeCase(this, couleur, jeu);
		joue = false;
				}	
			}

}