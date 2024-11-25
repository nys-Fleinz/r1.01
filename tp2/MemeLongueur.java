class MemeLongueur extends Program{
    void algorithm(){
        String mot1 = readString();
        String mot2 = readString();
        int longueurMot1 = length(mot1); //COMPLÉTER L’AFFECTATION
        int longueurMot2 = length(mot2); //COMPLÉTER L’AFFECTATION
        boolean memeLongueur = longueurMot1 == longueurMot2; //COMPLÉTER L’AFFECTATION
        println("Les deux mots sont de la même longueur : " + memeLongueur);
    }
}