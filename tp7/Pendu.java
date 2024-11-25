class Pendu extends Program {
    void algorithm() {
        print("Mot à fair deviner: ");
        String motADeviner = readString();
        String mot="abc";
        String lettre;
        String trouve="*";
        boolean vf=false;
        // println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        int essais = 5;
        while(essais>0 && mot !=motADeviner) {
            print("Il vous reste "+essais+" tentatives: ");

            for(int i=0; i<length(motADeviner); i=i+1) {
                for(int j=0; j<length(mot); j=j+1) {
                    if(charAt(motADeviner, i)==charAt(mot, j)) {
                        trouve= ""+charAt(mot, j);
                    }
                }
                print(trouve+" ");
                if(trouve!="*") {
                    vf=true;
                    trouve="*";
                }
            }

            if(vf=false) {
                println("faux");
                essais=essais-1;
            } else {
                println("vrai");
                vf=false;
            }
            println("\nVotre lettre: ");
            lettre=readString();
            mot=mot+lettre;
        }
    }
}