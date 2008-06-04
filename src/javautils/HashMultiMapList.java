package javautils;

import java.util.*;

/**
 * @author Sebastian Riedel
 */
public class HashMultiMapList<K, V> extends HashMap<K, List<V>> {
  protected List<V> emptyList = Collections.unmodifiableList(new ArrayList<V>(0));

  public void add(K key, V value) {
    List<V> list = get(key);
    if (list.size() == 0) {
      list = new LinkedList<V>();
      put(key, list);
    }
    list.add(value);
  }

  public HashMultiMapList<K, V> deepcopy() {
    HashMultiMapList<K, V> result = new HashMultiMapList<K, V>();
    for (Map.Entry<K, List<V>> entry : entrySet())
      result.put(entry.getKey(), new LinkedList<V>(entry.getValue()));
    return result;
  }


  public List<V> get(Object o) {
    List<V> result=  super.get(o);
    return result == null ? emptyList : result;
  }
}
