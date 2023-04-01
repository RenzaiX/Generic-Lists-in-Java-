import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Iterator;

public class GQTest {
    private static GenericList<Integer> list;
    private static GenericQueue<Integer> queue;

    private static GenericList<String> list2;
    private static GenericQueue<String> queue2;

    private static GenericList<Double> list3;
    private static GenericQueue<Double> queue3;

    private static GenericList<Character> list4;
    private static GenericQueue<Character> queue4;


    @Test
    @DisplayName("Test add method")
    public void testAdd() {
        list = new GenericQueue<>(0);                       // 1 element
        assertEquals(1, list.getLength());
        for(int i = 1; i < 10; i++) {                           // +9 elements
            list.add(i);
        }
        assertEquals(10, list.getLength());

        list2 = new GenericQueue<>("hello");
        assertEquals(1, list2.getLength());
        for(int i = 1; i < 10; i++) {
            list2.add("hello");
        }
        assertEquals(10, list2.getLength());

        list3 = new GenericQueue<>(1.0);
        assertEquals(1, list3.getLength());
        for(int i = 1; i < 10; i++) {
            list3.add(1.0);
        }
        assertEquals(10, list3.getLength());

        list4 = new GenericQueue<>('a');
        assertEquals(1, list4.getLength());
        for(int i = 1; i < 10; i++) {
            list4.add('a');
        }
        assertEquals(10, list4.getLength());
    }

    @Test
    @DisplayName("Test add method with code")
    public void testAddWithCode() {
        queue = new GenericQueue<>(0);
        queue.add(1, 1);
        assertEquals(1, queue.getHead().next.code);
        assertEquals(1, queue.getHead().next.data);

        queue2 = new GenericQueue<>("hello");
        queue2.add("world", 1);
        assertEquals(1, queue2.getHead().next.code);
        assertEquals("world", queue2.getHead().next.data);

        queue3 = new GenericQueue<>(1.0);
        queue3.add(2.0, 1);
        assertEquals(1, queue3.getHead().next.code);
        assertEquals(2.0, queue3.getHead().next.data);

        queue4 = new GenericQueue<>('a');
        queue4.add('b', 1);
        assertEquals(1, queue4.getHead().next.code);
        assertEquals('b', queue4.getHead().next.data);

    }

    @Test
    @DisplayName("Test delete method")
    public void testDelete() {
        list = new GenericQueue<>(1);
        list.add(2);
        list.add(3);
        list.delete();
        assertEquals(2, list.getLength());
        for(int i = 0; i <= list.getLength(); i++) {
            list.delete();
        }
        assertEquals(0, list.getLength());

        list2 = new GenericQueue<>("hello");
        list2.add("world");
        list2.add("open");
        list2.delete();
        assertEquals(2, list2.getLength());
        for(int i = 0; i <= list2.getLength(); i++) {
            list2.delete();
        }
        assertEquals(0, list2.getLength());

        list3 = new GenericQueue<>(1.0);
        list3.add(2.0);
        list3.add(3.0);
        list3.delete();
        assertEquals(2, list3.getLength());
        for(int i = 0; i <= list3.getLength(); i++) {
            list3.delete();
        }
        assertEquals(0, list3.getLength());

        list4 = new GenericQueue<>('a');
        list4.add('b');
        list4.add('c');
        list4.delete();
        assertEquals(2, list4.getLength());
        for(int i = 0; i <= list4.getLength(); i++) {
            list4.delete();
        }
        assertEquals(0, list4.getLength());
    }

    @Test
    @DisplayName("Test get method")
    public void testGet() {
        list = new GenericQueue<>(1);
        list.add(2);
        list.add(3);

        assertEquals(2, list.get(1));
        for(int i = 0; i < list.getLength(); i++) {
            assertEquals(i+1, list.get(i));
        }

        list2 = new GenericQueue<>("hello");
        list2.add("world");
        list2.add("open");

        assertEquals("world", list2.get(1));
        assertEquals("hello", list2.get(0));
        assertEquals("open", list2.get(2));

        list3 = new GenericQueue<>(1.0);
        list3.add(2.0);
        list3.add(3.0);

        assertEquals(2.0, list3.get(1));
        assertEquals(1.0, list3.get(0));
        assertEquals(3.0, list3.get(2));

        list4 = new GenericQueue<>('a');
        list4.add('b');
        list4.add('c');

        assertEquals('b', list4.get(1));
        assertEquals('a', list4.get(0));
        assertEquals('c', list4.get(2));


    }

