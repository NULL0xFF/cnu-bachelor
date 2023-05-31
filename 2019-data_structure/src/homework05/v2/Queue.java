package homework05.v2;

public interface Queue {

  /**
   * Adds the specified element to the back of this queue.
   *
   * @param object the element to be added to this queue.
   */
  void add(Object object);

  /**
   * Returns the element at the front of this queue.
   *
   * @return the element at the front of this queue.
   * @throws IllegalStateException if this queue is empty
   */
  Object first();

  /**
   * Removes and returns the element at the front of this queue.
   *
   * @return the element at the front of this queue.
   * @throws IllegalStateException if this queue is empty
   */
  Object remove();

  /**
   * Returns the number of elements in this queue.
   *
   * @return the number of elements in this queue.
   */
  int size();
}
