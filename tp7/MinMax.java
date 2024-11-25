class MinMax extends Program {
    void testMinMax() {
        assertArrayEquals(new int[]{1,3}, minMax(new int[]{2,1,3}));
        assertArrayEquals(new int[]{2,2}, minMax(new int[]{2,2,2}));
        assertArrayEquals(new int[]{-1,3}, minMax(new int[]{3,-1,2}));
    }

    void testMinMaxIndices() {
        assertArrayEquals(new int[]{1,2}, minMaxIndices(new int[]{2,1,3}));
        assertArrayEquals(new int[]{0,0}, minMaxIndices(new int[]{2,2,2}));
        assertArrayEquals(new int[]{1,0}, minMaxIndices(new int[]{3,-1,2}));
    }

    int[] minMax(int[] tab) {
        int[] result = new int[]{tab[0], tab[0]};
        for(int i=0; i<length(tab); i=i+1) {
            if(tab[i]>result[1]) {
                result[1]=tab[i];
            }
            if(tab[i]<result[0]) {
                result[0]=tab[i];
            }
        }
        return result;
    }
    int[] minMaxIndices(int[] tab) {
        int[] indices = new int[2];
        int[] result = new int[]{tab[0], tab[0]};
        for(int i=0; i<length(tab); i=i+1) {
            if(tab[i]>result[1]) {
                result[1]=tab[i];
                indices[1]=i;
            }
            if(tab[i]<result[0]) {
                result[0]=tab[i];
                indices[0]=i;
            }
        }
        return indices;
    }    
}