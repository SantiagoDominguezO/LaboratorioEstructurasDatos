public class DoublyLinkedListWithTail<T> {

    private class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedListWithTail() {
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
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    public void pushBack(T x) {
        Node newNode = new Node(x);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
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

        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }

        size--;

        return value;
    }

    public T popBack() {
        if (tail == null) {
            return null;
        }

        T value = tail.data;

        tail = tail.prev;

        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }

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
        Node current = head;

        while (current != null) {

            if (current.data.equals(x)) {

                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                size--;

                return true;
            }

            current = current.next;
        }

        return false;
    }

    public boolean addBefore(T target, T x) {
        Node current = head;

        while (current != null) {

            if (current.data.equals(target)) {

                Node newNode = new Node(x);

                newNode.next = current;
                newNode.prev = current.prev;

                if (current.prev != null) {
                    current.prev.next = newNode;
                } else {
                    head = newNode;
                }

                current.prev = newNode;

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

                newNode.prev = current;
                newNode.next = current.next;

                if (current.next != null) {
                    current.next.prev = newNode;
                } else {
                    tail = newNode;
                }

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
            System.out.print(current.data + " <-> ");
            current = current.next;
        }

        System.out.println("null");
    }
}