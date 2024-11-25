class FizzBuzz extends Program {
    void algorithm() {
        print("Nombre: ");
        int nombre = readInt();
        
        if(nombre%3 == 0 && nombre%5 != 0) {
            println("fizz");
        } else if(nombre%3 != 0 && nombre%5 == 0) {
            println("buzz");
        } else if(nombre%3 == 0 && nombre%5 ==0) {
            println("fizzbuzz");
        } else {
            println(nombre);
        }
    }
}