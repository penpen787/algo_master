package datastructure.map;

import org.junit.Assert;
import org.junit.Test;

public class SimpleHashMapTest {

    @Test
    public void putSomeValue() {
        SimpleHashMap<Integer, Integer> map = new SimpleHashMap<>();
        map.put(1,100);
        map.put(2,200);
        map.put(3,300);
        map.put(4,400);

        Assert.assertEquals(4, map.size());
    }

//    @Test
//    public void putSomeValue() {
//        SimpleHashMap<Integer, Integer> map = new SimpleHashMap<>();
//        map.put(1,100);
//        map.put(2,200);
//        map.put(3,300);
//        map.put(4,400);
//
//        Assert.assertEquals(4, map.size());
//    }

}
