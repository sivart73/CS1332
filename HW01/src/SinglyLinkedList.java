import java.util.NoSuchElementException;

/**
 * Your implementation of a SinglyLinkedList
 *
 * @author YOUR NAME HERE
 * @version 1.0
 */
public class SinglyLinkedList<T> implements LinkedListInterface<T> {

    // Do not add new instance variables.
    private LinkedListNode<T> head;
    private int size;

    @Override
    public void addAtIndex(int index, T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index number "
                    + "negative or too large");
        }
        LinkedListNode<T> newnode = new LinkedListNode<>(data, null);
        if (index == 0) {
            head = newnode;
            size++;
        } else {
            LinkedListNode<T> temp = head;
            LinkedListNode<T> previous = null;
            for (int i = 0; i < index; i++) {
                previous = temp;
                temp = temp.getNext();
            }
            newnode.setNext(previous.getNext());
            previous.setNext(newnode);
            size++;
        }

    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index number "
                    + "negative or too large");
        }
        if (index == 0) {
            return head.getData();
        } else {
            LinkedListNode<T> getnode = head;
            for (int i = 1; i <= index; i++) {
                getnode = getnode.getNext();
            }
            return getnode.getData();
        }

    }


    @Override
    public T removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index number "
                    + "negative or too large");
        }
        LinkedListNode<T> current = head;
        LinkedListNode<T> previous = null;
        if (index == 0) {
            head = head.getNext();
            size--;
            return current.getData();
        } else {
            for (int i = 1; i <= index; i++) {
                previous = current;
                current  = current.getNext();
            }
            previous.setNext(current.getNext());
            size--;
            return current.getData();
        }

    }

    @Override
    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot add null data to list");
        }
        LinkedListNode<T> newnode = new LinkedListNode<T>(data, head);
        head = newnode;
        size++;
    }

    @Override
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot add null data to list");
        }
        LinkedListNode<T> newnode = new LinkedListNode<T>(data);
        if (head == null) {
            head = newnode;
            size++;
        } else {
            LinkedListNode<T> temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newnode);
            size++;
        }

    }

    @Override
    public T removeFromFront() {
        if (head == null) {
            return null;
        } else {
            LinkedListNode<T> temp = head;
            head = head.getNext();
            size--;
            return temp.getData();
        }

    }

    @Override
    public T removeFromBack() {

        if (isEmpty()) {
            return null;
        }
        LinkedListNode<T> current = head;
        LinkedListNode<T> previous = null;

        while (current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }
        //previous.setNext(null);
        size--;
        return current.getData();
    }


    @Override
    public int removeFirstOccurrence(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty - no such element");
        }
        LinkedListNode<T> current = head;
        LinkedListNode<T> previous = null;
        if (head.getData().equals(data)) {
            head = head.getNext();
            return 0;
        } else {
            for (int i = 0; i < size; i++) {
                if (current.getData().equals(data)) {
                    previous.setNext(current.getNext());
                    size--;
                    return i;
                } else {
                    previous = current;
                    current = current.getNext();
                }
            }
        }
        throw new NoSuchElementException("Data not found in list");

    }

    @Override
    public Object[] toArray() {

        Object[] newarray = new Object[size];
        LinkedListNode<T> temp = head;
        for (int i = 0; i < size; i++) {
            newarray[i] = temp.getData();
            temp = temp.getNext();
        }
        return newarray;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public LinkedListNode<T> getHead() {
        // DO NOT MODIFY!
        return head;

    }
}