    @Test
    @DisplayName("Test set method")
    public void testSet() {
        list = new GenericQueue<>(1);
        list.add(2);
        list.add(3);
        list.set(1, 4);
        assertEquals(4, list.get(1));
        for(int i = 0; i < list.getLength(); i++) {
            list.set(i, i);
            assertEquals(i, list.get(i));
        }

        list2 = new GenericQueue<>("hello");
        list2.add("world");
        list2.add("open");
        list2.set(1, "new");
        assertEquals("new", list2.get(1));

        list3 = new GenericQueue<>(1.0);
        list3.add(2.0);
        list3.add(3.0);
        list3.set(1, 4.0);
        assertEquals(4.0, list3.get(1));

        list4 = new GenericQueue<>('a');
        list4.add('b');
        list4.add('c');
        list4.set(1, 'd');
        assertEquals('d', list4.get(1));

    }

    @Test
    @DisplayName("Test dumplist method")
    public void testDumplist() {
        list = new GenericQueue<>(1);
        ArrayList<Integer> list5 = new ArrayList<Integer>();
        list.add(2);
        list.add(3);
        list5 = list.dumplist();
        for(int i = 0; i < list.getLength(); i++) {
            assertEquals(i+1, list5.get(i));
        }

        list2 = new GenericQueue<>("hello");
        ArrayList<String> list6 = new ArrayList<String>();
        list2.add("world");
        list2.add("open");
        list6 = list2.dumplist();
        assertEquals("hello", list6.get(0));
        assertEquals("world", list6.get(1));
        assertEquals("open", list6.get(2));

        list3 = new GenericQueue<>(1.0);
        ArrayList<Double> list7 = new ArrayList<Double>();
        list3.add(2.0);
        list3.add(3.0);
        list7 = list3.dumplist();
        assertEquals(1.0, list7.get(0));
        assertEquals(2.0, list7.get(1));
        assertEquals(3.0, list7.get(2));

    }

    @Test
    @DisplayName("Test getLength method")
    public void testGetLength() {
        list = new GenericQueue<>(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.getLength());
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(13, list.getLength());

        list2 = new GenericQueue<>("hello");
        list2.add("world");
        list2.add("open");
        assertEquals(3, list2.getLength());
        for (int i = 0; i < 10; i++) {
            list2.add("hello");
        }
        assertEquals(13, list2.getLength());

        list3 = new GenericQueue<>(1.0);
        list3.add(2.0);
        list3.add(3.0);
        assertEquals(3, list3.getLength());
        for (int i = 0; i < 10; i++) {
            list3.add(1.0);
        }
        assertEquals(13, list3.getLength());

        list4 = new GenericQueue<>('a');
        list4.add('b');
        list4.add('c');
        assertEquals(3, list4.getLength());
        for (int i = 0; i < 10; i++) {
            list4.add('a');
        }
        assertEquals(13, list4.getLength());
    }

    @Test
    @DisplayName("Test setLength method")
    public void testSetLength() {
        list = new GenericQueue<>(1);
        list.add(2);
        list.add(3);
        list.setLength(4);
        assertEquals(4, list.getLength());
        for (int i = 0; i < 10; i++) {
            list.setLength(i);
            assertEquals(i, list.getLength());
        }

        list2 = new GenericQueue<>("hello");
        list2.add("world");
        list2.add("open");
        list2.setLength(4);
        assertEquals(4, list2.getLength());
        for (int i = 0; i < 10; i++) {
            list2.setLength(i);
            assertEquals(i, list2.getLength());
        }

        list3 = new GenericQueue<>(1.0);
        list3.add(2.0);
        list3.add(3.0);
        list3.setLength(4);
        assertEquals(4, list3.getLength());
        for (int i = 0; i < 10; i++) {
            list3.setLength(i);
            assertEquals(i, list3.getLength());
        }

        list4 = new GenericQueue<>('a');
        list4.add('b');
        list4.add('c');
        list4.setLength(4);
        assertEquals(4, list4.getLength());
        for (int i = 0; i < 10; i++) {
            list4.setLength(i);
            assertEquals(i, list4.getLength());
        }

    }

