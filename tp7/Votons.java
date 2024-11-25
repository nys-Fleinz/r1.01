class Votons extends Program {
    void testEstAdopte(){
        assertEquals(false, estAdopte(new boolean[]{true,false}));
        assertEquals(true, estAdopte(new boolean[]{true,true,false}));
    }

    boolean estAdopte(boolean[] tab) {
        int pour   = 0;
        int contre = 0;
        boolean adopte=false;

        for(int i=0; i<length(tab); i=i+1) {
            if(tab[i]) {
                pour=pour+1;
            } else {
                contre=contre+1;
            }
            
            
        }
        if(pour>contre) {
            adopte=true;
        }
        return adopte;
    }
}

