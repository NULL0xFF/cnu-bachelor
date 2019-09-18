package hw13.person;

public class TestPerson {

	public static void main(String[] args) {
		Person[] array = new Person[10];

		array[0] = new Person("김민규", 170.0);
		array[1] = new Person("이정희", 156.3);
		array[2] = new Person("홍인규", 193.2);
		array[3] = new Person("최인석", 177.3);
		array[4] = new Person("문보람", 171.4);
		array[5] = new Person("김휘웅", 172.3);
		array[6] = new Person("장호웅", 182.9);
		array[7] = new Person("이석휘", 176.1);
		array[8] = new Person("김준용", 184.8);
		array[9] = new Person("신일구", 188.3);

		System.out.println("배열에 저장된 사람들");
		for (Person p : array)
			System.out.println(p.getName() + ", 키: " + p.getHeight());

		System.out.print("\n가장 키가 큰 사람: " + Person.getTallest(array));

	}
}