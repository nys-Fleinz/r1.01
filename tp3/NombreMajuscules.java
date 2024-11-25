class NombreMajuscules extends Program {
    void algorithm() {
        String txt = readString();
        int compteur = 0;
        for(int i =0; i<length(txt); i=i+1) {
            if(charAt(txt, i)>='A' && charAt(txt, i)<='Z') {
                compteur = compteur+1;
            }
        }
        println("Nombre de majuscules: "+compteur);
    }
}