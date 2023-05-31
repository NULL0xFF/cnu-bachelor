package lab06.practice01;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

  public static void main(String[] args) {
    Map<String, Student> st = new HashMap<>();

    st.put("201800001", new Student(201800001, "유비"));
    st.put("201800002", new Student(201800002, "관우"));
    st.put("201800003", new Student(201800003, "장비"));

    // 모든 항목을 출력
    System.out.println(st);

    // 하나의 항목을 삭제
    st.remove("201800002");

    // 하나의 항목을 대체
    st.put("201800003", new Student(201800003, "조자룡"));

    System.out.println(st.get("201800003"));

    for (Map.Entry<String, Student> s : st.entrySet()) {
      String key = s.getKey();
      Student value = s.getValue();
      System.out.println("key=" + key + ", value=" + value);
    }
  }
}

class Student {

  @SuppressWarnings("unused")
  private int number;
  private String name;

  public Student(int number, String name) {
    this.number = number;
    this.name = name;
  }

  public String toString() {
    return name;
  }
}
