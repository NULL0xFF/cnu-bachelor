package lab08;

public class LinkedList<T> implements List<T> {

  private Node<T> head; // 첫 번쨰 노드를 가리키는 필드
  private Node<T> tail; // 마지막 노드를 가리키는 필드
  private int size = 0; // 리스트의 원소의 개수

  @Override
  public boolean add(int index, T element) {
    if (index < 0 || index > this.size) {
      throw new IndexOutOfBoundsException();
    }
    if (index == 0) {
      this.addFirst(element);
    } else {
      Node<T> temp1 = node(index - 1);
      Node<T> temp2 = temp1.next;
      Node<T> newNode = new Node<>(element);
      temp1.next = newNode;
      newNode.next = temp2;
      this.size++;
      if (newNode.next == null) {
        this.tail = newNode;
      }
    }
    return true;
  }

  @Override
  public boolean addFirst(T element) {
    Node<T> newNode = new Node<>(element);
    newNode.next = this.head;
    this.head = newNode;
    this.size++;
    if (this.head.next == null) {
      this.tail = this.head;
    }
    return true;
  }

  @Override
  public boolean addLast(T element) {
    if (this.isEmpty()) {
      this.addFirst(element);
    } else {
      Node<T> newNode = new Node<>(element);
      this.tail.next = newNode;
      this.tail = newNode;
      this.size++;
    }
    return true;
  }

  @Override
  public T remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    if (index == 0) {
      return removeFirst();
    }
    Node<T> temp = node(index - 1);
    Node<T> nodeToDelete = temp.next;
    temp.next = temp.next.next;
    T returnData = nodeToDelete.data;
    if (nodeToDelete == tail) {
      tail = temp;
    }
    nodeToDelete = null;
    size--;
    return returnData;
  }

  @Override
  public T removeFirst() {
    Node<T> temp = head;
    head = temp.next;
    T returnData = temp.data;
    temp = null;
    size--;
    return returnData;
  }

  @Override
  public T removeLast() {
    return remove(size - 1);
  }

  @Override
  public T set(int index, T element) {
//		Node<T> preNode = this.head;
//		if (preNode.next == null) {
//			this.head.data = element;
//			return null;
//		}
//		Node<T> aftNode;
//		Node<T> newNode = new Node<>(element);
//		Object obj;
//		for (int i = 0; i < index - 1; i++) {
//			preNode = preNode.next;
//		}
//		obj = preNode.next.data;
//		aftNode = preNode.next.next;
//		newNode.next = aftNode;
//		preNode.next = newNode;
//		return (T) obj;
    Node<T> tempNode = node(index);
    if (tempNode == null) {
      System.out.println("It was NULL");
      this.add(index, element);
      return null;
    }
    T tempData = tempNode.data;
    tempNode.data = element;
    return tempData;
  }

  @Override
  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    return node(index).data;
  }

  @Override
  public int indexOf(T element) {
    Node<T> temp = this.head;
    for (int i = 0; i < this.size; i++) {
      if (element.equals(temp.data)) {
        return i;
      }
      temp = temp.next;
    }
    return -1;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  // @Override
  public String toString() {
    // 리스트에 원소가 없으면 head가 null이다.
    if (head == null) {
      return "[]";
    }
    // head 노드를 temp로 참조
    Node<T> temp = head;
    StringBuilder str = new StringBuilder("[");
    while (temp.next != null) {
      // temp 다음 연결이 null이 아니면 while문 실행
      str.append(temp.data + ", ");
      temp = temp.next;
    }
    // 다음 연결이 null인 노드지만 노드에 데이터가
    // 있기에 str에 append해준다.
    str.append(temp.data);
    return new String(str + "]");
  }

  private Node<T> node(int index) {
    Node<T> x = this.head;
    for (int i = 0; i < index; i++) {
      x = x.next;
    }
    return x;
  }

  private class Node<E> {

    private E data; // 데이터가 저장될 필드
    private Node<E> next; // 다음 노드를 가리키는 필드

    public Node(E input) {
      this.data = input; // 데이터 저장
      this.next = null;
    }

    @Override
    public String toString() {
      // 노드의 데이터를 확인
      return String.valueOf(this.data);
    }
  }
}
