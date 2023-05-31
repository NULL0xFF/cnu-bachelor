package homework07;

public class Entry {

  private final Object key;
  private Object value;

  public Entry(Object key, Object value) {
    this.key = key;
    this.value = value;
  }

  /**
   * Key is the first object in this ordered pair.
   *
   * @return key
   */
  public Object getKey() {
    return this.key;
  }

  /**
   * Value is the second object in this ordered pair.
   *
   * @return value
   */
  public Object getValue() {
    return this.value;
  }

  /**
   * Value is the second object in this ordered pair;
   *
   * @param value
   */
  public void setValue(Object value) {
    this.value = value;
  }
}
