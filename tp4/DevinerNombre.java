class DevinerNombre extends Program{
    void algorithm() {
        String rep = "";
        int borneInf = 1;
        int borneSup = 100;
        int guess = 50;
        while(!equals(rep, "=")) {
            println("Est-ce que le nombre est "+guess+" ?");
            rep = readString();
            if(equals(rep, "+")) {
                borneInf = guess;
            }
            if(equals(rep, "-")) {
                borneSup = guess;
            }
            guess=(borneInf+borneSup)/2;
        }
    }
}