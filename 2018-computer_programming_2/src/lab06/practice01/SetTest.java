package lab06.practice01;

import java.util.HashSet;

public class SetTest {

  public static void main(String[] args) {
    HashSet<String> set = new HashSet<String>();

    set.add("milk");
    set.add("bread");
    set.add("butter");
    set.add("cheese");
    set.add("ham");
    set.add("ham");

    System.out.println(set);
  }
}
