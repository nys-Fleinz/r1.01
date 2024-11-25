class SuperLogicielDeLanTroisMille extends Program{
    void algorithm() {
        print("Bienvenue dans le SuperLogicielDeLanTroisMille\n\n1. Ouvrir un document existant.\n2. Créer un nouveau document.\n3. Enregistrer le document courant.\n4. Quitter ce magnifique logiciel.\n\nVeuillez entrer votre choix:");
        int choix = readInt();
        if(choix == 1) {
            println("Vous avez choisis: \"Ouvrir un document existant.\"");
        } else if(choix == 2) {
            println("Vous avez choisis: \"Créer un nouveau document.\"");
        } else if(choix == 3) {
            println("Vous avez choisis: \"Enregistrer le document courant\"");
        } else if(choix == 4) {
            println("Vous avez choisis: \"Quitter ce magnifique logiciel.\"");
        }
    }
}