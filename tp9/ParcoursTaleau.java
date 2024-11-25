class parcoursTableau extends Program {
    void testRechercherPremiereOccurrence () {
        char[][] tab = new char[][]{{'a','b','c'},{'d','a','b'},{'a','e','d'}};
        assertArrayEquals(new int[]{0,1}, rechercherPremiereOccurrence(tab, 'b'));
        assertArrayEquals(new int[]{1,0}, rechercherPremiereOccurrence(tab, 'd'));
        assertArrayEquals(new int[]{2,1}, rechercherPremiereOccurrence(tab, 'e'));
        assertArrayEquals(new int[]{-1,-1}, rechercherPremiereOccurrence(tab, 'x'));
    }

    int[] rechercherPremiereOccurrence(char[] tab, char cara) {
        
    }
}