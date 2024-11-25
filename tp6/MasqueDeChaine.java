class MasqueDeChaine extends Program {
    
    void testMasque () {
        assertEquals("a...a...a....", testMasque("au bal masqué", 'a'));
        assertEquals("................", testMasque("Tonari no Totoro", 'u'));
        assertEquals(".o......o..o.o.o", testMasque("Tonari no Totoro", 'o'));
        assertEquals("", testMasque("", 'z'));
    }

    String testMasque(String phrase, char car) {
        String chaineFin="";
        for(int i=0; i<length(phrase); i=i+1) {
            if(charAt(phrase, i) == car) {
                chaineFin = chaineFin + car;
            } else {
                chaineFin = chaineFin + ".";
            }
        }
        return chaineFin;
    }
}