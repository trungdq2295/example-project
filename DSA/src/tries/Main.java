package tries;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    Tries tries = new Tries();
    tries.addNode("TrungNguyen");
    tries.addNode("Trang");

    List<String> list = tries.showSuggestion("Tr");
    list.forEach(System.out::println);
  }
}
