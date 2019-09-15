package datastructure.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class SimpleHashMapTest {
    SimpleHashMap<Integer, Integer> map;
    @Before
    public void setup() {
        map = new SimpleHashMap<>();
        map.put(1,100);
        map.put(2,200);
    }

    @Test
    public void putSomeValue() {
        map.put(3,300);
        map.put(4,400);

        Assert.assertEquals(4, map.size());
    }

    @Test
    public void get() {
        Assert.assertEquals(100, (int) map.get(1));
        Assert.assertEquals(200, (int) map.get(2));
        Assert.assertEquals(null, map.get(3));
    }

    @Test
    public void removeAndGet() {
        Assert.assertEquals(null, map.get(3));
        Assert.assertEquals(2, map.size());

        map.remove(1);
        Assert.assertEquals(null, map.get(1));
        Assert.assertEquals(200, (int) map.get(2));
        Assert.assertEquals(1, map.size());
    }

    @Test
    public void clear() {
        Assert.assertEquals(2, map.size());
        map.clear();
        Assert.assertEquals(0, map.size());
    }

    @Test
    public void keySet() {
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            System.out.println("Key : " + key);
        }
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(map.isEmpty() == false);
        map.clear();
        Assert.assertTrue(map.isEmpty());
    }

}
