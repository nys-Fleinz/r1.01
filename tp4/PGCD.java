class PGCD extends Program {
    void algorithm() {
        int a = readInt();
        int b = readInt();
        int r = 1;
        while(r!=0) {
            r=a%b;
            a=b;
            if(r!=0) {
                b=r;
            }
        }
        println("Le pgcd est "+b);
    }
}