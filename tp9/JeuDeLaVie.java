class JeuDeLaVie extends Program {
    /*------------TESTS------------*/
    void testNombreDeVoisins() {
        // Initialiser un monde exemple
        boolean[][] monde =
        new boolean[][]{{false, false, false, false, false},
        {false, false, false, false, false},
        {false, true, true, true, false},
        {false, false, false, false, false},
        {false, false, false, false, false}};
        assertEquals(2, nombreDeVoisins(monde, 2, 2));
        assertEquals(2, nombreDeVoisins(monde, 1, 1));
        assertEquals(3, nombreDeVoisins(monde, 3, 2));
    }

    void testEvolution () {
        assertEquals(false,evolution(0, false));
        assertEquals(false,evolution(0, true));
        assertEquals(false,evolution(1, false));
        assertEquals(false,evolution(1, true));
        assertEquals(false,evolution(2, false));
        assertEquals(true,evolution(2, true));
        assertEquals(true,evolution(3, false));
        assertEquals(true,evolution(3, true));
        assertEquals(false,evolution(4, false));
        assertEquals(false,evolution(4, true));
    }
    /*-----------------------------*/
    void algorithm() {
        boolean [][] monde = new boolean[20][20];
        boolean [][] mondeN;
        int generation = 0;
        boolean stop = false;
        init(monde, 0.1);
        // Ici, on pourra par la suite ajouter des motifs (carré, glisseur, barre, autres) => voir question suivante
        afficher(monde);
        while(!stop){
            generation = generation +1;
            mondeN = new boolean[length(monde,1)][length(monde,2)];
            // Complétez ici par la double boucle qui calcule la
            // génération suivante dans mondeN

            for(int i=0; i<length(monde,1); i=i+1) {
                for(int j=0; j<length(monde,2); j=j+1) {
                    mondeN[i][j] = evolution(nombreDeVoisins(monde, i, j), monde[i][j]);
                }
            }

            monde = mondeN;
            println("Génération "+generation);
            afficher(monde);
            println("Entrez \"stop\" pour arrêter, ou entrée pour continuer");
            String message=readString();
            stop = equals("stop",message);
            if(equals("carre",message)) {
                ajouterCarre(monde, readInt(), readInt());
            }
            if(equals("glisseur",message)) {
                ajouterGlisseur(monde, readInt(), readInt());
            }
        }
    }




    void afficher(boolean[][] monde) {
        String affichage="";
        for(int i=0; i<length(monde,1); i=i+1) { //1: lignes 2: colonnes
            for(int j=0; j<length(monde,2); j=j+1) {
                if(monde[i][j]) {
                    affichage=affichage+"■ ";
                } else {
                    affichage=affichage+"□ ";
                }
            }
            affichage=affichage+"\n";
        }
        print(affichage);
    }

    void init(boolean[][] tab, double proba) {
        for(int i=0; i<length(tab,1); i=i+1) {
            for(int j=0; j<length(tab,2); j=j+1) {
                if(proba>=random()) {
                    tab[i][j] = true;
                } else {
                    tab[i][j] = false;
                }
            }
        }
    }

    int nombreDeVoisins(boolean[][] monde, int ligne, int col) {
        int voisins = 0;
        
        if(ligne>0 && monde[ligne-1][col]) { //HAUT
            voisins = voisins+1;
        }
        if(ligne<length(monde,1)-1 && monde[ligne+1][col]) { //BAS
            voisins = voisins+1;
        }
        if(col>0) { //GAUCHE
            if(monde[ligne][col-1]) { //GAUCHE
                voisins=voisins+1;
            }
            if(ligne>0 && monde[ligne-1][col-1]) { //HAUT GAUCHE
                voisins=voisins+1;
            }
            if(ligne<length(monde,1)-1 && monde[ligne+1][col-1]) { //BAS GAUCHE
                voisins=voisins+1;
            }
        }
        if(col<length(monde,2)-1) { //DROITE
            if(monde[ligne][col+1]) { //DROITE
                voisins=voisins+1;
            }
            if(ligne>0 && monde[ligne-1][col+1]) { //HAUT DROITE
                voisins=voisins+1;
            }
            if(ligne<length(monde,1)-1 && monde[ligne+1][col+1]) { //BAS DROITE
                voisins=voisins+1;
            }
        }
        return voisins;
    }

    boolean evolution(int nombreDeVoisins, boolean etatCellule) {
        boolean etat=false;
        if(nombreDeVoisins==3) {
            etat=true;
        }
        if(nombreDeVoisins>=2 && nombreDeVoisins<=3 && etatCellule) {
            etat=true;
        }
        return etat;
    }

    // Ajoute ce motif aux coordonnées données
    // @@
    // @@
    void ajouterCarre(boolean[][] monde, int lig, int col) {
        if(lig<length(monde,1)-1 && col<length(monde,2)) {
            for(int i = lig; i<lig+2; i=i+1) {
                for(int j = col; j<col+2; j=j+1) {
                    monde[i][j] = true;
                }
            }
        }
    }

    // Ajoute ce motif aux coordonnées données
    // .@.
    // ..@
    // @@@
    void ajouterGlisseur (boolean[][] monde, int lig, int col) {
        monde[lig  ][col  ] = true;
        monde[lig  ][col-1] = true;
        monde[lig  ][col+1] = true;
        monde[lig+1][col+1] = true;
        monde[lig+2][col  ] = true;
    }
    // Ajoute ce motif aux coordonnées données
    // @@@
    void ajouterBarre (boolean[][] monde, int lig, int col) {

    }
}