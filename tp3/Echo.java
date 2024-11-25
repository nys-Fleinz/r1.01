class Echo extends Program {
    void algorithm(){
        print("Chaîne à répéter: ");
        String phrase = readString();
        print("Nombre de fois: ");
        int n = readInt();

        for(int i=0; i<n; i=i+1) {
            println(phrase);
        }
    }
}