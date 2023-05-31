package lab08;

public class LinkedListTest {

  public static void main(String[] args) {
    List<Integer> list = new LinkedList<>();
    System.out.println("list size: " + list.size());
    System.out.println("list isEmpty?: " + list.isEmpty());
    System.out.println("list: " + list.toString());

    for (int i = 5; i >= 0; i--) {
      list.addFirst(i);
    }
    for (int i = 11; i <= 15; i++) {
      list.addLast(i);
    }
    for (int i = 6; i <= 10; i++) {
      list.add(i, i);
    }
    System.out.println(list);

    List<Integer> list2 = new LinkedList<>();
    System.out.println(list2);

    System.out.println(list2.set(0, 1));
    System.out.println(list2);
    System.out.println(list2.set(1, 2));
    System.out.println(list2);
    System.out.println(list2.set(5, 6));
    System.out.println(list2);
  }
}
