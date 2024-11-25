class Diviseurs extends Program {
    void algorithm() {
        int nombre = readInt();
        String phrase = "Diviseurs: ";
        int parfait = 0;

        for(int i = nombre; i>=1; i=i-1) {
            if((nombre%i)==0) {
                phrase = phrase+i+" ";
                parfait = parfait+i;
            }
        }
        println(phrase);
        if(parfait-nombre == nombre) {
            println("Nombre parfait!");
        }
    }
}