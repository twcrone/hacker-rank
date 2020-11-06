public class Fib {

  public static void main(String[] args) {
    int n = 10;
    for(int i = 1; i <= n; i++) {
      System.out.print(fib(i) + " ");
    }
  }

  private static int fib(int n) {
    if(n == 1 || n == 2) {
      return n;
    }
    return fib(n - 1) + fib(n - 2);
  }


}
