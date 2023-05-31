package homework13.person;

public class Person implements Comparable<Object> {

  // 필드 선언
  private final String name;
  private final double height;

  /**
   * Person 생성자
   *
   * @param name
   * @param height
   */
  public Person(String name, double height) {
    this.name = name;
    this.height = height;
  }

  /**
   * 배열의 height들 중의 가장 큰 수가 존재하는 배열 인덱스 연산 메소드
   *
   * @param array
   * @return
   */
  public static int getMaximum(Comparable<Object>[] array) {
    Person[] people = (Person[]) array;
    int maximumIndex = 0;
    for (int i = 0; i < array.length; i++) {
      if (people[maximumIndex].getHeight() < people[i].getHeight()) {
        maximumIndex = i;
      }
    }
    return maximumIndex;
  }

  /**
   * 배열의 height들 중의 가장 큰 수를 가지는 배열 인덱스의 name 접근 메소드
   *
   * @param people
   * @return
   */
  public static String getTallest(Person[] people) {
    return String.format("%s", people[Person.getMaximum(people)].name);
  }

  /**
   * name 접근자
   *
   * @return
   */
  public String getName() {
    return this.name;
  }

  /**
   * height 접근자
   *
   * @return
   */
  public double getHeight() {
    return this.height;
  }

  /**
   * height 비교 메소드
   */
  @Override
  public int compareTo(Object obj) {
    Person personObject = (Person) obj;
    if (this.height < personObject.height) {
      return -1;
    } else if (this.height > personObject.height) {
      return 1;
    } else {
      return 0;
    }
  }
}
