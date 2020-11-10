import java.util.List;

public interface IEvictionPolicies{

    public void insert(int key, int value);

    public int get(int key);

    public List<Cache> stateOfCache();

}