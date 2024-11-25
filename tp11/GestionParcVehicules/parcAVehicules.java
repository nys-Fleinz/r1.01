class parcAVehicules extends Program {
    final int NB_MAX=100;

    Vehicule newVehicule (String modele, int annee) {
        Vehicule voiture = new Vehicule();
        voiture.modele=modele;
        voiture.annee=annee;
        return voiture;
    }

    String toString(Vehicule v) {
        return v.modele+" "+v.annee;
    }

    String toString(Parc parking) {
        String liste="";
        for(int i=0; i<parking.nbVehicules; i=i+1) {
            if(!equals(parking.vehicules[i].modele,"")) {
                liste=liste+parking.vehicules[i].modele+" "+parking.vehicules[i].annee+"\n";
            }
        }
        return liste;
    }
    
    void testToStringParc() {
        Parc p = newParcVide();
        Vehicule v1 = newVehicule("Yaris", 2020);
        Vehicule v2 = newVehicule("Touran", 2019);
        ajouterVehicule(p, v1);
        ajouterVehicule(p, v2);
        assertEquals("Yaris 2020\nTouran 2019\n", toString(p));
    }

    void testToStringVehicle() {
        assertEquals("Yaris 2020", toString(newVehicule("Yaris", 2020)));
    }

    Parc newParcVide() {
        Parc parc = new Parc();
        parc.vehicules = new Vehicule[NB_MAX];
        return parc;
    }

    boolean ajouterVehicule (Parc parking, Vehicule v) {
        boolean libre;
        if(parking.nbVehicules<NB_MAX) {
            parking.vehicules[parking.nbVehicules]=v;
            parking.nbVehicules=parking.nbVehicules+1;
            libre=true;
        } else {
            libre=false;
        }
        return libre;
    }

    int nbVoitures(Parc p, String modele) {
        int nombreDeVoitures=0;
        for(int i=0; i<p.nbVehicules; i=i+1) {
            if(equals(p.vehicules[i].modele,modele)) {
                nombreDeVoitures=nombreDeVoitures+1;
            }
        }
        return nombreDeVoitures;
    }

    boolean fusionParcs(Parc p1, Parc p2) {
        int compteur=p2.nbVehicules-1;
        boolean fusion=false;
        if(p1.nbVehicules<NB_MAX) {
            fusion=true;
        }
        while(p1.nbVehicules<NB_MAX && compteur>=0) {
            ajouterVehicule(p1, p2.vehicules[compteur]);
            p2.vehicules[compteur] = newVehicule("", 0);
            p2.nbVehicules=p2.nbVehicules-1;
            compteur=compteur-1;
        }
        return fusion;
    }

    void testFusionParc() {
        Parc parc1 = newParcVide();
        ajouterVehicule(parc1, newVehicule("Yaris", 2020));
        ajouterVehicule(parc1, newVehicule("Yaris", 2020));
        ajouterVehicule(parc1, newVehicule("Yaris", 2020));
        Parc parc2 = newParcVide();
        ajouterVehicule(parc2, newVehicule("Yaris", 2020));
        ajouterVehicule(parc2, newVehicule("Yaris", 2020));
        ajouterVehicule(parc2, newVehicule("Yaris", 2020));
        fusionParcs(parc1, parc2);
        println("\nParc 1:\n"+toString(parc1) +"----");
        println("\nParc 2:\n"+toString(parc2) +"----");
    }

    void suppressionVehicule(Parc p, Vehicule v) {
        int i=0;
        boolean supprime=false;
        while(i<p.nbVehicules && !supprime) {
            if(equals(p.vehicules[i].modele,v.modele) && p.vehicules[i].annee==v.annee) {
                for(int j=p.nbVehicules-1; j>i; i=i+1) {
                    p.vehicules[i]=p.vehicules[i+1];
                }
                p.vehicules[i] = newVehicule("", 0);
            } else {
                i=i+1;
            }
        }
    }


    void testSupressionVehicules() {
        Parc parc1 = newParcVide();
        ajouterVehicule(parc1, newVehicule("Yaris", 2020));
        ajouterVehicule(parc1, newVehicule("Renault", 2020));
        ajouterVehicule(parc1, newVehicule("Yaris", 2020));
        ajouterVehicule(parc1, newVehicule("Yaris", 2020));
        ajouterVehicule(parc1, newVehicule("Yaris", 2020));
        ajouterVehicule(parc1, newVehicule("Renault", 2020));
        suppressionVehicule(parc1, newVehicule("Renault", 2020));
        println(toString(parc1));
    }

}