package lab07;

public class ArrayListTest {

  public static void main(String[] args) {

    List<Integer> list = new ArrayList<>(3);

    System.out.println(list.remove(0));
    System.out.println(list.remove(-100));
    System.out.println(list.remove(100));
    list.add(0, 1);
    //System.out.println(list.remove(0));
    System.out.println(list.remove(-100));
    System.out.println(list.remove(100));

    list.add(5, 100);
    System.out.println("List: " + list + "\nsize: " + list.size());
  }
}
