import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Iterator;


public class HMTest {
    private static MyHashMap<Integer> map;
    private static MyHashMap<String> map2;
    private static MyHashMap<Double> map3;
    private static MyHashMap<Character> map4;
    private static MyHashMap<Integer> nullMap;


    @Test
    @DisplayName("Test constructor method")
    public void testConstructor() {
        nullMap = new MyHashMap<>(null, null);
        assertNull(nullMap.map.get(0));

        map = new MyHashMap<>("key", 1);
        assertEquals(1, map.size());

        map2 = new MyHashMap<>("key", "value");
        assertEquals(1, map2.size());

        map3 = new MyHashMap<>("key", 1.0);
        assertEquals(1, map3.size());

        map4 = new MyHashMap<>("key", 'a');
        assertEquals(1, map4.size());
    }

    @Test
    @DisplayName("Test put method")
    public void testPut() {
        nullMap = new MyHashMap<>(null, 1);
        assertNull(nullMap.map.get(0));
        nullMap.put(null, 2);
        assertNull(nullMap.map.get(0));

        map = new MyHashMap<>("key", 1);
        map.put("hello", 1);
        map.put("open", 3);
        assertEquals(3, map.size());
        map.put("open", 3);
        map.put("open", 4);
        assertEquals(5, map.size());

        map2 = new MyHashMap<>("key", "value");
        map2.put("key", "world");
        map2.put("open", "source");
        assertEquals(3, map2.size());
        map2.put("open", "source");
        map2.put("open", "source");
        assertEquals(5, map2.size());

        map3 = new MyHashMap<>("key", 1.0);
        map3.put("key", 2.0);
        map3.put("open", 3.0);
        assertEquals(3, map3.size());
        map3.put("open", 3.0);
        map3.put("open", 3.0);
        assertEquals(5, map3.size());

        map4 = new MyHashMap<>("key", 'a');
        map4.put("key", 'b');
        map4.put("open", 'c');
        assertEquals(3, map4.size());
        map4.put("open", 'c');
        map4.put("open", 'c');
        assertEquals(5, map4.size());

    }

    @Test
    @DisplayName("Test contains method")
    public void testContains() {
        nullMap = new MyHashMap<>(null, 1);
        assertTrue(nullMap.map.contains(null));
        nullMap.put(null, 2);
        assertTrue(nullMap.map.contains(null));

        map = new MyHashMap<>("key", 1);
        map.put("hello", 1);
        map.put("open", 3);
        map.put("open", 3);
        assertTrue(map.contains("hello"));
        assertTrue(map.contains("open"));
        assertTrue(map.contains("key"));
        assertFalse(map.contains("hello2"));

        map2 = new MyHashMap<>("key", "value");
        map2.put("key", "world");
        map2.put("open", "source");
        assertTrue(map2.contains("key"));
        assertTrue(map2.contains("open"));
        assertFalse(map2.contains("hello21"));

        map3 = new MyHashMap<>("key", 1.0);
        map3.put("key", 2.0);
        map3.put("open", 3.0);
        assertTrue(map3.contains("key"));
        assertTrue(map3.contains("open"));
        assertFalse(map3.contains("hello21"));

        map4 = new MyHashMap<>("key", 'a');
        map4.put("key", 'b');
        map4.put("open", 'c');
        assertTrue(map4.contains("key"));
        assertTrue(map4.contains("open"));
        assertFalse(map4.contains("hello21"));

    }

    @Test
    @DisplayName("Test size method")
    public void testSize() {
        nullMap = new MyHashMap<>(null, 1);
        assertEquals(0, nullMap.size());
        nullMap.put(null, 2);
        assertEquals(0, nullMap.size());

        map = new MyHashMap<>("key", 1);
        map.put("hello", 1);
        map.put("open", 3);
        assertEquals(3, map.size());
        map.put("open", 3);
        map.put("hello", 3);
        assertEquals(5, map.size());

        map2 = new MyHashMap<>("key", "value");
        map2.put("open", "world");
        map2.put("open", "source");
        map2.put("open", "source");
        assertEquals(4, map2.size());

        map3 = new MyHashMap<>("key", 1.0);
        map3.put("open", 2.0);
        map3.put("open", 3.0);
        map3.put("open", 3.0);
        assertEquals(4, map3.size());

        map4 = new MyHashMap<>("key", 'a');
        map4.put("open", 'b');
        map4.put("open", 'c');
        map4.put("open", 'c');
        assertEquals(4, map4.size());

    }

