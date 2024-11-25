class Saisons extends Program {
    String saisonMeteorologique (int mois) {
        if(mois<1 || mois >12) {
            return "erreur";
        } else if(mois==12 || mois<=2) {
            return "hiver";
        } else if(mois<=5) {
            return "printemps";
        } else if(mois<=8){
            return "été";
        } else if(mois<=11) {
            return "automne";
        }
        return "erreur";
    }
    void algorithm () {
        int jours=0;
        for (int m=0;m<=13;m=m+1){
            println("mois " + m + " : " + saisonMeteorologique(m)+", "+nombreJoursMois(m)+" jours");
            jours = jours+nombreJoursMois(m);
        }
        println("nombre de jours total : "+jours);
    }
    int nombreJoursMois(int numeroMois) {
        //30: 4 6 9 11
        //28: 2
        //31: 1 3 5 7 8 10 12
        if(numeroMois==4 || numeroMois==6 || numeroMois==9 || numeroMois==11) {
            return 30;
        } else if(numeroMois==2) {
            return 28;
        } else if(numeroMois==1 || numeroMois==3 || numeroMois==5 || numeroMois==7 || numeroMois==8 || numeroMois==10 || numeroMois==12) {
            return 31;
        } else {
            return 0;
        }
    }
}