class MajMin extends Program {
	void algorithm(){
		print("Entrez une lettre en minuscule");
		char lettreMin = readChar();
		char enMaj = (char)((int)lettreMin-('a'-'A')); // <- À COMPLÉTER
		println("La lettre " + lettreMin + " en majuscule donne : " + enMaj );
		print("Entrez une lettre en majuscule");
		char lettreMaj = readChar();
		char enMin = (char)((int)lettreMaj+32); // <- À COMPLÉTER
		println("La lettre " + lettreMaj + " en minuscule donne : " + enMin );
	}
}