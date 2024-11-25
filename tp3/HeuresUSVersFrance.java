class HeuresUSVersFrance extends Program {
    void algorithm() {
        println("heure: ");
        int heure = readInt();
        println("minutes: ");
        String minutes = readString();
        println("AM-PM: ");
        String ampm = readString();

        if(equals(ampm, "AM") && heure>=12) {
            heure=0;
        } else if(equals(ampm, "PM")) {
            heure=heure+12;
        }
        if(length(minutes)<2) {
            minutes = "0"+minutes;
        }
        println(heure+":"+minutes);

    }
}