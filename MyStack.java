public class MyStack<T> {

    private T[] data;
    private int top;
    private int size;

    @SuppressWarnings("unchecked")
    public MyStack() {
        data = (T[]) new Object[4];
        top = 0;
        size = 0;
    }

    public void push(T x) {
        if (size == data.length) {
            resize();
        }

        data[top] = x;
        top = (top + 1) % data.length;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        top = (top - 1 + data.length) % data.length;

        T value = data[top];
        data[top] = null;

        size--;

        return value;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }

        int position = (top - 1 + data.length) % data.length;

        return data[position];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void delete() {
        data = null;
        top = 0;
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newData = (T[]) new Object[data.length * 2];

        for (int i = 0; i < size; i++) {
            int position = (top - size + i + data.length)
                    % data.length;

            newData[i] = data[position];
        }

        data = newData;
        top = size;
    }
}