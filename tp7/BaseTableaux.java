class BaseTableaux extends Program {
    void testCreerTableau() {
        assertArrayEquals(new int[]{1,1,1,1,1,2,2,2,2,2}, creerTableau());
    }
    void testCreerTableau2() {
        assertArrayEquals(new int[]{1,1,1,1,1,2,2,2,2,2}, creerTableau(10));
        assertArrayEquals(new int[]{1,1,2,2,2}, creerTableau(5));
        assertArrayEquals(new int[]{}, creerTableau(0));
    }

    void testCreerTableauAleatoire() {
        
    }

    int[] creerTableauAleatoire(int taille) {
        int[] tab = new int[taille];
        for(int i=0; i<taille; i=i+1) {
            tab[i] = (int) (random()*20);
        }
        return tab;
    }

    int[] creerTableau() {
        int[] tab = new int[10];
        for(int i=0; i<length(tab); i=i+1) {
            if(i<5) {
                tab[i]=1;
            } else {
                tab[i]=2;
            }
        }
        return tab;
    }

    int[] creerTableau(int nombre) {
        int[] tab = new int[nombre];
        for(int i=0; i<length(tab); i=i+1) {
            if(i<(length(tab)/2)) {
                tab[i]=1;
            } else {
                tab[i]=2;
            }
        }
        return tab;
    }
}