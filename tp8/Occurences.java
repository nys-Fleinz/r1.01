class Occurences extends Program {
    void testNbFois () {
        String[] tab = new String[]{"je", "tu", "tu", "elle", "je", "je"};
        // "je" apparait 3 fois dans tab
        assertEquals(3, nbFois(tab, "je"));
        assertEquals(2, nbFois(tab, "tu"));
        assertEquals(0, nbFois(tab, "il"));
    }

    void testLesMots () {
        assertArrayEquals(new String[]{"je", "tu", "elle", "je", "tu"}, lesMots("je tu elle je tu"));
        assertArrayEquals(new String[]{"je", "tu", "elle", "je", "tu"}, lesMots(" je tu, elle . je tu ! "));
    }
    
    void testFrequences () {
        String[] motsCles = new String[]{"je", "tu", "elle"};
        int[] freq = new int[]{3, 2, 1};
        String[] mots = new String[]{"je", "tu", "tu", "elle", "je", "je"};
        assertArrayEquals(freq, frequences(motsCles, mots));
    }
    void testMotsDifferents () {
        String[] mots = new String[]{"je", "tu", "tu", "elle", "je", "je"};
        String[] motsDiff = motsDifferents(mots);
        for (int idx = 0; idx < length(mots); idx = idx+1){
            assertEquals(1, nbFois(motsDiff,mots[idx]));
            //on s’assure que chaque mot apparaît une et une seule fois dans motsDiff
        }
        //on vérifie que les mots sont bien à la bonne place
        assertEquals("je",motsDiff[0]);
        assertEquals("tu",motsDiff[1]);
        assertEquals("elle",motsDiff[2]);
        for (int idx = 3; idx < length(motsDiff); idx = idx+1){
            assertEquals("", motsDiff[idx]);
        }
    }

    void testSousTableau () {
        assertArrayEquals(new String[]{"a", "b", "c"}, sousTableau(new String[]{"a", "b", "c", "d", "e"}, 3));
        assertArrayEquals(new String[]{"a", "b"}, sousTableau(new String[]{"a", "b"}, 5));
        assertArrayEquals(new String[]{}, sousTableau(new String[]{"a", "b", "c"}, 0));
        assertArrayEquals(new String[]{"a", "b"}, sousTableau(new String[]{"a", "b"}, -5));
        // L’assertion suivante sert à tester qu’on retourne bien une copie du tableau
        // et non le tableau lui-même
        String[] tab = new String[]{"a", "b"};
        assertNotEquals(tab, sousTableau(tab, 2));
        assertNotEquals(tab, sousTableau(tab, 3));
        assertNotEquals(tab, sousTableau(tab, -1));
    }


    String[] lesMots(String phrase) {
        String[] array = new String[length(phrase)/2];
        int j=0;
        String mot="";
        phrase = phrase + ' ';
        for(int i=0; i<length(phrase); i=i+1) {
            if(charAt(phrase, i)>'a' && charAt(phrase, i)<'z') {
                mot=mot+charAt(phrase, i);
            } else {
                println("|"+mot+"|");
                array[j]=mot;                mot="";
                j=j+1;

            }
        }
        return sousTableau(array, j);
    }


    String[] motsDifferents(String[] mots) {
        String[] tab = new String[length(mots)];

        for(int i=0; i<length(tab); i=i+1) {
            tab[i]="";
        }
        int j=0;

        for(int i=0; i<length(mots); i=i+1) {
            if(!(nbFois(tab, mots[i])>0)) {
                tab[j] = mots[i];
                j=j+1;
            }
        }
        return tab;
    }

    String[] sousTableau(String[] tab, int taille) {
        if(taille<0 || taille>length(tab)) {
            taille=length(tab);
        }
        String[] copie = new String[taille];

        for(int i=0; i<taille; i=i+1) {
            copie[i]=tab[i];
        }
        return copie;
    }


    int[] frequences(String[] motsCles, String[] mots) {
        int[] tab = new int[length(motsCles)];
        
        for(int i=0; i<length(motsCles); i=i+1) {
            tab[i] = nbFois(mots, motsCles[i]);
        }
        return tab;
    }


    int nbFois(String[] tab, String mot) {
        int occurences=0;
        for(int i=0; i<length(tab); i=i+1) {
            if(equals(tab[i], mot)) {
                occurences=occurences+1;
            }
        }
        return occurences;
    }

    String toString(String[] tab) {
        String message="";
        for(int i=0; i<length(tab); i=i+1) {
            message=message+" "+tab[i];
        }
        return message;
    }
}