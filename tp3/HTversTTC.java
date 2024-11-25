class HTversTTC extends Program{
    void algorithm() {
        print("Combien de lignes ? ");
        int n = readInt();
        double taux = 1.196;
        for(int i=1; i<n+1; i=i+1) {
            println(i+" euros HT = "+i*taux+" euros TTC.");
        }
    }
}