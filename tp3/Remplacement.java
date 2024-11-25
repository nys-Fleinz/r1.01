class Remplacement extends Program{
    void algorithm(){
        String txt, txtFinal ="";
        char ancien, nouveau;
        println("Veuillez saisir votre texte : ");
        txt = readString();
        print("Caractère à remplacer : ");
        ancien = readChar();
        print("Caractère de remplacement : ");
        nouveau = readChar();

        for(int i = 0; i<length(txt); i=i+1) {
            if(charAt(txt, i) == ancien) {
                txtFinal = txtFinal+nouveau;
            } else {
                txtFinal=txtFinal+charAt(txt, i);
            }
        }
        println(txtFinal);
    }
}