class NiOuiNiNon extends Program {
    void algorithm() {
        String ouinon = "";
        while(!equals(toLowerCase(ouinon), "oui") && !equals(toLowerCase(ouinon), "non")) {
            print("PHRASE: ");
            ouinon = readString();
        }
        println("Perdu!");
    }
}