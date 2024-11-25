class LettreAuHasard extends Program {
	void algorithm(){
		int alea = (int) (random() * 26);
		println("somme"+ alea);
		char lettre = (char)(alea+65);
		println(lettre);
	}
}