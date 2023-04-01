import java.util.Iterator;
import java.util.ArrayList;

public class ReverseGLLIterator<E> implements Iterator<E> {

    // The tail of the list
    private GenericList<E>.Node<E> tail;
    // The previous node of the tail
    private GenericList<E>.Node<E> prev;
    // The head of the list
    private GenericList<E>.Node<E> head;

    // Constructor for the iterator initializes the tail of the list and prev by looping through the list to the end
    public ReverseGLLIterator(GenericList<E>.Node<E> list) {
        head = list;
        tail = list;
        while (tail.next != null) {
            prev = tail;
            tail = tail.next;
        }
    }

    // Returns true if the list has a next element
    public boolean hasNext() {
        return tail != null;
    }

    // Returns the next element in the list and updates the tail and prev
    public E next(){
        if(!hasNext()) {
            return null;
        }
        E data = tail.data;
        tail = prev;
        prev = getPreviousNode(head);

        return data;
    }

    // Returns the previous node of the tail
    private GenericList<E>.Node<E> getPreviousNode(GenericList<E>.Node<E> node) {
        GenericList<E>.Node<E> current = node;
        while (current != null) {
            if (current.next == prev) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

}
