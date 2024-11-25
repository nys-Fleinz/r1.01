class Dessins extends Program {
    void testTrianglePlein() {
        assertEquals("*\n", trianglePlein(1, '*'));
        assertEquals("o\noo\n", trianglePlein(2, 'o'));
        assertEquals("+\n++\n+++\n", trianglePlein(3, '+'));
    }

    String trianglePlein(int taille, char car) {
        String triangle="";
        String temp = "";
        for(int i=0; i<taille; i=i+1) {
            temp = temp + car;
            triangle=triangle+temp+"\n";
        }
        return triangle;
    }

    void testTriangleCreux() {
        assertEquals("*\n", TriangleCreux(1, '*'));
        assertEquals("o\noo\n", TriangleCreux(2, 'o'));
        assertEquals("+\n++\n+ +\n+  +\n+++++\n", TriangleCreux(5, '+'));
    }

    String TriangleCreux(int taille, char car) {
        String triangle="";
        String blanc="";
        String ligne="";
        
        for(int i=0; i<taille; i=i+1) {
            if((i-2) >= 0) {
                blanc=blanc+" ";
                ligne=ligne+car;
            }
            if(i==0) {
                triangle=triangle+car+"\n";
            } else if(i==1) {
                triangle=triangle+car+car+"\n";
            } else if(i==taille-1) {
                triangle=triangle+ligne;
            } 

        }

        return triangle;
    }
}