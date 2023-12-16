public interface CacheEvictionStrategy<K,V> {

    public void put(K key, V value, int maxSize);
    public V get(K key);
}
