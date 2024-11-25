class SousChaines extends Program{

    void algorithm(){

        print("Entrez un mot : ");
        String mot = readString();

        for (int l=0; l<length(mot)+1; l=l+1){
            for (int i=l; i<length(mot)+1; i=i+1){
                for (int j = l; j<i; j=j+1){
                    print(charAt(mot, j));
                    if (j==i-1) {
                        print("\n");
                    }
                }
            }
        }
    }
}