public class MyQueue<T> {

    private T[] data;
    private int front;
    private int size;

    @SuppressWarnings("unchecked")
    public MyQueue() {
        data = (T[]) new Object[4];
        front = 0;
        size = 0;
    }

    public void enqueue(T x) {
        if (size == data.length) {
            resize();
        }

        int position = (front + size) % data.length;
        data[position] = x;

        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T value = data[front];
        data[front] = null;

        front = (front + 1) % data.length;
        size--;

        return value;
    }

    public T front() {
        if (isEmpty()) {
            return null;
        }

        return data[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void delete() {
        data = null;
        front = 0;
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newData = (T[]) new Object[data.length * 2];

        for (int i = 0; i < size; i++) {
            int position = (front + i) % data.length;
            newData[i] = data[position];
        }

        data = newData;
        front = 0;
    }
}