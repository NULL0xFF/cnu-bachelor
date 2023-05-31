package lab08;

/**
 * 리스트 구현에 사용될 인터페이스
 *
 * @param <E>
 */
public interface List<E> {

  /**
   * 해당 index에 element를 삽입
   *
   * @param index
   * @param element
   * @return true
   */
  public boolean add(int index, E element);

  /**
   * 리스트 첫번째에 element를 삽입
   *
   * @param element
   * @return true
   */
  public boolean addFirst(E element);

  /**
   * 리스트 마지막에 element를 삽입
   *
   * @param element
   * @return true
   */
  public boolean addLast(E element);

  /**
   * 해당 index의 원소를 리턴 후에 제거
   *
   * @param index
   * @return 해당 index의 원소
   */
  public E remove(int index);

  /**
   * 리스트 첫번째의 원소를 리턴 후 제거
   *
   * @return 리스트의 첫번째 원소
   */
  public E removeFirst();

  /**
   * 리스트의 마지막 번쨰 원소를 리턴 후 제거
   *
   * @return 리스트의 마지막 원소
   */
  public E removeLast();

  /**
   * 리스트의 index 원소를 element로 변경
   *
   * @param index
   * @param element
   * @return 변경되기 전의 리스트의 원소
   */
  public E set(int index, E element);

  /**
   * 해당 index에 있는 값을 리턴
   *
   * @param index
   * @return 리스트의 해당하는 index의 원소
   */
  public E get(int index);

  /**
   * element에 해당하는 값이 있으면 그 값이 발견되는 첫번째 인덱스 값을 리턴 없으면 -1 리턴
   *
   * @param element
   * @return eement가 발견되는 첫번째 인덱스(없으면 -1을 리턴)
   */
  public int indexOf(E element);

  /**
   * 리스트의 크기를 리턴
   *
   * @return 리스트의 크기
   */
  public int size();

  /**
   * 리스트가 비어있는지 검사
   *
   * @return 배열에 원소가 없으면 true
   */
  public boolean isEmpty();
}
