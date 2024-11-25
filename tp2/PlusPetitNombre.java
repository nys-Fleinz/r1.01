class PlusPetitNombre extends Program {
    void algorithm() {
        print("Nombre 1: ");
        int nombre1 = readInt();
        print("Nombre 2: ");
        int nombre2 = readInt();

        if(nombre1>nombre2) {
            println(nombre2+" est le plux petit nombre.");
        } else {
            println(nombre1+ "est le plus petit nombre.");
        }
    }
}