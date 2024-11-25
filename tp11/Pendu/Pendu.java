class Pendu extends Program {
    Lettre newLettre(char car) {
        Lettre lettre = new Lettre();
        lettre.car = car;
        lettre.decouverte = false;
        return lettre;
    }

    void testCreerMot() {
        Lettre[] tab = creerMot("unix");
        assertEquals('u', tab[0].car);
        assertEquals('i', tab[2].car);
        assertEquals(4, length(tab));
    }

    Lettre[] creerMot(String mot) {
        Lettre[] tab = new Lettre[length(mot)];
        for(int i=0; i<length(mot); i=i+1) {
            tab[i]=newLettre(charAt(mot, i));
        }
        return tab;
    }

    String toString(Lettre lettre) {
        String leString = ""+lettre.car;
        if(lettre.decouverte==false) { leString="*"; }
        return leString;
    }

    String toString (Lettre[] mot) {
        String message="";
        for(int i=0; i<length(mot); i=i+1) {
            message=message+toString(mot[i]);
        }
        return message;
    }

    void testToStringMot() {
        Lettre[] mot = creerMot("chat");
        assertEquals("****", toString(mot));
        mot[1].decouverte=true;
        assertEquals("*h**", toString(mot));
    }

    void testToStringLettre() {
        Lettre lettre = newLettre('a');
        assertEquals("*", toString(lettre));
        lettre.decouverte=true;
        assertEquals("a", toString(lettre));
    }

    boolean estDecouvert(Lettre[] mot) {
        boolean decouvert;
        int lettresDecouvertes=0;
        if(length(mot)==0) { decouvert=false; }
        for(int i=0; i<length(mot); i=i+1) {
            if(mot[i].decouverte) {
                lettresDecouvertes=lettresDecouvertes+1;
            }
        }
        if(lettresDecouvertes==length(mot)) {
            decouvert=true;
        } else {
            decouvert=false;
        }
        return decouvert;
    }

    void testEstDecouvert() {
        Lettre[] mot = creerMot("chat");
        assertEquals(false, estDecouvert(mot));
        mot[0].decouverte = true;
        assertEquals(false, estDecouvert(mot));
        for(int i=0; i<length(mot); i=i+1) { mot[i].decouverte = true; }
        assertEquals(true, estDecouvert(mot));
        Lettre[] motVide = creerMot("");
        assertEquals(false, estDecouvert(motVide));
    }

    boolean decouvrir(Lettre[] mot, char car) {
        boolean trouve=false;
        for(int i=0; i<length(mot); i=i+1) {
            if(mot[i].car == car) {
                mot[i].decouverte = true;
                trouve=true;
            }
        }
        return trouve;
    }

    void testDecouvrir() {
        Lettre[] mot = creerMot("chat");
        assertEquals(true, decouvrir(mot, 'a'));
        assertEquals(false, decouvrir(mot, 'p'));
        assertEquals("**a*", toString(mot));
    }

    void algorithm() {
        print("Quel mot veux-tu faire deviner: ");
        Lettre[] mot = creerMot(readString());
        while(!estDecouvert(mot)) {
            print("Entre la lettre que tu veux deviner: ");
            if(decouvrir(mot, readChar())) {
                println("Lettre trouvée!");
            } else {
                println("La lettre n'est pas bonne :(");
            }
            println(toString(mot));
        }
        println("Bravo tu as découvert le mot!");
    }

}