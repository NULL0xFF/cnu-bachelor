package homework06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class StringOneHotTest {

  public static void main(String[] args) {
    String str = "Hello";
    StringOneHot soh = new StringOneHot(str);
    System.out.println("문자열 :" + soh.getString());
    System.out.println("문자열 Set:" + soh.getStrSet());
    System.out.println("문자열 Map:" + soh.getStrMap());
    System.out.println("문자열 One-hot Vector:" + soh.getStrOneHotVec());

    System.out.println("One-hot Vector로 나타낸 " + soh.getString());
    for (int i = 0; i < str.length(); i++) {
      // System.out.println(soh.getStrOneHotVec().get(str.substring(i, i + 1)));
    }
  }

}

class StringOneHot {

  private String str;
  private HashSet<Character> set = new HashSet<Character>();
  private Map<Integer, Character> map = new HashMap<>();
  private Vector<Character> vec = new Vector<>();

  public StringOneHot(String str) {
    this.str = str;

    for (int i = 0; i < str.length(); i++) {
      this.set.add(str.charAt(i));
    }

    Iterator<Character> e = set.iterator();
    Character c = null;
    for (int i = 0; e.hasNext(); i++) {
      c = e.next();
      this.map.put(i, c);
      this.vec.add(i, c);
    }

    System.out.println(vec.size());
    System.out.println(vec.toArray());

//		e = set.iterator();
//		for (Vector v = new Vector(); e.hasNext();) {
//			this.oHV.put(e.next(), v);
//		}

  }

  public String getString() {
    return this.str;
  }

  public HashSet<Character> getStrSet() {
    return this.set;
  }

  public Map<Integer, Character> getStrMap() {
    return this.map;
  }

  public Vector<Character> getStrOneHotVec() {
    return this.vec;
  }
}