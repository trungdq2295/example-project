// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
  public static void main(String[] args) {
//        // Press Alt+Enter with your caret at the highlighted text to see how
//        // IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
//        for (int i = 1; i <= 5; i++) {
//
//            // Press Shift+F9 to start debugging your code. We have set one breakpoint
//            // for you, but you can always add more by pressing Ctrl+F8.
//            System.out.println("i = " + i);
//        }

    System.out.println(fib(3));
  }

  private static int fib(int n) {
    int[] fbList = new int[n + 1];
    fbList[0] = 0;
    fbList[1] = 1;
    for (int i = 2; i <= n; i++) {
      fbList[i] = fbList[i - 1] + fbList[i-2];
    }
    return fbList[n];
  }
}