class Suffixe extends Program {
    void algorithm() {
        print("Votre mot: ");
        String mot = readString();
        print("Nombre de lettres de fin souhaitées: ");
        int nombre = readInt();
        String suffixe = substring(mot, length(mot)-nombre, length(mot));
        println("Résultat: " + suffixe);
    }
}