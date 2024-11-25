class MomentJournee extends Program {
    void algorithm() {
        print("heure: ");
        int heure = readInt();

        if(heure>=22 && heure<=23) {
            println("nuit");
        } else if(heure>=18) {
            println("soirée");
        } else if(heure>=12) {
            println("après-midi");
        } else if(heure>=0) {
            println("matinée");
        } else {
            println("erreur");
        }
    }
}