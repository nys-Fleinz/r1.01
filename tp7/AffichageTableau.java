class AffichageTableau extends Program {

    void algorithm() {
        int[] tabInt = new int[]{20, 30, 50};
        String[] tabStr = new String[]{"Alan", "Turing"};
        println(toString(tabInt));
        println(toString(tabStr));
    }


    String toString(int[] tab) {
        String data="";
        for(int i=0; i<length(tab); i=i+1) {
            data=data+tab[i]+" ";
        }
        return data;
    }

    String toString(String[] tab) {
        String data="";
        for(int i=0; i<length(tab); i=i+1) {
            data=data+tab[i]+" ";
        }
        return data;
    }



    void testToString_tabString () {
        assertEquals("un deux trois ", toString(new String[]{"un", "deux", "trois"}));
        assertEquals("", toString(new String[0]));
    }

    void testToString_tabInt () {
        assertEquals("1 2 3 ", toString(new int[]{1,2,3}));
        assertEquals("", toString(new int[0]));
    }
}