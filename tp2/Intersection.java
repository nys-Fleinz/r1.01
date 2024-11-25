class Intersection extends Program {
    void algorithm() {
        int borneInf1, borneSup1, borneInf2, borneSup2;
        int premier= 0;
        int deuxieme =0;

        print("Borne premier intervalle : ");
        borneInf1 = readInt();
        borneSup1 = readInt();
        print("Borne deuxième intervalle : ");
        borneInf2 = readInt();
        borneSup2 = readInt();

        if((borneInf1<borneInf2 && borneSup1<borneInf2) || (borneInf2<borneInf1 && borneSup2<borneInf1)) {
            print("VIDE");
        }
        if(borneInf2>borneSup1) {
            premier = borneInf2;
            deuxieme = borneSup1;
        }
        if(borneInf1>borneInf2) {
            premier = borneInf1;
            deuxieme = borneSup2;
        }

        println(premier + " " +deuxieme);

    }
}