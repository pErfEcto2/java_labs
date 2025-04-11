package lab2;

public class Queue {

    static class Node {
        String str;
        Node next;
        Node prev;

        Node(String str) {
            this.str = str;
            next = null;
            prev = null;
        }
    }

    Node head;
    Node tail;
    int size;

    public Queue() {
        head = null;
        tail = null;
    }

    public void add(String str) {
        Node Node = new Node(str);

        if (tail == null) {
            tail = Node;
            head = Node;
            return;
        }

        Node.next = tail;
        tail.prev = Node;
        tail = Node;
    }

    public String pop() {
        if (head == null) {
            return null;
        }

        String out = head.str;
        if (head == tail) {
            head = null;
            tail = null;
            return out;
        }

        head = head.prev;
        head.next.prev = null;
        head.next = null;

        return out;
    }

    public void print() {
        StringBuilder s = new StringBuilder();
        Node ptr = head;

        if (ptr == null) {
            System.out.println("Queue is empty");
        }

        while (ptr != null) {
            if (ptr == head && ptr == tail) {
                s.append(ptr.str).append(" <- head & tail\n");
            } else if (ptr == head) {
                s.append(ptr.str).append(" <- head\n");
            } else if (ptr == tail) {
                s.append(ptr.str).append(" <- tail\n");
            } else {
                s.append(ptr.str).append("\n");
            }
            ptr = ptr.prev;
        }

        System.out.println(s);
    }

    public class Iterator {
        private Node current;
        private Node last_returned;

        public Iterator() {
            current = head;
            last_returned = null;
        }

        public boolean hasNext() {
            return current != null;
        }

        public String next() {
            last_returned = current;

            String data = current.str;
            current = current.prev;
            return data;
        }

        public void remove() {
            if (last_returned == null) {
                System.out.println("No element to remove");
                return;
            }

            if (last_returned == head && last_returned == tail) {
                head = null;
                tail = null;
            } else if (last_returned == head) {
                head = head.prev;
                head.next = null;
            } else if (last_returned == tail) {
                tail = tail.next;
                tail.prev = null;
            } else {
                last_returned.next.prev = last_returned.prev;
                last_returned.prev.next = last_returned.next;
            }
        }
    }

    public Iterator iterator() {
        return new Iterator();
    }
}