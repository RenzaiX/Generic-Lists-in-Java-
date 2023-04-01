import java.util.ArrayList;
import java.util.Iterator;

public class GLLIterator<E> implements Iterator<E> {

    // The head of the list
    private GenericList<E>.Node<E> head;

    // Constructor for the iterator initializes the head of the list
    public GLLIterator(GenericList<E>.Node<E> list) {
        head = list;
    }

    // Returns true if the list has a next element
    public boolean hasNext() {
        return head != null;
    }

    // Returns the next element in the list
    public E next() {
        if(!hasNext()) {
            return null;
        }
        E data = head.data;
        head = head.next;
        return data;
    }
}
