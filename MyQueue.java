public class MyQueue<E> {
    private E[] data;
    private int size = 0;
    private int first = 0;
    public MyQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public E peek() {
        if (isEmpty())
            return null;
        return data[first];
    }
    public E dequeue() {
        if (isEmpty())
            return null;
        E head = data[first];
        data[first] = null;
        first = (first + 1) % data.length;
        size--;
        return head;
    }
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