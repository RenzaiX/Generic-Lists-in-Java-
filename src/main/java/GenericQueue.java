import java.util.ArrayList;
import java.util.Iterator;

public class GenericQueue<T> extends GenericList<T> {
    private Node<T> tail;

    public GenericQueue(T data) {
        super(data);
        Node<T> node = new Node<T>(data);
        setHead(node);
        tail = node;
    }

    // Adds an element to the end of the queue
    @Override
    public void add(T data) {
        Node<T> node = new Node<T>(data);
        // if the list is empty add the node to the head and tail, and increase size
        if (getHead() == null) {
            setHead(node);
            tail = node;
            setLength(getLength() + 1);
            return;
        }

        // if the list is not empty, add the node to the end and increase size
        tail.next = node;
        tail = node;
        setLength(getLength() + 1);
    }

    // Adds an element with a specified code to the end of the queue
    public void add(T data, int code)
    {
        Node<T> node = new Node<T>(data);
        node.code = code;

        if(getHead() == null)
        {
            setHead(node);
            tail = node;
            setLength(getLength() + 1);
            return;
        }

        // if the list is not empty, add the node to the end with a specified code and increase size
        tail.next = node;
        tail = node;
        setLength(getLength() + 1);
    }

    // Removes and returns the element at the front of the queue
    public T delete() {
        if(getHead() == null)
        {
            // if the list is empty, return null
            return null;
        }
        else if(getHead() == tail)
        {
            // if the list contains only one element, remove it and set head and tail to null
            T deleted = getHead().data;
            setHead(null);
            tail = null;
            setLength(getLength() - 1);
            return deleted;
        }
        else
        {
            // if the list contains more than one element, remove the first element and set head to the next node
            Node<T> temp = getHead();
            T deleted = temp.data;
            this.setHead(temp.next);
            setLength(getLength() - 1);
            return deleted;
        }
    }

    // Adds an element to the end of the queue
    public void enqueue(T data)
    {
        add(data);
    }

    // Removes and returns the element at the front of the queue
    public T dequeue()
    {
        return delete();
    }
}