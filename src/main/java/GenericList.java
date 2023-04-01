import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public abstract class GenericList<T> implements Iterable<T> {
    // declare private class variables
    private Node<T> head;
    private int length;

    // Constructor for initializing a new GenericList object with a single Node containing data
    public GenericList(T data)
    {
        Node<T> node = new Node<T>(data);
        head = node;
        length++;
    }

    // Nested class for creating Node objects
    class Node<T> {
        T data;
        Node<T> next;
        int code;

        // Constructor for initializing a new Node object with data and setting next to null and code to 0
        public Node(T data) {
            this.data = data;
            this.next = null;
            this.code = 0;
        }
    }

    // Method to print out the data in the GenericList object
    public void print()
    {
        Node<T> temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // Abstract methods for adding and deleting Nodes
    public abstract void add(T data);

    public abstract T delete();

    // Method to return an ArrayList of the data
    public ArrayList<T> dumplist()
    {
        ArrayList<T> list = new ArrayList<T>();
        Node<T> temp = head;
        while(temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }
        return list;
    }

    // Method to get the data at a specified index
    public T get(int index)
    {
        // Make sure values are in range
        if(index < 0 || length <= index)
        {
            return null;
        }
        Node<T> temp = head;
        for(int i =0; i< index; i++){
            temp = temp.next;
        }
        return temp.data;
    }

    // Method to replace the data at a specified index
    public T set(int index, T element)
    {
        // Make sure values are in range
        if(index < 0 || length <= index)
        {
            return null;
        }
        Node<T> temp = head;
        for(int i = 0; i<index; i++)
        {
            temp = temp.next;
        }
        // Store the previous data in a variable
        T previous = temp.data;
        temp.data = element;
        return previous;
    }

    // Getter and setter methods for the class variables
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    // Returns an iterator over the elements of the list in order (head to tail)
    public Iterator<T> iterator() {
        return new GLLIterator<T>(head);

    }

    // Returns an iterator over the elements of the list in reverse order (tail to head)
    public Iterator<T> descendingIterator() {
        return new ReverseGLLIterator<T>(head);
    }

}