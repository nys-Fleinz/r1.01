class TestBissextile extends Program{
    boolean estBissextile(int annee){
        boolean bissextile = false;
        if (annee%4 == 0 && (annee%100 != 0 || annee%400 == 0)){
                bissextile = true;
        }
        return bissextile;
    }

    void testBissextile() {
        assertEquals(estBissextile(2013), false);
        assertEquals(estBissextile(2006), false);
        assertEquals(estBissextile(1999), false);
        assertEquals(estBissextile(1000), false);
        assertEquals(estBissextile(2000), true);
        assertEquals(estBissextile(2012), true);
        assertEquals(estBissextile(2024), true);
        assertEquals(estBissextile(1600), true);
    }
}