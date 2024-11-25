class SousChaine extends Program {
    void algorithm() {
        print("MOT 1: ");
        String mot1 = readString();
        print("MOT 2: ");
        String mot2 = readString();
        println(sousChaine(mot1, mot2));
    }

    String sousChaine(String string1, String string2) {
        for(int i=0; i<(length(string1)-length(string2)); i=i+1) {
            if(equals(substring(string1, i, i+length(string2)), string2)) {
                return "trouvé";
            }
        }
        return "pas trouvé";
    }
}