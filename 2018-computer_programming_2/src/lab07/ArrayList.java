package lab07;

public class ArrayList<E> implements List<E> {

  private static final int DEFAULT_CAPACITY = 10;
  private Object[] elementData;
  private int size = 0;

  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int size) {
    this.elementData = new Object[size];
  }

  @Override
  public boolean add(int index, E element) {
    if ((index > 0 && this.get(index - 1) == null) || index < 0) {
      return false;
    }
    for (int i = this.size - 1; i >= index; i--) {
      this.elementData[i + 1] = this.elementData[i];
    }
    this.elementData[index] = element;
    this.size++;
    return true;
  }

  @Override
  public boolean addFirst(E element) {
    return this.add(0, element);
  }

  @Override
  public boolean addLast(E element) {
    boolean FLAG = false;
    try {
      this.elementData[this.size] = element;
      this.size++;
      FLAG = true;
    } catch (ArrayIndexOutOfBoundsException e) {
      this.resize();
    } finally {
      if (FLAG == false) {
        this.elementData[this.size] = element;
        this.size++;
      }
    }
    return true;
  }

  @SuppressWarnings("unchecked")
  @Override
  public E remove(int index) {
    if (this.isEmpty() == true) {
      return null;
    }
    Object obj;
    try {
      obj = this.elementData[index];
    } catch (ArrayIndexOutOfBoundsException e) {
      return null;
    }
    for (int i = index + 1; i <= this.size - 1; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    this.size--;
    this.elementData[this.size] = null;
    return (E) obj;
  }

  @Override
  public E removeFirst() {
    return this.remove(0);
  }

  @Override
  public E removeLast() {
    return this.remove(this.size - 1);
  }

  @SuppressWarnings("unchecked")
  @Override
  public E set(int index, E element) {
    Object obj = this.get(index);
    this.add(index, element);
    this.remove(index + 1);
    return (E) obj;
  }

  @SuppressWarnings("unchecked")
  @Override
  public E get(int index) {
    return (E) this.elementData[index];
  }

  @Override
  public int indexOf(E element) {
    for (int i = 0; i < this.size; i++) {
      if (element.equals(this.elementData[i])) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder("[");
    for (int i = 0; i < this.size; i++) {
      str.append(this.elementData[i]);
      if (i < this.size - 1) {
        str.append(", ");
      }
    }
    str.append("]");
    return new String(str);
  }

  private void resize() {
    Object[] tempData = this.elementData;
    this.elementData = new Object[this.size * 2];
    for (int i = 0; i < tempData.length; i++) {
      this.elementData[i] = tempData[i];
    }
  }
}
