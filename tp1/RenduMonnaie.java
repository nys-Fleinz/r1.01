class RenduMonnaie extends Program {
	void algorithm(){
		int reste, nb20, nb10, nb5, nb2, nb1, somme;
		print("Quelle est le montant que vous souhaitez rendre en monnaie ?");
		somme = readInt();

		nb20 = somme/20;
		somme = somme%20;

		nb10 = somme/10;
		somme = somme%10;

		nb5 = somme/5;
		somme = somme%5;

		nb2 = somme/2;
		somme = somme%2;

		nb1 = somme/1;
		somme = somme%1;
		
		

		println("Nombre de billets de 20 : " + nb20);
		println("Nombre de billets de 10 : " + nb10);
		println("Nombre de billets de 5 : " + nb5);
		println("Nombre de pièces de 2 : " + nb2);
		println("Nombre de pièces de 1 : " + nb1);
	}
}