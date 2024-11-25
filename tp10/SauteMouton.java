class SauteMouton extends Program {
    final char G = '<';
    final char D = '>';
    final char V = '_';

    void algorithm() {
        char[] prairie = new char[]{D,D,D,V,G,G,G};
        // pour le test on effectue 3 saisies
        while(!partieFini(prairie)) {
            println(toString(prairie));
            effectuerDeplacement(saisirCoup(prairie), prairie);
        }
    }

    boolean partieFini(char[] prairie) {
        boolean termine=false;
        if(prairie == new char[] {G,G,G,V,D,D,D}) {
            termine=true;
            println("Vous avez gagné!");
        } else {
            int compteur=0;
            while(compteur<length(prairie)) {
                if(estPositionValide(compteur, prairie)) {
                    compteur=compteur+1;
                } else {
                    
                }
            }
            if(compteur==0) {
                termine=true;
                println("Perdu! Les moutons sont bloqués!");
            }
        }
        return termine;
    }
    
    int indiceCaseVide(char[] prairie) {
        int indice=0;
        while(indice<length(prairie) && prairie[indice]!=V) {
            indice=indice+1;
        }
        return indice;
    }

    boolean estPositionValide(int positionMouton, char[] prairie) {
        boolean valide=false;
        if(positionMouton>=0 && positionMouton<length(prairie)) {
            if(prairie[positionMouton]==D) {
                if(positionMouton+1<length(prairie) && prairie[positionMouton+1]==V) { valide = true; } else
                if(positionMouton+2<length(prairie) && prairie[positionMouton+2]==V) { valide = true; }
            } else if(prairie[positionMouton]==G) {
                if(positionMouton-1>=0 && prairie[positionMouton-1]==V) { valide = true; } else
                if(positionMouton-2>=0 && prairie[positionMouton-2]==V) { valide = true; }
            } else {
                valide=false;
            }
        }
        return valide;
    }

    int saisirCoup(char[] prairie) {
        int indice =-1;
        if(!partieFini(prairie)) {
            while(!estPositionValide(indice, prairie)) {
                print("Entrez le numéro du mouton à déplacer: ");
                indice = readInt();
            }
        }
        return indice;
    }

    void effectuerDeplacement(int positionMouton, char[] prairie) {
        char temp = prairie[positionMouton];
        int vide = indiceCaseVide(prairie);
        if(prairie[positionMouton] == D) {
            if(positionMouton+1==vide) {
                prairie[positionMouton] = prairie[positionMouton+1];
                prairie[positionMouton+1] = temp;
            } else {
                prairie[positionMouton] = prairie[positionMouton+2];
                prairie[positionMouton+2] = temp;
            }
        } else {
            if(positionMouton-1 == vide) {
                prairie[positionMouton] = prairie[positionMouton-1];
                prairie[positionMouton-1] = temp;
            } else {
                prairie[positionMouton] = prairie[positionMouton-2];
                prairie[positionMouton-2] = temp;
            }
        }
    }

    void initialiser(char[] prairie) {
        for(int i=0; i<3; i=i+1) {
            prairie[i] = D;
        }
        prairie[3] = V;
        for(int i=4; i<7; i=i+1) {
            prairie[i] = G;
        }
    }

    String toString(char[] tab) {
        String message="";
        for(int i=0; i<length(tab); i=i+1) {
            message=message+tab[i];
        }
        return message;
    }
}