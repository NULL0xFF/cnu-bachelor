package homework07;

public interface Map {

  /**
   * If value!=null, then (key,value) is in this map.
   * <p>
   * If value==null, then no record in this map has the given key.
   *
   * @param key
   * @return value
   */
  Object get(Object key);

  /**
   * If oldValue==null, then (key,value) is in this map.
   * <p>
   * If oldValue!=null, then (key,oldValue) was in this map
   *
   * @param key
   * @param value
   * @return oldValue
   */
  Object put(Object key, Object value);

  /**
   * If oldValue==null, no record in this map has the given key.
   * <p>
   * If oldValue!=null, then (key,oldValue) was in this map
   *
   * @param key
   * @return oldValue
   */
  Object remove(Object key);

  /**
   * this map contains n records
   *
   * @return n
   */
  int size();
}
