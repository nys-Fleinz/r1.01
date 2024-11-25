class Cercle extends Program{

    final double PI = 3.14159;
    int multiplication = 0;

    double circonference(double rayon) {
        multiplication++;
        return PI * diametre(rayon);
    }
    double diametre(double rayon) {
        multiplication++;
        return 2 * rayon;
    }
    double aire(double rayon) {
        multiplication +=2;
        return PI * rayon * rayon;
    }
    double volume(double rayon){
        multiplication++;
        return 4.0/3.0 * aire(rayon);
    }

    void algorithm(){

        for(int i = 1; i<16; i++){
            println("\nCercle de rayon : " + i);
            println("Circonference : " + circonference(i));
            println("Aire : " + aire(i));
            println("Volume : " + volume(i));
        }

        println("Nombre de multiplications : " + multiplication);
    }
}