class NettoyerChaine extends Program {
    void algorithm() {
        String chaine = readString();
        println("Avant nettoyage :");
        println(">"+chaine+"<");

        if(charAt(chaine, 0) == ' ') {
            chaine = substring(chaine, 1, length(chaine));
        }
        if(charAt(chaine, length(chaine)-1) == ' ') {
            chaine = substring(chaine, 0, length(chaine)-1);
        }

        println("Après nettoyage :");
        println(">"+chaine+"<");
    }
}