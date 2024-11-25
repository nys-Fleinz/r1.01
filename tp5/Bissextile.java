class Bissextile extends Program {
    void algorithm() {

        for(int i=1887; i<2022; i=i+1) {
            if(estBissextile(i)) {
                print(i+" ");
            }
        }
    }

    boolean estBissextile(int annee) {
        if((annee%100) == 0) {
            if((annee%400) == 0) {
                return true;
            }
            return false;
        } else if((annee%4)==0) {
            return true;
        }
        return false;
    }
}