    @Test
    @DisplayName("Test getHead method")
    public void testGetHead() {
        list = new GenericQueue<>(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.getHead().data);

        list2 = new GenericQueue<>("hello");
        list2.add("world");
        list2.add("open");
        assertEquals("hello", list2.getHead().data);

        list3 = new GenericQueue<>(1.0);
        list3.add(2.0);
        list3.add(3.0);
        assertEquals(1.0, list3.getHead().data);

        list4 = new GenericQueue<>('a');
        list4.add('b');
        list4.add('c');
        assertEquals('a', list4.getHead().data);
    }

    @Test
    @DisplayName("Test setHead method")
    public void testSetHead() {
        GenericList<Integer>.Node<Integer> node = queue.new Node<Integer>(1);
        list = new GenericQueue<>(5);
        list.add(2);
        list.setHead(node);
        assertEquals(1, list.getHead().data);

        GenericList<String>.Node<String> node2 = queue2.new Node<String>("hello");
        list2 = new GenericQueue<>("world");
        list2.add("open");
        list2.setHead(node2);
        assertEquals("hello", list2.getHead().data);


    }



    @Test
    @DisplayName("Test GenericQueue constructor")
    public void testGenericQueue() {
        queue = new GenericQueue<Integer>(1);
        assertEquals(1, queue.getLength());

        queue2 = new GenericQueue<String>("hello");
        assertEquals("hello", queue2.getHead().data);

        queue3 = new GenericQueue<Double>(1.0);
        assertEquals(1.0, queue3.getHead().data);

        queue4 = new GenericQueue<Character>('a');
        assertEquals('a', queue4.getHead().data);

    }

    @Test
    @DisplayName("Test enqueue method")
    public void testEnqueue() {
        queue = new GenericQueue<Integer>(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.getLength());
        for(int i = 0; i < 10; i++) {
            queue.enqueue(i);
            assertEquals(i+4, queue.getLength());
        }

        queue2 = new GenericQueue<String>("hello");
        queue2.enqueue("world");
        queue2.enqueue("open");
        assertEquals(3, queue2.getLength());
        for(int i = 0; i < 10; i++) {
            queue2.enqueue("hello");
            assertEquals(i+4, queue2.getLength());
        }

        queue3 = new GenericQueue<Double>(1.0);
        queue3.enqueue(2.0);
        queue3.enqueue(3.0);
        assertEquals(3, queue3.getLength());
        for(int i = 0; i < 10; i++) {
            queue3.enqueue(1.0);
            assertEquals(i+4, queue3.getLength());
        }

        queue4 = new GenericQueue<Character>('a');
        queue4.enqueue('b');
        queue4.enqueue('c');
        assertEquals(3, queue4.getLength());
        for(int i = 0; i < 10; i++) {
            queue4.enqueue('a');
            assertEquals(i+4, queue4.getLength());
        }

    }

