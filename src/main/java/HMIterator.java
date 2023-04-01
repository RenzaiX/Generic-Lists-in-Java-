import java.util.ArrayList;
import java.util.Iterator;

public class HMIterator<V> implements Iterator<V> {
    // The map to iterate over
    private ArrayList<GenericQueue<V>> map;
    // The index of the current bucket in the map.
    private int index;

    // The current node in the current bucket
    private GenericList<V>.Node<V> currentNode;

    // Constructor that initializes the map and sets the index to 0 and currentNode to null
    public HMIterator(ArrayList<GenericQueue<V>> map) {
        this.map = map;
        this.index = 0;
        this.currentNode = null;
    }

    // Returns true if there are more elements in the map to iterate through
    public boolean hasNext() {
        index = 0;
        while (index < map.size()) {
            GenericQueue<V> queue = map.get(index);
            if (queue != null && queue.getHead() != null){
                currentNode = queue.getHead();
                return true;
            }
            index++;
        }
        currentNode = null;
        return currentNode != null;
    }

    // Returns the next element in the map and updates the index, currentNode, and head of the current bucket
    public V next() {
        if (!hasNext()) {
            return null;
        }

        GenericQueue<V> queue = map.get(index);
        while(queue == null){
            index++;
            queue = map.get(index);
        }

        GenericList<V>.Node<V> indexNode = queue.getHead();

        V data = indexNode.data;
        queue.setHead(indexNode.next);
        return data;
    }

    // Finds the next non-empty bucket in the map and sets the currentNode field to the head of that bucket
    private void findNextNode() {
        while (index < map.size()) {
            GenericQueue<V> queue = map.get(index);
            if (queue != null) {
                currentNode = queue.getHead();
                return;
            }
            index++;
        }
        currentNode = null;
    }
}




