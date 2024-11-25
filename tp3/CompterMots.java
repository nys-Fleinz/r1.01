class CompterMots extends Program {
    void algorithm() {
        String txt = readString();
        int compteur = 0;
        for(int i = 0; i<length(txt); i=i+1) {
            if(charAt(txt, i) == ' ' && charAt(txt, i-1) != ' ') {
                compteur = compteur+1;
            }
        }
    }
}