    @Test
    @DisplayName("Test dequeue method")
    public void testDequeue() {
        queue = new GenericQueue<Integer>(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        assertEquals(2, queue.getLength());
        for(int i = 0; i <= queue.getLength(); i++) {
            queue.dequeue();
        }
        assertEquals(0, queue.getLength());

        queue2 = new GenericQueue<String>("hello");
        queue2.enqueue("world");
        queue2.enqueue("open");
        queue2.dequeue();
        assertEquals(2, queue2.getLength());
        for(int i = 0; i <= queue2.getLength(); i++) {
            queue2.dequeue();
        }
        assertEquals(0, queue2.getLength());

        queue3 = new GenericQueue<Double>(1.0);
        queue3.enqueue(2.0);
        queue3.enqueue(3.0);
        queue3.dequeue();
        assertEquals(2, queue3.getLength());
        for(int i = 0; i <= queue3.getLength(); i++) {
            queue3.dequeue();
        }
        assertEquals(0, queue3.getLength());

        queue4 = new GenericQueue<Character>('a');
        queue4.enqueue('b');
        queue4.enqueue('c');
        queue4.dequeue();
        assertEquals(2, queue4.getLength());
        for(int i = 0; i <= queue4.getLength(); i++) {
            queue4.dequeue();
        }
        assertEquals(0, queue4.getLength());
    }

    @Test
    @DisplayName("Test GLLIterator methods")
    public void testGLLIterator() {

        queue = new GenericQueue<Integer>(1);

        Iterator<Integer> iterator1 = queue.iterator();
        assertTrue(iterator1.hasNext());
        assertEquals(1, iterator1.next());

        queue.enqueue(2);
        queue.enqueue(3);

        Iterator<Integer> iterator2 = queue.iterator();
        assertTrue(iterator2.hasNext());
        assertEquals(1, iterator2.next());
        assertTrue(iterator2.hasNext());
        assertEquals(2, iterator2.next());
        assertTrue(iterator2.hasNext());
        assertEquals(3, iterator2.next());
        assertFalse(iterator2.hasNext());

        queue2 = new GenericQueue<String>("hello");

        Iterator<String> iterator4 = queue2.iterator();
        assertTrue(iterator4.hasNext());
        assertEquals("hello", iterator4.next());

        queue2.add("world");
        queue2.add("open");

        Iterator<String> iterator3 = queue2.iterator();
        assertTrue(iterator3.hasNext());
        assertEquals("hello", iterator3.next());
        assertTrue(iterator3.hasNext());
        assertEquals("world", iterator3.next());
        assertTrue(iterator3.hasNext());
        assertEquals("open", iterator3.next());
        assertFalse(iterator3.hasNext());

        queue3 = new GenericQueue<Double>(1.0);

        Iterator<Double> iterator5 = queue3.iterator();
        assertTrue(iterator5.hasNext());
        assertEquals(1.0, iterator5.next());

        queue3.add(2.0);
        Iterator<Double> iterator6 = queue3.iterator();
        assertTrue(iterator6.hasNext());
        assertEquals(1.0, iterator6.next());
        assertTrue(iterator6.hasNext());
        assertEquals(2.0, iterator6.next());
        assertFalse(iterator6.hasNext());

        queue4 = new GenericQueue<Character>('a');

        Iterator<Character> iterator7 = queue4.iterator();
        assertTrue(iterator7.hasNext());
        assertEquals('a', iterator7.next());

        queue4.add('b');
        Iterator<Character> iterator8 = queue4.iterator();
        assertTrue(iterator8.hasNext());
        assertEquals('a', iterator8.next());
        assertTrue(iterator8.hasNext());
        assertEquals('b', iterator8.next());
        assertFalse(iterator8.hasNext());

    }

    @Test
    @DisplayName("Test forEach Loop methods")
    public void testForEachLoop() {
        GenericList<Integer> list = new GenericQueue<>(1);

        for(Integer i : list) {
            assertEquals(1, i);
        }

        list.add(2);
        list.add(3);
        int i = 1;
        for(Integer j : list) {
            assertEquals(i, j);
            i++;
        }

        GenericList<String> list2 = new GenericQueue<>("hello");

        for(String s : list2) {
            assertEquals("hello", s);
        }

        list2.add("world");
        list2.add("open");
        i = 0;
        String[] strings = {"hello", "world", "open"};
        for(String s : list2) {
            assertEquals(strings[i], s);
            i++;
        }

        GenericList<Double> list3 = new GenericQueue<>(1.0);

        for(Double d : list3) {
            assertEquals(1.0, d);
        }

        list3.add(2.0);
        list3.add(3.0);
        i = 1;
        for(Double d : list3) {
            assertEquals(i, d);
            i++;
        }

        GenericList<Character> list4 = new GenericQueue<>('a');

        for(Character c : list4) {
            assertEquals('a', c);
        }

        list4.add('b');
        list4.add('c');
        i = 0;
        char[] chars = {'a', 'b', 'c'};
        for(Character c : list4) {
            assertEquals(chars[i], c);
            i++;
        }

    }

    @Test
    @DisplayName("Test ReverseGLLIterator methods")
    public void testReverseGLLIterator() {
        queue = new GenericQueue<Integer>(1);

        Iterator<Integer> iterator1 = queue.descendingIterator();
        assertTrue(iterator1.hasNext());
        assertEquals(1, iterator1.next());
        assertFalse(iterator1.hasNext());

        queue.enqueue(2);
        queue.enqueue(3);

        Iterator<Integer> iterator2 = queue.descendingIterator();
        assertTrue(iterator2.hasNext());
        assertEquals(3, iterator2.next());
        assertTrue(iterator2.hasNext());
        assertEquals(2, iterator2.next());
        assertTrue(iterator2.hasNext());
        assertEquals(1, iterator2.next());
        assertFalse(iterator2.hasNext());



    }

}
