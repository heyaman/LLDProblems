public class Main {
    public static void main(String[] args) {
        Cache<String,Integer>cache=new CustomCache(3, new LRUEvictionStrategy());
        cache.put("virat",50);
        cache.put("sachin",100);
        cache.put("abd",67);
        cache.put("rohit",90);
        cache.put("hardik",20);
        System.out.println(cache.get("abd"));



    }
}