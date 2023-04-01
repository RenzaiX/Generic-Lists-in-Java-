import java.util.ArrayList;
import java.util.Iterator;

public class MyHashMap<T> implements Iterable<T> {
    ArrayList<GenericQueue<T>> map;
    int size;

    // Constructor initializes an ArrayList of size 10 and calls the put function for the initial key-value pair
    public MyHashMap(String key, T value) {
        this.map = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            this.map.add(null);
        }
        // If the key is null, do not add it to the map
        if(key != null)
        {
            put(key, value);
        }

    }

    // Adds a key-value pair to the HashMap by calculating its hash value and adding it to the appropriate GenericQueue
    public void put(String key, T value)
    {
        if(key == null)
        {
            return;
        }
        int hashValue = key.hashCode() & 9;

        if (map.get(hashValue) == null) {
            // If the GenericQueue at this hash value is null, create a new GenericQueue with the value and set the code to the hash code of the key
            GenericQueue<T> newQueue = new GenericQueue<T>(value);
            newQueue.getHead().code = key.hashCode();
            map.set(hashValue, newQueue);

        } else {
            // If the GenericQueue at this hash value is not null, add the value and set the code to the hash code of the key
            map.get(hashValue).add(value, key.hashCode());

        }
        // Increment size to keep track of the number of key-value pairs in the map
        size++;
    }

    // Checks if the HashMap contains the specified key by computing its hash value and searching the appropriate GenericQueue
    public boolean contains(String key)
    {
        if(key == null)
        {
            return false;
        }
        int hashValue = key.hashCode() & 9;

        GenericQueue<T> tempQ = map.get(hashValue);

        if(tempQ == null)
        {
            return false;
        }
        // Iterate through the GenericQueue and return true if the key's hash code is found
        GenericList<T>.Node<T> curr = tempQ.getHead();

        while(curr != null)
        {
            if(curr.code == key.hashCode())
            {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }

    // Gets the value associated with the specified key by computing its hash value
    public T get(String key) {
        if(key == null)
        {
            return null;
        }
        int hashValue = key.hashCode() & 9;
        GenericQueue<T> tempQ = map.get(hashValue);

        if(tempQ == null)
        {
            return null;
        }
        // Iterate through the GenericQueue and return the value associated with the key's hash code
        GenericList<T>.Node<T> temp = tempQ.getHead();

        while(temp != null)
        {
            if(temp.code == key.hashCode())
            {
                return temp.data;
            }
            temp = temp.next;
        }

        return null;
    }

    // Returns the number of key-value pairs in the HashMap
    public int size() {
        return size;
    }

    // Checks if the HashMap is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // Replaces the value associated with the specified key and returns the previous value, or null if the key was not found
    public T replace(String key, T value) {
        if(key == null)
        {
            return null;
        }
        int hashValue = key.hashCode() & 9;
        GenericQueue<T> tempQ = map.get(hashValue);

        if(tempQ == null)
        {
            return null;
        }
        // Iterate through the GenericQueue and replace the value associated with the key's hash code
        GenericList<T>.Node<T> temp = tempQ.getHead();

        while(temp != null)
        {
            if(temp.code == key.hashCode())
            {
                T old = temp.data;
                temp.data = value;
                return old;
            }
            temp = temp.next;
        }
        return null;
    }

    // Returns an Iterator over the key-value pairs in the HashMap
    public Iterator<T> iterator() {
        return new HMIterator(map);

    }
}


