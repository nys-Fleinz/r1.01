class EuroToYen extends Program {
    void algorithm(){
        double taux = 135.90;
        print("combien de lignes souhaitez-vous ?");
        int n = readInt();

        for(int i = 1; i<(n+1); i=i+1){
            println(i+" euros = "+ i*taux +" yens.");
        }
    }
}