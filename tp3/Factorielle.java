class Factorielle extends Program{
    void algorithm() {
        print("Factorielle: ");
        int n = readInt();
        int resultat = 1;
        for(int i=1; i<n+1; i=i+1) {
            resultat = resultat*i;
        }
        println("Résultat: "+resultat);
    }
}