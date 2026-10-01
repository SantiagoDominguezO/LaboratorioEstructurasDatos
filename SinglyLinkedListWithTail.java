public class SinglyLinkedListWithTail<T> {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedListWithTail() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void pushFront(T x) {
        Node newNode = new Node(x);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    public void pushBack(T x) {
        Node newNode = new Node(x);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public T popFront() {
        if (head == null) {
            return null;
        }

        T value = head.data;
        head = head.next;

        size--;

        if (head == null) {
            tail = null;
        }

        return value;
    }

    public T popBack() {
        if (head == null) {
            return null;
        }

        if (head == tail) {
            T value = head.data;
            head = null;
            tail = null;
            size--;
            return value;
        }

        Node current = head;

        while (current.next != tail) {
            current = current.next;
        }

        T value = tail.data;

        current.next = null;
        tail = current;

        size--;

        return value;
    }

    public T find(T x) {
        Node current = head;

        while (current != null) {
            if (current.data.equals(x)) {
                return current.data;
            }

            current = current.next;
        }

        return null;
    }

    public boolean erase(T x) {
        if (head == null) {
            return false;
        }

        if (head.data.equals(x)) {
            head = head.next;
            size--;

            if (head == null) {
                tail = null;
            }

            return true;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.data.equals(x)) {

                if (current.next == tail) {
                    tail = current;
                }

                current.next = current.next.next;
                size--;

                return true;
            }

            current = current.next;
        }

        return false;
    }

    public boolean addBefore(T target, T x) {
        if (head == null) {
            return false;
        }

        if (head.data.equals(target)) {
            pushFront(x);
            return true;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.data.equals(target)) {
                Node newNode = new Node(x);

                newNode.next = current.next;
                current.next = newNode;

                size++;

                return true;
            }

            current = current.next;
        }

        return false;
    }

    public boolean addAfter(T target, T x) {
        Node current = head;

        while (current != null) {
            if (current.data.equals(target)) {
                Node newNode = new Node(x);

                newNode.next = current.next;
                current.next = newNode;

                if (current == tail) {
                    tail = newNode;
                }

                size++;

                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }
}