    @Test
    @DisplayName("Test isEmpty method")
    public void testIsEmpty() {
        map = new MyHashMap<>("key", null);
        assertFalse(map.isEmpty());
        map.put("hello", 1);
        map.put("open", 3);
        assertFalse(map.isEmpty());

        map2 = new MyHashMap<>("key", "value");
        assertFalse(map2.isEmpty());
        map2.put("open", "world");
        map2.put("open", "source");
        map2.put("open", "source");
        assertFalse(map2.isEmpty());

        map3 = new MyHashMap<>("key", 1.0);
        assertFalse(map3.isEmpty());
        map3.put("open", 2.0);
        map3.put("open", 3.0);
        map3.put("open", 3.0);
        assertFalse(map3.isEmpty());

        map4 = new MyHashMap<>("key", 'a');
        assertFalse(map4.isEmpty());
        map4.put("open", 'b');
        map4.put("open", 'c');
        map4.put("open", 'c');
        assertFalse(map4.isEmpty());

    }

    @Test
    @DisplayName("Test get method")
    public void testGet() {
        nullMap = new MyHashMap<>(null, 1);
        assertEquals(1, nullMap.get(null));
        nullMap.put(null, 2);
        assertEquals(2, nullMap.get(null));

        map = new MyHashMap<>("key", null);
        assertNull(map.get("key"));
        map.put("hello", 1);
        map.put("open", 3);
        map.put("open", 4);
        assertEquals(1, map.get("hello"));
        assertEquals(3, map.get("open"));
        assertEquals(3, map.get("open"));

        map2 = new MyHashMap<>("key", "value");
        map2.put("open", "world");
        map2.put("open", "source");
        map2.put("open", "source");
        assertEquals("value", map2.get("key"));
        assertEquals("world", map2.get("open"));
        assertEquals("world", map2.get("open"));

        map3 = new MyHashMap<>("key", 1.0);
        map3.put("open", 2.0);
        map3.put("open", 3.0);
        map3.put("open", 3.0);
        assertEquals(1.0, map3.get("key"));
        assertEquals(2.0, map3.get("open"));
        assertEquals(2.0, map3.get("open"));

        map4 = new MyHashMap<>("key", 'a');
        map4.put("open", 'b');
        map4.put("open", 'c');
        map4.put("open", 'c');
        assertEquals('a', map4.get("key"));
        assertEquals('b', map4.get("open"));
        assertEquals('b', map4.get("open"));

    }

    @Test
    @DisplayName("Test replace method")
    public void testReplace() {
        nullMap = new MyHashMap<>(null, 1);
        nullMap.replace(null, 2);
        assertNull(nullMap.get(null));

        map = new MyHashMap<>("key", 1);
        map.replace("key", 2);
        assertEquals(2, map.get("key"));
        map.put("hello", 1);
        map.replace("hello", 1);
        assertEquals(1, map.get("hello"));
        map.put("open", 3);
        map.put("open", 4);
        map.replace("open", 5);
        assertEquals(5, map.get("open"));

        map2 = new MyHashMap<>("key", "value");
        map2.replace("key", "world");
        assertEquals("world", map2.get("key"));
        map2.put("open", "world");
        map2.replace("open", "source");
        assertEquals("source", map2.get("open"));

        map3 = new MyHashMap<>("key", 1.0);
        map3.replace("key", 2.0);
        assertEquals(2.0, map3.get("key"));
        map3.put("open", 2.0);
        map3.replace("open", 3.0);
        assertEquals(3.0, map3.get("open"));

        map4 = new MyHashMap<>("key", 'a');
        map4.replace("key", 'b');
        assertEquals('b', map4.get("key"));
        map4.put("open", 'b');
        map4.replace("open", 'c');
        assertEquals('c', map4.get("open"));

    }

