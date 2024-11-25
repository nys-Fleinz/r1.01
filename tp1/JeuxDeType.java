class JeuxDeType extends Program {
	void algorithm(){
		String prenom = "Alan";
		String nom = "Turing";
		int naissance = 1912;
		int annee = 2022;
		int age = annee - naissance;
		char initiale = charAt(prenom,0);
		println(initiale + ". " + nom + " aurait eu " + age + "ans en " + annee);
	}
}