class Hanoi_63050212 {
  public static void main(String[] args) {
    int n = 6;
    hanoi(n, "A", "B", "C");
  }

  public static void hanoi(int n, String a, String b, String c) {
    if (n == 0) return;
        hanoi(n - 1, a, c, b); //from,cen,to
          System.out.println("move " + n + " : " + a + " -> " + b);
            hanoi(n - 1, c, b, a); //cen,to,from
  }
}