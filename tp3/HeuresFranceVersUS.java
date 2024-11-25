class HeuresFranceVersUS extends Program {
    void algorithm() {
        println("heure: ");
        int heure = readInt();
        println("minutes: ");
        String minutes = readString();
        String ampm = "";

        if(heure<=12) {
            ampm = "AM";
        } else {
            heure = heure-12;
            ampm = "PM";
        }
        if(heure ==0) {
            heure = 12;
        }
        println(heure+":"+minutes+" "+ampm);
    }
}