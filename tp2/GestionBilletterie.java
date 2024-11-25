class GestionBilletterie extends Program{
    void algorithm() {
        double tarif = 12;
        print("Age: ");
        int age = readInt();
        print("Option 3D ? (1 si oui, autre nombre si non): ");
        int troisD = readInt();
        print("Abonné ? (1 si oui, autre nombre si non): ");
        int abonne = readInt();

        if(age<=10) {
            tarif = tarif/2;
        } else if(age<=16 || age>=60) {
            tarif = tarif-3;
        }
        if(troisD == 1) {
            tarif = tarif+2;
        }
        if(abonne == 1) {
            tarif = tarif*0.8;
        }
        println("Prix à payer: "+tarif+"€");
    }
}