// A generic queue that uses an array circularly to store the elements.
public class MyQueue<E> {
    // data fields
    private E[] data; // a generic array for storing the elements in the queue
    private int size = 0; // the number of the stored elements (initially 0)
    private int first = 0; // the index of the first queue element (initially 0)

    // constructor that creates an empty queue with the specified initial capacity
    public MyQueue(int capacity) {
        // the array is created with the type Object instead of the generic type E
        // then casted to E[] as generic array creation is not possible
        data = (E[]) new Object[capacity];
    }

    // returns true if the queue is empty and false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // returns the element at the start (head) of the queue without removing it
    public E peek() {
        // return null if the queue is empty
        if (isEmpty())
            return null;
        // return the element at index first (the element at the head of the queue)
        return data[first];
    }

    // removes and returns the element at the start (head) of the queue
    public E dequeue() {
        // return null if the queue is empty
        if (isEmpty())
            return null;
        // store the first element in a variable to return after it is removed
        E head = data[first];
        // remove the first element
        data[first] = null; // dereference to help garbage collection
        // update the variables first and size
        first = (first + 1) % data.length; // circular update
        size--; // decrease size by 1
        // return the removed first element that is stored in the variable head
        return head;
    }

    // adds the given element e to the end (tail) of the queue then returns true
    // if the queue is not full, returns false otherwise
    public void enqueue(E e) {
        ensureCapacity();
        int rear = (first + size) % data.length;
        data[rear] = e;
        size++;
    }
    private void ensureCapacity() {
        if (size<data.length) return;
        int newCapacity=data.length*2;
        System.out.println("Queue capacity: " +size+" -> "+newCapacity);
        E[] newData=(E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i]=data[(first + i) % data.length];
        }
        data=newData;
        first=0;
    }
    public String toString() {
        StringBuilder queueContent=new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            queueContent.append(data[(first+i)%data.length]);
            if (i<size-1) queueContent.append(", ");
        }
        queueContent.append("]");
        StringBuilder arrayContent=new StringBuilder("[");
        for (int i = 0; i < data.length; i++) {
            arrayContent.append(data[i]);
            if (i < data.length-1) arrayContent.append(", ");
        }
        arrayContent.append("]");
        return "Queue: head -> " + queueContent + " and Inner Array: " + arrayContent;
    }

}