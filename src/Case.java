
public class Case {
	private String couleur;
	private int joueur;
	private int i;
	private int j;
	
	public String getCouleur(){
		return this.couleur;
	}
		
	
	@Override
	public String toString() {
		return "Case [couleur=" + couleur + ", joueur=" + joueur + ", i=" + i + ", j=" + j + ",]";
	}



	public int getJoueur(){
		return this.joueur;
	}
	
	public int getI(){
		return this.i;
	}
	
	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public void setJoueur(int joueur) {
		this.joueur = joueur;
	}

	public void setI(int i) {
		this.i = i;
	}

	public Case(int i, int j){
		this.joueur = 0;
		this.i=i;
		this.j=j;
		this.couleur="aucune";
	}
	
	public Case(String str){
		String[] Case = new String[]{"couleur=","joueur=","i=","j="};
		Case = remplaceParValeur(Case,str,',',0);
		this.joueur = Integer.parseInt(Case[1]);
		this.i = Integer.parseInt(Case[2]);
		this.j = Integer.parseInt(Case[3]);
		this.couleur = Case[0];
	}
	
	public static String[] remplaceParValeur(String[] str, String texte, char separateur, int aPartir){
		for(int k=0 ; k<str.length ; k++){
			int index = texte.indexOf(str[k],aPartir-1)+str[k].length();
			int i = 0;
			String mot="";
			while(texte.charAt(index+i)!=separateur){
				mot = mot + texte.charAt(index+i);
				i++;
			}
			str[k]=mot;
		}
		return str;
	}
	
	public void changeJoueur(Entity nouveauJoueur){
		joueur = nouveauJoueur.numero;
	}
	
	public void changeCouleur(String nouvelleCouleur){
		couleur = nouvelleCouleur;
	}
}
