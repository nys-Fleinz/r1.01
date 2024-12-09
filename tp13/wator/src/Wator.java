class Wator extends Program{

    //Paramètres de la simulation
    final int NB_COLS = 10;
    final int NB_LIGNES = 10;
    final int TPS_GEST_THON = 2; //Le temps de gestation d'un thon
    final int TPS_GEST_REQUIN = 4; //idem pour le requin
    final int NOURRITURE_REQUIN = 3; //La nourriture de départ d'un requin

    final double PROBA_THON=0.25;
    final double PROBA_REQUIN=0.10;
    final int LATENCE = 10; //à diminuer pour augmenter la vitesse de la simulation
    
    void algorithm(){
		Poisson[][] ocean = new Poisson[NB_LIGNES][NB_COLS];
		initialiser(ocean,PROBA_THON,PROBA_REQUIN);
		while(!estVide(ocean)){
			println(toString(ocean));
			int lig = tirerAuHasard(NB_LIGNES);
			int col = tirerAuHasard(NB_COLS);
			appliquerRegles(ocean,lig,col);
			println("On applique les regles en " + lig + ", " + col);
			println("THONS: "+nombreEspece(ocean, Espece.THON)+" REQUIN: "+nombreEspece(ocean, Espece.REQUIN));
			delay(LATENCE);
		}
    }
	
	//Donner le nombre d'une espece
	int nombreEspece(Poisson[][] tab, Espece espece) {
		int nombreFinal=0;
		for (int i=0;i<length(tab,1);i++){
			for (int j=0;j<length(tab,2);j++){
				if(tab[i][j]!=null && tab[i][j].espece==espece) {
					nombreFinal+=1; //rajouter 1 pour chaque espece trouvé
				}
			}
		}
		return nombreFinal;
	}
	
    //remplit le tableau de poissons aléatoirement selon des probas données en paramètre
    void initialiser(Poisson[][] tab, double probaThon, double probaRequin){
		for (int l=0;l<length(tab,1);l++){
			for (int c=0;c<length(tab,2);c++){
				tab[l][c]=newPoisson(probaThon,probaRequin);
			}
		}
    }


    //Créer un poisson ou non en fonction des probabilités fournies
    Poisson newPoisson(double probaThon, double probaRequin){
		double alea = random();
		Poisson p;
		if (alea<probaThon){
			p = newThon();
		}else if(alea<probaThon+probaRequin){
			p = newRequin();
		}else{
			//il n'y a pas de poisson
			p = null;
		}
		return p;
    }

    //Créer un thon à partir des caractéristiques en constantes globales
    Poisson newThon(){
		Poisson p = new Poisson();
		p.nourriture=1;
		p.tempsGestation=TPS_GEST_THON;
		p.espece=Espece.THON;
		return p;
    }

    //Créer un requin à partir des caractéristiques en constantes globales
    Poisson newRequin(){
		Poisson p = new Poisson();
		p.nourriture=NOURRITURE_REQUIN;
		p.tempsGestation=TPS_GEST_REQUIN;
		p.espece=Espece.REQUIN;
		return p;
    }

    
    //indique si le tableau est vide (ne contient aucun poisson) ou non
    boolean estVide(Poisson[][] tab){
		for (int l=0;l<length(tab,1);l++){
			for (int c=0;c<length(tab,2);c++){
				if (!estVide(tab,l,c)){
					return false;
				}
			}
		}
		return true;
    }

	//indique si une case est vide ou non
	boolean estVide(Poisson[][] tab, int l, int c){
		return tab[l][c]==null;
	}

    //fonction qui permet de tirer un entier au hasard entre 0 et le nombre passé en paramètre exclus
    int tirerAuHasard(int max){
		return (int) (random()*max) ;
    }

    //fonction qui applique les règles de la simulation sur une case dont les coordonnées sont données en paramètre
    void appliquerRegles(Poisson[][] tab, int lig, int col){
		if (!estVide(tab,lig,col)){
			Poisson p = tab[lig][col];
			appliquerFamine(tab, lig, col, p.espece);
			boolean deplace = deplacementAlea(tab, lig, col, p.espece);
			appliquerGestation(tab, lig, col, p, deplace);
		}
    }

	// Appliquer l'effet de gestation sur un thon ou un requin
	void appliquerGestation(Poisson[][] tab, int lig, int col, Poisson p, boolean deplace) {
		if(p.tempsGestation<=0 && deplace) {
			if(p.espece==Espece.THON) {
				tab[lig][col]=newThon();
			} else if(p.espece==Espece.REQUIN) {
				tab[lig][col]=newRequin();
			}
		} else {
			p.tempsGestation+= -1;
		}
	}

	// Appliquer l'effet de famine sur un thon ou un requin
	void appliquerFamine(Poisson[][] tab, int lig, int col, Espece comportement) {
		if(comportement==Espece.REQUIN) {
			if(tab[lig][col].nourriture<=0) {
				tab[lig][col]=null; //Supprime le requin si la nourriture est à 0
			} else {
				tab[lig][col].nourriture=-1; //enlève 1 de nourriture
			}
		}
	}


    
    //Tente de se faire déplacer le poisson de (lig,col) aléatoirement avec la règle de l'espèce donnée
    //Renvoie true si l'opération a réussi, false sinon
    boolean deplacementAlea(Poisson[][] tab, int lig, int col, Espece comportement){
		boolean deplace=false;
		int nbEssais = 0;
		int num = tirerAuHasard(9); //on tire le numéro d'une case au hasard dans le voisinage incluant la case où on est (la 4)
		// 0 | 1 | 2
		// 3 | 4 | 5
		// 6 | 7 | 8
		while(!deplace && nbEssais<8){
			int decalL = num/3 - 1; //on calcule le décalage de ligne
			int decalC = num%3 - 1; //on calcule le décalage de colonne
			//on déplace le poisson d'une case à une autre avec la règle de l'espèce passée en paramètre
			deplace = deplacerPoisson(tab,lig,col,lig+decalL,col+decalC, comportement);
			nbEssais++;
			num=(num+1)%9;//on passe au numéro de case suivante	    
		}
		//si un requin  n'a pas réussi à se déplacer (pas de thon à proximité) alors il se déplace comme un thon (au hasard)
		if (comportement==Espece.REQUIN && !deplace){
			deplace = deplacementAlea(tab,lig,col,Espece.THON);
		}
		return deplace;
    }

    //Tente de faire se déplacer le poisson de (lig,col) à (ligDest,colDest) selon la règle d'une espèce donnée
    //Renvoie true si l'opération a réussi, false sinon
    boolean deplacerPoisson(Poisson[][] tab, int lig, int col, int ligDest, int colDest, Espece comportement){
		if (coordonnesValides(ligDest, colDest) && (lig!=ligDest || col!=colDest) ){
			if ( (comportement==Espece.THON  && estVide(tab, ligDest, colDest)) //règle du thon
			|| (comportement==Espece.REQUIN && !estVide(tab, ligDest, colDest) && tab[ligDest][colDest].espece==Espece.THON) ){ //règle du requin
				tab[ligDest][colDest]=tab[lig][col];
				tab[lig][col]=null;
				if(tab[ligDest][colDest]!=null && comportement==Espece.REQUIN) { //vérifie si le poisson n'est pas mort entre temps
					tab[ligDest][colDest].nourriture=NOURRITURE_REQUIN; // redonne de la nourriture après avoir manger
				}
				return true;
			}
		}
		return false;//la case est occupée ou inaccessible
    }
    
    boolean coordonnesValides(int lig, int col){
    	return lig>=0 && lig < NB_LIGNES && col>=0 && col<NB_COLS;
    } 
        
    //Retourne la chaîne de caractère prête à être affichée qui correspond au tableau de poisson passé en paramètre
    String toString(Poisson[][] tab){
		String res = "";
		for (int l=0;l<length(tab,1);l++){
			for (int c=0;c<length(tab,2);c++){
				res += toString(tab[l][c]);
			}	    
			res+= "\n";
		}
		return res;
    }
    
    //Retourne la chaîne de caractère prête à être affichée qui correspond au poisson passé en paramètre
    String toString(Poisson p){
		if (p==null) {
			return "~";
		}
		else if (p.espece==Espece.THON){
			return "T";
		}else if (p.espece==Espece.REQUIN){
			return "R";
		}else{
			return "?";
		}
    }
}
