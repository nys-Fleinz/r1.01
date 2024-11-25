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
            liste=liste+parking.vehicules[i].modele+" "+parking.vehicules[i].annee+"\n";
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
        for(int i=0; i<p.nbVehicules; i=i+1) {
            
        }
    }
}