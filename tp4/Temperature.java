class Temperature extends Program{
    void algorithm() {
        int rep = readInt();
        int max=rep;
        int min=rep;
        int total=rep;
        int compteur=1;

        while(rep != -273) {
            rep = readInt();
            if (rep!=-273) {
                if(rep>max) {
                    max = rep;
                } else if(rep<min) {
                    min = rep;
                }
                total=total+rep;
                println("total: "+total);
                compteur=compteur+1;
            }
        }
        
        println("MAX: "+max+"\nMIN: "+min+"\nMOYENNE: "+ total/compteur);
    }
}