class HTversTTC2 extends Program{
    void algorithm() {
        print("Combien de lignes ? ");
        int lignes = readInt();
        print("A partir de: ");
        int debut = readInt();
        double taux = 1.196;

        for(int i=0; i<lignes+1; i=i+1) {
            println(debut+" euros HT = "+ debut*taux+" euros TTC.");
            debut=debut+1;
        }
    }
}