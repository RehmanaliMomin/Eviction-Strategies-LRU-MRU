import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LRU implements IEvictionPolicies{

    //Cache cache = new Cache();

    LinkedList<Integer> queue;
    int size;
    HashMap<Integer, Integer> map;

    public LRU(int size) {
        queue = new LinkedList<>();
        this.size = size;
        map = new HashMap<>();
    }

  
    public void insert(int key, int value) {

        if (map.containsKey(key)) {
            queue.remove(new Integer(key));
            queue.addFirst(new Integer(key));
            map.replace(key, value);
        } else {
            if (queue.size() == size) {
                map.remove(queue.pollLast());
                queue.addFirst(key);
            } else {
                queue.addFirst(key);
            }
            map.put(key, value);
        }
    }

   
    public int get(int key) {
        if (map.containsKey(key)) {
            queue.remove(new Integer(key));
            queue.addFirst(new Integer(key));
            return map.get(key);
        }
        return -1;
    }

   
    public List<Cache> stateOfCache() {
        List<Cache> list = new ArrayList();
        for(Integer i: queue ){
            list.add(new Cache(i,map.get(i)));
        }
        return list;
    }

}
