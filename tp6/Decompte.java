class Decompte extends Program{

    void testGenereNombresPairs1() {
        assertEquals("8642", genereNombresPairs1(8));
        assertEquals("12108642", genereNombresPairs1(12));
        assertEquals("2", genereNombresPairs1(2));
    }

    void testGenereNombresPairs2() {
        assertEquals("*8642*", genereNombresPairs2(8));
        assertEquals("*12108642*", genereNombresPairs2(12));
        assertEquals("*2*", genereNombresPairs2(2));
    }

    void testGenereNombresPairs3() {
        assertEquals("8*6*4*2", genereNombresPairs3(8));
        assertEquals("12*10*8*6*4*2", genereNombresPairs3(12));
        assertEquals("2", genereNombresPairs3(2));
    }

    String genereNombresPairs1(int nbr){
        String result = "";
        for (int i = nbr; i>1; i=i-1){
            if (i%2 == 0) result = result + i;
        }
        return result;
    }

    String genereNombresPairs2(int nbr){
        String result = "*";
        for (int i = nbr; i>1; i=i-1){
            if (i%2 == 0) result = result + i;
        }
        result=result+'*';
        return result;
    }

    String genereNombresPairs3(int nbr){
        
        String result = "";
        for (int i = nbr; i>1; i--){
            if (i%2 == 0 && i>2) {
                result = result + i;
                result+='*';
            }
            else if (i%2 == 0 ) result = result + i;
        }
        return result;
    }
}