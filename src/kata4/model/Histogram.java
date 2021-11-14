package kata4.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import static javafx.scene.input.KeyCode.T;

public class Histogram <T>{
    private final Map <T,Integer> map = new HashMap<T, Integer>();
    
    public int get(T key){
        int n = map.get(key);
        return n;
    }
    
    public Set<T> keySet(){
        return map.keySet();
    }
    public void increment(T key){
        map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
    }
}
