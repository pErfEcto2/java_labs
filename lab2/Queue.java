package lab2;

/**
 * A doubly-linked queue
 */
public class Queue {

    /**
     * Internal node class for queue elements
     */
    static class Node {
        String str; // The string data stored in this node
        Node next; // Reference to the next node
        Node prev; // Reference to the previous node

        /**
         * Creates a new node with the given string
         * @param str the string to store in this node
         */
        Node(String str) {
            this.str = str;
            next = null;
            prev = null;
        }
    }

    Node head; // Reference to the head of the queue
    Node tail; // Reference to the tail of the queue
    int size; // Current number of elements in the queue

    /**
     * Constructs an empty queue
     */
    public Queue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Returns the number of elements in the queue
     * @return the size of the queue
     */
    public int size() {
        return size;
    }

    /**
     * Adds an element to the back of the queue
     * @param str the string to add to the queue
     */
    public void add(String str) {
        Node Node = new Node(str);
        size++;

        if (tail == null) {
            tail = Node;
            head = Node;
            return;
        }

        Node.next = tail;
        tail.prev = Node;
        tail = Node;
    }

    /**
     * Removes and returns the element from the front of the queue
     * @return the removed element, or null if queue is empty
     */
    public String pop() {
        if (head == null) {
            return null;
        }

        size--;

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

    /**
     * Returns a string representation of the queue
     * @return a string showing queue contents and structure
     */
    @Override
    public String toString() {
        Node ptr = head;
        if (ptr == null) {
            return "Queue is empty";
        }

        StringBuilder s = new StringBuilder();
        s.append("Size: ").append(size()).append("\n");

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

        return s.toString();
    }

    /**
     * Iterator for traversing the queue from head to tail
     */
    public class Iterator {
        private Node current; // Current node in iteration
        private Node last_returned; // Last node returned by next()

        /**
         * Constructs an iterator starting at the head of the queue
         */
        public Iterator() {
            current = head;
            last_returned = null;
        }

        /**
         * Checks if there are more elements to iterate over
         * @return true if there are more elements, false otherwise
         */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the iteration
         * @return the next string in the queue
         */
        public String next() {
            last_returned = current;

            String data = current.str;
            current = current.prev;
            return data;
        }

        /**
         * Removes the last element returned by next() from the queue
         */
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

    /**
     * Returns an iterator for this queue
     * @return a new iterator instance
     */
    public Iterator iterator() {
        return new Iterator();
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println(q);

        Queue.Iterator it = q.iterator();
        System.out.println("Empty iterator:");
        System.out.println("Has next? " + it.hasNext());
        System.out.println("Has next? " + (it.hasNext() + "\n"));

        System.out.println("-".repeat(10) + " Populating the queue\n");

        q.add("1");
        System.out.println(q);

        q.add("2");
        System.out.println(q);

        q.add("3");
        System.out.println(q);

        System.out.println("-".repeat(10) + " After populating the queue:\n");
        System.out.println(q);
        it = q.iterator();
        System.out.println("-".repeat(10) + " Iterator created\n");
        while (it.hasNext()) {
            System.out.println("Next element is: " + it.next());
        }

        System.out.println("-".repeat(10) + " Removing elements from the queue\n");

        System.out.println(q.pop());
        System.out.println(q + "\n");

        System.out.println(q.pop());
        System.out.println(q + "\n");

        System.out.println(q.pop());
        System.out.println(q + "\n");

        System.out.println(q.pop());
        System.out.println(q);

        System.out.println("-".repeat(10) + " Resetting the queue and populating it");

        q = new Queue();
        q.add("1");
        q.add("2");
        q.add("3");
        q.add("4");
        System.out.println("Queue before removal:\n" + q);
        System.out.println("-".repeat(10) + " Iterator with removals");

        it = q.iterator();
        while (it.hasNext()) {
            String element = it.next();
            if (element.equals("2") || element.equals("4")) {
                System.out.println("Removing: " + element);
                it.remove();
            }
        }
        System.out.println("Queue after removal:\n" + q);



        System.out.println("-".repeat(10) + " Resetting the queue and populating it with only one element");
        q = new Queue();
        q.add("1");
        System.out.println(q);

        System.out.println("-".repeat(10) + " Creating an iterator");
        it = q.iterator();
        System.out.println("Next: " + it.next());
        System.out.println("-".repeat(10) + " Removing the element in the queue");
        it.remove();
        System.out.println("Queue after removing single element:\n" + q);


        System.out.println("-".repeat(10) + " Removing without calling next()");
        q = new Queue();
        q.add("1");
        q.add("2");
        it = q.iterator();
        it.remove();

        System.out.println("-".repeat(10) + " Two removes without next()");
        q = new Queue();
        q.add("1");
        it = q.iterator();
        it.next();
        System.out.println("First remove:");
        it.remove();

        System.out.println("Second remove:");
        try {
            it.remove();
        } catch (Exception e) {
            System.out.println("Error!");
            System.out.println(e.getMessage());
        }

        System.out.println("-".repeat(10) + " Infinite next() calls");
        q = new Queue();
        q.add("1");
        it = q.iterator();
        try {
            while (true) {
                System.out.println("Next: " + it.next());
            }
        } catch (Exception e) {
            System.out.println("Error!");
            System.out.println(e.getMessage());
        }
    }
}