    @Test
    @DisplayName("Test forEach Loop")
    public void HMForEachLoopTest()
    {
        map = new MyHashMap<>("key1", 1);
        map.put("key3", 2);
        map.put("key2", 3);
        map.put("key2", 4);
        map.put("key2", 5);
        map.put("key2", 5);

        // list of key values 1, 2, 3, 4, 5, 5
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(5);

        for (Integer i : map) {
            assertTrue(list.contains(i));
            list.remove(i);
        }

        map2 = new MyHashMap<>("key1", "value1");
        map2.put("key3", "value2");
        map2.put("key2", "value3");
        map2.put("key2", "value4");
        map2.put("key2", "value5");
        map2.put("key2", "value5");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("value1");
        list2.add("value2");
        list2.add("value3");
        list2.add("value4");
        list2.add("value5");
        list2.add("value5");

        for (String i2 : map2) {
            assertTrue(list2.contains(i2));
            list2.remove(i2);
        }

        map3 = new MyHashMap<>("key1", 1.0);
        map3.put("key3", 2.0);
        map3.put("key3", 3.0);

        ArrayList<Double> list3 = new ArrayList<>();
        list3.add(1.0);
        list3.add(2.0);
        list3.add(3.0);

        for (Double i3 : map3) {
            assertTrue(list3.contains(i3));
            list3.remove(i3);
        }

        map4 = new MyHashMap<>("key1", 'a');
        map4.put("key3", 'b');
        map4.put("key3", 'c');

        ArrayList<Character> list4 = new ArrayList<>();
        list4.add('a');
        list4.add('b');
        list4.add('c');

        for (Character i4 : map4) {
            assertTrue(list4.contains(i4));
            list4.remove(i4);
        }

    }


    @Test
    @DisplayName("Test hasNextE constructor method")
    public void testHMIterator() {
        map = new MyHashMap<>("key", 5);
        Iterator<Integer> iterator1 = map.iterator();
        assertTrue(iterator1.hasNext());
        assertEquals(5, iterator1.next());
        assertFalse(iterator1.hasNext());

        map.put("key1", 6);
        map.put("key1", 6);
        map.put("key1", 7);

        map.put("key2", 7);

        Iterator<Integer> iterator2 = map.iterator();
        assertTrue(iterator2.hasNext());
        assertEquals(6, iterator2.next());
        assertTrue(iterator2.hasNext());
        assertEquals(6, iterator2.next());
        assertTrue(iterator2.hasNext());
        assertEquals(7, iterator2.next());
        assertTrue(iterator2.hasNext());
        assertEquals(7, iterator2.next());
        assertFalse(iterator2.hasNext());

        map2 = new MyHashMap<>("key", "value");
        Iterator<String> iterator3 = map2.iterator();
        assertTrue(iterator3.hasNext());
        assertEquals("value", iterator3.next());
        assertFalse(iterator3.hasNext());

        map2.put("key1", "value1");
        map2.put("key1", "value1");
        map2.put("key1", "value2");

        map2.put("key2", "value2");

        Iterator<String> iterator4 = map2.iterator();
        assertTrue(iterator4.hasNext());
        assertEquals("value1", iterator4.next());
        assertTrue(iterator4.hasNext());
        assertEquals("value1", iterator4.next());
        assertTrue(iterator4.hasNext());
        assertEquals("value2", iterator4.next());
        assertTrue(iterator4.hasNext());
        assertEquals("value2", iterator4.next());
        assertFalse(iterator4.hasNext());

        map3 = new MyHashMap<>("key", 1.0);
        Iterator<Double> iterator5 = map3.iterator();
        assertTrue(iterator5.hasNext());
        assertEquals(1.0, iterator5.next());
        assertFalse(iterator5.hasNext());

        map3.put("key1", 2.0);
        map3.put("key1", 2.0);
        map3.put("key1", 3.0);

        Iterator<Double> iterator6 = map3.iterator();
        assertTrue(iterator6.hasNext());
        assertEquals(2.0, iterator6.next());
        assertTrue(iterator6.hasNext());
        assertEquals(2.0, iterator6.next());
        assertTrue(iterator6.hasNext());
        assertEquals(3.0, iterator6.next());
        assertFalse(iterator6.hasNext());

        map4 = new MyHashMap<>("key", 'a');
        Iterator<Character> iterator7 = map4.iterator();
        assertTrue(iterator7.hasNext());
        assertEquals('a', iterator7.next());
        assertFalse(iterator7.hasNext());

        map4.put("key1", 'b');
        map4.put("key1", 'b');
        map4.put("key1", 'c');

        Iterator<Character> iterator8 = map4.iterator();
        assertTrue(iterator8.hasNext());
        assertEquals('b', iterator8.next());
        assertTrue(iterator8.hasNext());
        assertEquals('b', iterator8.next());
        assertTrue(iterator8.hasNext());
        assertEquals('c', iterator8.next());
        assertFalse(iterator8.hasNext());
    }

}
