import java.util.Arrays;
import java.util.List;

public class CacheEviction{

    public static void main(String[] args){

        int size = 5;

        IEvictionPolicies lru = new LRU(size);

        lru.insert(12, 21);

        foo(lru.stateOfCache());
        lru.get(12);
        lru.insert(83, 91);
        foo(lru.stateOfCache());
        lru.insert(16, 21);
        foo(lru.stateOfCache());
        lru.insert(132, 21);
        foo(lru.stateOfCache());
        lru.insert(127, 21);
        foo(lru.stateOfCache());
        lru.insert(935, 23);
        foo(lru.stateOfCache());
        lru.get(16);
        foo(lru.stateOfCache());
        lru.insert(832, 21);
        foo(lru.stateOfCache());
        lru.insert(93, 23);

    }

    static void foo(List<Cache> list){
        for(Cache c : list){
            System.out.print(c.key +" "+c.value +" , ");
        }
        System.out.println();
    }
  
}

