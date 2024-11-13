public class MyStack<E> {
    private E[] data;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 5;
    public MyStack() {
        this(DEFAULT_CAPACITY);
    }
    public MyStack(int capacity) {
        if (capacity < DEFAULT_CAPACITY)
            capacity = DEFAULT_CAPACITY;
        data = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public E peek() {
        if (isEmpty())
            return null;
        return data[size - 1];
    }

    public E pop() {
        if (isEmpty())
            return null;
        E top = data[size - 1];
        data[--size] = null;
        if (size < data.length / 4.0 && !isEmpty())
            resize(data.length / 2);
        return top;
    }

    public void push(E e) {
        if (size == data.length)
            resize(2 * data.length);
        data[size++] = e;
    }
    private void resize(int capacity) {
        if (capacity < DEFAULT_CAPACITY)
            return;
        System.out.println("Stack capacity: " + data.length + " -> " + capacity);
        E[] newArray = (E[]) new Object[capacity];
        System.arraycopy(data, 0, newArray, 0, size);
        data = newArray;
    }
    @Override
    public String toString() {
        if (isEmpty())
            return "[]";
        String str = "[";
        for (int i = size - 1; i >= 0; i--) {
            str = str + data[i];
            if (i != 0)
                str = str + ", ";
            else
                str = str + "]";
        }
        return str;
    }
}