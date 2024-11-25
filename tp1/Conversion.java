class Conversion extends Program {
	void algorithm(){
		final double COURS_LIVRE = 1.09;
		double bourse = COURS_LIVRE*59;
		bourse = bourse+42;
		println("Total: "+bourse+"€");
		println("Chacun: "+bourse/2+"€");
	}
}