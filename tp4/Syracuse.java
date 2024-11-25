class Syracuse extends Program {
    void algorithm() {
        int entier = readInt();
        int altitude = entier;
        int altitudeMax = entier;
        String trajectoire = "Trajectoire: ";
        int duree = 0;
        int dureeVolEnAltitude = 0;


        while(altitude !=1) {

            if((altitude%2) == 0) {
                altitude=altitude/2;
            } else {
                altitude=(altitude*3)+1;
            }

            if(altitude>altitudeMax) {
                altitudeMax=altitude;
            }
            if(altitude<entier) {
                dureeVolEnAltitude = dureeVolEnAltitude+1;
            }
            trajectoire = trajectoire+altitude+", ";
            duree=duree+1;
        }
        int facteurExpansion = altitudeMax/entier;
        println(trajectoire);
        println("Altitude max: "+altitudeMax);
        println("Durée de vol: "+duree);
        println("Durée de vol en altitude: "+dureeVolEnAltitude);
        println("Facteur d'expansion"+facteurExpansion);

    }
}