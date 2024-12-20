package hash.table;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    HashTable hashTable = new HashTable();
    hashTable.set("abc", 3);
    hashTable.set("abcx", 4);
    hashTable.set("abc8", 9);
    hashTable.set("abc", 7);
    hashTable.printTable();
    System.out.println(Arrays.toString(hashTable.keys().toArray()));
  }
}
