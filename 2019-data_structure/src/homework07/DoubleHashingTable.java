package homework07;

public class DoubleHashingTable implements Map {

  private final Entry NIL = new Entry(null, null);
  private final float loadFactor;
  private Entry[] entries;
  private int size, used, rehashed;

  public DoubleHashingTable(int capacity, float loadFactor) {
    this.entries = new Entry[capacity];
    this.loadFactor = loadFactor;
  }

  public DoubleHashingTable(int capacity) {
    this(capacity, 0.75F);
  }

  public DoubleHashingTable() {
    this(101);
  }

  private int hash(Object key) {
    return (key.hashCode() & 0x7FFFFFFF) % entries.length;
  }

  private int nextProbe(int h, int i) {
    return (h + i) % entries.length;
  }

  private void rehash() {
    Entry[] oldEntries = this.entries;
    this.entries = new Entry[2 * oldEntries.length + 1];
    for (int k = 0; k < oldEntries.length; k++) {
      Entry entry = oldEntries[k];
      if (entry == null || entry == this.NIL) {
        continue;
      }
      int h = hash(entry.getKey());
      for (int i = 0; i < this.entries.length; i++) {
        int j = nextProbe(h, i);
        System.out.printf("REHASH PROBE  : %d\n", j);
        if (this.entries[j] == null) {
          this.entries[j] = entry;
          break;
        }
      }
    }
    this.used = this.size;
    this.rehashed++;
    System.out.printf("DOUBLE REHASH : %d\n", this.rehashed); // XXX TEST CODE
  }

  @Override
  public Object get(Object key) {
    int h = this.hash(key);
    for (int i = 0; i < this.entries.length; i++) {
      int j = this.nextProbe(h, i);
      Entry entry = this.entries[j];
      if (entry == null) {
        break;
      }
      if (entry == NIL) {
        continue;
      }
      if (entry.getKey().equals(key)) {
        return entry.getValue();
      }
    }
    return null; // failure: key not found
  }

  @Override
  public Object put(Object key, Object value) {
    if (this.used > this.loadFactor * this.entries.length) {
      System.out.printf("REHASH WORD   : %s\n", key);
      this.rehash();
    }
    int h = this.hash(key);
    for (int i = 0; i < this.entries.length; i++) {
      int j = this.nextProbe(h, i);
      Entry entry = this.entries[j];
      if (entry == null) {
        this.entries[j] = new Entry(key, value);
        this.size++;
        this.used++;
        return null; // insertion success
      }
      if (entry == NIL) {
        continue;
      }
      if (entry.getKey().equals(key)) {
        Object oldValue = entry.getValue();
        this.entries[j].setValue(value);
        return oldValue;
      }
    }
    return null; // failure: table overflow
  }

  @Override
  public Object remove(Object key) {
    int h = this.hash(key);
    for (int i = 0; i < this.entries.length; i++) {
      int j = this.nextProbe(h, i);
      Entry entry = this.entries[j];
      if (entry == null) {
        break;
      }
      if (entry == NIL) {
        continue;
      }
      if (entry.getKey().equals(key)) {
        Object oldValue = entry.getValue();
        this.entries[j] = NIL;
        size--;
        return oldValue; // success
      }
    }
    return null; // failure: key not found
  }

  @Override
  public int size() {
    return this.size;
  }
}
