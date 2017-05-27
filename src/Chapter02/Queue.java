package Chapter02;

import java.util.Iterator;

public class Queue {

    private static class Node {
        String name;
        Node previous;
        Node next;
        
        public Node(String name) {
            this.name = name;
        }
    }
    
    private Node head;
    private Node tail;
    
    public Queue() {
        // TODO Auto-generated constructor stub
    }
    
    public void add(String name) {
        Node newNode = new Node(name);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.previous = tail;
            tail = newNode;
        }
    }
    
    public void remove() {
        if (head != null)
            head = head.next;
    }
    
    private class QueueIterator implements Iterator<Node> {
        Node current = head;
        
        public boolean hasNext() {
            return current != null;
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
        
        public Node next() {
            if (!this.hasNext()) return null;
            Node cur = current;
            current = current.next;
            return cur;
        }
    }
    
    public QueueIterator iterator() {
        return new QueueIterator();
    }

}
