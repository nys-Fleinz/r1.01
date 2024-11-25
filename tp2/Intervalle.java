class Intervalle extends Program {
    void algorithm() {
        int borneInf, borneSup;
        print("Entrez la borne inférieure : ");
        borneInf = readInt();
        print("Entrez la borne supérieure : ");
        borneSup = readInt();
        println();

        if(borneInf<=borneSup) {
            println("L'intervalle n'est pas vide.");
        } else {
            println("L'intervalle est vide.");
        }
    }
}