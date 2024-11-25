class DessineIUT extends Program {
    void algorithm() {
        print("Taille: ");
        int n = readInt();
        print("Char: ");
        char c = readChar();
        
        I(n, c);
        U(n, c);
        T(n, c);

        L(n, c);
        I(n, c);
        L(n, c);
        L(n, c);
        E(n, c);

    }

    //LETTRES
    void I(int n, char c) {
        dessineLigne(n, c);
        dessineMilieu(n, c, n-2);
        dessineLigne(n, c);
        println();
    }

    void U(int n, char c) {
        dessineExtremite(n, c, n-1);
        dessineLigne(n, c);
        println();
    }

    void T(int n, char c) {
        dessineLigne(n, c);
        dessineMilieu(n, c, n-1);
        println();
    }

    void L(int n, char c) {
        dessineGauche(n, c, n-1);
        dessineLigne(n, c);
        println();
    }

    void E(int n, char c) {
        dessineLigne(n, c);
        dessineGauche(n, c, (n-3)/2);
        dessineLigne(n, c);
        dessineGauche(n, c, (n-3)/2);
        dessineLigne(n, c);
        println();
    }



    //DESSINER
    void dessineGauche(int n, char c, int l) {
        for(int i=0; i<l; i=i+1) {
            println(c);
        }
    }

    void dessineLigne(int n, char c) {
        for (int i=0; i<n; i=i+1) {
        print(c);
        }
        println();
    }

    void dessineMilieu(int n, char c, int l) {
        String ligne = "";
        for(int i=0; i < (n/2); i=i+1) {
            ligne = ligne +" ";
        }
        ligne=ligne+c;
        for(int i=0; i<l; i=i+1) {
            println(ligne);
        }
    }

    void dessineExtremite(int n, char c, int l) {
        String ligne = ""+c;
        for(int i=0; i+2<n; i=i+1) {
            ligne=ligne+" ";
        }
        ligne=ligne+c;
        for(int i=0; i<l; i=i+1) {
            println(ligne);
        }
    }

}