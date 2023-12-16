import java.util.*;

public class LRUEvictionStrategy implements CacheEvictionStrategy {
    private final Map<Object, Node> map;
    Node head;
    Node tail;

    public LRUEvictionStrategy() {
        this.map = new HashMap<>();
    }

//     cache.put("virat",50);
//        cache.put("sachin",100);
//        cache.put("abd",67);
//        cache.put("rohit",90);
//        cache.put("hardik",20);

    @Override
    public void put(Object key, Object value, int maxSize) {
        Node node = map.get(key);
        if(node==null){
            if(map.size()>=maxSize){
                // here i need to remove least frequent used
                if(tail!=null){
                    Node prevTail=tail.prev;
                    map.remove(tail.keyData);
                    tail=prevTail;
                    tail.next=null;
                }
            }
        }else{
            Node prev=node.prev;
            Node next=node.next;
            prev.next=next;
            next.prev=prev;
        }
        node=new Node(key, value);
        node.next=head;
        if(head!=null){
            head.prev=node;

        }else{
            tail=node;
        }
        head=node;
        map.put(key,node);


    }

    @Override
    public Object get(Object key) {
        Node node = map.get(key);
        if (node == null) return node;
        Node prev = node.prev;
        if (prev != null) {
            prev.next = node.next;
        }
        Node next = node.next;
        if (next != null) {
            next.prev = prev;
        }
        node.next = head;
        head = node;
        node.prev = null;
        return node.valueData;
    }


    private class Node<K,V> {
        K keyData;
        V valueData;
        Node next;
        Node prev;

        public Node(K keyData, V valueData) {
            this.keyData=keyData;
            this.valueData = valueData;
            this.next = null;
            this.prev = null;
        }
    }
}
