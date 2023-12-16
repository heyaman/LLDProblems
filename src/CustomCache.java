public class CustomCache implements Cache{
    private final CacheEvictionStrategy cacheEvictionStrategy;
    private final int maxLimit;

    public CustomCache(int maxLimit, CacheEvictionStrategy cacheEvictionStrategy) {
        this.maxLimit=maxLimit;
        this.cacheEvictionStrategy = cacheEvictionStrategy;
    }

    @Override
    public void put(Object key, Object value) {
        this.cacheEvictionStrategy.put(key, value, maxLimit);

    }

    @Override
    public Object get(Object key) {
        return this.cacheEvictionStrategy.get(key);
    }
}
