public class SinglyLinkedList<T> {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public SinglyLinkedList() {
        head = null;
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

        newNode.next = head;
        head = newNode;

        size++;
    }

    public void pushBack(T x) {
        Node newNode = new Node(x);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
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

        return value;
    }

    public T popBack() {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            T value = head.data;
            head = null;
            size--;
            return value;
        }

        Node current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        T value = current.next.data;
        current.next = null;

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
            return true;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.data.equals(x)) {
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