class RechercherRemplacer extends Program{

    void testCopieEnRemplacant () {
        assertEquals("15x35" , copieEnRemplacant("15*35", "*", "x"));
        assertEquals("15 + 35", copieEnRemplacant("15 plus 35", "plus", "+"));
        assertEquals("abcd", copieEnRemplacant("abcd", "cb" , "xy"));
        assertEquals("abcd", copieEnRemplacant("abcd", "", "x"));
        assertEquals("abcd", copieEnRemplacant("-ab-cd-", "-", ""));
        assertEquals("xx" , copieEnRemplacant("aaaa", "aa" , "x"));
        assertEquals("xxa", copieEnRemplacant("aaaaa", "aa" , "x"));
        assertEquals("9 plus 3 plus 3", copieEnRemplacant("9 moins 3 moins 3", "moins", "plus"));
    }

    String copieEnRemplacant(String texte, String mot, String remplacement){
        String result = "";
        String chaine = "";
        int dernierRemplacement = 0;

        for (int i=0; i<length(texte)-i; i=i+1){
            println("result: ");
            if((length(mot)-1)+(i)>=length(texte)) {
                result=result+substring(texte, dernierRemplacement, length(texte));
                println("fin atteinte");
            } else if(equals(substring(texte, i, length(mot)+i), mot)) {
                result = result + substring(texte, dernierRemplacement, i-length(texte));
                dernierRemplacement=i;
                println("denier remplacement"+ dernierRemplacement);
            }
        }
        return result;
    }
}