package lab06.practice02;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortTest {

  public static void main(String[] args) {
    Student array[] = {new Student(2018005, "김철수"), new Student(2018002, "이철수"),
        new Student(2018003, "박철수")};

    List<Student> list = Arrays.asList(array);
    Collections.sort(list);
    System.out.println(list);
  }
}

class Student implements Comparable<Student> {

  private int number;
  private String name;

  public Student(int number, String name) {
    this.number = number;
    this.name = name;
  }

  @Override
  public int compareTo(Student s) {
    return number - s.number;
  }

  public String toString() {
    return name;
  }
}