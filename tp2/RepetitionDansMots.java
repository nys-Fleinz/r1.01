class RepetitionDansMots extends Program {
    void algorithm() {
        String mot = readString();
        int taille = length(mot);
        boolean repetition = equals(substring(mot, 0, (taille/2)), substring(mot, taille/2, taille));
        println(mot + "=" + repetition);
    }
}