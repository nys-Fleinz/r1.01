class Tri extends Program {

  void algorithm() {
    char c1, c2, c3, temp;
    c1 = readChar();
    c2 = readChar();
    c3 = readChar();

    if (c1 > c2) {
      temp = c1;
      c1 = c2;
      c2 = temp;
    }

    if (c2 > c3) {
      temp = c2;
      c2 = c3;
      c3 = temp;
    }

    if (c1 > c2) {
      temp = c1;
      c1 = c2;
      c2 = temp;
    }
    println("" + c1 + c2 + c3);
  }
}